package com.gagc.gbl.easy.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.gagc.gbl.easy.entity.ToStoreIndexData;

/**
 * @author yin
 * @date 2019/11/06
 */
public class ToStoreDataLIstener extends AnalysisEventListener<ToStoreIndexData> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ToStoreDataLIstener.class);
	
	/**
	 * (non-Javadoc)
	 * 
	 * @see com.alibaba.excel.read.listener.ReadListener#invoke(java.lang.Object,
	 *      com.alibaba.excel.context.AnalysisContext)
	 */
	@Override
	public void invoke(ToStoreIndexData data, AnalysisContext context) {
		// TODO Auto-generated method stub
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.alibaba.excel.read.listener.ReadListener#doAfterAllAnalysed(com.alibaba.excel.context.AnalysisContext)
	 */
	@Override
	public void doAfterAllAnalysed(AnalysisContext context) {
		// TODO Auto-generated method stub
		LOGGER.info("解析完成");
	}

}
