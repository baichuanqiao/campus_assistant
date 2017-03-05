package com.baichuan.campus_assistant.ui.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import com.baichuan.campus_assistant.db.entity.MyUser;
import com.baichuan.campus_assistant.R;
import com.baichuan.campus_assistant.utils.NetUtils;

import butterknife.BindView;
import butterknife.OnClick;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class RegisterActivity extends BaseActivity {

    @BindView(R.id.etRegisterUsername)
    EditText mEtRegisterUsername;
    @BindView(R.id.etRegisterPassword)
    EditText mEtRegisterPassword;
    @BindView(R.id.etRegisterNickname)
    EditText mEtRegisterNickname;
    @BindView(R.id.btnRegister)
    Button mBtnRegister;
    @BindView(R.id.ivBack)
    ImageView mIvBack;

    private String mRegisterUsername;
    private String mRegisterPassword;
    private String mRegisterNickname;

    @Override
    protected void initView() {}

    @Override
    protected void initData() {}

    @Override
    protected void setListeners() {}

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @OnClick({R.id.ivBack, R.id.btnRegister})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivBack:
                finish();
                break;
            case R.id.btnRegister:
                mRegisterUsername = mEtRegisterUsername.getText().toString().trim();
                mRegisterPassword = mEtRegisterPassword.getText().toString().trim();
                mRegisterNickname = mEtRegisterNickname.getText().toString().trim();
                //都不是空
                if (!NetUtils.isConnected(mContext)) {
                    showShortToast(getString(R.string.no_connect));
                } else if (TextUtils.isEmpty(mRegisterUsername)) {
                    mEtRegisterUsername.requestFocus();
                    mEtRegisterUsername.setError(getString(R.string.username_nonblank));
                    return;
                } else if (TextUtils.isEmpty(mRegisterPassword)) {
                    mEtRegisterPassword.requestFocus();
                    mEtRegisterPassword.setError(getString(R.string.password_nonblank));
                    return;
                }  else if (TextUtils.isEmpty(mRegisterNickname)) {
                    mEtRegisterNickname.requestFocus();
                    mEtRegisterNickname.setError(getString(R.string.nickname_nonblank));
                    return;
                }
                else {
                    showProgress();
                    MyUser myUser = new MyUser();
                    myUser.setUsername(mRegisterUsername);
                    myUser.setPassword(mRegisterPassword);
                    myUser.setNickname(mRegisterNickname);
                    //注意：不能用save方法进行注册
                    myUser.signUp(new SaveListener<MyUser>() {
                        @Override
                        public void done(MyUser myUser, BmobException e) {
                            closeProgress();
                            if (e == null) {
                                showShortToast(getString(R.string.register_success));
                                startActivity(new Intent(mContext, MainActivity.class));
                                RegisterActivity.this.finish();
                            } else {
                                showShortToast(getString(R.string.register_err));
                            }
                        }
                    });
                }
                break;
        }
    }
}
