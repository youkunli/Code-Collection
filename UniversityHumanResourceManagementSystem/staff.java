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
		fr = new JFrame("ְ����Ϣ����");
		fr.setSize(1365, 725);
		p11 = new JPanel();
		p12 = new JPanel();
		p13 = new JPanel();
		p11.setLayout(new GridLayout(12,2,0,30));
		l1 = new JLabel("Ա�����");
		tf1 = new JTextField();
		l2 = new JLabel("Ա������");
		tf2 = new JTextField();
		l3 = new JLabel("�Ա�");
		JPanel pl3 = new JPanel();
		nan = new JRadioButton("��");
		nv  = new JRadioButton("Ů");
		ButtonGroup bg = new ButtonGroup();
		bg.add(nan);
		bg.add(nv);
		pl3.add(nan);
		pl3.add(nv);
		l4 = new JLabel("����");
		tf4 = new JTextField(13);
		l5 = new JLabel("��������");
		JPanel pl5 = new JPanel();
		tf51 = new JTextField(5);
		JLabel l51 = new JLabel("��");
		tf52 = new JTextField(2);
		JLabel l52 = new JLabel("��");
		pl5.add(tf51);
		pl5.add(l51);
		pl5.add(tf52);
		pl5.add(l52);
		l6 = new JLabel("����");
		tf6 = new JTextField();
		l7 = new JLabel("��ͥסַ");
		tf7 = new JTextField();
		l8 = new JLabel("���ڲ���");
		String dept[] = {"101","102","103","104","105"};
		cbb8 = new JComboBox(dept);
		l9 = new JLabel("ְ��");
		String title[] = {"����","������","��ʦ","����ʦ"};
		cbb9 = new JComboBox(title);
		l10 = new JLabel("����");
		tf10 = new JTextField();
		l11 = new JLabel("��ϵ�绰");
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
	    // Class.forName("com.mysql.jdbc.Driver");// ��̬����mysql����
	     //con = DriverManager.getConnection(url);
         // Statement������кܶ෽��������executeUpdate����ʵ�ֲ��룬���º�ɾ����
        // Statement sta = con.createStatement();

		
		vc.add("Ա�����");
		vc.add("Ա������");
		vc.add("�Ա�");
		vc.add("����");
		vc.add("��������");
		vc.add("����");
		vc.add("��ͥסַ");
		vc.add("���ڲ���");
		vc.add("ְ��");
		vc.add("����");
		vc.add("��ϵ�绰");
		vc.add("E-mail");
		
		sql = "select * from Ա��������Ϣ��";//SQL���  
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
			vv.add(ret.getString(7));
			vv.add(ret.getString(8));
			vv.add(ret.getString(9));
			vv.add(ret.getString(10));
			vv.add(ret.getString(11));
			vv.add(ret.getString(12));
			vd.add(vv);
		}
		//ret.close();  
        //db1.close();//�ر����� 
		//selectData("select * from Ա��������Ϣ��");
		tam = new DefaultTableModel(vd,vc);
		ta = new JTable(tam);
		pane = new JScrollPane(ta);
		//p12.add(pane);

		
		b1 = new JButton("¼��");
		b2 = new JButton("�޸�");
		b3 = new JButton("ɾ��");
		b4 = new JButton("�˳�");
		b5 = new JButton("��ѯ");
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
				ss = "��";
			else
				ss = "Ů";
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
				db1 = new DBHelper("insert into Ա��������Ϣ�� values ('"+tf1.getText()+"','"+tf2.getText()+"','"+ss+"','"+tf4.getText()+"','"+tf51.getText()+"/"+tf52.getText()+"','"+tf6.getText()+"','"+tf7.getText()+"','"+cbb8.getSelectedItem()+"','"+cbb9.getSelectedItem()+"','"+tf10.getText()+"','"+tf11.getText()+"','"+tf121.getText()+"@"+tf122.getText()+"."+tf123.getText()+"')");//����DBHelper����
             }catch(Exception e1){
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==b5)
		{
			vd.removeAllElements();
			
			try{
				sql = "select * from Ա��������Ϣ�� where Ա�����='"+tf1.getText()+"'";//SQL���
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
	        //db1.close();//�ر����� 
			//selectData("select * from Ա��������Ϣ��");
			
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
					db1 = new DBHelper("update Ա��������Ϣ�� set Ա������='"+tf2.getText()+"' where Ա����� = '"+id+"'");//����DBHelper����
				
					
					
					//sta.execute("insert into project values('"+ss+"','"+t1.getText()+"','"+cb1.getSelectedItem()+"','"+t2.getText()+"','"+t3.getText()+"')");
				}catch(Exception e1){
					e1.printStackTrace();
				}break;
			case 3:
				String ss3 = new String();
				if(nan.isSelected())
					ss3 = "��";
				else
					ss3 = "Ů";
				tam.setValueAt(ss3, selectRow, selectColumn);
				ta.setModel(tam);
				try{
					db1 = new DBHelper("update Ա��������Ϣ�� set �Ա�='"+ss3+"' where Ա����� = '"+id+"'");//����DBHelper����
				
                    }catch(Exception e1){
					e1.printStackTrace();
				}break;
			case 4:
				tam.setValueAt(tf4.getText(), selectRow, selectColumn);
				ta.setModel(tam);
				try{
					db1 = new DBHelper("update Ա��������Ϣ�� set ����='"+tf4.getText()+"' where Ա����� = '"+id+"'");//����DBHelper����
				
					}catch(Exception e1){
					e1.printStackTrace();
				}break;
			case 5:
				tam.setValueAt(tf51.getText()+"/"+tf52.getText(), selectRow, selectColumn);
				ta.setModel(tam);
				try{
					db1 = new DBHelper("update Ա��������Ϣ�� set ��������='"+tf51.getText()+"/"+tf52.getText()+"' where Ա����� = '"+id+"'");//����DBHelper����
				
					}catch(Exception e1){
					e1.printStackTrace();
				}break;
			case 6:
				tam.setValueAt(tf6.getText(), selectRow, selectColumn);
				ta.setModel(tam);
				try{
					db1 = new DBHelper("update Ա��������Ϣ�� set ����='"+tf6.getText()+"' where Ա����� = '"+id+"'");//����DBHelper����
				
					}catch(Exception e1){
					e1.printStackTrace();
				}break;
			case 7:
				tam.setValueAt(tf7.getText(), selectRow, selectColumn);
				ta.setModel(tam);
				try{
					db1 = new DBHelper("update Ա��������Ϣ�� set ��ͥסַ='"+tf7.getText()+"' where Ա����� = '"+id+"'");//����DBHelper����
				
					}catch(Exception e1){
					e1.printStackTrace();
				}break;
			case 8:
				tam.setValueAt(cbb8.getSelectedItem(), selectRow, selectColumn);
				ta.setModel(tam);
				try{
					db1 = new DBHelper("update Ա��������Ϣ�� set ���ű��='"+cbb8.getSelectedItem()+"' where Ա����� = '"+id+"'");//����DBHelper����
				
					}catch(Exception e1){
					e1.printStackTrace();
				}break;
			case 9:
				tam.setValueAt(cbb9.getSelectedItem(), selectRow, selectColumn);
				ta.setModel(tam);
				try{
					db1 = new DBHelper("update Ա��������Ϣ�� set ְ��='"+cbb9.getSelectedItem()+"' where Ա����� = '"+id+"'");//����DBHelper����
				
					}catch(Exception e1){
					e1.printStackTrace();
				}break;
			case 10:
				tam.setValueAt(tf10.getText(), selectRow, selectColumn);
				ta.setModel(tam);
				try{
					db1 = new DBHelper("update Ա��������Ϣ�� set ����='"+tf10.getText()+"' where Ա����� = '"+id+"'");//����DBHelper����
				
					}catch(Exception e1){
					e1.printStackTrace();
				}break;
			case 11:
				tam.setValueAt(tf11.getText(), selectRow, selectColumn);
				ta.setModel(tam);
				try{
					db1 = new DBHelper("update Ա��������Ϣ�� set ��ϵ�绰='"+tf11.getText()+"' where Ա����� = '"+id+"'");//����DBHelper����
				
					}catch(Exception e1){
					e1.printStackTrace();
				}break;
			case 12:
				tam.setValueAt(tf121.getText()+"@"+tf122.getText()+"."+tf123.getText(), selectRow, selectColumn);
				ta.setModel(tam);
				try{
					db1 = new DBHelper("update Ա��������Ϣ�� set E-mail='"+tf121.getText()+"@"+tf122.getText()+"."+tf123.getText()+"' where Ա����� = '"+id+"'");//����DBHelper����
				
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
				db1 = new DBHelper("delete from Ա��������Ϣ�� where Ա����� = '"+id+"'");//����DBHelper����

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
