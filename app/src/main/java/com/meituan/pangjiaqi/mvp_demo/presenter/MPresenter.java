package com.meituan.pangjiaqi.mvp_demo.presenter;

import com.meituan.pangjiaqi.mvp_demo.bean.UserBean;
import com.meituan.pangjiaqi.mvp_demo.model.IUserModel;
import com.meituan.pangjiaqi.mvp_demo.model.UserModel;
import com.meituan.pangjiaqi.mvp_demo.view.IUserView;

/**
 * Created by pangjiaqi on 2016/11/25.
 * 这是处理view和model的逻辑部分，view与model不直接联系
 * View的部分，通过初始化一个MPresenter实现
 * View通过MPresenter实现处理
 * 把presenter需要的参数传给它，而不需要知道他是如何跟model交互的
 */

public class MPresenter {
    private IUserModel iUserModel;
    private IUserView iUserView;

    public MPresenter(IUserView view) {
        iUserView = view;
        iUserModel = new UserModel();
    }

    /**
     * 把从view传来的数据存在model中
     * @param name
     * @param isBoy
     */
    public void saveUser(String name, boolean isBoy) {
        iUserModel.saveUser(new UserBean(name, isBoy));
    }

    /**
     * 从model里面取到数据，并通过view的接口设置给view，具体由Activity实现
     * @param id
     */
    public void load(int id) {
        UserBean user = iUserModel.loadUser(id);
        iUserView.setId(id);
        iUserView.SetNameAndSex(user.getName(),user.isBoy());
    }

}
