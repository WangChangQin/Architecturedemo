package com.changqin.architecturedemo.ui.englishlist;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.changqin.architecturedemo.R;
import com.changqin.architecturedemo.api.IEnglishApi;
import com.changqin.architecturedemo.bean.EnglishArticleData;
import com.changqin.architecturedemo.bean.EnglishArticleResponse;
import com.changqin.architecturedemo.databinding.ActivityEnglishBinding;
import com.changqin.architecturedemo.net.RetrofitFactory;
import com.changqin.architecturedemo.ui.englishdetail.EnglishDetailActivity;
import com.changqin.architecturedemo.viewmodel.EnglishListViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EnglishListActivity extends AppCompatActivity {

    private EnglishListAdapter mEnglishListAdapter;
    private ActivityEnglishBinding mBinding;
    private EnglishListViewModel mEnglishListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //init databinding
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_english);
        mEnglishListAdapter = new EnglishListAdapter(mEnglishClickCallback);
        mBinding.englishList.setAdapter(mEnglishListAdapter);
        mBinding.setIsLoading(true);
        //init viewmodel
        mEnglishListViewModel = ViewModelProviders.of(this).get(EnglishListViewModel.class);
        subscribeUi();
        loadData();
    }

    private void subscribeUi() {
        mEnglishListViewModel.getEnglishData().observe(this, new Observer<List<EnglishArticleData>>() {
            @Override
            public void onChanged(@Nullable List<EnglishArticleData> data) {
                if (data != null) {
                    mBinding.setIsLoading(false);
                    mEnglishListAdapter.setEnglishListData(data);
                } else {
                    mBinding.setIsLoading(true);
                }
                mBinding.executePendingBindings();
            }
        });
    }

    private void loadData() {
        mBinding.setIsLoading(true);
        RetrofitFactory.getRetrofit().create(IEnglishApi.class)
                .getEnglishList(10, 0, 0)
                .enqueue(new Callback<EnglishArticleResponse>() {
                    @Override
                    public void onResponse(Call<EnglishArticleResponse> call, Response<EnglishArticleResponse> response) {
                        EnglishArticleResponse data = response.body();
                        if (data != null) {
                            MutableLiveData<List<EnglishArticleData>> mutableLiveData = new MutableLiveData<>();
                            mutableLiveData.setValue(data.getData());
                            mEnglishListViewModel.setEnglishData(mutableLiveData);
                        }
                    }

                    @Override
                    public void onFailure(Call<EnglishArticleResponse> call, Throwable t) {
                        mBinding.setIsLoading(false);
                        mBinding.executePendingBindings();
                        Toast.makeText(EnglishListActivity.this, "load fail!", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private final EnglishClickCallback mEnglishClickCallback = new EnglishClickCallback() {
        @Override
        public void onClick(EnglishArticleData data) {
            EnglishDetailActivity.startAction(EnglishListActivity.this,
                    data.getNewsId(),
                    data.getPic(),
                    data.getTitle_cn());
        }
    };
}
