import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

import java.io.*;
import java.util.*;
import java.sql.*;

class mainframe implements ActionListener{
	JFrame fr;
	JMenuBar menuBar;
	JMenu manageMenu;
	JMenuItem i1,i2,i3,i4,i5;
	JLabel l1,l2,l3;
	JTextField tf1;
	JPasswordField pf2;
	JButton b1,b2,b3;
	
	mainframe() throws Exception{
		fr = new JFrame("高校人力资源管理系统");
		fr.setSize(500, 200);
		fr.setLayout(new BorderLayout());
		menuBar = new JMenuBar();
		manageMenu = new JMenu("信息管理");
		i1 = new JMenuItem("职工信息管理");
		i2 = new JMenuItem("部门信息管理");
		i3 = new JMenuItem("学历信息管理");
		i4 = new JMenuItem("奖惩信息管理");
		i5 = new JMenuItem("工作量信息管理");
		fr.setJMenuBar(menuBar);
		menuBar.add(i1);
		menuBar.add(i2);
		menuBar.add(i3);
		menuBar.add(i4);
		menuBar.add(i5);
		i1.setEnabled(false);
		i2.setEnabled(false);
		i3.setEnabled(false);
		i4.setEnabled(false);
		i5.setEnabled(false);
		i1.setEnabled(true);
		i2.setEnabled(true);
		i3.setEnabled(true);
		i4.setEnabled(true);
		i5.setEnabled(true);
		
		l1 = new JLabel("用户名");
		l2 = new JLabel("密码");
		l3 = new JLabel("欢迎来到高校人力资源管理系统！");
		tf1 = new JTextField(6);
		pf2 = new JPasswordField(6);
		JPanel plogin1 = new JPanel();
		plogin1.add(l1);
		plogin1.add(tf1);
		plogin1.add(l2);
		plogin1.add(pf2);
		fr.add(BorderLayout.CENTER,plogin1);
		
		b1 = new JButton("登录");
		b2 = new JButton("退出");
		b3 = new JButton("查询");
		JPanel plogin2 = new JPanel();
		plogin2.add(b1);
		plogin2.add(b2);
		plogin2.add(b3);
		//b3.setEnabled(false);
		fr.add(BorderLayout.SOUTH,plogin2);
		
		
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		i1.addActionListener(this);
		i2.addActionListener(this);
		i3.addActionListener(this);
		i4.addActionListener(this);
		i5.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		}

	public void actionPerformed(ActionEvent e){
		if(e.getSource()==i1)
		{try {
			new staff();
            }
        catch(Exception ee) {
            ee.printStackTrace();
           }
			
		}
		else if(e.getSource()==i2)
		{
			try {
				new department();
	            }
	        catch(Exception ee) {
	            ee.printStackTrace();
	           }
		}
		else if(e.getSource()==i3)
		{
			try {
				new education();
	            }
	        catch(Exception ee) {
	            ee.printStackTrace();
	           }
		}
		else if(e.getSource()==i4)
		{
			try {
				new rewardandpenalty();
	            }
	        catch(Exception ee) {
	            ee.printStackTrace();
	           }
		}
		else if(e.getSource()==i5)
		{
			try {
				new workload();
	            }
	        catch(Exception ee) {
	            ee.printStackTrace();
	           }
		}
		else if(e.getSource()==b1)
		{
			try {
				String name = new String(tf1.getText());
				String password = new String(pf2.getText());
				if(name.equals("admin")&&password.equals("123456"))
				{
					i1.setEnabled(true);
					i2.setEnabled(true);
					i3.setEnabled(true);
					i4.setEnabled(true);
					i5.setEnabled(true);
					JOptionPane.showMessageDialog(fr, "登录成功","登录结果",JOptionPane.INFORMATION_MESSAGE);
					//fr.add(BorderLayout.CENTER,l3);
				}
				else
				{
					JOptionPane.showMessageDialog(fr, "登录失败","登录结果",JOptionPane.INFORMATION_MESSAGE);
				}
	            }
	        catch(Exception ee) {
	            ee.printStackTrace();
	           }
		}
		else if(e.getSource()==b2)
		{
			try {
				fr.dispose();
	            }
	        catch(Exception ee) {
	            ee.printStackTrace();
	           }
		}
		else if(e.getSource()==b3)
		{
			try {
				new searchDeptStaff();
	            }
	        catch(Exception ee) {
	            ee.printStackTrace();
	           }
		}
	}
}





public class UniversityHumanResourceManagementSystem {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		new mainframe();
	}

}
