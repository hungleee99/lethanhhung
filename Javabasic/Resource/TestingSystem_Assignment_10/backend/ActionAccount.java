/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TestingSystem_Assignment_10.backend;

import TestingSystem_Assignment_10.SqlUtils.PropertiesSql;
import TestingSystem_Assignment_10.SqlUtils.Sqlconnection;
import TestingSystem_Assignment_10.entity.Account;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class ActionAccount {
    private PropertiesSql propertiesSql;
    private Sqlconnection sqlconnection;
    public ActionAccount() throws IOException {
        propertiesSql = new PropertiesSql();
        sqlconnection = new Sqlconnection();
    }
    
    public List<Account> getAccounts() throws SQLException, IOException, FileNotFoundException, ClassNotFoundException{
        List<Account> accounts = new ArrayList<>();
        Connection connection = sqlconnection.connect();
        String sql = "select *from `account`";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next()){
            Account a = new Account();
            a.setAccountID(rs.getInt("AccountID"));
            a.setEmail(rs.getString("Email"));
            a.setUsername(rs.getString("Username"));
            a.setFullname(rs.getString("FullName"));
            a.setDepartmentID(rs.getInt("DepartmentID"));
            accounts.add(a);
        }
        connection.close();
        return accounts;
    }
    public Account search(int id) throws SQLException, IOException, ClassNotFoundException, Exception{
        Connection connection = sqlconnection.connect();
        String sql = "select *from `account` where AccountID=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        if(rs.next()){
            Account a = new Account();
            a.setAccountID(rs.getInt("AccountID"));
            a.setEmail(rs.getString("Email"));
            a.setUsername(rs.getString("Username"));
            a.setFullname(rs.getString("FullName"));
            a.setDepartmentID(rs.getInt("DepartmentID"));
            connection.close();
            return a;
        }else{
            connection.close();
            throw new Exception("Cannot find AccountID: "+id);
        }
    }
    public boolean searchName(String name) throws SQLException, IOException, ClassNotFoundException, Exception{
        Connection connection = sqlconnection.connect();
        String sql = "select *from `account` where Username=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        ResultSet rs = preparedStatement.executeQuery();
        if(rs.next()){ 
            connection.close();
            return true;
        }else{
            connection.close();
            return false;
        }
    }
    public boolean searchID(int id) throws SQLException, IOException, ClassNotFoundException, Exception{
        Connection connection = sqlconnection.connect();
        String sql = "select *from `account` where AccountID=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        if(rs.next()){ 
            connection.close();
            return true;
        }else{
            connection.close();
            return false;
        }
    }
    public void crename(String name1,String name) throws SQLException, IOException, ClassNotFoundException, Exception{
        if(searchName(name)){
            throw  new Exception("Username is Exists");
        }
        Connection connection = sqlconnection.connect();
        String sql = "insert into `account` (Email,Username)"+" value (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name1);
        preparedStatement.setString(2, name);
        preparedStatement.executeUpdate();
        connection.close();
        
    }
    
}
