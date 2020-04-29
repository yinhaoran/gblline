package com.gagc.gbl.easy.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.filechooser.FileSystemView;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.StringUtils;
import com.alibaba.excel.write.style.column.SimpleColumnWidthStyleStrategy;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gagc.gbl.easy.entity.StanddardIndexData;
import com.gagc.gbl.easy.entity.ToStoreIndexData;
import com.gagc.gbl.easy.entity.WriteResultData;
import com.gagc.gbl.easy.handler.GblToStoreWriteHandler;
import com.gagc.gbl.easy.itf.IEasyService;
import com.gagc.gbl.easy.listener.StanddardDataListener;
import com.gagc.gbl.easy.listener.ToStoreDataLIstener;

/**
 * @author yin
 * @date 2019/11/07
 */
public class EasyServiceImpl implements IEasyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EasyServiceImpl.class);

    /**
     * (non-Javadoc)
     * 
     * @see com.gagc.gbl.easy.itf.IEasyService#printExcel(java.lang.String, java.lang.String)
     */
    @Override
    public void printExcel(String path1, String path2) {
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        List<Object> list1 = EasyExcel.read(path1, StanddardIndexData.class, new StanddardDataListener())
            .sheet("物流线路基础信息表").doReadSync();
        list1.remove(0);
        Map<String, StanddardIndexData> map = praseStandardMap(list1);
        List<Object> list =
            EasyExcel.read(path2, ToStoreIndexData.class, new ToStoreDataLIstener()).sheet("物流信息表").doReadSync();
        list.remove(0);
        list.remove(0);
        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            ToStoreIndexData toStoreIndexData = (ToStoreIndexData)it.next();
            List<String> subList = new ArrayList<String>();
            subList.add(toStoreIndexData.getPlace1());
            subList.add(toStoreIndexData.getPlace2());
            subList.add(toStoreIndexData.getPlace3());
            subList.add(toStoreIndexData.getPlace4());
            subList.add(toStoreIndexData.getPlace5());
            subList.add(toStoreIndexData.getPlace6());
            subList.add(toStoreIndexData.getPlace7());
            subList.add(toStoreIndexData.getPlace8());
            subList.add(toStoreIndexData.getPlace9());
            subList.add(toStoreIndexData.getPlace10());
            subList.add(toStoreIndexData.getPlace11());
            subList.add(toStoreIndexData.getPlace12());
            subList.add(toStoreIndexData.getPlace13());
            subList.add(toStoreIndexData.getPlace14());
            subList.add(toStoreIndexData.getPlace15());
            toStoreIndexData.setList(subList);
            String date = toStoreIndexData.getDate();
            if (StringUtils.isEmpty(date)) {
                it.remove();
            }
        }
        List<WriteResultData> jsonArray = getWriteList(list, map);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        String fileaddress = FileSystemView.getFileSystemView().getHomeDirectory() + "/在途预警报表" + date + ".xlsx";
        EasyExcel.write(fileaddress, WriteResultData.class).registerWriteHandler(new GblToStoreWriteHandler())
            .registerWriteHandler(new SimpleColumnWidthStyleStrategy(30)).sheet("在途预警报表" + date).doWrite(jsonArray);
        LOGGER.info("结果集大小为：{}", jsonArray.size());
    }

    /**
     * 生成要输出的对象列表
     * 
     * @param mainList
     *            主数据
     * @param mainMap
     *            标准时间对照图
     * @return
     */
    private List<WriteResultData> getWriteList(List<Object> mainList, Map<String, StanddardIndexData> mainMap) {
        List<WriteResultData> list = new ArrayList<WriteResultData>();
        Iterator<Object> iterator = mainList.iterator();
        while (iterator.hasNext()) {
            JSONObject jsonObject = new JSONObject();
            ToStoreIndexData storeIndexData = (ToStoreIndexData)iterator.next();
            String date = storeIndexData.getDate();
            jsonObject.put("date", date);
            String billcode = storeIndexData.getBillcode();
            jsonObject.put("billcode", billcode);
            String storecode = storeIndexData.getStorecode();
            jsonObject.put("storecode", storecode);
            String storename = storeIndexData.getStorename();
            jsonObject.put("storename", storename);
            String cages = storeIndexData.getCages();
            jsonObject.put("cages", cages);
            String expectdate = storeIndexData.getExpectdate();
            jsonObject.put("expectdate", expectdate);
            String actual = storeIndexData.getActual();
            jsonObject.put("actual", actual);
            String delay = storeIndexData.getDelay();
            jsonObject.put("delay", delay);
            String sign = storeIndexData.getSign();
            jsonObject.put("signdate", sign);
            String province = storeIndexData.getProvince();
            jsonObject.put("province", province);
            String area = storeIndexData.getArea();
            jsonObject.put("area", area);
            String ordertype = storeIndexData.getOrdertype();
            jsonObject.put("ordertype", ordertype);
            String carrier = storeIndexData.getCarrier();
            jsonObject.put("carrier", carrier);
            List<String> lines = storeIndexData.getList();
            try {
                lines.lastIndexOf("广州");
                lines.indexOf("广州");
                
                StanddardIndexData standard = mainMap.get(storecode);
                jsonObject.put("standard", storeIndexData.getStandard());
                jsonObject.put("transtype", standard.getTranstype());
                jsonObject.put("secondCity", standard.getTranscity());
//                Integer check1 = standard.getCheck1();
//                String startpalce = standard.getStartpalce();
                Integer check2 = standard.getCheck2();
                String transcity = standard.getTranscity();
                Integer check3 = standard.getCheck3();
                String currcity = standard.getCurrcity();
                Integer check4 = Integer.valueOf(storeIndexData.getStandard());
                String sign1 = "签收";
//                addDataToJSONObject(jsonObject, check1, startpalce, lines, "first");
                isStartPlaceDelay(jsonObject, lines);
                addDataToJSONObject(jsonObject, check2, transcity, lines, "second");
                addDataToJSONObject(jsonObject, check3, currcity, lines, "third");
                addDataToJSONObject(jsonObject, check4, sign1, lines, "fourth");
                appendJsonObject(jsonObject);
            } catch (Exception e) {
                LOGGER.error("线路表中不存在店铺编码为{} 的线路信息", storecode);
            }
            WriteResultData resultData = JSON.parseObject(jsonObject.toJSONString(), WriteResultData.class);
            list.add(resultData);
        }
        return list;
    }

    void isStartPlaceDelay(JSONObject jsonObject,List<String> lines) {
        int index = lines.lastIndexOf("广州");
        if(index > 0) {
            jsonObject.put("first", "是");
        } else {
            jsonObject.put("first", "否");
        }
    }
    
    /**
     * 将超时汇总信息拼接到json串中
     * 
     * @param jsonObject
     */
    private void appendJsonObject(JSONObject jsonObject) {
        String isDelay = null;
        StringBuffer sb = new StringBuffer();
        isDelay = jsonObject.getString("first");
        if ("是".equals(isDelay)) {
            sb.append("始发地超时");
        }
        isDelay = jsonObject.getString("second");
        if ("是".equals(isDelay)) {
            sb.append("+中转地超时");
        }
        isDelay = jsonObject.getString("third");
        if ("是".equals(isDelay)) {
            sb.append("+目的地超时");
        }
        isDelay = jsonObject.getString("fourth");
        if ("是".equals(isDelay)) {
            sb.append("+签收超时");
        }
        String result = sb.toString();
        if (result.startsWith("+")) {
            result = result.substring(1);
        }
        jsonObject.put("result", result);
    }

    /**
     * 超时判断逻辑
     * 
     * @param jsonObject
     *            每行信息转成的JSONObject对象
     * @param check
     *            超时检查
     * @param place
     *            地点
     * @param lines
     *            在途线路信息
     * @param key
     *            关键字
     */
    private void addDataToJSONObject(JSONObject jsonObject, Integer check, String place, List<String> lines,
        String key) {
        if (check == null || check == 0 || "无".equals(place)) {
            return;
        }
        int index = lines.indexOf(place);
        if (index == -1) {
//            jsonObject.put(key, "是");
            jsonObject.put(key, "否");
        } else {
            if (index <= check - 1) {
                jsonObject.put(key, "否");
            } else {
                jsonObject.put(key, "是");
            }
        }
    }

    /**
     * 标准时效映射表
     * 
     * KEY 店铺编码 VALUE StanddardIndexData
     * 
     * @param list
     * @return
     */
    private Map<String, StanddardIndexData> praseStandardMap(List<Object> list) {
        Map<String, StanddardIndexData> map = new HashMap<String, StanddardIndexData>();
        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            StanddardIndexData obj = (StanddardIndexData)it.next();
            Double a = Double.valueOf(String.valueOf(obj.getTime1() == null ? "0" : obj.getTime1()));
            Double b = Double.valueOf(String.valueOf(obj.getTime2() == null ? "0" : obj.getTime2()));
            Double c = Double.valueOf(String.valueOf(obj.getTime3() == null ? "0" : obj.getTime3()));
            Double d = Double.valueOf(String.valueOf(obj.getStandard() == null ? "0" : obj.getStandard()));
            if (!a.equals(NumberUtils.DOUBLE_ZERO)) {
                Integer check1 = getListIndexRange(a);
                obj.setCheck1(check1);
            }
            if (!b.equals(NumberUtils.DOUBLE_ZERO)) {
                Integer check2 = getListIndexRange(a + b);
                obj.setCheck2(check2);
                Integer check1 = obj.getCheck1();
                if (check1 != null && check1.equals(check2)) {
                    obj.setCheck1(null);
                }
            }
            if (!c.equals(NumberUtils.DOUBLE_ZERO)) {
                Integer check3 = getListIndexRange(a + b + c);
                obj.setCheck3(check3);
                Integer check1 = obj.getCheck1();
                if (check1 != null && check1.equals(check3)) {
                    obj.setCheck1(null);
                }
                Integer check2 = obj.getCheck2();
                if (check2 != null && check2.equals(check3)) {
                    obj.setCheck2(null);
                }
            }
            if (!d.equals(NumberUtils.DOUBLE_ZERO)) {
                Integer check4 = getListIndexRange(d);
                obj.setCheck4(check4);
                /**
                 * 覆盖前面的记录
                 */
                Integer check1 = obj.getCheck1();
                if (check1 != null && check1.equals(check4)) {
                    obj.setCheck1(null);
                }
                Integer check2 = obj.getCheck2();
                if (check2 != null && check2.equals(check4)) {
                    obj.setCheck2(null);
                }
                Integer check3 = obj.getCheck3();
                if (check3 != null && check3.equals(check4)) {
                    obj.setCheck3(null);
                }
            }
            map.put(obj.getStorecode(), obj);
        }
        return map;
    }

    /**
     * 计算各个节点应该核查的时间
     * 
     * @param num
     * @return
     */
    private Integer getListIndexRange(Double num) {
        int a = 0;
        if (num >= 0.5 && num <= 1) {
            a = 1;
        } else if (num > 1 && num <= 2) {
            a = 2;
        } else if (num > 2 && num <= 3) {
            a = 3;
        } else if (num > 3 && num <= 4) {
            a = 4;
        } else if (num > 4 && num <= 5) {
            a = 5;
        } else if (num > 5 && num <= 6) {
            a = 6;
        } else if (num > 6 && num <= 7) {
            a = 7;
        } else if (num > 7 && num <= 8) {
            a = 8;
        } else if (num > 8 && num <= 9) {
            a = 9;
        } else if (num > 9 && num <= 10) {
            a = 10;
        } else if (num > 10 && num <= 11) {
            a = 11;
        } else if (num > 11 && num <= 12) {
            a = 12;
        } else if (num > 12 && num <= 13) {
            a = 13;
        } else if (num > 13 && num <= 14) {
            a = 14;
        } else if (num > 14 && num <= 15) {
            a = 15;
        }
        return a;
    }

}
