/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TestingSystem_Assignment_10.backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class Ex1 {
    public Connection connection; 
    private Properties properties;
    public void connect() throws SQLException, FileNotFoundException, IOException, ClassNotFoundException{
        properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\admin\\OneDrive\\Documents\\NetBeansProjects\\Rocket7\\src\\TestingSystem_Assignment_10\\backend\\Connection.properties"));
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        Class.forName(properties.getProperty("driver"));
        connection = DriverManager.getConnection(url,user,password);
        System.out.println("ket noi thanh cong");
    }
    public void selectSql() throws SQLException{
            String sql = "select *from position";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs  = statement.executeQuery();
            while(rs.next()){
                String PositionID = rs.getString("PositionID");
                String PositionName = rs.getString("PositionName");
                System.out.println(PositionID+"\t|\t"+PositionName+"\n");
            }
    }
    public void insertP(String name) throws SQLException{
            String sql = "insert into position (PositionName) value (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            int effect = statement.executeUpdate();
            if (effect == 1) {
		System.out.println("complete");
            } else {
		System.out.println(("false"));
            }
    }
    public void updateP() throws SQLException{
            Statement statement = connection.createStatement();
            String sql = "update position set PositionName ='DEV' where PositionID =5";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, name);
            int effect = statement.executeUpdate(sql);
            if (effect == 1) {
		System.out.println("complete");
            } else {
		System.out.println(("false"));
            }
    }
    public void deleteP(int id) throws SQLException{
            String sql = "delete from position where PositionID =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int effect = statement.executeUpdate();
            if (effect > 0) {
		System.out.println("complete");
            } else {
		System.out.println(("false"));
            }
    }
    public void closeConnection() throws SQLException{
        connection.close();
    }
/*public class Ex1 {
    public Connection connection; 
    public void connect() throws SQLException, IOException, ClassNotFoundException{
        String url = "jdbc:mysql://localhost:3306/qlybaithi";
        String user ="root";
        String password ="hung12345";
        connection = DriverManager.getConnection(url,user,password);
        System.out.println("ket noi thanh cong");
    }
    public void selectSql() throws SQLException{
            String sql = "select *from position";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs  = statement.executeQuery();
            while(rs.next()){
                String PositionID = rs.getString("PositionID");
                String PositionName = rs.getString("PositionName");
                System.out.println(PositionID+"\t|\t"+PositionName+"\n");
            }
    }
    public void insertP(String name) throws SQLException{
            String sql = "insert into position (PositionName) value (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            int effect = statement.executeUpdate();
            if (effect == 1) {
		System.out.println("complete");
            } else {
		System.out.println(("false"));
            }
    }
    public void updateP() throws SQLException{
            Statement statement = connection.createStatement();
            String sql = "update position set PositionName ='DEV' where PositionID =5";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, name);
            int effect = statement.executeUpdate(sql);
            if (effect == 1) {
		System.out.println("complete");
            } else {
		System.out.println(("false"));
            }
    }
    public void deleteP(int id) throws SQLException{
            String sql = "delete from position where PositionID =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int effect = statement.executeUpdate();
            if (effect > 0) {
		System.out.println("complete");
            } else {
		System.out.println(("false"));
            }
    }
    public void closeConnection() throws SQLException{
        connection.close();
    }
    */

}
