package com.jia.changle.mapper;

import com.jia.changle.po.ClProduct;
import com.jia.changle.po.ClProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClProductMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cl_product
     *
     * @mbggenerated
     */
    int countByExample(ClProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cl_product
     *
     * @mbggenerated
     */
    int deleteByExample(ClProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cl_product
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer productId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cl_product
     *
     * @mbggenerated
     */
    int insert(ClProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cl_product
     *
     * @mbggenerated
     */
    int insertSelective(ClProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cl_product
     *
     * @mbggenerated
     */
    List<ClProduct> selectByExample(ClProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cl_product
     *
     * @mbggenerated
     */
    ClProduct selectByPrimaryKey(Integer productId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cl_product
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ClProduct record, @Param("example") ClProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cl_product
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ClProduct record, @Param("example") ClProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cl_product
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ClProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cl_product
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ClProduct record);
}