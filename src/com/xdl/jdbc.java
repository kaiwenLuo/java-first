package com.xdl;

import java.sql.*;

public class jdbc {

    public static void main(String[] args) throws SQLException {
        //1.加载驱动
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //2.获得连接
        Connection conn = null;
        try {
            conn = DriverManager.getConnection
                    ("jdbc:oracle:thin:@localhost:1521/xe", "scott", "tiger");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //3.进行查询
        String sql = "select * from dept";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //4.得到结果
        ResultSet resultSet = ps.executeQuery();
        //5.展示结果
        while (resultSet.next()){
            String dName = resultSet.getString(3);
            System.out.println(dName);
        }
        //6.关闭
        resultSet.close();
        ps.close();
        conn.close();
    }
}
