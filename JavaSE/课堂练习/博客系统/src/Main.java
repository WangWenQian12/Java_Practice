

import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException,SQLException {

        //1.注册Driver
        Class.forName ("com.mysql.jdbc.Driver");
        //2.通过DriverManager 获取数据库连接
        Connection connection = DriverManager.getConnection (
                "jdbc:mysql://localhost:3306/sms?useSSL=false",
                "root",
                "775823"
        );

        //创建向日葵班(用try不用close)
        Statement statement = connection.createStatement ();
        statement.executeUpdate ("INSERT INTO classes(name) VALUES('向日葵班')");
        statement.close ();

        //查找向日葵班的班号
        statement = connection.createStatement ();
        ResultSet no = statement.executeQuery ("SELECT id FROM classes WHERE name = '向日葵班'");
        no.close ();
        statement.close ();

        //插入新生
        statement  = connection.createStatement ();
        statement.executeUpdate ("INSERT INTO students(sn,class_id,name) VALUES ('10086','classId')");

       /*
        //增
        Statement statement = connection.createStatement ();
        int rows = statement.executeUpdate ("INSERT INTO classes(name) VALUES('Java11班')");
        System.out.println (rows);
        statement.close ();

        Statement statement2 = connection.createStatement ();
        rows = statement2.executeUpdate ("INSERT INTO classes(name) VALUES('Java12班')");
        System.out.println (rows);
        statement2.close ();

        //改
        statement = connection.createStatement ();
        rows = statement.executeUpdate ("UPDATE classes SET name = 'C++11班' WHERE name = 'Java11班'");
        System.out.println (rows);
        statement.close ();*/


        //删
//        statement = connection.createStatement ();
//        rows = statement.executeUpdate ("DELETE classes(name) VALUES('Java12班')");
//        System.out.println (rows);
//        statement.close ();

        //



        /*ResultSet resultSet = statement.executeQuery ("SHOW TABLES");
        while(resultSet.next ()){
            //JDBC,列是从1开始的
            String tableName = resultSet.getString (1);
            System.out.println (tableName);
        }
        resultSet.close ();

        statement.close ();


        //System.out.println (connection);
        */
        connection.close ();
    }

}
