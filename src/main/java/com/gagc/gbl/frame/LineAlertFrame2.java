package com.gagc.gbl.frame;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gagc.gbl.easy.impl.EasyServiceImpl;
import com.gagc.gbl.easy.itf.IEasyService;

/**
 * @author yin
 * @date 2019/11/07
 */
public class LineAlertFrame2 extends ParentFrame {

	private static final Logger LOGGER = LoggerFactory.getLogger(LineAlertFrame2.class);

	private IEasyService iEasyService;

	private IEasyService getIEasyService() {
		if (iEasyService == null) {
			iEasyService = new EasyServiceImpl();
		}
		return iEasyService;
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.gagc.gbl.frame.ParentFrame#init()
	 */
	@Override
	public void init() {
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.gagc.gbl.frame.ParentFrame#getFrameLabelName()
	 */
	@Override
	public String getFrameLabelName() {
		return "在途预警";
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		try {
			Component source = (Component) actionEvent.getSource();
			if (source.equals(b1) || source.equals(b2)) {
				FileSystemView fileSystemView = FileSystemView.getFileSystemView();
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(fileSystemView.getHomeDirectory());
				fileChooser.showOpenDialog(source);
				File file = fileChooser.getSelectedFile();
				if (file == null) {
					return;
				}
				String path = file.getAbsolutePath();
				if (source.equals(b1)) {
					p1.setText(path);
				} else {
					p2.setText(path);
				}
			} else if (b3.equals(source)) {
				String path1 = p1.getText();
				String path2 = p2.getText();
				if (StringUtils.isEmpty(path1) || StringUtils.isEmpty(path2)) {
					throw new Exception("路径为空请重新选择文件");
				}
				getIEasyService().printExcel(path1, path2);
				JOptionPane.showMessageDialog(null, "生成预警报告成功", "提示", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			JOptionPane.showMessageDialog(null, "操作失败，原因：" + e.getMessage(), "错误提示", JOptionPane.ERROR_MESSAGE);
		}
	}

}
