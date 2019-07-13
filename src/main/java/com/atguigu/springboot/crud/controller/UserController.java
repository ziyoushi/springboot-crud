package com.atguigu.springboot.crud.controller;

import com.atguigu.springboot.crud.bean.TAdmin;
import com.atguigu.springboot.crud.mapper.AdminMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author changchen
 * @create 2019-06-16 下午 4:20
 */
//使用同步 完善所有功能
@Controller
public class UserController {

    @Autowired
    AdminMapper adminMapper;

    //去列表页面
    @RequestMapping("/toUser")
    public String toUser(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                         @RequestParam(value = "pageSize",defaultValue = "3")Integer pageSize,
                         @RequestParam(value = "condition",defaultValue = "")String condition,
                         Model model){

        PageHelper.startPage(pageNum,pageSize);

        //查询出List 封装到PageInfo

        List<TAdmin> list = adminMapper.selectByExample(null);

        PageInfo<TAdmin> pageInfo = new PageInfo<TAdmin>(list,5);

        //model.addAttribute("list",list);
        model.addAttribute("pageInfo",pageInfo);

        return "admin/user";
    }


}
