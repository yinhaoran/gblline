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
@ColumnWidth(15)
public class WriteResultData {
	@ExcelProperty("运输单号")
	private String billcode;
	@DateTimeFormat("yyyy-MM-dd")
	@ExcelProperty("发运时间")
	private Date date;
	@ExcelProperty("店代码")
	private String storecode;
	@ExcelProperty("店名")
	private String storename;
	@ExcelProperty("箱数")
	private String cages;
	@DateTimeFormat("yyyy-MM-dd")
	@ExcelProperty("预计到达时间")
	private Date expectdate;
	@ExcelProperty("标准时效")
	private String standard;
	@ExcelProperty("实际时效")
	private String actual;
	@ExcelProperty("是否延迟")
	private String delay;
	@DateTimeFormat("yyyy-MM-dd")
	@ExcelProperty("签收时间")
	private Date signdate;
	@ExcelProperty("订单类型")
	private String ordertype;
	@ExcelProperty("运输商")
	private String carrier;
	@ExcelProperty("省份")
	private String province;
	@ExcelProperty("始发地超时")
	private String first;
	@ExcelProperty("中转地超时")
	private String second;
	@ExcelProperty("目的地超时")
	private String third;
	@ExcelProperty("签收超时")
	private String fourth;
}
