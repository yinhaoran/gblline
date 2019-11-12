package com.gagc.gbl.easy.itf;

/**
 * @author yin
 * @date 2019/11/07
 */
public interface IEasyService {
	/**
	 * 导出Excepl
	 * 
	 * @param path1
	 *            标准时间表
	 * @param path2
	 *            在途信息表
	 */
	public void printExcel(String path1, String path2);
}
