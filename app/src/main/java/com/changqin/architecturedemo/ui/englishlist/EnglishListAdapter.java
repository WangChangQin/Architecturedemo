package com.changqin.architecturedemo.ui.englishlist;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.changqin.architecturedemo.R;
import com.changqin.architecturedemo.bean.EnglishArticleData;
import com.changqin.architecturedemo.databinding.ItemEnglishBinding;

import java.util.List;

/**
 * Created by wangchangqin on 2017/11/22.
 */

public class EnglishListAdapter extends RecyclerView.Adapter<EnglishListAdapter.EnglishBindingHolder> {
    List<EnglishArticleData> mEnglishListData;
    @Nullable
    private final EnglishClickCallback mClickCallback;
    public EnglishListAdapter(@NonNull EnglishClickCallback clickCallback) {
        this.mClickCallback = clickCallback;
    }

    @Override
    public EnglishBindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemEnglishBinding binding =  DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_english,parent,false);
        binding.setCallback(mClickCallback);
        return new EnglishBindingHolder(binding);
    }

    @Override
    public void onBindViewHolder(EnglishBindingHolder holder, int position) {
        holder.mBinding.setEnglish(mEnglishListData.get(position));
        holder.mBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mEnglishListData==null?0:mEnglishListData.size();
    }

    public void setEnglishListData(List<EnglishArticleData> englishListData) {
        mEnglishListData = englishListData;
    }
    public void addEnglishListData(List<EnglishArticleData> englishListData) {
        mEnglishListData.addAll(englishListData);
    }

    static class EnglishBindingHolder extends RecyclerView.ViewHolder{
        private ItemEnglishBinding mBinding;

        EnglishBindingHolder(ItemEnglishBinding itemEnglishBinding) {
            super(itemEnglishBinding.getRoot());
            this.mBinding = itemEnglishBinding;
        }
    }
}
