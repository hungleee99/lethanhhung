/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TestingSystem_Assignment_10.entity;

/**
 *
 * @author admin
 */
public class Department {
    private int DepartmentID;
    private String DepartmentName;

    public Department() {
    }

    public int getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(int DepartmentID) {
        this.DepartmentID = DepartmentID;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String DepartmentName) {
        this.DepartmentName = DepartmentName;
    }

    @Override
    public String toString() {
        return "Department{" + "DepartmentID=" + DepartmentID + ", DepartmentName=" + DepartmentName + '}';
    }

    
    
    
    
}
