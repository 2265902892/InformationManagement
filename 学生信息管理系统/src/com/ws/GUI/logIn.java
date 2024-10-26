/*
 * Created by JFormDesigner on Fri Oct 25 17:21:43 CST 2024
 */

package com.ws.GUI;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

/**
 * @author 韦思
 */
public class logIn extends JFrame {
    public logIn() {
        initComponents();
    }

    public static  void main(String[] args) throws SQLException {

        logIn frm = new logIn();
        frm.setVisible(true);
    }

    private void login(ActionEvent e) throws Exception {
        //获取连接
        String url="jdbc:mysql://localhost:3306/sys?useSSL=false&serverTimezone=Asia/Shanghai";
        String username="root";
        String password1="123456";
        Connection conn= DriverManager.getConnection(url,username,password1);

        String sql="select * from user where id=? and password=?";

        PreparedStatement pstmt=conn.prepareStatement(sql);

        String stuid=loginuser.getText().trim();
        String stupsw =loginpsw.getText().trim();


        pstmt.setString(1, stuid);
        pstmt.setString(2, stupsw);

        //创建结果集
        ResultSet rs=pstmt.executeQuery();

        if(rs.next()){
            studentlist stu=new studentlist();
            stu.setVisible(true);
            this.setVisible(false);
        }else {
            this.logerro.setText("密码输入错误！请重新输入！");
            this.loginuser.setText("");
            this.loginpsw.setText("");
        }

    }

    //回车跳转到密码框
    private void loginuserKeyPressed(KeyEvent e) {
        // TODO add your code here
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            // 请求将焦点转移到密码字段
            loginpsw.requestFocusInWindow();
        }
    }

    //点击选中账号框全部内容
    private void usercheckall(ActionEvent e) {
        // TODO add your code here
        loginuser.selectAll();
    }

    //点击选中密码框全部内容
    private void checkpswall(ActionEvent e) {
        // TODO add your code here
        loginpsw.selectAll();
    }


    //注册账号
    private void register(ActionEvent e) {
        // TODO add your code here
        register re=new register();
        re.setVisible(true);
        this.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        toplabel = new JLabel();
        separator1 = new JSeparator();
        label1 = new JLabel();
        label2 = new JLabel();
        loginuser = new JTextField();
        loginpsw = new JPasswordField();
        button1 = new JButton();
        logerro = new JLabel();
        register = new JButton();

        //======== this ========
        setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 12));
        setTitle("\u5b66\u751f\u7ba1\u7406\u7cfb\u7edf\u767b\u5f55");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- toplabel ----
        toplabel.setText("\u8bf7\u767b\u5f55");
        toplabel.setFont(new Font("\u5b8b\u4f53", toplabel.getFont().getStyle(), toplabel.getFont().getSize() + 25));
        contentPane.add(toplabel);
        toplabel.setBounds(180, 20, 115, 50);
        contentPane.add(separator1);
        separator1.setBounds(0, 85, 485, 3);

        //---- label1 ----
        label1.setText("\u8d26\u53f7\uff1a");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 4f));
        contentPane.add(label1);
        label1.setBounds(135, 125, 50, 35);

        //---- label2 ----
        label2.setText("\u5bc6\u7801\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 4f));
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(135, 165), label2.getPreferredSize()));

        //---- loginuser ----
        loginuser.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                loginuserKeyPressed(e);
            }
        });
        loginuser.addActionListener(e -> usercheckall(e));
        contentPane.add(loginuser);
        loginuser.setBounds(195, 130, 155, 25);

        //---- loginpsw ----
        loginpsw.addActionListener(e -> checkpswall(e));
        contentPane.add(loginpsw);
        loginpsw.setBounds(195, 164, 155, 25);

        //---- button1 ----
        button1.setText("\u786e\u5b9a");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 5f));
        button1.addActionListener(e -> {
            try {
                login(e);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        contentPane.add(button1);
        button1.setBounds(135, 230, 70, 30);

        //---- logerro ----
        logerro.setForeground(Color.red);
        logerro.setFont(logerro.getFont().deriveFont(logerro.getFont().getSize() + 3f));
        contentPane.add(logerro);
        logerro.setBounds(0, 325, 485, 45);

        //---- register ----
        register.setText("\u6ce8\u518c");
        register.setFont(register.getFont().deriveFont(register.getFont().getSize() + 5f));
        register.addActionListener(e -> register(e));
        contentPane.add(register);
        register.setBounds(280, 230, 70, 30);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel toplabel;
    private JSeparator separator1;
    private JLabel label1;
    private JLabel label2;
    private JTextField loginuser;
    private JPasswordField loginpsw;
    private JButton button1;
    private JLabel logerro;
    private JButton register;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
