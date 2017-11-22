package com.changqin.architecturedemo.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.changqin.architecturedemo.bean.EnglishArticleDetail;

import java.util.List;

/**
 * Created by wangchangqin on 2017/11/22.
 */

public class EnglishDetailViewModel extends AndroidViewModel {
    private MutableLiveData<List<EnglishArticleDetail>> mData;
    public EnglishDetailViewModel(@NonNull Application application) {
        super(application);
        mData = new MutableLiveData<>();
    }

    public LiveData<List<EnglishArticleDetail>> getData() {
        return mData;
    }

    public void setData(MutableLiveData<List<EnglishArticleDetail>> data) {
        mData.setValue(data.getValue());
    }
}
