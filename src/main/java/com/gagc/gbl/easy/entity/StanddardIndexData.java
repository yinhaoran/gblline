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
	@ExcelProperty(index = 2)
	private String storecode;
	@ExcelProperty(index = 7)
	private String standard;
	@ExcelProperty(index = 9)
	public String time1;
	@ExcelProperty(index = 10)
	public String startpalce;
	@ExcelProperty(index = 11)
	public String time2;
	@ExcelProperty(index = 12)
	public String transcity;
	@ExcelProperty(index = 13)
	public String time3;
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
