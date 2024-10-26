/*
 * Created by JFormDesigner on Fri Oct 25 23:48:27 CST 2024
 */

package com.ws.GUI;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.event.*;

/**
 * @author 韦思
 */
public class UpdateView extends JFrame {
    private String id;
    public UpdateView(String id) {
        this.id = id;
        initComponents();
    }

    //修改按钮
    private void save(ActionEvent e) throws Exception {
        // TODO add your code here
        try {
            String url="jdbc:mysql://localhost:3306/sys?useSSL=false&serverTimezone=Asia/Shanghai";
            String username="root";
            String password1="123456";
            Connection conn= DriverManager.getConnection(url,username,password1);
            String sql="UPDATE student SET  学号=?,姓名 = ?,年龄 = ?,专业 = ?,班级 = ?,偏爱学科 = ? WHERE 学号 = ?";
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
            pstmt.setString(7,id);

            int count=pstmt.executeUpdate();

            if (count==1){
                this.label8.setText("添加成功！");
                this.dispose();
            }else {
                this.label8.setText("添加失败！");
            }
            pstmt.close();
            conn.close();
        }catch (Exception ex){
            this.label8.setText("添加失败！");
        }
    }

    private void cancel(ActionEvent e) {
        // TODO add your code here
        this.dispose();
    }

    //取消按钮
    private void cancelStateChanged(ChangeEvent e) {
        // TODO add your code here
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        txtid = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        txtname = new JTextField();
        txtage = new JTextField();
        label3 = new JLabel();
        label4 = new JLabel();
        txtspeciality = new JTextField();
        txtclass = new JTextField();
        label6 = new JLabel();
        label5 = new JLabel();
        txtlike = new JTextField();
        save = new JButton();
        cancel = new JButton();
        label8 = new JLabel();

        //======== this ========
        setTitle("\u4fee\u6539\u5b66\u751f\u4fe1\u606f");
        var contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(txtid);
        txtid.setBounds(115, 45, 190, 24);

        //---- label1 ----
        label1.setText("\u5b66\u53f7\uff1a");
        label1.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 15));
        contentPane.add(label1);
        label1.setBounds(65, 45, 50, 30);

        //---- label2 ----
        label2.setText("\u59d3\u540d\uff1a");
        label2.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 15));
        contentPane.add(label2);
        label2.setBounds(65, 85, 50, 30);
        contentPane.add(txtname);
        txtname.setBounds(115, 90, 190, 24);
        contentPane.add(txtage);
        txtage.setBounds(115, 130, 190, 24);

        //---- label3 ----
        label3.setText("\u5e74\u9f84\uff1a");
        label3.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 15));
        contentPane.add(label3);
        label3.setBounds(65, 125, 50, 30);

        //---- label4 ----
        label4.setText("\u4e13\u4e1a\uff1a");
        label4.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 15));
        contentPane.add(label4);
        label4.setBounds(65, 170, 50, 30);
        contentPane.add(txtspeciality);
        txtspeciality.setBounds(115, 170, 190, 24);
        contentPane.add(txtclass);
        txtclass.setBounds(115, 215, 190, 24);

        //---- label6 ----
        label6.setText("\u73ed\u7ea7\uff1a");
        label6.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 15));
        contentPane.add(label6);
        label6.setBounds(65, 210, 50, 30);

        //---- label5 ----
        label5.setText("\u504f\u7231\u5b66\u79d1\uff1a");
        label5.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 15));
        contentPane.add(label5);
        label5.setBounds(35, 255, 80, 30);
        contentPane.add(txtlike);
        txtlike.setBounds(115, 255, 190, 24);

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
        save.setBounds(115, 305, 60, 30);

        //---- cancel ----
        cancel.setText("\u53d6\u6d88");
        cancel.addActionListener(e -> cancel(e));
        contentPane.add(cancel);
        cancel.setBounds(240, 305, 60, 30);

        //---- label8 ----
        label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() + 4f));
        contentPane.add(label8);
        label8.setBounds(30, 370, 300, 40);

        contentPane.setPreferredSize(new Dimension(375, 465));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JTextField txtid;
    private JLabel label1;
    private JLabel label2;
    private JTextField txtname;
    private JTextField txtage;
    private JLabel label3;
    private JLabel label4;
    private JTextField txtspeciality;
    private JTextField txtclass;
    private JLabel label6;
    private JLabel label5;
    private JTextField txtlike;
    private JButton save;
    private JButton cancel;
    private JLabel label8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
