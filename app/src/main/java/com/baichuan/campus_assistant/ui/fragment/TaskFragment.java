package com.baichuan.campus_assistant.ui.fragment;


import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.baichuan.campus_assistant.CloudNoteApp;
import com.baichuan.campus_assistant.R;
import com.baichuan.campus_assistant.adapter.NoteRecyclerAdapter;
import com.baichuan.campus_assistant.db.entity.Note;
import com.baichuan.campus_assistant.db.entity.NoteEntity;
import com.baichuan.campus_assistant.observable.NotesFromDatabaseObservable;
import com.baichuan.campus_assistant.observable.NotesSyncToBmobObservable;
import com.baichuan.campus_assistant.ui.activity.EditNoteActivity;
import com.baichuan.campus_assistant.ui.activity.NoteDetailActivity;
import com.baichuan.campus_assistant.utils.NetUtils;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import rx.Observer;
import rx.functions.Action0;

/**
 * A simple {@link Fragment} subclass.
 */
public class TaskFragment extends BaseFragment implements Observer<List<NoteEntity>> {


    @Override
    protected void init() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_task;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onNext(List<NoteEntity> noteEntities) {

    }
}