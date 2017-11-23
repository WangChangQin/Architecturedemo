package com.changqin.architecturedemo.bean;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;

/**
 * Created by wangchangqin on 2017/9/13.
 */
@Entity(tableName = "english_detail",foreignKeys = {
        @ForeignKey(entity = EnglishArticleData.class,
                parentColumns = "NewsId",
                childColumns = "NewsId",
                onDelete = ForeignKey.CASCADE)},indices = {
        @Index(value = "NewsId")
})
public class EnglishArticleDetail {
    /**
     * ImgPath :
     * ParaId : 1
     * IdIndex : 1
     * EndTime : 0.0
     * ImgDesc :
     * Timing : 0.0
     * Sentence_cn : 上周日摘得美国小姐桂冠的女孩是来自北达科塔州的常春藤联盟大学毕业生，同时也是国家舞蹈冠军。
     * Sentence : An Ivy League graduate and national dance champion from North Dakota was crowned Miss America on Sunday.
     * NewsId : 57838
     */

    private String ImgPath;
    private String ParaId;
    private String IdIndex;
    private String EndTime;
    private String ImgDesc;
    private String Timing;
    private String Sentence_cn;
    private String Sentence;
    private String NewsId;

    public String getImgPath() {
        return ImgPath;
    }

    public void setImgPath(String ImgPath) {
        this.ImgPath = ImgPath;
    }

    public String getParaId() {
        return ParaId;
    }

    public void setParaId(String ParaId) {
        this.ParaId = ParaId;
    }

    public String getIdIndex() {
        return IdIndex;
    }

    public void setIdIndex(String IdIndex) {
        this.IdIndex = IdIndex;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String EndTime) {
        this.EndTime = EndTime;
    }

    public String getImgDesc() {
        return ImgDesc;
    }

    public void setImgDesc(String ImgDesc) {
        this.ImgDesc = ImgDesc;
    }

    public String getTiming() {
        return Timing;
    }

    public void setTiming(String Timing) {
        this.Timing = Timing;
    }

    public String getSentence_cn() {
        return Sentence_cn;
    }

    public void setSentence_cn(String Sentence_cn) {
        this.Sentence_cn = Sentence_cn;
    }

    public String getSentence() {
        return Sentence;
    }

    public void setSentence(String Sentence) {
        this.Sentence = Sentence;
    }

    public String getNewsId() {
        return NewsId;
    }

    public void setNewsId(String NewsId) {
        this.NewsId = NewsId;
    }

    @Override
    public String toString() {
        return "EnglishArticleDetail{" +
                "ImgPath='" + ImgPath + '\'' +
                ", ParaId='" + ParaId + '\'' +
                ", IdIndex='" + IdIndex + '\'' +
                ", EndTime='" + EndTime + '\'' +
                ", ImgDesc='" + ImgDesc + '\'' +
                ", Timing='" + Timing + '\'' +
                ", Sentence_cn='" + Sentence_cn + '\'' +
                ", Sentence='" + Sentence + '\'' +
                ", NewsId='" + NewsId + '\'' +
                '}';
    }
}
