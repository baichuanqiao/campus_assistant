package com.baichuan.campus_assistant.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.bmob.v3.BmobUser;
import com.baichuan.campus_assistant.R;
import com.baichuan.campus_assistant.db.entity.MyUser;
import com.baichuan.campus_assistant.db.entity.NoteEntity;
import com.baichuan.campus_assistant.db.entity.Note;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.exception.BmobException;
/**
 * Created by baichuan on 2017/2/19.
 */
public class NoteRecyclerAdapter extends ListBaseAdapter {
    private LayoutInflater mInflater;

    public NoteRecyclerAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(mInflater.inflate(R.layout.item_note,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        NoteEntity noteEntity = mDataList.get(position);
        final ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.tvTitle.setText(noteEntity.getTitle());
        viewHolder.tvDate.setText(noteEntity.getDate());
        viewHolder.tvSummary.setText(noteEntity.getSummary());
        final BmobQuery<Note> query = new BmobQuery<Note>();
        query.getObject(noteEntity.getObjId(), new QueryListener<Note>() {

            @Override
            public void done(Note object, BmobException e) {

                viewHolder.tvUserId.setText(object.getUserObjId());

            }

        });
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;
        private TextView tvDate;
        private TextView tvSummary;
        private TextView tvUserId;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            tvSummary = (TextView) itemView.findViewById(R.id.tvSummary);
            tvUserId = (TextView) itemView.findViewById(R.id.userId);
        }
    }
}
