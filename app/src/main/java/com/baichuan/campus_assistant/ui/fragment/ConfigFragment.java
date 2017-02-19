package com.baichuan.campus_assistant.ui.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.ImageView;

import com.baichuan.campus_assistant.R;
import com.baichuan.campus_assistant.ui.activity.LoginActivity;

import butterknife.BindView;
import butterknife.OnClick;
import cn.bmob.v3.BmobUser;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConfigFragment extends BaseFragment {

    @BindView(R.id.ivUserAvatar)
    ImageView mIvUserAvatar;
    @BindView(R.id.btnInOut)
    Button mBtnInOut;

    @Override
    protected void init() {
        BmobUser bmobUser = BmobUser.getCurrentUser();
        if (bmobUser != null) {
            mBtnInOut.setText(R.string.login_out);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_config;
    }


    @OnClick(R.id.btnInOut)
    public void onClick() {
        BmobUser.logOut();   //清除缓存用户对象
        startActivity(new Intent(mContext, LoginActivity.class));
        getActivity().finish();
    }
}
