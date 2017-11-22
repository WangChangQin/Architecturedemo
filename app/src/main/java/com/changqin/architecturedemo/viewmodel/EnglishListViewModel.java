package com.changqin.architecturedemo.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.changqin.architecturedemo.bean.EnglishArticleData;

import java.util.List;

/**
 * Created by wangchangqin on 2017/11/22.
 */

public class EnglishListViewModel extends AndroidViewModel{
    private  MutableLiveData<List<EnglishArticleData>> mObservableEnglishData;
    public EnglishListViewModel(@NonNull Application application) {
        super(application);
        mObservableEnglishData = new MutableLiveData<>();
    }

    public LiveData<List<EnglishArticleData>> getEnglishData() {
        return mObservableEnglishData;
    }

    public void setEnglishData(MutableLiveData<List<EnglishArticleData>> observableEnglishData) {
        mObservableEnglishData.setValue(observableEnglishData.getValue());
    }
}
