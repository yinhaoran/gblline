package com.gagc.gbl.easy.listener;


import com.gagc.gbl.easy.entity.StanddardIndexData;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

/**
 * @author yin
 * @date 2019/11/06
 */
public class StanddardDataListener extends AnalysisEventListener<StanddardIndexData> {

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.alibaba.excel.read.listener.ReadListener#invoke(java.lang.Object,
	 *      com.alibaba.excel.context.AnalysisContext)
	 */
	@Override
	public void invoke(StanddardIndexData data, AnalysisContext context) {
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
	}

}
