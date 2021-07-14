package com.cykj.bean;

/**
 * @ClassName: Menu
 * @Description: 菜单
 * @Author: BWL
 * @Date: 2021/7/7
 */
public class Menu {

    //menu表
    private int MENUID;
    private String MNAME;
    private int FATHERID;
    private String URL;

    //power表
    private int POWERID;
    private int ROLEID;
//    private int MENUID;


    public Menu() {

    }

    public Menu(int MENUID, String MNAME, int FATHERID, String URL, int POWERID, int ROLEID) {
        this.MENUID = MENUID;
        this.MNAME = MNAME;
        this.FATHERID = FATHERID;
        this.URL = URL;
        this.POWERID = POWERID;
        this.ROLEID = ROLEID;
    }

    public int getMENUID() {
        return MENUID;
    }

    public void setMENUID(int MENUID) {
        this.MENUID = MENUID;
    }

    public String getMNAME() {
        return MNAME;
    }

    public void setMNAME(String MNAME) {
        this.MNAME = MNAME;
    }

    public int getFATHERID() {
        return FATHERID;
    }

    public void setFATHERID(int FATHERID) {
        this.FATHERID = FATHERID;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public int getPOWERID() {
        return POWERID;
    }

    public void setPOWERID(int POWERID) {
        this.POWERID = POWERID;
    }

    public int getROLEID() {
        return ROLEID;
    }

    public void setROLEID(int ROLEID) {
        this.ROLEID = ROLEID;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "MENUID=" + MENUID +
                ", MNAME='" + MNAME + '\'' +
                ", FATHERID=" + FATHERID +
                ", URL='" + URL + '\'' +
                ", POWERID=" + POWERID +
                ", ROLEID=" + ROLEID +
                '}';
    }
}
