/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Assignment5.Inheritance;

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

//    public  void remove(){
//            q1.remove(q1);   
//    }
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
