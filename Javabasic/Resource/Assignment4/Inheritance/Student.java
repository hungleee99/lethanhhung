/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Assignment5.Inheritance;

/**
 *
 * @author admin
 */
public class Student extends Q3_Person{
    public int id;

    public Student(String name) {
        super(name);
    }

    public Student(int id, String name) {
        super(name);
        this.id = id;
    }
    
}
