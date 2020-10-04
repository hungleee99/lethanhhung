/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TestingSystem_Assignment_10.frontend;

import TestingSystem_Assignment_10.backend.Ex1;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class Program1 {
    public static void main(String[] args) throws SQLException, IOException, FileNotFoundException, ClassNotFoundException {
        Ex1 ex = new Ex1();
        ex.connect();
        ex.selectSql();
        ex.insertP("hung");
        ex.updateP();
        ex.deleteP(18);
        ex.closeConnection();
        
    }
}
