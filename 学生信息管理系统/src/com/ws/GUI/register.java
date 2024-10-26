/*
 * Created by JFormDesigner on Sat Oct 26 15:39:48 CST 2024
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
public class register extends JFrame {
    public register() {
        initComponents();
    }

    private void regqd(ActionEvent e) throws Exception {
       try {
           // TODO add your code here
        String url="jdbc:mysql://localhost:3306/sys?useSSL=false&serverTimezone=Asia/Shanghai";
        String username="root";
        String password1="123456";
        Connection conn= DriverManager.getConnection(url,username,password1);
        String sql="INSERT INTO user (id,password) VALUES (?,?)";
        PreparedStatement pstmt=conn.prepareStatement(sql);

        String v1=regid.getText().trim();
        String v2=regpsw.getText().trim();

        pstmt.setString(1,v1);
        pstmt.setString(2,v2);

        int count=pstmt.executeUpdate();

        if (count==1){
            this.label3.setText("添加成功！");
            this.regid.setText("");
            this.regpsw.setText("");
        }else {
            this.label3.setText("添加失败！");
        }
        pstmt.close();
        conn.close();
       }catch (Exception e1){
           this.label3.setText("该账号以存在，请重新输入！");
       }
    }

    //注册页面返回按钮
    private void regreturn(ActionEvent e) {
        // TODO add your code here
        logIn lo=new logIn();
        lo.setVisible(true);
        this.dispose();

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        regpsw = new JTextField();
        regid = new JTextField();
        regqd = new JButton();
        regreturn = new JButton();
        label3 = new JLabel();

        //======== this ========
        setTitle("\u6ce8\u518c\u8d26\u53f7");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u8d26\u53f7\uff1a");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 4f));
        contentPane.add(label1);
        label1.setBounds(100, 80, 50, 35);

        //---- label2 ----
        label2.setText("\u5bc6\u7801\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 4f));
        contentPane.add(label2);
        label2.setBounds(100, 137, 50, 35);
        contentPane.add(regpsw);
        regpsw.setBounds(155, 140, 155, 25);
        contentPane.add(regid);
        regid.setBounds(155, 85, 155, 25);

        //---- regqd ----
        regqd.setText("\u786e\u5b9a");
        regqd.setFont(regqd.getFont().deriveFont(regqd.getFont().getSize() + 5f));
        regqd.addActionListener(e -> {
            try {
                regqd(e);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        contentPane.add(regqd);
        regqd.setBounds(100, 194, 70, 30);

        //---- regreturn ----
        regreturn.setText("\u8fd4\u56de");
        regreturn.setFont(regreturn.getFont().deriveFont(regreturn.getFont().getSize() + 5f));
        regreturn.addActionListener(e -> regreturn(e));
        contentPane.add(regreturn);
        regreturn.setBounds(240, 195, 70, 30);

        //---- label3 ----
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 4f));
        contentPane.add(label3);
        label3.setBounds(30, 260, 370, 50);

        contentPane.setPreferredSize(new Dimension(440, 370));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JTextField regpsw;
    private JTextField regid;
    private JButton regqd;
    private JButton regreturn;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
