package com.meituan.pangjiaqi.mvp_demo.model;

import com.meituan.pangjiaqi.mvp_demo.bean.UserBean;

/**
 * Created by pangjiaqi on 2016/11/25.
 * userModel的接口，由userModel实现方法
 * 在Presenter的构造中使用这个接口
 */

public interface IUserModel {
    //void setId(int id);
    UserBean loadUser(int id);
    void saveUser(UserBean userBean);
    void setNameAndSex(String name, boolean r);
}
