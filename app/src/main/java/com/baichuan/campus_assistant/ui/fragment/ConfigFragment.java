package com.baichuan.campus_assistant.ui.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.baichuan.campus_assistant.R;
import com.baichuan.campus_assistant.ui.activity.LoginActivity;
import com.baichuan.campus_assistant.ui.activity.MainActivity;

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
    @BindView(R.id.myTask)
    TextView textView;

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


    @OnClick({R.id.btnInOut,R.id.myTask})
    public void onClick(View view) {
        switch(view.getId()){
            case  R.id.btnInOut:
                BmobUser.logOut();   //清除缓存用户对象
                startActivity(new Intent(mContext, LoginActivity.class));
                getActivity().finish();
                break;
            case  R.id.myTask:
                startActivity(new Intent(mContext,MainActivity.class));
                getActivity().finish();
                break;
        }

    }


}
