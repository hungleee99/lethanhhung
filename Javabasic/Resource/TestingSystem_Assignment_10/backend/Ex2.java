/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TestingSystem_Assignment_10.backend;

import TestingSystem_Assignment_10.entity.Department;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class Ex2 {
    
    private Connection connection;
    private Properties properties;

    public Ex2() {
    }
    
    public List<Department> getDepartment() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException{
        List<Department> departments = new ArrayList<>();
        properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\admin\\OneDrive\\Documents\\NetBeansProjects\\Rocket7\\src\\TestingSystem_Assignment_10\\backend\\Connection.properties"));
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        Class.forName(properties.getProperty("driver"));
        connection = DriverManager.getConnection(url, user, password);
        String sql = "select DepartmentID,DepartmentName from department";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()){
            Department d = new Department();
            d.setDepartmentID(rs.getInt("DepartmentID"));
            d.setDepartmentName(rs.getString("DepartmentName"));
            departments.add(d);
        }
        connection.close();
        return  departments;
    }
    public  Department searching(int id) throws IOException, ClassNotFoundException, SQLException, Exception{
        properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\admin\\OneDrive\\Documents\\NetBeansProjects\\Rocket7\\src\\TestingSystem_Assignment_10\\backend\\Connection.properties"));
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        Class.forName(properties.getProperty("driver"));
        connection = DriverManager.getConnection(url, user, password);
        String sql = "select DepartmentID,DepartmentName from department  where DepartmentID=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        if(rs.next()){
            Department d = new Department();
            d.setDepartmentID(rs.getInt("DepartmentID"));
            d.setDepartmentName(rs.getString("DepartmentName"));
            connection.close();
            return d;
            
        }else{
            connection.close();
            throw new Exception(("Cannot find department which has id = "+id));
            
        }
    }
    public  boolean isDepartmentNameExists(String name) throws IOException, ClassNotFoundException, SQLException, Exception{
        properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\admin\\OneDrive\\Documents\\NetBeansProjects\\Rocket7\\src\\TestingSystem_Assignment_10\\backend\\Connection.properties"));
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        Class.forName(properties.getProperty("driver"));
        connection = DriverManager.getConnection(url, user, password);
        String sql = "select DepartmentID,DepartmentName from department  where DepartmentName=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        ResultSet rs = statement.executeQuery();
        if(rs.next()){
            connection.close();
            return  true;
        }else{
            connection.close();
            return false;
            
        }
    }
    public  boolean isDepartmentIDExists(int id) throws IOException, ClassNotFoundException, SQLException, Exception{
        properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\admin\\OneDrive\\Documents\\NetBeansProjects\\Rocket7\\src\\TestingSystem_Assignment_10\\backend\\Connection.properties"));
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        Class.forName(properties.getProperty("driver"));
        connection = DriverManager.getConnection(url, user, password);
        String sql = "select DepartmentID,DepartmentName from department  where DepartmentID=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        if(rs.next()){
            connection.close();
            return  true;
        }else{
            connection.close();
            return false;
            
        }
    }
    public  void createDepartment(String name) throws IOException, ClassNotFoundException, SQLException, Exception{
        if(isDepartmentNameExists(name)){
            throw new Exception("Department Name is Exists!");
        }
            properties = new Properties();
            properties.load(new FileInputStream("C:\\Users\\admin\\OneDrive\\Documents\\NetBeansProjects\\Rocket7\\src\\TestingSystem_Assignment_10\\backend\\Connection.properties"));
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            Class.forName(properties.getProperty("driver"));
            connection = DriverManager.getConnection(url, user, password);
            String sql = "insert into department (DepartmentName)"+" value (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.executeUpdate();
            connection.close();
            
        
    }
    public  void updateDepartmentName(int id, String newName) throws IOException, ClassNotFoundException, SQLException, Exception{
        if(!isDepartmentIDExists(id)){
            throw new Exception("Cannot find department which has id = " + id);
        }else{
            if(isDepartmentNameExists(newName)){
                throw new Exception("Department Name is Exists!");
            }           
        }  
            properties = new Properties();
            properties.load(new FileInputStream("C:\\Users\\admin\\OneDrive\\Documents\\NetBeansProjects\\Rocket7\\src\\TestingSystem_Assignment_10\\backend\\Connection.properties"));
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            Class.forName(properties.getProperty("driver"));
            connection = DriverManager.getConnection(url, user, password);
            String sql = "UPDATE Department SET DepartmentName = ? WHERE DepartmentId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newName);
            statement.setInt(2, id);
            statement.executeUpdate();
            connection.close();
    }
    public  void deleteDepartment (int id) throws IOException, ClassNotFoundException, SQLException, Exception{
        if(!isDepartmentIDExists(id)){
            throw new Exception("Cannot find department which has id = " + id);
        }         
        
            properties = new Properties();
            properties.load(new FileInputStream("C:\\Users\\admin\\OneDrive\\Documents\\NetBeansProjects\\Rocket7\\src\\TestingSystem_Assignment_10\\backend\\Connection.properties"));
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            Class.forName(properties.getProperty("driver"));
            connection = DriverManager.getConnection(url, user, password);
            String sql = "delete from Department where DepartmentId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            connection.close();
    }
}
