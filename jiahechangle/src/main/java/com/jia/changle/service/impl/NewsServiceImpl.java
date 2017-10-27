package com.jia.changle.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jia.changle.mapper.ClNewsMapper;
import com.jia.changle.po.ClNews;
import com.jia.changle.po.ClNewsExample;
import com.jia.changle.po.ClProduct;
import com.jia.changle.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by slipkinem on 9/5/2017 at 10:41 AM.
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private ClNewsMapper newsMapper;

    @Value("#{changle['uploadUrl']}")
    private String uploadUrl;

    @Override
    public Map<String, Object> getNews(Integer pageNum, Integer pageSize, String lang) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<ClNews> news;
        try {
            PageHelper.startPage(pageNum, pageSize);
            news = newsMapper.selectByExampleWithBLOBs(new ClNewsExample());

            if (lang != null && !"".equals(lang) && lang.equals("en")) {
                for (int i = 0; i < news.size(); i++) {
                    news.get(i).setNewsContent(news.get(i).getNewsContentEn());
                    news.get(i).setNewsSubtitle(news.get(i).getNewsSubtitleEn());
                    news.get(i).setNewsTitle(news.get(i).getNewsTitleEn());
                }
            }

            PageInfo<ClNews> pageInfo = new PageInfo<ClNews>(news);
            map.put("news", news);
            map.put("total", pageInfo.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public ClNews getNewsById(Integer newsId) {
        return newsMapper.selectByPrimaryKey(newsId);
    }

    @Override
    public Integer upload(HttpServletRequest request) {
        Integer code = null;
        ClNews news = new ClNews();

        try {
            if (request.getParameter("newsId") != null) {
                news.setNewsId(Integer.parseInt(request.getParameter("newsId")));
            }
            if (request.getParameter("status") != null) {
                news.setStatus(Integer.parseInt(request.getParameter("status")));
            } else {
                news.setStatus(0);
            }
            news.setNewsTitle(request.getParameter("newsTitle"));
            news.setNewsTitleEn(request.getParameter("newsTitleEn"));
            news.setNewsSubtitle(request.getParameter("newsSubtitle"));
            news.setNewsSubtitleEn(request.getParameter("newsSubtitleEn"));
            news.setNewsContent(request.getParameter("newsContent"));
            news.setNewsContentEn(request.getParameter("newsContentEn"));
            MultipartHttpServletRequest multipartHttpServletRequest = WebUtils.getNativeRequest(request, MultipartHttpServletRequest.class);
            MultipartFile file = multipartHttpServletRequest.getFile("file");

            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();

                File targetFile = new File(uploadUrl, fileName);
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }
                file.transferTo(targetFile);
                news.setNewsUrl("/changle_uploads/" + fileName);

                if (news.getNewsId() != null) {
                    code = this.update(news);
                } else {
                    code = this.insert(news);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }

    @Override
    public Integer update(ClNews news) {
        return newsMapper.updateByPrimaryKeyWithBLOBs(news);
    }

    @Override
    public Integer insert(ClNews news) {
        return newsMapper.insert(news);
    }

    @Override
    public Integer delete(Integer newsId) {
        return newsMapper.deleteByPrimaryKey(newsId);
    }
}
