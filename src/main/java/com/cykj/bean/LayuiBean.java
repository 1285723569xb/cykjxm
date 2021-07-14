package com.cykj.bean;

import java.util.ArrayList;
import java.util.List;

public class LayuiBean {

    /**
     *  -- LayUI 数据表格 请求数据字段 --
     */
    // 解析接口状态
    private int code;
    // 解析接口文本
    private String msg;
    // 解析数据长度
    private int count;
    // 解析数据列表
    private List<?> data;
    // 每页数据条数
    private int limit;
    /**
     *  -- LayUI 树形组件 请求数据字段 --
     */
    // 节点标题
    private String title;
    // 节点ID
    private int id;
    // 节点对应的url
    private String href;
    // 节点是否初始展开
    private boolean spread;
    // 子节点
    private List<LayuiBean> children;
    /**
     *  -- 构造方法 --
     */
    public LayuiBean(int count, List<?> data, int limit) {
        this.count = count;
        this.code = 0;
        this.msg = "成功";
        this.data = data;
        this.limit = limit;
    }

    public LayuiBean(String title, int id, String href) {
        this.title = title;
        this.id = id;
        this.href = href;
        this.spread = true;
        this.children = new ArrayList<LayuiBean>();
    }

    /**
     *  -- get&set方法 --
     */
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public boolean isSpread() {
        return spread;
    }

    public void setSpread(boolean spread) {
        this.spread = spread;
    }

    public List<LayuiBean> getChildren() {
        return children;
    }

    public void setChildren(List<LayuiBean> children) {
        this.children = children;
    }
}
