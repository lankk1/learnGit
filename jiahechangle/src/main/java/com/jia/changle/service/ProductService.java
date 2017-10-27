package com.jia.changle.service;

import com.jia.changle.po.ClProduct;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by slipkinem on 8/31/2017 at 11:53 AM.
 */
public interface ProductService {
    Map<String, Object> getProducts(Integer pageNum, Integer pageSize, String lang);
    Integer deleteProduct(Integer productId);
    List<ClProduct> getProductById();
    Integer insertProduct(ClProduct product);
    Integer updateProduct(ClProduct product);
    List<ClProduct> search(String keyword);
    Integer upload(HttpServletRequest request);
}
