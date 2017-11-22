package com.changqin.architecturedemo.api;

/**
 * Created by wangchangqin on 2017/10/14.
 */

public class ComicApi extends BaseApi{
    public static final String BASE_COMIC_URL = "http://121.41.65.66:88/comics/";
    public static final String GET_ALL_COMIC = BASE_COMIC_URL+"?page={pageIndex}&q%5Btags_name_eq%5D={categoryName}&package_name=com.vjson.anime&version_code=73&version_name=1.0.7.3&channel=coolapk&sign=dcf692dc1d4cead44ce1d5d1b9409e26&platform=android";
    public static final String GET_COMIC_INFO = BASE_COMIC_URL+"{comicId}?package_name=com.vjson.anime&version_code=73&version_name=1.0.7.3&channel=coolapk&sign=dcf692dc1d4cead44ce1d5d1b9409e26&platform=android";
    public static final String GET_COMIC_DETAIL = BASE_COMIC_URL+"{comicId}/{section}?package_name=com.vjson.anime&version_code=73&version_name=1.0.7.3&channel=coolapk&sign=dcf692dc1d4cead44ce1d5d1b9409e26&platform=android";
    public static final String GET_ALL_CATEGORY = BASE_COMIC_URL+"categories?package_name=com.vjson.anime&version_code=73&version_name=1.0.7.3&channel=coolapk&sign=dcf692dc1d4cead44ce1d5d1b9409e26&platform=android";

}
