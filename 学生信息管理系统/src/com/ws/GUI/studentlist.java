/*
 * Created by JFormDesigner on Fri Oct 25 17:33:56 CST 2024
 */

package com.ws.GUI;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author 韦思
 */
public class studentlist extends JFrame {
    public studentlist() {
        initComponents();
    }

    //通过学号查询
    private void search(ActionEvent e) throws Exception {
        // TODO add your code here
        String url="jdbc:mysql://localhost:3306/sys?useSSL=false&serverTimezone=Asia/Shanghai";
        String username="root";
        String password1="123456";
        Connection conn= DriverManager.getConnection(url,username,password1);

        String sql="";
        String id=this.stuid.getText().trim();
        PreparedStatement pstmt=null;
        if(stuid.getText().trim().equals("")) {
            sql = "select * from student";
            pstmt=conn.prepareStatement(sql);
        }else {
            sql = "select * from student where 学号=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,id);
        }

        ResultSet rs=pstmt.executeQuery();

        Vector<Vector<Object>> tableData = new Vector<>();
        ResultSetMetaData metaData = rs.getMetaData();
        int columns = metaData.getColumnCount();
        // 添加列名
        Vector<Object> columnNames = new Vector<>();
        for (int i = 1; i <= columns; i++) {
            columnNames.add(metaData.getColumnName(i));
        }


        // 添加数据
        while (rs.next()) {
            Vector<Object> row = new Vector<>();
            for (int i = 1; i <= columns; i++) {
                row.add(rs.getObject(i));
            }
            tableData.add(row);
        }
        // 创建TableModel
        TableModel model = new DefaultTableModel( tableData, columnNames);
        this.table1.setModel(model);

        rs.close();
        pstmt.close();
        conn.close();
    }
    

    //添加学生信息
    private void stuinsert(ActionEvent e) throws Exception {
        // TODO add your code here
        insertstu save=new insertstu();
        save.setVisible(true);

    }
    

    private void stureset(ActionEvent e) {
        // TODO add your code here
    }

    //修改选择的学生信息
    private void stuupdat(ActionEvent e) {
        // TODO add your code here

            // 获取选中行
            int row = table1.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(panel1, "请选择一条记录", "系统提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String id = (String) table1.getValueAt(row, 0);


            UpdateView view = new UpdateView(id);
            view.setVisible(true);

    }

    //删除选中的学生信息
    private void studelecta(ActionEvent e) throws SQLException {
        // TODO add your code here
        // 获取选中行
        int row = table1.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(panel1, "请选择一条记录", "系统提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int result = JOptionPane.showConfirmDialog(panel1, "确认删除该学生吗？", "提示",
                JOptionPane.YES_NO_OPTION);
        if (result == 0) {
            String id = (String) table1.getValueAt(row, 0);
            //删除数据库中的记录

            String url="jdbc:mysql://localhost:3306/sys?useSSL=false&serverTimezone=Asia/Shanghai";
            String username="root";
            String password1="123456";
            Connection conn= DriverManager.getConnection(url,username,password1);
            String sql="DELETE FROM student WHERE 学号 = ?";
            PreparedStatement pstmt=conn.prepareStatement(sql);

            pstmt.setString(1,id);

            int count=pstmt.executeUpdate();
//            service.delete(sid);
            JOptionPane.showMessageDialog(panel1, "删除成功!");
//            load(null);
        }
    }


    private void initComponents(){
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        stuid = new JTextField();
        search = new JButton();
        stuinsert = new JButton();
        stuupdat = new JButton();
        studelecta = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        panel1 = new JPanel();

        //======== this ========
        setTitle("\u5b66\u751f\u4fe1\u606f\u7ba1\u7406\u7cfb\u7edf");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u5b66\u53f7");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(15, 14), label1.getPreferredSize()));
        contentPane.add(stuid);
        stuid.setBounds(50, 11, 135, 23);

        //---- search ----
        search.setText("\u641c\u7d22");
        search.addActionListener(e -> {
            try {
                search(e);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        contentPane.add(search);
        search.setBounds(200, 10, 65, 23);

        //---- stuinsert ----
        stuinsert.setText("\u6dfb\u52a0");
        stuinsert.addActionListener(e -> {
            try {
                stuinsert(e);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        contentPane.add(stuinsert);
        stuinsert.setBounds(475, 10, stuinsert.getPreferredSize().width, 23);

        //---- stuupdat ----
        stuupdat.setText("\u4fee\u6539");
        stuupdat.addActionListener(e -> stuupdat(e));
        contentPane.add(stuupdat);
        stuupdat.setBounds(550, 10, stuupdat.getPreferredSize().width, 23);

        //---- studelecta ----
        studelecta.setText("\u5220\u9664");
        studelecta.addActionListener(e -> {
            try {
                studelecta(e);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        contentPane.add(studelecta);
        studelecta.setBounds(625, 10, studelecta.getPreferredSize().width, 23);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(5, 40, 730, 275);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(5, 320, 730, 45);

        contentPane.setPreferredSize(new Dimension(745, 400));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField stuid;
    private JButton search;
    private JButton stuinsert;
    private JButton stuupdat;
    private JButton studelecta;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
