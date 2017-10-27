package com.jia.changle.controller;

import com.jia.changle.po.ClNews;
import com.jia.changle.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by slipkinem on 9/5/2017.
 */
@RequestMapping(value = "/news")
@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getNews(Integer pageNum, Integer pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.putAll(newsService.getNews(pageNum, pageSize, null));
            map.put("errorCode", 0);
            map.put("errorMessage", "查询成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 上传图片并且根据判断进行插入或者更新
     *
     * @param request request
     * @return Map
     */
    @RequestMapping(value = "upload")
    @ResponseBody
    public Map<String, Object> uploadNews(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("errorCode", newsService.upload(request));
            map.put("errorMessage", "操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("errorCode", 99);
            map.put("errorMessage", "上传失败，服务器错误");
        }
        return map;
    }

    /**
     * 单纯更新新闻
     * @param news
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> uploadNews(@RequestBody ClNews news) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("errorCode", newsService.update(news));
            map.put("errorMessage", "操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("errorCode", 99);
            map.put("errorMessage", "上传失败，服务器错误");
        }
        return map;
    }

    /**
     * 删除新闻
     * @param newsId
     * @return
     */
    @RequestMapping(value = "/{newsId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> uploadNews(@PathVariable("newsId") Integer newsId) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("errorCode", newsService.delete(newsId));
            map.put("errorMessage", "操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("errorCode", 99);
            map.put("errorMessage", "上传失败，服务器错误");
        }
        return map;
    }
}
