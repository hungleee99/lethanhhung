/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TestingSystem_Assignment_10.SqlUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author admin
 */
public class Sqlconnection {
    private Connection connection;
    private PropertiesSql properties;
    public Sqlconnection() throws IOException{
        properties = new PropertiesSql();
    }
    
    public void connectForTesting() throws SQLException, FileNotFoundException, IOException, ClassNotFoundException{
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        Class.forName(properties.getProperty("driver"));
        connection = DriverManager.getConnection(url,user,password);
        System.out.println("ket noi thanh cong");
    }
    public Connection connect() throws SQLException, FileNotFoundException, IOException, ClassNotFoundException{
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        Class.forName(properties.getProperty("driver"));
        connection = DriverManager.getConnection(url,user,password);
        return connection;
    }
    public void disconnect() throws SQLException{
        connection.close();
    }
     
}
