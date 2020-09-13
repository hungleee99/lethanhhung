/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment_1;

import java.time.LocalDate;

/**
 *
 * @author admin
 */
public class GroupAccount {
   int  Groupid;
   int Accountid;
   LocalDate JoinDate;

    public GroupAccount() {
    }

    public GroupAccount(int Groupid, int Accountid, LocalDate JoinDate) {
        this.Groupid = Groupid;
        this.Accountid = Accountid;
        this.JoinDate = JoinDate;
    }
   
}
