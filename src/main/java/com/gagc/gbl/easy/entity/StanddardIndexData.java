package com.gagc.gbl.easy.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

import lombok.Data;

/**
 * 店铺路线标准时间对照
 * 
 * @author yin
 * @date 2019/11/07
 */
@Data
public class StanddardIndexData {
	/**
	 * 店代码
	 */
    @ExcelProperty(index = 2)
	private String storecode;
	/**
	 * 标准时效
	 */
    @ExcelProperty(index = 7)
	private String standard;
	/**
	 * 运输方式
	 */
    @ExcelProperty(index = 8)
	private String transtype;
	
    @ExcelProperty(index = 9)
	public String time1;
	/**
	 * 始发地
	 */
    @ExcelProperty(index = 10)
	public String startpalce;
	
    @ExcelProperty(index = 11)
	public String time2;
	/**
	 * 中转城市
	 */
    @ExcelProperty(index = 12)
	public String transcity;
	
    @ExcelProperty(index = 13)
	public String time3;
	/**
	 * 当前城市
	 */
    @ExcelProperty(index = 14)
	public String currcity;
	
    @ExcelProperty(index = 15)
	public String time4;
	
    @ExcelIgnore
	public Integer check1;
	@ExcelIgnore
	public Integer check2;
	@ExcelIgnore
	public Integer check3;
	@ExcelIgnore
	public Integer check4;
}
