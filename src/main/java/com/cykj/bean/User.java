package com.cykj.bean;

/**
 * @ClassName: User
 * @Description:
 * @Author: BWL
 * @Date: 2021/7/9
 */
public class User {

    private int stuid;
    private String stuacc;
    private String stuname;
    private String stuidcard;
    private String stuexamnum;
    private String stusex;
    private String stuage;

    public User() {

    }

    public User(int stuid, String stuacc, String stuname, String stuidcard, String stuexamnum, String stusex, String stuage) {
        this.stuid = stuid;
        this.stuacc = stuacc;
        this.stuname = stuname;
        this.stuidcard = stuidcard;
        this.stuexamnum = stuexamnum;
        this.stusex = stusex;
        this.stuage = stuage;
    }

    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

    public String getStuacc() {
        return stuacc;
    }

    public void setStuacc(String stuacc) {
        this.stuacc = stuacc;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getStuidcard() {
        return stuidcard;
    }

    public void setStuidcard(String stuidcard) {
        this.stuidcard = stuidcard;
    }

    public String getStuexamnum() {
        return stuexamnum;
    }

    public void setStuexamnum(String stuexamnum) {
        this.stuexamnum = stuexamnum;
    }

    public String getStusex() {
        return stusex;
    }

    public void setStusex(String stusex) {
        this.stusex = stusex;
    }

    public String getStuage() {
        return stuage;
    }

    public void setStuage(String stuage) {
        this.stuage = stuage;
    }

    @Override
    public String toString() {
        return "User{" +
                "stuid=" + stuid +
                ", stuacc='" + stuacc + '\'' +
                ", stuname='" + stuname + '\'' +
                ", stuidcard='" + stuidcard + '\'' +
                ", stuexamnum='" + stuexamnum + '\'' +
                ", stusex='" + stusex + '\'' +
                ", stuage='" + stuage + '\'' +
                '}';
    }
}
