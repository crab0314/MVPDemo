package com.meituan.pangjiaqi.mvp_demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.meituan.pangjiaqi.mvp_demo.R;
import com.meituan.pangjiaqi.mvp_demo.presenter.MPresenter;
import com.meituan.pangjiaqi.mvp_demo.view.IUserView;

/**
 * 这个Activity实现了IUserView接口的方法，在整个这个文件中，都不需要了解model的结构
 * 具体是通过presenter，传入presenter需要的参数，需要展示的也由presenter返回来
 */

public class UserActivity extends Activity implements IUserView {

    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private MPresenter mPresenter = new MPresenter(this);


    private void initView() {
        editText1 = (EditText) findViewById(R.id.uid_edit);
        editText2 = (EditText) findViewById(R.id.uname_edit);
        editText3 = (EditText) findViewById(R.id.usex_edit);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void click(View view) {
        switch (view.getId()) {
            case R.id.bt_query:
                if (!TextUtils.isEmpty(editText1.getText().toString())) {
                    mPresenter.load(Integer.parseInt(editText1.getText().toString()));
                } else {
                    Toast.makeText(this, "请输入id", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.bt_reset:
                if (!editText1.getText().toString().equals("not found")
                        && !TextUtils.isEmpty(editText2.getText().toString())
                        && !TextUtils.isEmpty(editText3.getText().toString())
                        && ((editText3.getText().toString().equals("girl"))
                        || (editText3.getText().toString().equals("boy")))) {
                    mPresenter.saveUser(editText2.getText().toString(),
                            editText2.getText().toString().equals("boy") ? true : false);
                    Toast.makeText(this, "已存", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "请输入正确信息", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void setId(int id) {
        editText1.setText("" + id);
    }

    @Override
    public void SetNameAndSex(String name, boolean isBoy) {
        editText2.setText(name);
        if (name.equals("not found"))
            editText3.setText("not found");
        else
            editText3.setText(isBoy ? "boy" : "girl");
    }

}
