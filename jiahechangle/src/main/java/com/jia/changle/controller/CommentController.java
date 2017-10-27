package com.jia.changle.controller;

import com.jia.changle.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by slipkinem on 9/4/2017.
 */
@Controller
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getComments(Integer pageNum, Integer pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.putAll(commentService.getComments(pageNum, pageSize));
            map.put("errorCode", 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

    @RequestMapping(value = "/{commentId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteComment (@PathVariable("commentId") Integer commentId) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("errorCode", commentService.deleteComments(commentId));
            map.put("errorMessage", "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }
}
