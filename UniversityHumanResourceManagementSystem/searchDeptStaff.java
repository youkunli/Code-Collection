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
		fr = new JFrame("ѧУ�����Ÿ���ְ�ƵĽ�ְ������");
		fr.setSize(800, 400);
		fr.setLayout(new BorderLayout());
		bb = new JButton("�˳�");
		bb.addActionListener(this);
		fr.add(BorderLayout.SOUTH,bb);
		fr.setVisible(true);
		
		vc.add("���ű��");
		vc.add("��������");
		vc.add("����");
		vc.add("������");
		vc.add("��ʦ");
		vc.add("����ʦ");

		sql = "select * from �����Ÿ�ְ�Ʊ�";//SQL���  
        db1 = new DBHelper(sql);//����DBHelper���� 
		
        ret = db1.pst.executeQuery();//ִ����䣬�õ������
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
        //db1.close();//�ر����� 
		//selectData("select * from Ա��������Ϣ��");
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
