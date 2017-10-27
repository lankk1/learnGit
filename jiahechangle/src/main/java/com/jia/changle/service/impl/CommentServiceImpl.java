package com.jia.changle.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jia.changle.mapper.ClCommentMapper;
import com.jia.changle.po.ClComment;
import com.jia.changle.po.ClCommentExample;
import com.jia.changle.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by slipkinem on 8/31/2017 at 11:52 AM.
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private ClCommentMapper clCommentMapper;

    @Override
    public Integer insertComment(ClComment comment) {
        Integer status = null;
        try {
            status = clCommentMapper.insert(comment);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public Map<String, Object> getComments(Integer pageNum, Integer pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<ClComment> comments;

        try {
            PageHelper.startPage(pageNum, pageSize);
            ClCommentExample clCommentExample = new ClCommentExample();
            clCommentExample.setOrderByClause("create_time desc");
            comments = clCommentMapper.selectByExampleWithBLOBs(clCommentExample);
            PageInfo<ClComment> page = new PageInfo<ClComment>(comments);
            map.put("comments", comments);
            map.put("total", page.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

    @Override
    public Integer deleteComments(Integer commentId) {
        return clCommentMapper.deleteByPrimaryKey(commentId);
    }
}
