package com.atguigu.springboot.crud.controller;

import com.atguigu.springboot.crud.bean.TAdmin;
import com.atguigu.springboot.crud.mapper.AdminMapper;
import com.atguigu.springboot.crud.utils.AppDateUtil;
import com.atguigu.springboot.crud.utils.AppUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @author changchen
 * @create 2019-06-14 下午 6:28
 */
@Controller
public class AdminController {

    @Autowired
    private AdminMapper adminMapper;

    @GetMapping("/toListPage")
    public String index(Model model,@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                        @RequestParam(value = "pageSize",defaultValue = "3")Integer pageSize,
                        @RequestParam(value = "condition",defaultValue = "")String condition){


        PageHelper.startPage(pageNum,pageSize);
        //List<TAdmin> list = adminMapper.getAllAdmins();
        List<TAdmin> list = adminMapper.selectByExample(null);


        PageInfo<TAdmin> pageInfo = new PageInfo<TAdmin>(list,5);

        //model.addAttribute("list",list);
        model.addAttribute("pageInfo",pageInfo);


        return "admin/list";
    }

    @GetMapping("/toUpdatePage")
    public String toUpdatePage(@RequestParam("adminId")Integer id,Model model){
        //System.out.println(id);
        //根据id查询出
        TAdmin admin = adminMapper.getAdminById(id);
        model.addAttribute("admin",admin);

        return "admin/update";
    }

    @PostMapping("/update")
    public String update(TAdmin admin){

        //admin.setCreatetime(AppDateUtil.getCurrentTimeStr());
        int count = adminMapper.updateAdmin(admin);
        if (count>0){

        return "admin/list";
        }else {
            return "admin/update";
        }

    }

    //删除
    @ResponseBody
    @GetMapping("/delete")
    public String delete(Integer adminId){
        int count = adminMapper.deleteAdminById(adminId);
        if (count>0){
            return "ok";
        }else {
            return "fail";
        }
    }

    //新增
    @ResponseBody
    @PostMapping("/add")
    public String add(TAdmin admin){
        admin.setCreatetime(AppDateUtil.getCurrentTimeStr());
        admin.setUserpswd(AppUtil.getDigestPwd(admin.getUserpswd()));

        int count = adminMapper.saveAdmin(admin);
        if (count>0){
            return "ok";
        }else {
            return "fail";
        }

    }

}
