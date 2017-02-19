package com.baichuan.campus_assistant.db;

import com.baichuan.campus_assistant.CloudNoteApp;
import com.baichuan.campus_assistant.db.dao.NoteEntityDao;
import com.baichuan.campus_assistant.db.entity.NoteEntity;

import java.util.List;

/**
 * Created by baichuan on 2017/2/19.
 */
public class NoteUtils {

    /**
     * 列出全部数据
     * @return
     */
    public static List<NoteEntity> list(){
        List<NoteEntity> noteEntities;
        noteEntities= CloudNoteApp.getNoteEntityDao()
                .queryBuilder()
                .orderDesc(NoteEntityDao.Properties.Id)
                .list();
        return noteEntities;
    }

    /**
     * 列出未同步的所有数据
     * @return
     */
    public static List<NoteEntity> listNotSync(){
        //找出数据库中所有同步标记为否的
        List<NoteEntity> noteEntities;
        noteEntities=CloudNoteApp.getNoteEntityDao()
                .queryBuilder()
                .where(NoteEntityDao.Properties.IsSync.eq(false))
                .build()
                .list();
        return noteEntities;
    }
}
