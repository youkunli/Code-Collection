import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

import java.io.*;
import java.util.*;
import java.sql.*;

class workload implements ActionListener{
	JFrame fr;
	JPanel p11,p12,p13;
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField tf1,tf2,tf3,tf4;
	JTable ta;
	DefaultTableModel tam;
	Vector vd = new Vector();
	Vector vc = new Vector();

	JButton b1,b2,b3,b4;
	
	static String sql = null;  
    static DBHelper db1 = null;  
    static ResultSet ret = null; 
	
	workload()throws Exception{
		fr = new JFrame("工作量信息管理");
		fr.setSize(1365, 725);
		p11 = new JPanel();
		p12 = new JPanel();
		p13 = new JPanel();
		p11.setLayout(new GridLayout(6,2,0,100));
		l1 = new JLabel("员工编号");
		tf1 = new JTextField(15);
		l2 = new JLabel("员工姓名");
		tf2 = new JTextField();
		l3 = new JLabel("课程门数");
		tf3 = new JTextField();
		l4 = new JLabel("工作时长");
		tf4 = new JTextField();

		
		p11.add(l1);
		p11.add(tf1);
		p11.add(l2);
		p11.add(tf2);
		p11.add(l3);
		p11.add(tf3);
		p11.add(l4);
		p11.add(tf4);
		
		
		vc.add("员工编号");
		vc.add("员工姓名");
		vc.add("课程门数");
		vc.add("工作时长");

		sql = "select * from 工作量信息表";//SQL语句  
        db1 = new DBHelper(sql);//创建DBHelper对象 
		
        ret = db1.pst.executeQuery();//执行语句，得到结果集
		while(ret.next()){
			Vector vv = new Vector();
			vv.add(ret.getString(1));
			vv.add(ret.getString(2));
			vv.add(ret.getString(3));
			vv.add(ret.getString(4));

			vd.add(vv);
		}
		ret.close();  
        db1.close();//关闭连接 
		
		tam = new DefaultTableModel(vd,vc);
		ta = new JTable(tam);
		JScrollPane pane = new JScrollPane(ta);
		//p12.add(pane);
		
		
		
		
		
		
		b1 = new JButton("录入");
		b2 = new JButton("修改");
		b3 = new JButton("删除");
		b4 = new JButton("退出");
		p13.add(b1);
		p13.add(b2);
		p13.add(b3);
		p13.add(b4);
		
		fr.add(BorderLayout.WEST,p11);
		fr.add(BorderLayout.CENTER,pane);
		fr.add(BorderLayout.SOUTH,p13);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==b1){
			Vector lr = new Vector();
			lr.add(tf1.getText());
			lr.add(tf2.getText());
			lr.add(tf3.getText());
			lr.add(tf4.getText());
			
			tam.addRow(lr);
			try{
				db1 = new DBHelper("insert into 工作量信息表 values ('"+tf1.getText()+"','"+tf2.getText()+"','"+tf3.getText()+"','"+tf4.getText()+"')");//创建DBHelper对象
			
				//sta.execute("insert into project values('"+ss+"','"+t1.getText()+"','"+cb1.getSelectedItem()+"','"+t2.getText()+"','"+t3.getText()+"')");
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==b2)
		{
			int selectRow = ta.getSelectedRow();
			int selectColumn = ta.getSelectedColumn();
			String id = (String)tam.getValueAt(selectRow, 0);
			
			switch(selectColumn+1){
			case 3:
				tam.setValueAt(tf3.getText(), selectRow, selectColumn);
				ta.setModel(tam);
				try{
					db1 = new DBHelper("update 工作量信息表 set 课程门数='"+tf3.getText()+"' where 员工编号 = '"+id+"'");//创建DBHelper对象
				
					}catch(Exception e1){
					e1.printStackTrace();
				}break;
			case 4:
				tam.setValueAt(tf4.getText(), selectRow, selectColumn);
				ta.setModel(tam);
				try{
					db1 = new DBHelper("update 工作量信息表 set 工作时长='"+tf4.getText()+"' where 员工编号 = '"+id+"'");//创建DBHelper对象
				
					}catch(Exception e1){
					e1.printStackTrace();
				}break;
			}
		}
		else if(e.getSource()==b3)
		{
			tam = new DefaultTableModel(vd,vc);
			int selectRow = ta.getSelectedRow();
			String id = (String)tam.getValueAt(selectRow, 0);
			tam.removeRow(selectRow);
			ta.setModel(tam);
			try{
				db1 = new DBHelper("delete from 工作量信息表 where 员工编号 = '"+id+"'");//创建DBHelper对象
			
				
				
				//sta.execute("insert into project values('"+ss+"','"+t1.getText()+"','"+cb1.getSelectedItem()+"','"+t2.getText()+"','"+t3.getText()+"')");
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==b4)
		{
			fr.dispose();
		}
	}

}

