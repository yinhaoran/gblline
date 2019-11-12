package com.gagc.gbl.frame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * @author yin
 * @date 2019/10/22
 */
public class ParentContainer extends JFrame implements ActionListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	// 创建内容面板
	JPanel contentPane;
	JMenuBar jMenuBarSM = new JMenuBar();
	JMenu jMenuFile = new JMenu("文件");
	JMenuItem jMenuFileExit = new JMenuItem("退出");
	JMenu jMenuFunction = new JMenu("功能");
	JMenuItem jMenuLineAlert = new JMenuItem("在途预警功能");
	
	/**
	 * Create the frame.
	 */
	public ParentContainer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jbInit();
	}

	public void jbInit() {
		/**
		 * 创建内容面板和其布局
		 */
		contentPane = (JPanel) getContentPane();
		contentPane.setLayout(null);
		/**
		 * 框架的大小和其标题
		 */
		setSize(new Dimension(400, 320));
		setTitle("售后报表工具");
		/**
		 * 添加监听事件
		 */
		jMenuFileExit.addActionListener(this);
		jMenuFunction.addActionListener(this);
		/**
		 * 添加菜单组件到菜单条
		 */
		setJMenuBar(jMenuBarSM);
		jMenuBarSM.add(jMenuFile);
		jMenuBarSM.add(jMenuFileExit);
		jMenuBarSM.add(jMenuFunction);
		// 添加菜单项组件到菜单组件
		jMenuFile.add(jMenuFileExit);
		
		jMenuBarSM.add(jMenuLineAlert);
		jMenuLineAlert.addActionListener(this);
		jMenuFunction.add(jMenuLineAlert);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		JPanel jPanel = null;
		// 点击“文件”菜单下的“退出”菜单项
		if (actionEvent.getSource() == jMenuFileExit) {
			System.exit(0);
		} else if (actionEvent.getSource() == jMenuLineAlert) {
			jPanel = new LineAlertFrame2();
		}
		// 移除主界面上原有的内容
		this.remove(this.getContentPane());
		this.setContentPane(jPanel);
		// 令界面可见
		this.setVisible(true);
		this.setResizable(true);
		this.setSize(630, 400);
	}

}
