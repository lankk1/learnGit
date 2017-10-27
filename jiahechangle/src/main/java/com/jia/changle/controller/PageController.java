package com.jia.changle.controller;

import com.jia.changle.po.ClComment;
import com.jia.changle.service.CommentService;
import com.jia.changle.service.NewsService;
import com.jia.changle.service.ProductService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by slipkinem on 8/30/2017 at 11:16 AM.
 */
@Controller
@RequestMapping(value = "/changle")
public class PageController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "product/{pageNum}", method = RequestMethod.GET)
    public ModelAndView product(@PathVariable Integer pageNum, HttpServletRequest request, @Param("lang") String lang) {
        ModelAndView mv = new ModelAndView();
        pageNum = pageNum == null ? 0 : pageNum;
        try {
            request.getSession().setAttribute("pageNum", pageNum);
            request.getSession().setAttribute("pageSize", 9);
            mv.addObject("res", productService.getProducts(pageNum, 9, lang));
            mv.setViewName("product");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

    @RequestMapping(value = "about", method = RequestMethod.GET)
    public ModelAndView aboutUs() {
        return new ModelAndView("about");
    }

    @RequestMapping(value = "news/{pageNum}", method = RequestMethod.GET)
    public ModelAndView newsCenter(@PathVariable("pageNum") Integer pageNum, @Param("lang") String lang, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        pageNum = pageNum == null ? 0 : pageNum;
        try {
            request.getSession().setAttribute("pageNum", pageNum);
            request.getSession().setAttribute("pageSize", 3);
            mv.addObject("res", newsService.getNews(pageNum, 3, lang));
            mv.setViewName("news");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

    @RequestMapping(value = "news/detail/{newsId}", method = RequestMethod.GET)
    public ModelAndView newsDetail(@PathVariable("newsId") Integer newsId) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("newsDetail", newsService.getNewsById(newsId));
        mv.setViewName("news-detail");
        return mv;
    }

    @RequestMapping(value = "contact", method = RequestMethod.GET)
    public ModelAndView contactUs() {
        return new ModelAndView("contact");
    }

    @RequestMapping(value = "comment", method = RequestMethod.GET)
    public ModelAndView comment() {
        return new ModelAndView("comment");
    }

    @RequestMapping(value = "comment", method = RequestMethod.POST)
    public ModelAndView postComment(ClComment comment) {
        try {
            Integer r = commentService.insertComment(comment);
            System.out.println(r);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView("comment");
    }

    @RequestMapping(value = "front", method = RequestMethod.GET)
    public ModelAndView front(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("front");
        return mv;
    }
}
