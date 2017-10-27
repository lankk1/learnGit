package com.jia.changle.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jia.changle.dao.ClProductCustomMapper;
import com.jia.changle.mapper.ClProductMapper;
import com.jia.changle.po.ClProduct;
import com.jia.changle.po.ClProductExample;
import com.jia.changle.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
 * Created by slipkinem on 8/31/2017 at 11:53 AM.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ClProductMapper productMapper;

    @Autowired
    private ClProductCustomMapper productCustomMapper;

//    @Value("#{changle['uploadUrl']}")
    private static String uploadUrl = "/usr/local/images/";

    @Override
    public Map<String, Object> getProducts(Integer pageNum, Integer pageSize, String lang) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<ClProduct> products;
        try {
            PageHelper.startPage(pageNum, pageSize);
            products = productMapper.selectByExample(new ClProductExample());

            if (lang != null && !"".equals(lang) && lang.equals("en")) {
                for (int i = 0; i < products.size(); i++) {
                    products.get(i).setProductName(products.get(i).getProductNameEn());
                    products.get(i).setProductDescription(products.get(i).getProductDescriptionEn());
                }
            }

            PageInfo<ClProduct> page = new PageInfo<ClProduct>(products);
            map.put("products", products);
            map.put("total", page.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public Integer deleteProduct(Integer productId) {
        return productMapper.deleteByPrimaryKey(productId);
    }

    @Override
    public List<ClProduct> getProductById() {
        return null;
    }

    @Override
    public Integer insertProduct(ClProduct product) {
        return productMapper.insert(product);
    }

    @Override
    public Integer updateProduct(ClProduct product) {
        return productMapper.updateByPrimaryKey(product);
    }

    @Override
    public List<ClProduct> search(String keyword) {
        return productCustomMapper.search(keyword);
    }

    @Override
    public Integer upload(HttpServletRequest request) {
        Integer code = null;
        ClProduct product = new ClProduct();

        try {
            if (request.getParameter("productId") != null) {
                product.setProductId(Integer.parseInt(request.getParameter("productId")));
            }
            if (request.getParameter("status") != null) {
                product.setStatus(Integer.parseInt(request.getParameter("status")));
            } else {
                product.setStatus(0);
            }
            product.setProductName(request.getParameter("productName"));
            product.setProductNameEn(request.getParameter("productNameEn"));
            product.setProductDescription(request.getParameter("productDescription"));
            product.setProductDescriptionEn(request.getParameter("productDescriptionEn"));
            MultipartHttpServletRequest multipartHttpServletRequest = WebUtils.getNativeRequest(request, MultipartHttpServletRequest.class);
            MultipartFile file = multipartHttpServletRequest.getFile("file");

            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();

                File targetFile = new File(uploadUrl, fileName);
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }
                System.out.print("开始上传文件，uploadUrl："+uploadUrl);
                System.out.print("文件信息："+targetFile.toString());
                file.transferTo(targetFile);
                product.setProductImg("/changle_uploads/" + fileName);

                if (product.getProductId() != null) {
                    code = this.updateProduct(product);
                } else {
                    code = this.insertProduct(product);
                }
            }
        } catch (Exception e) {
            System.out.print(e.toString());
            e.printStackTrace();
        }
        return code;
    }
}
