package com.gagc.gbl.easy.entity;

import java.util.List;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

import lombok.Data;

/**
 * 在途信息对照
 * 
 * @author yin
 * @date 2019/11/07
 */
@Data
public class ToStoreIndexData {
    /**
     * 序号
     */
	@ExcelProperty(index = 0)
	private String no;
	/**
	 * 发运时间
	 */
	@ExcelProperty(index = 1)
	private String date;
	/**
	 * 运输单号
	 */
	@ExcelProperty(index = 2)
	private String billcode;
	/**
	 * 店代码
	 */
	@ExcelProperty(index = 3)
	private String storecode;
	/**
	 * 店名
	 */
	@ExcelProperty(index = 4)
	private String storename;
	/**
	 * 箱数
	 */
	@ExcelProperty(index = 5)
	private String cages;
	/**
	 * 预计到达时间
	 */
	@ExcelProperty(index = 6)
	private String expectdate;
	/**
	 * 标准时效（天）
	 */
	@ExcelProperty(index = 7)
	private String standard;
	/**
	 * 实际时效（天）
	 */
	@ExcelProperty(index = 8)
	private String actual;
	/**
	 * 是否延迟
	 */
	@ExcelProperty(index = 9)
	private String delay;
	/**
	 * 签收时间
	 */
	@ExcelProperty(index = 10)
	private String sign;
	/**
	 * 订单类型
	 */
	@ExcelProperty(index = 11)
	private String ordertype;
	/**
	 * 运输商
	 */
	@ExcelProperty(index = 12)
	private String carrier;
	/**
	 * 省份
	 */
	@ExcelProperty(index = 13)
	private String province;
	/**
	 * 区域
	 */
	@ExcelProperty(index = 14)
	private String area;
	
	@ExcelProperty(index = 18)
	private String place1;
	
	@ExcelProperty(index = 20)
	private String place2;
	
	@ExcelProperty(index = 22)
	private String place3;
	
	@ExcelProperty(index = 24)
	private String place4;
	
	@ExcelProperty(index = 26)
	private String place5;
	
	@ExcelProperty(index = 28)
	private String place6;
	
	@ExcelProperty(index = 30)
	private String place7;
	
	@ExcelProperty(index = 32)
	private String place8;
	
	@ExcelProperty(index = 34)
	private String place9;
	
	@ExcelProperty(index = 36)
	private String place10;
	
	@ExcelProperty(index = 38)
	private String place11;
	
	@ExcelProperty(index = 40)
	private String place12;
	
	@ExcelProperty(index = 42)
	private String place13;
	
	@ExcelProperty(index = 44)
	private String place14;
	
	@ExcelProperty(index = 46)
	private String place15;
	
	@ExcelIgnore
	private List<String> list;
}
