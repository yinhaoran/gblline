package com.gagc.gbl.gbllinealert;

import com.alibaba.excel.annotation.ExcelProperty;

import lombok.Data;

/**
 * 
 * @author yinha
 * @date 2019/12/06
 */
@Data
public class PsnInfo {
    @ExcelProperty("姓名")
    private String name;
}
