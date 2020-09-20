/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Assignment5.Encapsulation;

/**
 *
 * @author admin
 */
public class Account {
    public String id;
    public String name;
    public int balance;

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }
    public int credit(int amount){
        return amount;
    }
    public int deedit(int amount){
        return amount;
    }
    public static void tranferTo(Account account,int amount) {
        System.out.println("Complate");
    }
    
}
