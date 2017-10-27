package com.jia.changle.dao;

import com.jia.changle.po.ClProduct;

import java.util.List;

/**
 * Created by slipkinem on 9/4/2017.
 */
public interface ClProductCustomMapper {
    List<ClProduct> search (String keyword);
}
