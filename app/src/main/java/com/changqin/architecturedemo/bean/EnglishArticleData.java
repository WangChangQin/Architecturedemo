package com.changqin.architecturedemo.bean;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by wangchangqin on 2017/9/13.
 */
@Entity(tableName = "englishLists")
public class EnglishArticleData {
    /**
     * CreatTime : 2017-09-13 15:08:39.0
     * HardWeight : 8.2
     * Category : 128
     * UserName : smallling2
     * Title : Sydney bride gets married with bouquet made of doughnuts
     * Sound :
     * Pic : 57852.jpg
     * Flag : 1
     * Source : BBC
     * NewsId : 57852
     * Uid : 2291717
     * DescCn : 婚礼上的捧花总是要与众不同才好。这不， 澳洲的这位新娘别出心裁，用甜甜圈做捧花，引来许多网友围观。
     * Title_cn : 甜蜜蜜！澳洲这位新娘婚礼上用甜甜圈做捧花
     * WordCount : 248
     * TopicId : 101
     * ReadCount : 157
     */
    @PrimaryKey
    private String NewsId;
    private String Uid;
    private String CreatTime;
    private String HardWeight;
    private String Category;
    private String UserName;
    private String Title;
    private String Sound;
    private String Pic;
    private String Flag;
    private String Source;
    private String DescCn;
    private String Title_cn;
    private String WordCount;
    private String TopicId;
    private String ReadCount;

    public String getCreatTime() {
        return CreatTime;
    }

    public void setCreatTime(String CreatTime) {
        this.CreatTime = CreatTime;
    }

    public String getHardWeight() {
        return HardWeight;
    }

    public void setHardWeight(String HardWeight) {
        this.HardWeight = HardWeight;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getSound() {
        return Sound;
    }

    public void setSound(String Sound) {
        this.Sound = Sound;
    }

    public String getPic() {
        return Pic;
    }

    public void setPic(String Pic) {
        this.Pic = Pic;
    }

    public String getFlag() {
        return Flag;
    }

    public void setFlag(String Flag) {
        this.Flag = Flag;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String Source) {
        this.Source = Source;
    }

    public String getNewsId() {
        return NewsId;
    }

    public void setNewsId(String NewsId) {
        this.NewsId = NewsId;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String Uid) {
        this.Uid = Uid;
    }

    public String getDescCn() {
        return DescCn;
    }

    public void setDescCn(String DescCn) {
        this.DescCn = DescCn;
    }

    public String getTitle_cn() {
        return Title_cn;
    }

    public void setTitle_cn(String Title_cn) {
        this.Title_cn = Title_cn;
    }

    public String getWordCount() {
        return WordCount;
    }

    public void setWordCount(String WordCount) {
        this.WordCount = WordCount;
    }

    public String getTopicId() {
        return TopicId;
    }

    public void setTopicId(String TopicId) {
        this.TopicId = TopicId;
    }

    public String getReadCount() {
        return ReadCount;
    }

    public void setReadCount(String ReadCount) {
        this.ReadCount = ReadCount;
    }

    @Override
    public String toString() {
        return "EnglishArticleData{" +
                "CreatTime='" + CreatTime + '\'' +
                ", HardWeight='" + HardWeight + '\'' +
                ", Category='" + Category + '\'' +
                ", UserName='" + UserName + '\'' +
                ", Title='" + Title + '\'' +
                ", Sound='" + Sound + '\'' +
                ", Pic='" + Pic + '\'' +
                ", Flag='" + Flag + '\'' +
                ", Source='" + Source + '\'' +
                ", NewsId='" + NewsId + '\'' +
                ", Uid='" + Uid + '\'' +
                ", DescCn='" + DescCn + '\'' +
                ", Title_cn='" + Title_cn + '\'' +
                ", WordCount='" + WordCount + '\'' +
                ", TopicId='" + TopicId + '\'' +
                ", ReadCount='" + ReadCount + '\'' +
                '}';
    }
}
