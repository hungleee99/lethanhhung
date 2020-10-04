/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TestingSystem_Assignment_10.SqlUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author admin
 */
public class PropertiesSql {
        private Properties properties;

    public PropertiesSql() throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\admin\\OneDrive\\Documents\\NetBeansProjects\\Rocket7\\src\\TestingSystem_Assignment_10\\backend\\Connection.properties"));
    }
    public String getProperty(String key) {
		return properties.getProperty(key);
    }   
}
