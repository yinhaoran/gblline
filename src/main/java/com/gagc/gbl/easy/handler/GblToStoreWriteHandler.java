package com.gagc.gbl.easy.handler;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;

import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;

/**
 * @author yin
 * @date 2019/11/07
 */
public class GblToStoreWriteHandler implements CellWriteHandler {

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.alibaba.excel.write.handler.CellWriteHandler#beforeCellCreate(com.alibaba.excel.write.metadata.holder.WriteSheetHolder,
	 *      com.alibaba.excel.write.metadata.holder.WriteTableHolder,
	 *      org.apache.poi.ss.usermodel.Row, com.alibaba.excel.metadata.Head,
	 *      java.lang.Integer, java.lang.Integer, java.lang.Boolean)
	 */
	@Override
	public void beforeCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row,
			Head head, Integer columnIndex, Integer relativeRowIndex, Boolean isHead) {
		// TODO Auto-generated method stub

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.alibaba.excel.write.handler.CellWriteHandler#afterCellCreate(com.alibaba.excel.write.metadata.holder.WriteSheetHolder,
	 *      com.alibaba.excel.write.metadata.holder.WriteTableHolder,
	 *      org.apache.poi.ss.usermodel.Cell, com.alibaba.excel.metadata.Head,
	 *      java.lang.Integer, java.lang.Boolean)
	 */
	@Override
	public void afterCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Cell cell,
			Head head, Integer relativeRowIndex, Boolean isHead) {
		// TODO Auto-generated method stub

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.alibaba.excel.write.handler.CellWriteHandler#afterCellDispose(com.alibaba.excel.write.metadata.holder.WriteSheetHolder,
	 *      com.alibaba.excel.write.metadata.holder.WriteTableHolder,
	 *      java.util.List, org.apache.poi.ss.usermodel.Cell,
	 *      com.alibaba.excel.metadata.Head, java.lang.Integer, java.lang.Boolean)
	 */
	@Override
	public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder,
			List<CellData> cellDataList, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {
		if (!isHead && (cell.getColumnIndex() == 13 || cell.getColumnIndex() == 14 || cell.getColumnIndex() == 15
				|| cell.getColumnIndex() == 16)) {
			String cellvalue = cell.getStringCellValue();
			if (StringUtils.isNoneEmpty(cellvalue) && "是".equals(cellvalue)) {
				CellStyle style = writeSheetHolder.getSheet().getWorkbook().createCellStyle();
				style.setFillForegroundColor(IndexedColors.RED.getIndex());
				style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				cell.setCellStyle(style);
			}
		}
	}

}
