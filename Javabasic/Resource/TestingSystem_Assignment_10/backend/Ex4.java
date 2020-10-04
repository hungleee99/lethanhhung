/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TestingSystem_Assignment_10.backend;

import TestingSystem_Assignment_10.SqlUtils.PropertiesSql;
import TestingSystem_Assignment_10.SqlUtils.Sqlconnection;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class Ex4 {
    private PropertiesSql propertiesSql;
    private Sqlconnection sqlconnection;

    public Ex4() throws IOException {
        propertiesSql =  new  PropertiesSql();
        sqlconnection = new Sqlconnection();
    }
    public void deletesql(int id) throws SQLException, IOException, FileNotFoundException, ClassNotFoundException{
        Connection connection = sqlconnection.connect();
        connection.setAutoCommit(false);
        String sql = "delete from `account` where DepartmentID =?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        String sql2 = "delete from `Department` where DepartmentID =?";
        PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
        preparedStatement.executeUpdate();  
        System.out.println("delete acount success");
        preparedStatement2.setInt(1, id);
        try {
            preparedStatement.executeUpdate();  
            System.out.println("delete acount success");
            
            preparedStatement2.executeUpdate();  
            System.out.println("delete department success");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            connection.rollback();
            System.out.println("rollbacked");
        }
        connection.setAutoCommit(true);
        connection.close();
    }
    
    
}
