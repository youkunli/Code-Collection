import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

import java.io.*;
import java.util.*;
import java.sql.*;

class department implements ActionListener{
	JFrame fr;
	JPanel p11,p12,p13;
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6;
	JTable ta;
	DefaultTableModel tam;
	Vector vd = new Vector();
	Vector vc = new Vector();
	
	JButton b1,b2,b3,b4;
	
	static String sql = null;  
    static DBHelper db1 = null;  
    static ResultSet ret = null;  
	
	department()throws Exception{
		fr = new JFrame("������Ϣ����");
		fr.setSize(1365, 725);
		p11 = new JPanel();
		p12 = new JPanel();
		p13 = new JPanel();
		p11.setLayout(new GridLayout(6,2,0,100));
		l1 = new JLabel("���ű��");
		tf1 = new JTextField(15);
		l2 = new JLabel("��������");
		tf2 = new JTextField();
		l3 = new JLabel("��������");
		tf3 = new JTextField();
		l4 = new JLabel("����");
	    tf4 = new JTextField();
		l5 = new JLabel("��ϵ��ʽ");
		tf5 = new JTextField();
		l6 = new JLabel("�칫�ص�");
		tf6 = new JTextField();

		
		p11.add(l1);
		p11.add(tf1);
		p11.add(l2);
		p11.add(tf2);
		p11.add(l3);
		p11.add(tf3);
		p11.add(l4);
		p11.add(tf4);
		p11.add(l5);
		p11.add(tf5);
		p11.add(l6);
		p11.add(tf6);
		
		
		
		vc.add("���ű��");
		vc.add("��������");
		vc.add("��������");
		vc.add("����");
		vc.add("��ϵ��ʽ");
		vc.add("�칫�ص�");

		
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
		//ret.close();  
        //db1.close();//�ر����� 
		
		tam = new DefaultTableModel(vd,vc);
		ta = new JTable(tam);
		JScrollPane pane = new JScrollPane(ta);
		
		
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
			int itf3 = Integer.parseInt(tf3.getText());
			lr.add(tf4.getText());
			lr.add(tf5.getText());
			lr.add(tf6.getText());
			
			
			tam.addRow(lr);
			try{
				db1 = new DBHelper("insert into ������Ϣ�� values ('"+tf1.getText()+"','"+tf2.getText()+"','"+itf3+"','"+tf4.getText()+"','"+tf5.getText()+"','"+tf6.getText()+"')");//����DBHelper����
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
			case 2:
				tam.setValueAt(tf2.getText(), selectRow, selectColumn);
				ta.setModel(tam);
				try{
					db1 = new DBHelper("update ������Ϣ�� set ��������='"+tf2.getText()+"' where Ա����� = '"+id+"'");//����DBHelper����
				
					
					
					//sta.execute("insert into project values('"+ss+"','"+t1.getText()+"','"+cb1.getSelectedItem()+"','"+t2.getText()+"','"+t3.getText()+"')");
				}catch(Exception e1){
					e1.printStackTrace();
				}break;
			
			case 4:
				tam.setValueAt(tf4.getText(), selectRow, selectColumn);
				ta.setModel(tam);
				try{
					db1 = new DBHelper("update ������Ϣ�� set ��������='"+tf4.getText()+"' where Ա����� = '"+id+"'");//����DBHelper����
				
					}catch(Exception e1){
					e1.printStackTrace();
				}break;
			case 5:
				tam.setValueAt(tf5.getText(), selectRow, selectColumn);
				ta.setModel(tam);
				try{
					db1 = new DBHelper("update ������Ϣ�� set ��ϵ��ʽ='"+tf5.getText()+"' where Ա����� = '"+id+"'");//����DBHelper����
				
					}catch(Exception e1){
					e1.printStackTrace();
				}break;
			case 6:
				tam.setValueAt(tf6.getText(), selectRow, selectColumn);
				ta.setModel(tam);
				try{
					db1 = new DBHelper("update ������Ϣ�� set �칫�ص�='"+tf6.getText()+"' where Ա����� = '"+id+"'");//����DBHelper����
				
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
				db1 = new DBHelper("delete from ������Ϣ�� where ���ű�� = '"+id+"'");//����DBHelper����
			
				
				
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

