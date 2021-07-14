package com.cykj.service;

import com.cykj.bean.Menu;
import com.cykj.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: AOP
 * @Param:
 * @Author: BWL
 * @Date: 2021-06-01 14:38
 */

@Service
public interface UserService {

    //学生登录
    public List<User> studentLogin(@Param("stuacc") String stuacc, @Param("stuidcard") String stuidcard);

    //注册查询此账号是否已存在
    public List<User> isexietRegi(@Param("stuacc") String stuacc);

    //vue注册
    public Boolean VueRegister(@Param("stuacc") String stuacc, @Param("stuidcard") String stuidcard, @Param("stuage") String stuage);

    //vue用户表带分页
    public List<User> UserTbFy(@Param("page") int page, @Param("pagenum") int pagenum);

    //查询学生表总记录
    public int selUserCount();

    //一级菜单导航栏
    public List<Menu> MenuFirst();

    //二级菜单导航栏
//    public List<Menu> MenuEr();

    //统计
    public List<User> selTongJi();

    //拥有权限渲染rePower
    public List<Menu> havePower(@Param("ROLEID") int roleid);

    //未拥有权限渲染nhavePower
    public List<Menu> nhavePower(@Param("ROLEID") int roleid);

    //查询该权限是否存在
    public Boolean isidexit(@Param("ROLEID") int roleid, @Param("MENUID") int menuid);

    //添加权限
    public Boolean insertPower(@Param("ROLEID") int roleid, @Param("MENUID") int menuid);
}
