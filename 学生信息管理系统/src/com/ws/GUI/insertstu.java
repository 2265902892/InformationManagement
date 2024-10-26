/*
 * Created by JFormDesigner on Fri Oct 25 21:44:29 CST 2024
 */

package com.ws.GUI;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

/**
 * @author 韦思
 */
public class insertstu extends JFrame {
    public insertstu() {
        initComponents();
    }

    private void save(ActionEvent e) throws Exception {
        // TODO add your code here
        try {


        String url="jdbc:mysql://localhost:3306/sys?useSSL=false&serverTimezone=Asia/Shanghai";
        String username="root";
        String password1="123456";
        Connection conn= DriverManager.getConnection(url,username,password1);

        String sql="INSERT INTO student (学号,姓名,年龄,专业,班级,偏爱学科) VALUES (?,?,?,?,?,?)";
        PreparedStatement pstmt=conn.prepareStatement(sql);


        String v1=txtid.getText().trim();
        String v2=txtname.getText().trim();
        String v3=txtage.getText().trim();
        String v4=txtspeciality.getText().trim();
        String v5=txtclass.getText().trim();
        String v6=txtlike.getText().trim();

        pstmt.setString(1,v1);
        pstmt.setString(2,v2);
        pstmt.setString(3,v3);
        pstmt.setString(4,v4);
        pstmt.setString(5,v5);
        pstmt.setString(6,v6);

        int count=pstmt.executeUpdate();

        if (count==1){
            this.label7.setText("添加成功！");
            this.dispose();
        }else {
            this.label7.setText("添加失败！");
        }
       pstmt.close();
        conn.close();
    }catch (Exception ex){
            this.label7.setText("学号已存在，添加失败！");
        }
}
    private void cancel(ActionEvent e) {
        // TODO add your code here
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        txtid = new JTextField();
        txtlike = new JTextField();
        txtname = new JTextField();
        txtspeciality = new JTextField();
        txtclass = new JTextField();
        label6 = new JLabel();
        save = new JButton();
        cancel = new JButton();
        txtage = new JTextField();
        label7 = new JLabel();

        //======== this ========
        setTitle("\u6dfb\u52a0\u5b66\u751f");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u5b66\u53f7\uff1a");
        label1.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 15));
        contentPane.add(label1);
        label1.setBounds(70, 80, 50, 30);

        //---- label2 ----
        label2.setText("\u59d3\u540d\uff1a");
        label2.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 15));
        contentPane.add(label2);
        label2.setBounds(70, 122, 50, 30);

        //---- label3 ----
        label3.setText("\u5e74\u9f84\uff1a");
        label3.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 15));
        contentPane.add(label3);
        label3.setBounds(70, 164, 50, 30);

        //---- label4 ----
        label4.setText("\u4e13\u4e1a\uff1a");
        label4.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 15));
        contentPane.add(label4);
        label4.setBounds(70, 206, 50, 30);

        //---- label5 ----
        label5.setText("\u504f\u7231\u5b66\u79d1\uff1a");
        label5.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 15));
        contentPane.add(label5);
        label5.setBounds(40, 290, 80, 30);
        contentPane.add(txtid);
        txtid.setBounds(120, 83, 190, txtid.getPreferredSize().height);
        contentPane.add(txtlike);
        txtlike.setBounds(120, 293, 190, 24);
        contentPane.add(txtname);
        txtname.setBounds(120, 125, 190, 24);
        contentPane.add(txtspeciality);
        txtspeciality.setBounds(120, 209, 190, 24);
        contentPane.add(txtclass);
        txtclass.setBounds(120, 251, 190, 24);

        //---- label6 ----
        label6.setText("\u73ed\u7ea7\uff1a");
        label6.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 15));
        contentPane.add(label6);
        label6.setBounds(70, 248, 50, 30);

        //---- save ----
        save.setText("\u4fdd\u5b58");
        save.addActionListener(e -> {
            try {
                save(e);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        contentPane.add(save);
        save.setBounds(120, 340, 60, 30);

        //---- cancel ----
        cancel.setText("\u53d6\u6d88");
        cancel.addActionListener(e -> cancel(e));
        contentPane.add(cancel);
        cancel.setBounds(245, 340, 60, 30);
        contentPane.add(txtage);
        txtage.setBounds(120, 167, 190, 24);

        //---- label7 ----
        label7.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 16));
        contentPane.add(label7);
        label7.setBounds(15, 395, 390, 35);

        contentPane.setPreferredSize(new Dimension(420, 465));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField txtid;
    private JTextField txtlike;
    private JTextField txtname;
    private JTextField txtspeciality;
    private JTextField txtclass;
    private JLabel label6;
    private JButton save;
    private JButton cancel;
    private JTextField txtage;
    private JLabel label7;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
