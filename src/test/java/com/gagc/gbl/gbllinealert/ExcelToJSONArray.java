package com.gagc.gbl.gbllinealert;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class ExcelToJSONArray {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelToJSONArray.class);

    @Test
    public void resolveExcel() {
        String path = "C:\\Users\\yinha\\Documents\\2019-12-06\\停车需求表 测试.xlsx";
        List<PsnInfo> list = EasyExcel.read(path, PsnInfo.class, null).sheet().doReadSync();
        // LOGGER.info("{}", list.size());
        JSONArray array = JSONArray.parseArray(JSON.toJSONString(list));
        createJsonFile(array, "C:\\Users\\yinha\\Documents\\2019-12-06\\a.txt");
    }

    /**
     * 将JSON数据格式化并保存到文件中
     * 
     * @param jsonData
     *            需要输出的json数
     * @param filePath
     *            输出的文件地址
     * @return
     */
    public static boolean createJsonFile(Object jsonData, String filePath) {
        String content = JSON.toJSONString(jsonData, SerializerFeature.PrettyFormat,
            SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
        // 标记文件生成是否成功
        boolean flag = true;
        // 生成json格式文件
        try {
            // 保证创建一个新文件
            File file = new File(filePath);
            if (!file.getParentFile().exists()) { // 如果父目录不存在，创建父目录
                file.getParentFile().mkdirs();
            }
            if (file.exists()) { // 如果已存在,删除旧文件
                file.delete();
            }
            file.createNewFile();
            // 将格式化后的字符串写入文件
            Writer write = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            write.write(content);
            write.flush();
            write.close();
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }

}
