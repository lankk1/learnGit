package com.jia.changle.service;

import com.jia.changle.po.ClNews;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by slipkinem on 9/5/2017 at 10:39 AM.
 */
public interface NewsService {
    Map<String, Object> getNews(Integer pageNum, Integer pageSize, String lang);

    ClNews getNewsById(Integer newsId);

    Integer upload(HttpServletRequest request);

    Integer update(ClNews news);
    Integer insert(ClNews news);

    Integer delete(Integer newsId);
}
