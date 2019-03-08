import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

import java.io.*;
import java.util.*;
import java.sql.*;

class rewardandpenalty implements ActionListener{
	JFrame fr;
	JPanel p11,p12,p13;
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField tf1,tf2,tf3,tf5,tf6;
	JComboBox cbb4;
	JTable ta;
	DefaultTableModel tam;
	Vector vd = new Vector();
	Vector vc = new Vector();
	
	JButton b1,b2,b3,b4;
	
	static String sql = null;  
    static DBHelper db1 = null;  
    static ResultSet ret = null;  
	
	rewardandpenalty()throws Exception{
		fr = new JFrame("������Ϣ����");
		fr.setSize(1365, 725);
		p11 = new JPanel();
		p12 = new JPanel();
		p13 = new JPanel();
		p11.setLayout(new GridLayout(6,2,0,100));
		l1 = new JLabel("���ͱ��");
		tf1 = new JTextField(15);
		l2 = new JLabel("Ա�����");
		tf2 = new JTextField();
		l3 = new JLabel("Ա������");
		tf3 = new JTextField();
		l4 = new JLabel("����ʱ��");
		String year[] = {"1950","1951","1952","1953","1954","1955","1956","1957","1958","1959",
		         "1960","1961","1962","1963","1964","1965","1966","1967","1968","1969",
		         "1970","1971","1972","1973","1974","1975","1976","1977","1978","1979",
		         "1980","1981","1982","1983","1984","1985","1986","1987","1988","1989",
		         "1990","1991","1992","1993","1994","1995","1996","1997","1998","1999",
		         "2000","2001","2002","2003","2004","2005","2006","2007","2008","2009",
		         "2010","2011","2012","2013","2014","2015","2016","2017","2018"};
        cbb4 = new JComboBox(year);
		l5 = new JLabel("����ԭ��");
		tf5 = new JTextField();
		l6 = new JLabel("�����ص�");
		tf6 = new JTextField();

		
		p11.add(l1);
		p11.add(tf1);
		p11.add(l2);
		p11.add(tf2);
		p11.add(l3);
		p11.add(tf3);
		p11.add(l4);
		p11.add(cbb4);
		p11.add(l5);
		p11.add(tf5);
		p11.add(l6);
		p11.add(tf6);
		
		
		
		vc.add("���ͱ��");
		vc.add("Ա�����");
		vc.add("Ա������");
		vc.add("����ʱ��");
		vc.add("����ԭ��");
		vc.add("�����ص�");

		sql = "select * from ������Ϣ��";//SQL���  
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
		ret.close();  
        db1.close();//�ر�����
		
		tam = new DefaultTableModel(vd,vc);
		ta = new JTable(tam);
		JScrollPane pane = new JScrollPane(ta);
		//p12.add(pane);
		
		
		
		b1 = new JButton("¼��");
		b2 = new JButton("�޸�");
		b3 = new JButton("ɾ��");
		b4 = new JButton("�˳�");
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
			String ss = new String();
			lr.add(tf1.getText());
			lr.add(tf2.getText());
			lr.add(tf3.getText());
			lr.add(cbb4.getSelectedItem());
			lr.add(tf5.getText());
			lr.add(tf6.getText());
			
			
			tam.addRow(lr);
			try{
				db1 = new DBHelper("insert into ������Ϣ�� values ('"+tf1.getText()+"','"+tf2.getText()+"','"+tf3.getText()+"','"+cbb4.getSelectedItem()+"','"+tf5.getText()+"','"+tf6.getText()+"')");//����DBHelper����
			
	           
				
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
			case 4:
				tam.setValueAt(cbb4.getSelectedItem(), selectRow, selectColumn);
				ta.setModel(tam);
				try{
					db1 = new DBHelper("update ������Ϣ�� set ����ʱ��='"+cbb4.getSelectedItem()+"' where Ա����� = '"+id+"'");//����DBHelper����
				
					}catch(Exception e1){
					e1.printStackTrace();
				}break;
			case 5:
				tam.setValueAt(tf5.getText(), selectRow, selectColumn);
				ta.setModel(tam);
				try{
					db1 = new DBHelper("update ������Ϣ�� set ����ԭ��='"+tf5.getText()+"' where Ա����� = '"+id+"'");//����DBHelper����
				
					}catch(Exception e1){
					e1.printStackTrace();
				}break;
			case 6:
				tam.setValueAt(tf6.getText(), selectRow, selectColumn);
				ta.setModel(tam);
				try{
					db1 = new DBHelper("update ������Ϣ�� set �����ص�='"+tf6.getText()+"' where Ա����� = '"+id+"'");//����DBHelper����
				
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
				db1 = new DBHelper("delete from ������Ϣ�� where ���ͱ�� = '"+id+"'");//����DBHelper����
			
				
				
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

