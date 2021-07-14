package com.cykj.controller;

import com.cykj.bean.LayuiBean;
import com.cykj.bean.Menu;
import com.cykj.bean.PageBean;
import com.cykj.bean.User;
import com.cykj.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * @ClassName: Test
 * @Description:
 * @Author: BWL
 * @Date: 2021/7/8
 */

@Controller
@RequestMapping("/admin")
public class Test {

    @Autowired
    private UserService userService;
    Gson gson = new Gson();
    String flag = "0";
    Boolean flagb = false;
    private Map<String, Object> pbs = null;
    private Map<String, Object> repower = null;

    @RequestMapping(value = "/hello", produces = {"application/text;charset=UTF-8"})
    public String Hello() {
        return "hello";
    }

    /**
     * @Description: ajax注册
     * @Param:
     * @Author: BWL
     * @Date: 2021-07-09 12:19
     */
    @GetMapping(value = "/register", produces = {"application/text;charset=UTF-8"})
    public @ResponseBody
    Boolean register(User user) {
        System.out.println(user.getStuacc());
        System.out.println(user.getStuidcard());
        System.out.println(user.getStuage());
        if (user.getStuacc() != null) {
            user.setStuacc(user.getStuacc());
        }
        if (user.getStuidcard() != null) {
            user.setStuidcard(user.getStuidcard());
        }
        if (user.getStuage() != null) {
            user.setStuage(user.getStuage());
        }
        List<User> isexietRegi = userService.isexietRegi(user.getStuacc());
        if (isexietRegi.isEmpty()) {
            Boolean flag = userService.VueRegister(user.getStuacc(), user.getStuidcard(), user.getStuage());
            if (flag) {
                flagb = true;
            } else {
                flagb = false;
            }
        } else {
            flagb = false;
        }
        return flagb;
    }

    /**
     * @Description: ajax登录
     * @Param:
     * @Author: BWL
     * @Date: 2021-07-09 15:29
     */
    @GetMapping(value = "/ajaxLogin", produces = {"application/text;charset=UTF-8"})
    public @ResponseBody
    String ajaxLogin(String stuacc, String stuidcard, HttpSession httpSession, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println(stuacc);
        System.out.println(stuidcard);
        User user = new User();
        if (stuacc != null) {
            user.setStuacc(stuacc);
        }
        if (stuidcard != null) {
            user.setStuidcard(stuidcard);
        }
        List<User> studentLogin = userService.studentLogin(stuacc, stuidcard);
        if (!studentLogin.isEmpty()) {
            flag = "200";
        } else {
            flag = "100";
        }
        return flag;
    }


    /**
     * @Description: vue用户表带分页
     * @Param:
     * @Author: BWL
     * @Date: 2021-07-11 21:06
     */
    @GetMapping(value = "/tablefy", produces = {"application/text;charset=UTF-8"})
    public @ResponseBody
    String tablefy(int currentPage, int pagesize) {
        int num = userService.selUserCount();
        List<User> ruserLists = userService.UserTbFy((Integer.valueOf(currentPage) - 1) * Integer.valueOf(pagesize), Integer.valueOf(pagesize));
        PageBean pageBean = new PageBean(0, "成功", num, ruserLists);
        String userJson = gson.toJson(pageBean);
        return userJson;
    }


    /**
     * @Description: 菜单导航栏
     * @Param:
     * @Author: BWL
     * @Date: 2021-07-11 21:26
     */
    @GetMapping(value = "/MenuFirst", produces = {"application/text;charset=UTF-8"})
    public @ResponseBody
    String menufirst() {
        List<Menu> MenuFirst = userService.MenuFirst();
        String menujson = gson.toJson(MenuFirst);
        return menujson;
    }

    /**
     * @Description: 统计
     * @Param:
     * @Author: BWL
     * @Date: 2021-07-11 22:57
     */
    @GetMapping(value = "/selTongJi", produces = {"application/text;charset=UTF-8"})
    public @ResponseBody
    String selTongJi() {
        List<User> selTongJi = userService.selTongJi();
        String tjJson = gson.toJson(selTongJi);
        System.out.println(tjJson);
        return tjJson;
    }

    /**
     * @Description: 渲染权限
     * @Param:
     * @Author: BWL
     * @Date: 2021-07-13 20:06
     */
    @ResponseBody
    @GetMapping(value = "/rePower", produces = {"application/text;charset=UTF-8"})
    public String rePower(Menu menu) {
//        int roleid = Integer.valueOf(req.getParameter("roleid"));
        repower = new HashMap<>();
        repower.put("leftList", changeMeans(userService.havePower(menu.getROLEID())));
        repower.put("rightList", changeMeans(userService.nhavePower(menu.getROLEID())));
        String json = gson.toJson(repower);
        return json;
    }


    /**
     * @return
     * @Description: 权限右移
     * @Param:
     * @Author: BWL
     * @Date: 2021-07-13 20:06
     */
    @ResponseBody
    @GetMapping(value = "/addright", produces = {"application/text;charset=UTF-8"})
    public String nhavePower(int roleid, HttpServletRequest req) {
//        roleid = Integer.valueOf(req.getParameter("role"));
//        System.out.println(allID);
        System.out.println(req.getParameter("allID"));
        int[] left = Arrays.stream(req.getParameter("allID").split(",")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < left.length; i++) {
            if (!userService.isidexit(roleid, left[i])) {
                userService.insertPower(roleid, left[i]);
            }
        }
        return "200";
    }


    /**
     * @Description: 数据交换
     * @Param:
     * @Author: BWL
     * @Date: 2021-07-13 16:58
     */
    private List<LayuiBean> changeMeans(List<Menu> list) {
        List<LayuiBean> result = new ArrayList<LayuiBean>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getFATHERID() == 0) {
                LayuiBean menu = new LayuiBean(list.get(i).getMNAME(), list.get(i).getMENUID(), list.get(i).getURL());
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).getFATHERID() == list.get(i).getMENUID()) {
                        menu.getChildren().add(new LayuiBean(list.get(j).getMNAME(), list.get(j).getMENUID(), list.get(j).getURL()));
                    }
                }
                if (!menu.getChildren().isEmpty()) {
                    result.add(menu);
                }
            }
        }
        return result;
    }

}
