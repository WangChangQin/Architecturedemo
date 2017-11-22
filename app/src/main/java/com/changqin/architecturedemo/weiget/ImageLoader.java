package com.changqin.architecturedemo.weiget;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.changqin.architecturedemo.R;
import com.changqin.architecturedemo.app.App;

/**
 * Created by wangchangqin on 2017/10/17.
 */

public class ImageLoader {
    public static void LoadImg(String url, ImageView iv) {
        Glide.with(App.sContext)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .error(R.drawable.default_wrong)
                .into(iv);
    }
}
