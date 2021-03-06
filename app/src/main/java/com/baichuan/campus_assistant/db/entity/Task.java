package com.baichuan.campus_assistant.db.entity;

import cn.bmob.v3.BmobObject;

/**
 * Created by baichuan on 2017/2/19.
 * 用于bmob云后端使用的后端实体
 */
public class Task extends BmobObject {

    private String title;
    private String summary;
    private String content;
    private String image;   //图片
    private String video;   //视频
    private String userObjId;   //用户id
    private long dbId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getUserObjId() {
        return userObjId;
    }

    public void setUserObjId(String userObjId) {
        this.userObjId = userObjId;
    }

    public long getDbId() {
        return dbId;
    }

    public void setDbId(long dbId) {
        this.dbId = dbId;
    }

    public NoteEntity toEntity() {
        NoteEntity entity = new NoteEntity();
        entity.setTitle(getTitle());
        entity.setContent(getContent());
        entity.setSummary(getSummary());
        entity.setImage(getImage());
        entity.setVideo(getVideo());
        entity.setId(getDbId());
        entity.setDate(getUpdatedAt());
        return entity;
    }
}
