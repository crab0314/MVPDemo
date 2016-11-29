package com.meituan.pangjiaqi.mvp_demo.model;

import com.meituan.pangjiaqi.mvp_demo.bean.UserBean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pangjiaqi on 2016/11/25.
 * 实质上这个model只负责数据相关的部分，不关心视图的部分，不直接和view交互
 * 在这个程序里，数据存在presenter的一个列表中，而实际上可能存在任何地方
 */

public class UserModel implements IUserModel {

    private int id = 0;
    private String name = "";
    private boolean isBoy = false;
    private Map<Integer, UserBean> params = new HashMap<>();

    @Override
    public void setNameAndSex(String name, boolean r) {
        this.name = name;
        isBoy = r;
        UserBean userBean = new UserBean(name, r);
        params.put(id, userBean);
    }

    @Override
    public UserBean loadUser(int id) {
        for(int i:params.keySet()){
            if(i==id){
                return params.get(i);
            }
        }
        return new UserBean("not found",false);
    }

    @Override
    public void saveUser(UserBean userBean) {
        id++;
        params.put(id,userBean);
    }
}
