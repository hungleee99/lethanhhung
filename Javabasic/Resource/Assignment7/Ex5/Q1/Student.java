/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Assignment7.Ex5.chuabai;

import java.util.Scanner;


/**
 *
 * @author admin
 */
public class Student {
    private String id;
    private String name;

    public Student() {
    }

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void nhap(){
        Scanner s = new Scanner(System.in);
        System.out.println("nhap id: ");
        id  = s.nextLine();
        System.out.println("nhap name: ");
        name  = s.nextLine();
        
    }
    public void in(){
        System.out.println("id: "+id);
        System.out.println("name: "+name);
        
    }
	
    public String toString(){
        return getId() + "-"+getName();
    }
}
