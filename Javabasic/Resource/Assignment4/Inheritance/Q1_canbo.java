/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Assignment4.Inheritance;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Q1_canbo {
    private String name;
    private int age;
    private Enum gender;
    private String address;
    
    
    public Q1_canbo() {
    }

    public Q1_canbo(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Enum getGender() {
        return gender;
    }

    public void setGender(Enum gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void setgt(int gender){
        if(gender ==1){
            this.gender = Enum.valueOf("MALE");
            }else if(gender==0){
            this.gender = Enum.valueOf("FEMALE");
            }else{
            this.gender = Enum.valueOf("UNKNOW");
            }
    }
    @Override
    public String toString() {
        return super.toString(); 
    }
    public  void nhap(){
         Scanner nhap = new Scanner(System.in);
               System.out.println("nhap ten: ");     
               name = nhap.nextLine(); 
               System.out.println("nhap tuoi: ");     
               age = (nhap.nextInt()); 
               System.out.println("nhap Gender: "); 
               System.out.println("0 - FEMALE, 1 - MALE , Other -  UNKNOW");
               setgt(nhap.nextInt());          
               nhap.nextLine();
               System.out.println("nhap dia chi: ");     
               address = (nhap.nextLine());
    }
    
    public void in(){
            System.out.println("\nthong tin can bo\n");
            System.out.println("Ten: "+this.name);
            System.out.println("Tuoi: "+this.age);
            System.out.println("gioitinh: "+this.gender);
            System.out.println("dia chi: "+this.address);
            
    }
}
