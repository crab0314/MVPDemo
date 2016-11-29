package com.meituan.pangjiaqi.mvp_demo.bean;

/**
 * Created by pangjiaqi on 2016/11/25.
 * 这是一个bean文件，model中会使用到这个数据结构
 */

public class UserBean {
    String name = "";
    boolean isBoy = false;

    public UserBean(String name, boolean r) {
        this.name = name;
        this.isBoy = r;
    }

    public String getName() {
        return name;
    }

    public boolean isBoy() {
        return isBoy;
    }

    public void setName(String name) {
        this.name = name;
    }

}
