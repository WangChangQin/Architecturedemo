package com.changqin.architecturedemo.weiget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.changqin.architecturedemo.R;


/**
 * Created by wangchangqin on 2017/9/14.
 */

@SuppressLint("AppCompatCustomView")
public class BilingualTextView extends TextView {
    private String[] article;
    public enum ArticleType{
        English,
        Bilingual
    }
    public BilingualTextView(Context context) {
        this(context,null);
    }

    public BilingualTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BilingualTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTextSize(16);
        setLineSpacing(2,1.5f);
        setTextColor(ContextCompat.getColor(context, R.color.jianshu_topic_title_color));
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0,20,0,20);
        setLayoutParams(lp);
    }

    /***
     * [0] 中文
     * [1] 英文
     * @param article
     */
    public void setArticle(String[] article){
        if (article!=null&&article.length==2){
            this.article = article;
            setText(article[1]);
        }
    }

    public void setArticleType(ArticleType type){
        if (article==null||article.length!=2){
            throw new RuntimeException("please set data first");
        }
        if (type.equals(ArticleType.English)){
            setText(article[1]);
        }else {
            setText(article[1]+"\n"+article[0]);
        }
    }
}
