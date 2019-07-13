package com.atguigu.springboot.crud.mapper;

import com.atguigu.springboot.crud.bean.TAdmin;
import com.atguigu.springboot.crud.bean.TAdminExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author changchen
 * @create 2019-06-14 下午 6:28
 */
public interface AdminMapper {

    List<TAdmin> getAllAdmins();

    TAdmin getAdminById(Integer id);

    int updateAdmin(TAdmin admin);

    int deleteAdminById(@Param("adminId") Integer adminId);

    int saveAdmin(TAdmin admin);

    List<TAdmin> selectByExample(TAdminExample example);
}
