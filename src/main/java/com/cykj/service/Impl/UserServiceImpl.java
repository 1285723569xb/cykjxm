package com.cykj.service.Impl;

import com.cykj.bean.Menu;
import com.cykj.bean.User;
import com.cykj.mapper.UserMapper;
import com.cykj.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: UserServiceImpl
 * @Description:
 * @Author: BWL
 * @Date: 2021/6/1
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    /**
     * @Description: 学生登录
     * @Param:
     * @Author: BWL
     * @Date: 2021-06-14 16:35
     */
    @Override
    public List<User> studentLogin(@Param("stuacc") String stuacc, @Param("stuidcard") String stuidcard) {
        List<User> falgk = userMapper.studentLogin(stuacc, stuidcard);
        return falgk;
    }

    /**
     * @Description: 注册查询此账号是否已存在
     * @Param:
     * @Author: BWL
     * @Date: 2021-07-11 20:32
     */
    @Override
    public List<User> isexietRegi(String stuacc) {
        return userMapper.isexietRegi(stuacc);
    }

    /**
     * @Description: vue注册
     * @Param:
     * @Author: BWL
     * @Date: 2021-07-11 19:26
     */
    @Override
    public Boolean VueRegister(String stuacc, String stuidcard, String stuage) {
        return userMapper.VueRegister(stuacc, stuidcard, stuage);
    }

    /**
     * @Description: vue用户表带分页
     * @Param:
     * @Author: BWL
     * @Date: 2021-07-11 19:27
     */
    @Override
    public List<User> UserTbFy(int page, int pagenum) {
        return userMapper.UserTbFy(page, pagenum);
    }

    /**
     * @Description: 查询学生表总记录
     * @Param:
     * @Author: BWL
     * @Date: 2021-07-11 21:31
     */
    @Override
    public int selUserCount() {
        return userMapper.selUserCount();
    }

    /**
     * @Description: 一级菜单导航栏
     * @Param:
     * @Author: BWL
     * @Date: 2021-07-11 19:27
     */
    @Override
    public List<Menu> MenuFirst() {
        return userMapper.MenuFirst();
    }

    /**
     * @Description: 二级菜单导航栏
     * @Param:
     * @Author: BWL
     * @Date: 2021-07-11 19:28
     */
//    @Override
//    public List<Menu> MenuEr() {
//        return userMapper.MenuEr();
//    }

    /**
     * @Description: 统计
     * @Param:
     * @Author: BWL
     * @Date: 2021-07-11 22:57
     */
    @Override
    public List<User> selTongJi() {
        return userMapper.selTongJi();
    }

    @Override
    public List<Menu> havePower(int roleid) {
        return userMapper.havePower(roleid);
    }

    @Override
    public List<Menu> nhavePower(int roleid) {
        return userMapper.nhavePower(roleid);
    }

    /**
     * @Description:查询该权限是否存在
     * @Param:
     * @Author: BWL
     * @Date: 2021-07-13 23:17
     */
    @Override
    public Boolean isidexit(int roleid, int menuid) {
        return userMapper.isidexit(roleid, menuid);
    }

    /**
     * @Description: 添加权限
     * @Param:
     * @Author: BWL
     * @Date: 2021-07-13 23:20
     */
    @Override
    public Boolean insertPower(int roleid, int menuid) {
        return userMapper.insertPower(roleid, menuid);
    }

}
