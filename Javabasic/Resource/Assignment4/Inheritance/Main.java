/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Assignment5.Inheritance;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Main {
    public static void main(String[] args) {
        Q2_QLCB q2_qlcb = new Q2_QLCB();
        Scanner nhap = new Scanner(System.in);
        System.out.println("nhap n phan tu: ");
        int n =nhap.nextInt();
        for(int i=0;i<n;i++){
            q2_qlcb.nhap();
        }
        q2_qlcb.in();
        q2_qlcb.tk();
        System.out.println("\n\t\t xoa doi tuong\n");
        q2_qlcb.remove();
        System.out.println("\n\t\t danh sach sau khi xoa\n");
        q2_qlcb.in();
        System.exit(0);
    }
}
