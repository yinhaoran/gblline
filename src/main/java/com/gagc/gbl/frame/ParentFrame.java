package com.gagc.gbl.frame;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.TransferHandler;

/**
 * 父窗口
 * 
 * @author yin
 * @date 2019/10/14
 */
public abstract class ParentFrame extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	/**
	 * 物流线路统计表的路径
	 */
	JTextField p1 = new JTextField(26);
	/**
	 * 物流信息跟踪表的路径
	 */
	JTextField p2 = new JTextField(26);
	JButton b1 = new JButton("浏览");
	JButton b2 = new JButton("浏览");
	
	JButton b3 = new JButton("开始分析");
//	JLabel label = new JLabel("消息栏");
	JLabel frameLabel = new JLabel("窗口标题");

	@SuppressWarnings("serial")
	public ParentFrame() {
		p1.setEditable(false);
		p1.setText("请将线路信息表拖入该窗口，或者点击右边的浏览 -->");
		p1.setTransferHandler(new TransferHandler() {
			@Override
			public boolean importData(JComponent comp, Transferable t) {
				try {
					Object o = t.getTransferData(DataFlavor.javaFileListFlavor);
					String filepath = o.toString();
					if (filepath.startsWith("[")) {
						filepath = filepath.substring(1);
					}
					if (filepath.endsWith("]")) {
						filepath = filepath.substring(0, filepath.length() - 1);
					}
					p1.setText(filepath);
					return true;
				} catch (Exception e) {

				}
				return false;
			}
			@Override
			public boolean canImport(JComponent comp, DataFlavor[] flavors) {
				for (int i = 0; i < flavors.length; i++) {
					if (DataFlavor.javaFileListFlavor.equals(flavors[i])) {
						return true;
					}
				}
				return false;
			}
		});
		p2.setEditable(false);
		p2.setText("请将在途信息表拖入该窗口，或者点击右边的浏览 -->");
		p2.setTransferHandler(new TransferHandler() {
			@Override
			public boolean importData(JComponent comp, Transferable t) {
				try {
					Object o = t.getTransferData(DataFlavor.javaFileListFlavor);
					String filepath = o.toString();
					if (filepath.startsWith("[")) {
						filepath = filepath.substring(1);
					}
					if (filepath.endsWith("]")) {
						filepath = filepath.substring(0, filepath.length() - 1);
					}
					p2.setText(filepath);
					return true;
				} catch (Exception e) {
				}
				return false;
			}
			
			@Override
			public boolean canImport(JComponent comp, DataFlavor[] flavors) {
				for (int i = 0; i < flavors.length; i++) {
					if (DataFlavor.javaFileListFlavor.equals(flavors[i])) {
						return true;
					}
				}
				return false;
			}
		});
		setLayout(null);// 没有布置可以用这个设计
		p1.setBounds(50, 100, 450, 30);
		
		p2.setBounds(50, 155, 450, 30);
		
		b1.setBounds(510, 100, 60, 30);// 设置组件大小和位置
		
		b2.setBounds(510, 155, 60, 30);// 设置组件大小和位置
		
		b3.setBounds(50, 210, 120, 30);// 设置组件大小和位置
		/**
		 * 标题
		 */
		frameLabel.setBounds(50, 50, 150, 30);
		frameLabel.setText(getFrameLabelName());
		add(frameLabel);
		add(p1);
		add(p2);
		add(b1);// 加入组件
		add(b2);// 加入组件
		add(b3);// 加入组件
		init();
	}

	public abstract void init();

	public abstract String getFrameLabelName();
}
