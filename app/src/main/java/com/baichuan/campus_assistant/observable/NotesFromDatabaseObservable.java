package com.baichuan.campus_assistant.observable;

import com.baichuan.campus_assistant.db.NoteUtils;
import com.baichuan.campus_assistant.db.entity.NoteEntity;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by baichuan on 2017/2/19.
 */
public class NotesFromDatabaseObservable {

    public static Observable<List<NoteEntity>> ofDate() {
        return Observable.create(new Observable.OnSubscribe<List<NoteEntity>>() {
            @Override
            public void call(Subscriber<? super List<NoteEntity>> subscriber) {
                List<NoteEntity> noteEntities = NoteUtils.list();
                if (noteEntities != null && noteEntities.size() != 0) {
                    subscriber.onNext(noteEntities);
                }
                subscriber.onCompleted();
            }
        })
                .subscribeOn(Schedulers.io())                     //io线程执行
                .observeOn(AndroidSchedulers.mainThread());      //主线程观察
    }
}
