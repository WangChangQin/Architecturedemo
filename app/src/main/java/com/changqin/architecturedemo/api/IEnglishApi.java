package com.changqin.architecturedemo.api;

import com.changqin.architecturedemo.bean.EnglishArticleDetailResponse;
import com.changqin.architecturedemo.bean.EnglishArticleResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by wangchangqin on 2017/10/18.
 */

public interface IEnglishApi {
    /***
     * public static final String BASE_ENGLISH = "http://cms.iyuba.com/cmsApi";
     public static final String ENGLISH_LIST = BASE_ENGLISH + "/getMyNewsList.jsp?maxId=0&pageCounts={pageCounts}&source=0&format=json&categoryId={categoryId}&level={level}";
     public static final String ENGLISH_DETAIL = BASE_ENGLISH + "/getText.jsp?format=json&uid=4093785&appid=153&NewsId={NewsId}";
     public static final String ENGLISH_COVER = "http://static.iyuba.com/cms/news/image/";
     * @return pageCounts
     */
    @GET("getMyNewsList.jsp?maxId=0&source=0&format=json")
    Call<EnglishArticleResponse> getEnglishList(@Query("pageCounts") int pageCounts,
                                                @Query("categoryId") int categoryId,
                                                @Query("level") int level);

    @GET("getText.jsp?format=json&uid=4093785&appid=153")
    Call<EnglishArticleDetailResponse> getEnglishDetail(@Query("NewsId") String NewsId);
}
