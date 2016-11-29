package com.meituan.pangjiaqi.mvp_demo.view;

/**
 * Created by pangjiaqi on 2016/11/25.
 * 这是一个View的接口，由UserActivity实现
 */

public interface IUserView {
    /**
     * 这两个方法，将会由presenter调用，而实际由Activity重写这两个方法
     * @param id
     */
    void setId(int id);
    void SetNameAndSex(String name,boolean isBoy);
}
