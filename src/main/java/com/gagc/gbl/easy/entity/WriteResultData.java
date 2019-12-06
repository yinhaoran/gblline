package com.gagc.gbl.easy.entity;

import java.util.Date;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;

import lombok.Data;

/**
 * 在途预警报告对象
 * 
 * @author yin
 * @date 2019/11/07
 */
@Data

public class WriteResultData {
    @ColumnWidth(15)
    @ExcelProperty("运输单号")
    private String billcode;
    
    @ColumnWidth(15)
    @DateTimeFormat("yyyy-MM-dd")
    @ExcelProperty("发运时间")
    private Date date;
    
    @ColumnWidth(15)
    @ExcelProperty("店代码")
    private String storecode;
    
    @ColumnWidth(15)
    @ExcelProperty("店名")
    private String storename;
    
    @ColumnWidth(15)
    @ExcelProperty("箱数")
    private String cages;
    
    @ColumnWidth(15)
    @DateTimeFormat("yyyy-MM-dd")
    @ExcelProperty("预计到达时间")
    private Date expectdate;
    
    @ColumnWidth(15)
    @ExcelProperty("标准时效")
    private String standard;
    
    @ColumnWidth(15)
    @ExcelProperty("实际时效")
    private String actual;
    
    @ColumnWidth(15)
    @ExcelProperty("是否延迟")
    private String delay;
    
    @ColumnWidth(15)
    @DateTimeFormat("yyyy-MM-dd")
    @ExcelProperty("签收时间")
    private Date signdate;
    
    /**
     * TODO ADD BY YHR 增加【运输方式】字段
     */
    @ColumnWidth(15)
    @ExcelProperty("运输方式")
    private String transtype;
    
    @ColumnWidth(15)
    @ExcelProperty("订单类型")
    private String ordertype;
    
    @ColumnWidth(15)
    @ExcelProperty("运输商")
    private String carrier;

    /**
     * TODO ADD BY YHR 增加【中转城市】字段
     */
    @ColumnWidth(15)
    @ExcelProperty("中转城市")
    private String secondCity;
    
    @ColumnWidth(15)
    @ExcelProperty("省份")
    private String province;
    
    @ColumnWidth(15)
    @ExcelProperty("始发地超时")
    private String first;
    
    @ColumnWidth(15)
    @ExcelProperty("中转地超时")
    private String second;
    
    @ColumnWidth(15)
    @ExcelProperty("目的地超时")
    private String third;
    
    @ColumnWidth(15)
    @ExcelProperty("签收超时")
    private String fourth;
    /**
     * TODO ADD BY YHR 增加【超时结果】字段
     */
    @ColumnWidth(30)
    @ExcelProperty("超时结果")
    private String result;
}
