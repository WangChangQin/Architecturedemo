package com.changqin.architecturedemo.ui.englishdetail;

import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.changqin.architecturedemo.R;
import com.changqin.architecturedemo.api.IEnglishApi;
import com.changqin.architecturedemo.bean.EnglishArticleDetail;
import com.changqin.architecturedemo.bean.EnglishArticleDetailResponse;
import com.changqin.architecturedemo.databinding.ActivityEnglishDetailBinding;
import com.changqin.architecturedemo.net.RetrofitFactory;
import com.changqin.architecturedemo.viewmodel.EnglishDetailViewModel;
import com.changqin.architecturedemo.weiget.BilingualTextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EnglishDetailActivity extends AppCompatActivity {
    private List<BilingualTextView> mTextViews;
    private String mNewId, mCoverUrl, mTitle;
    private boolean mArtType;
    private ActivityEnglishDetailBinding mBinding;
    private EnglishDetailViewModel mViewModel;

    public static void startAction(Activity a, String englishId, String coverurl, String title) {
        Intent intent = new Intent(a, EnglishDetailActivity.class);
        intent.putExtra("id", englishId);
        intent.putExtra("coverurl", coverurl);
        intent.putExtra("title", title);
        a.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_english_detail);
        initData();
        mBinding.setCover(mCoverUrl);
        mBinding.setTitle(mTitle);
        mViewModel = ViewModelProviders.of(this).get(EnglishDetailViewModel.class);
        subscribeUi();
        initToolbar();
        loadData();
    }

    private void initToolbar() {
        mBinding.toolbar.setTitle(mTitle);
        setSupportActionBar(mBinding.toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void subscribeUi() {
        mViewModel.getData().observe(this, new Observer<List<EnglishArticleDetail>>() {
            @Override
            public void onChanged(@Nullable List<EnglishArticleDetail> data) {
                if (data == null) {
                    mBinding.setIsLoading(true);
                } else {
                    mBinding.setIsLoading(false);
                    for (EnglishArticleDetail article : data) {
                        BilingualTextView textView = new BilingualTextView(EnglishDetailActivity.this);
                        String[] articleBilingual = new String[2];
                        articleBilingual[0] = article.getSentence_cn();
                        articleBilingual[1] = article.getSentence();
                        textView.setArticle(articleBilingual);
                        mBinding.articleContent.addView(textView);
                        mTextViews.add(textView);
                    }
                }
                mBinding.executePendingBindings();
            }
        });
    }


    protected void initData() {
        mTextViews = new ArrayList<>();
        Intent intent = getIntent();
        if (intent != null) {
            mNewId = intent.getStringExtra("id");
            mCoverUrl = intent.getStringExtra("coverurl");
            mTitle = intent.getStringExtra("title");
        }
    }

    private void loadData() {
        RetrofitFactory.getRetrofit().create(IEnglishApi.class)
                .getEnglishDetail(mNewId)
                .enqueue(new Callback<EnglishArticleDetailResponse>() {
                    @Override
                    public void onResponse(Call<EnglishArticleDetailResponse> call, Response<EnglishArticleDetailResponse> response) {
                        if (response.body() != null) {
                            MutableLiveData<List<EnglishArticleDetail>> liveData = new MutableLiveData<>();
                            liveData.setValue(response.body().getData());
                            mViewModel.setData(liveData);
                        }
                    }

                    @Override
                    public void onFailure(Call<EnglishArticleDetailResponse> call, Throwable t) {
                        mViewModel.setData(null);
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.englishmenu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //点击back键finish当前activity
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.switch_article_show:
                for (BilingualTextView tv : mTextViews) {
                    if (!mArtType) {
                        tv.setArticleType(BilingualTextView.ArticleType.Bilingual);
                    } else {
                        tv.setArticleType(BilingualTextView.ArticleType.English);
                    }
                }
                mArtType = !mArtType;
                break;
        }
        return true;
    }

}
