package cn.java.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

/**
 * description：功能
 * author：丁鹏
 * date：11:45
 */
public class GongNen {

    /**
     * 添加数据
     * @param name
     * @param idcard
     * @param gender
     * @param address
     * @return
     */
    public static boolean addPerson(Scanner input) throws Exception {
        System.out.println("开始录入公名信息：");
        System.out.print("请输入姓名：");
        String name = input.next();
        System.out.print("请输入身份证号：");
        String idcard = input.next();
        System.out.print("请输入性别：");
        String gender = input.next();
        System.out.print("请输入地址：");
        String address = input.next();
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dt71", "root", "root");
        Statement st = conn.createStatement();
        String sql = "INSERT  INTO  person(name,idcard,gender,address) values('"+name+"','"+idcard+"','"+gender+"','"+address+"')";
        int i = st.executeUpdate(sql);
        st.close();
        conn.close();
        return i>=1?true:false;
    }

}
