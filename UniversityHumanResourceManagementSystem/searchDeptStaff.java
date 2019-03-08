import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

import java.io.*;
import java.util.*;
import java.sql.*;

public class searchDeptStaff implements ActionListener{
	JFrame fr;
	JButton bb;
	JTable ta;
	JScrollPane pane;
	DefaultTableModel tam;
	Vector vd = new Vector();
	Vector vc = new Vector();
	static String sql = null;  
    static DBHelper db1 = null;  
    static ResultSet ret = null; 
	searchDeptStaff()throws Exception{
		fr = new JFrame("学校各部门各种职称的教职工数量");
		fr.setSize(800, 400);
		fr.setLayout(new BorderLayout());
		bb = new JButton("退出");
		bb.addActionListener(this);
		fr.add(BorderLayout.SOUTH,bb);
		fr.setVisible(true);
		
		vc.add("部门编号");
		vc.add("部门名称");
		vc.add("教授");
		vc.add("副教授");
		vc.add("讲师");
		vc.add("助理讲师");

		sql = "select * from 各部门各职称表";//SQL语句  
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
			vd.add(vv);
		}
		//ret.close();  
        //db1.close();//关闭连接 
		//selectData("select * from 员工基本信息表");
		tam = new DefaultTableModel(vd,vc);
		ta = new JTable(tam);
		pane = new JScrollPane(ta);
		fr.add(BorderLayout.CENTER,pane);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==bb)
			fr.dispose();
	}

}
