package com.jia.changle.service;

import com.jia.changle.po.ClComment;

import java.util.Map;

/**
 * Created by slipkinem on 8/31/2017 at 11:52 AM.
 */
public interface CommentService {
    Integer insertComment (ClComment comment);

    Map<String, Object> getComments(Integer pageNum, Integer pageSize);

    Integer deleteComments(Integer commentId);
}
