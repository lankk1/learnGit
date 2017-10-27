package com.jia.changle.controller;

import com.jia.changle.po.ClProduct;
import com.jia.changle.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by slipkinem on 8/31/2017 at 2:15 PM.
 */

@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getProducts(Integer pageNum, Integer pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.putAll(productService.getProducts(pageNum, pageSize, null));
            map.put("errorCode", 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteProduct(@PathVariable Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Integer code = productService.deleteProduct(id);
            map.put("errorCode", code);
            map.put("errorMessage", "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> updateProduct(@RequestBody ClProduct product) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Integer code = productService.updateProduct(product);
            map.put("errorCode", code);
            map.put("errorMessage", "编辑成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("errorCode", 99);
            map.put("errorMessage", "编辑失败，服务器错误");
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
    public Map<String, Object> uploadProductImg(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            System.out.println(request.getParameter("productName"));
            map.put("errorCode", productService.upload(request));
            map.put("errorMessage", "上传成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("errorCode", 99);
            map.put("errorMessage", "上传失败，服务器错误");
        }
        return map;
    }

    /**
     * 插入记录
     *
     * @param product 产品
     * @return map
     */
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insertProduct(@RequestBody ClProduct product) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Integer code = productService.updateProduct(product);
            map.put("errorCode", code);
            map.put("errorMessage", "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("errorCode", 99);
            map.put("errorMessage", "添加失败，服务器错误");
        }
        return map;
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public ModelAndView search(String keyword, HttpSession httpSession, String lang) {
        ModelAndView mv = new ModelAndView();
        Map<String, Object> map = new HashMap<String, Object>();

        List<ClProduct> list = productService.search(keyword);
        map.put("products", list);
        mv.addObject("res", map);
        mv.setViewName("product");
        return mv;
    }

}
