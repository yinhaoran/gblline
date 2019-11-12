package com.gagc.gbl;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.gagc.gbl.frame.ParentContainer;

/**
 * Hello world!
 *
 */
public class Application {
	public static void main(String[] args) {
		ParentContainer frame = new ParentContainer();
		frame.setVisible(true);
		// 获取屏幕尺寸
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// 获取主界面的窗体尺寸
		Dimension frameSize = frame.getSize();
		// 令主界面窗体居中
		if (frameSize.height > screenSize.height)
			frameSize.height = screenSize.height;
		if (frameSize.width > screenSize.width)
			frameSize.width = screenSize.width;
		frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		frame.setVisible(true);
	}
}
