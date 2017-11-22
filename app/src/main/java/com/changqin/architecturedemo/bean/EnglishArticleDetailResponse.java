package com.changqin.architecturedemo.bean;

import java.util.List;

/**
 * Created by wangchangqin on 2017/9/13.
 */

public class EnglishArticleDetailResponse {
    /**
     * result : 1
     * total : 7
     * readCount : 3680
     * msg : OK
     * data : [{"ImgPath":"","ParaId":"1","IdIndex":"1","EndTime":"0.0","ImgDesc":"","Timing":"0.0","Sentence_cn":"上周日摘得美国小姐桂冠的女孩是来自北达科塔州的常春藤联盟大学毕业生，同时也是国家舞蹈冠军。","Sentence":"An Ivy League graduate and national dance champion from North Dakota was crowned Miss America on Sunday.","NewsId":"57838"},{"ImgPath":"","ParaId":"2","IdIndex":"1","EndTime":"0.0","ImgDesc":"","Timing":"0.0","Sentence_cn":"这个女孩叫Cara Mund，来自美国俾斯麦，是罗德岛布朗大学的一名毕业生，并且已经被圣母大学法学院录取，她还与世界著名的\u201c火箭女郎\u201d舞团一起训练过一段时间。","Sentence":"Cara Mund, from Bismarck, N.D., a graduate of Brown University in Rhode Island, who has been accepted to Notre Dame\u2019s law school, trained for several summers with the world-famous Rockettes.","NewsId":"57838"},{"ImgPath":"","ParaId":"3","IdIndex":"1","EndTime":"0.0","ImgDesc":"","Timing":"0.0","Sentence_cn":"23岁的Mund是选美大赛中的51名选手之一，51名选手分别代表了美国的50个州和哥伦比亚特区。","Sentence":"Mund, 23, was one of 51 contestants in the pageant, representing the 50 United States and the District of Columbia.","NewsId":"57838"},{"ImgPath":"","ParaId":"4","IdIndex":"1","EndTime":"0.0","ImgDesc":"","Timing":"0.0","Sentence_cn":"在问答环节中，Mund加入了就\u201c美国最近退出巴黎气候协议\u201d议题的辩论，并认为这是一个\u201c糟糕的决定\u201d，\u201c不管信不信(气候变化)，我们都有必要加入会议，\u201d她补充道。","Sentence":"In a question-and-answer session, Mund weighed in on the United States\u2019 recent withdrawal from the Paris climate accord, saying she thought it was a \"bad decision.\" \"Whether you believe it (climate change) or not, we need to be at that table,\" she added.","NewsId":"57838"},{"ImgPath":"","ParaId":"5","IdIndex":"1","EndTime":"0.0","ImgDesc":"","Timing":"0.0","Sentence_cn":"这次选美比赛由美国广播公司在新泽西州的大西洋城现场直播。连续在拉斯维加斯举办了近十年的比赛后，这场比赛又回到了海滨赌博胜地举办。2004年，美国广播公司在收视率大幅下滑后，一度放弃直播，但在几年后又在有线电台重新回归。","Sentence":"The pageant was broadcast live on ABC from Atlantic City, New Jersey. The contest returned to the seaside gambling resort a few years ago after nearly a decade in Las Vegas. It was dropped by ABC in 2004 following a steep ratings decline, but returned after years on cable.","NewsId":"57838"},{"ImgPath":"","ParaId":"6","IdIndex":"1","EndTime":"0.0","ImgDesc":"","Timing":"0.0","Sentence_cn":"评委们根据才艺、现场提问环节、个人采访和礼服及泳装展示，对参赛选手进行了打分，选手中最小的还是青少年，最大的也不超过24岁。","Sentence":"Judges scored contestants, who ranged from teen-agers to the cut-off age of 24, based on talent, the live question segment, a personal interview and appearances in gowns and swimsuits.","NewsId":"57838"},{"ImgPath":"","ParaId":"7","IdIndex":"1","EndTime":"0.0","ImgDesc":"","Timing":"0.0","Sentence_cn":"许多参赛者在才艺表演环节都表演了唱歌和跳舞。获胜者不仅会获得六位数的奖金，还会得到一年的消费费用以及五万美元的奖学金。","Sentence":"Many of the entrants drew on music or dance for the talent portion. The winner receives a six-figure salary, expenses for the year and a $50,000 scholarship.","NewsId":"57838"}]
     */

    private String result;
    private String total;
    private String readCount;
    private String msg;
    private List<EnglishArticleDetail> data;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getReadCount() {
        return readCount;
    }

    public void setReadCount(String readCount) {
        this.readCount = readCount;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<EnglishArticleDetail> getData() {
        return data;
    }

    public void setData(List<EnglishArticleDetail> data) {
        this.data = data;
    }

}
