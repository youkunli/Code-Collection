import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

import java.io.*;
import java.util.*;
import java.sql.*;

class staff implements ActionListener{
	JFrame fr;
	JPanel p11,p12,p13;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	JTextField tf1,tf2,tf4,tf51,tf52,tf6,tf7,tf10,tf11,tf121,tf122,tf123;
	JComboBox cbb8,cbb9;
	JRadioButton nan,nv;
	JTable ta;
	JScrollPane pane;
	DefaultTableModel tam;
	Vector vd = new Vector();
	Vector vc = new Vector();
	JButton b1,b2,b3,b4,b5;
	
	static String sql = null;  
    static DBHelper db1 = null;  
    static ResultSet ret = null;  
	
	
	staff()throws Exception{
		fr = new JFrame("职工信息管理");
		fr.setSize(1365, 725);
		p11 = new JPanel();
		p12 = new JPanel();
		p13 = new JPanel();
		p11.setLayout(new GridLayout(12,2,0,30));
		l1 = new JLabel("员工编号");
		tf1 = new JTextField();
		l2 = new JLabel("员工姓名");
		tf2 = new JTextField();
		l3 = new JLabel("性别");
		JPanel pl3 = new JPanel();
		nan = new JRadioButton("男");
		nv  = new JRadioButton("女");
		ButtonGroup bg = new ButtonGroup();
		bg.add(nan);
		bg.add(nv);
		pl3.add(nan);
		pl3.add(nv);
		l4 = new JLabel("籍贯");
		tf4 = new JTextField(13);
		l5 = new JLabel("出生年月");
		JPanel pl5 = new JPanel();
		tf51 = new JTextField(5);
		JLabel l51 = new JLabel("年");
		tf52 = new JTextField(2);
		JLabel l52 = new JLabel("月");
		pl5.add(tf51);
		pl5.add(l51);
		pl5.add(tf52);
		pl5.add(l52);
		l6 = new JLabel("民族");
		tf6 = new JTextField();
		l7 = new JLabel("家庭住址");
		tf7 = new JTextField();
		l8 = new JLabel("所在部门");
		String dept[] = {"101","102","103","104","105"};
		cbb8 = new JComboBox(dept);
		l9 = new JLabel("职称");
		String title[] = {"教授","副教授","讲师","助理讲师"};
		cbb9 = new JComboBox(title);
		l10 = new JLabel("工资");
		tf10 = new JTextField();
		l11 = new JLabel("联系电话");
		tf11 = new JTextField();
		l12 = new JLabel("E-mail");
		JPanel pl12 = new JPanel();
		tf121 = new JTextField(3);
		tf122 = new JTextField(3);
		tf123 = new JTextField(3);
		JLabel l121 = new JLabel("@");
		tf52 = new JTextField(2);
		JLabel l122 = new JLabel(".");
		pl12.add(tf121);
		pl12.add(l121);
		pl12.add(tf122);
		pl12.add(l122);
		pl12.add(tf123);
		
		
		p11.add(l1);
		p11.add(tf1);
		p11.add(l2);
		p11.add(tf2);
		p11.add(l3);
		p11.add(pl3);
		p11.add(l4);
		p11.add(tf4);
		p11.add(l5);
		p11.add(pl5);
		p11.add(l6);
		p11.add(tf6);
		p11.add(l7);
		p11.add(tf7);
		p11.add(l8);
		p11.add(cbb8);
		p11.add(l9);
		p11.add(cbb9);
		p11.add(l10);
		p11.add(tf10);
		p11.add(l11);
		p11.add(tf11);
		p11.add(l12);
		p11.add(pl12);
		
		//Class.forName("com.hxtt.sql.access.AccessDriver");
		//String url = "jdbc:Access:///e:/HumanResource.accdb";
		//con = DriverManager.getConnection(url,"","");
		//sta = con.createStatement();
		
		 //Connection con = null;
	     //String sql;
	     //String url = "jdbc:mysql://localhost:3306/qqq"
	     //           + "user=root&password=0109&useUnicode=true&characterEncoding=UTF8";
	    // Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
	     //con = DriverManager.getConnection(url);
         // Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
        // Statement sta = con.createStatement();

		
		vc.add("员工编号");
		vc.add("员工姓名");
		vc.add("性别");
		vc.add("籍贯");
		vc.add("出生年月");
		vc.add("民族");
		vc.add("家庭住址");
		vc.add("所在部门");
		vc.add("职称");
		vc.add("工资");
		vc.add("联系电话");
		vc.add("E-mail");
		
		sql = "select * from 员工基本信息表";//SQL语句  
        db1 = new DBHelper(sql);//创建DBHelper对象 
		
        ret = db1.pst.executeQuery();//执行语句，得到结果集
		while(ret.next()){
			Vector vv = new Vector();
			vv.add(ret.getString(1));
			vv.add(ret.getString(2));
			vv.add(ret.getString(3));
			vv.add(ret.getString(4));
			vv.add(ret.getString(5));
			vv.add(ret.getString(6));
			vv.add(ret.getString(7));
			vv.add(ret.getString(8));
			vv.add(ret.getString(9));
			vv.add(ret.getString(10));
			vv.add(ret.getString(11));
			vv.add(ret.getString(12));
			vd.add(vv);
		}
		//ret.close();  
        //db1.close();//关闭连接 
		//selectData("select * from 员工基本信息表");
		tam = new DefaultTableModel(vd,vc);
		ta = new JTable(tam);
		pane = new JScrollPane(ta);
		//p12.add(pane);

		
		b1 = new JButton("录入");
		b2 = new JButton("修改");
		b3 = new JButton("删除");
		b4 = new JButton("退出");
		b5 = new JButton("查询");
		p13.add(b1);
		//p13.add(b5);
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
		b5.addActionListener(this);
		}
	
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==b1){
			Vector lr = new Vector();
			String ss = new String();
			lr.add(tf1.getText());
			lr.add(tf2.getText());
			if(nan.isSelected())
				ss = "男";
			else
				ss = "女";
			lr.add(ss);
			lr.add(tf4.getText());
			lr.add(tf51.getText()+"/"+tf52.getText());
			lr.add(tf6.getText());
			lr.add(tf7.getText());
			lr.add(cbb8.getSelectedItem());
			
			
			lr.add(cbb9.getSelectedItem());
			lr.add(tf10.getText());
			lr.add(tf11.getText());
			lr.add(tf121.getText()+"@"+tf122.getText()+"."+tf123.getText());
			
			tam.addRow(lr);
			try{
				db1 = new DBHelper("insert into 员工基本信息表 values ('"+tf1.getText()+"','"+tf2.getText()+"','"+ss+"','"+tf4.getText()+"','"+tf51.getText()+"/"+tf52.getText()+"','"+tf6.getText()+"','"+tf7.getText()+"','"+cbb8.getSelectedItem()+"','"+cbb9.getSelectedItem()+"','"+tf10.getText()+"','"+tf11.getText()+"','"+tf121.getText()+"@"+tf122.getText()+"."+tf123.getText()+"')");//创建DBHelper对象
             }catch(Exception e1){
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==b5)
		{
			vd.removeAllElements();
			
			try{
				sql = "select * from 员工基本信息表 where 员工编号='"+tf1.getText()+"'";//SQL语句
				db1 = new DBHelper(sql);//创建DBHelper对象 
				
		        ret = db1.pst.executeQuery();//执行语句，得到结果集
				while(ret.next()){
					Vector vv = new Vector();
					vv.add(ret.getString(1));
					vv.add(ret.getString(2));
					vv.add(ret.getString(3));
					vv.add(ret.getString(4));
					vv.add(ret.getString(5));
					vv.add(ret.getString(6));
					vv.add(ret.getString(7));
					vv.add(ret.getString(8));
					vv.add(ret.getString(9));
					vv.add(ret.getString(10));
					vv.add(ret.getString(11));
					vv.add(ret.getString(12));
					vd.add(vv);
				} 
				tam = new DefaultTableModel(vd,vc);
				ta = new JTable(tam);
				pane = new JScrollPane(ta);
				}catch(Exception e1){
				e1.printStackTrace();
			}
			  
	        
			//ret.close();  
	        //db1.close();//关闭连接 
			//selectData("select * from 员工基本信息表");
			
		}
		else if(e.getSource()==b2)
		{
			int selectRow = ta.getSelectedRow();
			int selectColumn = ta.getSelectedColumn();
			String id = (String)tam.getValueAt(selectRow, 0);
			
			switch(selectColumn+1){
			case 2:
				tam.setValueAt(tf2.getText(), selectRow, selectColumn);
				ta.setModel(tam);
				try{
					db1 = new DBHelper("update 员工基本信息表 set 员工姓名='"+tf2.getText()+"' where 员工编号 = '"+id+"'");//创建DBHelper对象
				
					
					
					//sta.execute("insert into project values('"+ss+"','"+t1.getText()+"','"+cb1.getSelectedItem()+"','"+t2.getText()+"','"+t3.getText()+"')");
				}catch(Exception e1){
					e1.printStackTrace();
				}break;
			case 3:
				String ss3 = new String();
				if(nan.isSelected())
					ss3 = "男";
				else
					ss3 = "女";
				tam.setValueAt(ss3, selectRow, selectColumn);
				ta.setModel(tam);
				try{
					db1 = new DBHelper("update 员工基本信息表 set 性别='"+ss3+"' where 员工编号 = '"+id+"'");//创建DBHelper对象
				
                    }catch(Exception e1){
					e1.printStackTrace();
				}break;
			case 4:
				tam.setValueAt(tf4.getText(), selectRow, selectColumn);
				ta.setModel(tam);
				try{
					db1 = new DBHelper("update 员工基本信息表 set 籍贯='"+tf4.getText()+"' where 员工编号 = '"+id+"'");//创建DBHelper对象
				
					}catch(Exception e1){
					e1.printStackTrace();
				}break;
			case 5:
				tam.setValueAt(tf51.getText()+"/"+tf52.getText(), selectRow, selectColumn);
				ta.setModel(tam);
				try{
					db1 = new DBHelper("update 员工基本信息表 set 出生年月='"+tf51.getText()+"/"+tf52.getText()+"' where 员工编号 = '"+id+"'");//创建DBHelper对象
				
					}catch(Exception e1){
					e1.printStackTrace();
				}break;
			case 6:
				tam.setValueAt(tf6.getText(), selectRow, selectColumn);
				ta.setModel(tam);
				try{
					db1 = new DBHelper("update 员工基本信息表 set 民族='"+tf6.getText()+"' where 员工编号 = '"+id+"'");//创建DBHelper对象
				
					}catch(Exception e1){
					e1.printStackTrace();
				}break;
			case 7:
				tam.setValueAt(tf7.getText(), selectRow, selectColumn);
				ta.setModel(tam);
				try{
					db1 = new DBHelper("update 员工基本信息表 set 家庭住址='"+tf7.getText()+"' where 员工编号 = '"+id+"'");//创建DBHelper对象
				
					}catch(Exception e1){
					e1.printStackTrace();
				}break;
			case 8:
				tam.setValueAt(cbb8.getSelectedItem(), selectRow, selectColumn);
				ta.setModel(tam);
				try{
					db1 = new DBHelper("update 员工基本信息表 set 部门编号='"+cbb8.getSelectedItem()+"' where 员工编号 = '"+id+"'");//创建DBHelper对象
				
					}catch(Exception e1){
					e1.printStackTrace();
				}break;
			case 9:
				tam.setValueAt(cbb9.getSelectedItem(), selectRow, selectColumn);
				ta.setModel(tam);
				try{
					db1 = new DBHelper("update 员工基本信息表 set 职称='"+cbb9.getSelectedItem()+"' where 员工编号 = '"+id+"'");//创建DBHelper对象
				
					}catch(Exception e1){
					e1.printStackTrace();
				}break;
			case 10:
				tam.setValueAt(tf10.getText(), selectRow, selectColumn);
				ta.setModel(tam);
				try{
					db1 = new DBHelper("update 员工基本信息表 set 工资='"+tf10.getText()+"' where 员工编号 = '"+id+"'");//创建DBHelper对象
				
					}catch(Exception e1){
					e1.printStackTrace();
				}break;
			case 11:
				tam.setValueAt(tf11.getText(), selectRow, selectColumn);
				ta.setModel(tam);
				try{
					db1 = new DBHelper("update 员工基本信息表 set 联系电话='"+tf11.getText()+"' where 员工编号 = '"+id+"'");//创建DBHelper对象
				
					}catch(Exception e1){
					e1.printStackTrace();
				}break;
			case 12:
				tam.setValueAt(tf121.getText()+"@"+tf122.getText()+"."+tf123.getText(), selectRow, selectColumn);
				ta.setModel(tam);
				try{
					db1 = new DBHelper("update 员工基本信息表 set E-mail='"+tf121.getText()+"@"+tf122.getText()+"."+tf123.getText()+"' where 员工编号 = '"+id+"'");//创建DBHelper对象
				
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
				db1 = new DBHelper("delete from 员工基本信息表 where 员工编号 = '"+id+"'");//创建DBHelper对象

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
