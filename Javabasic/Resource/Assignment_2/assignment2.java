/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment_1;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class assignment2 {
    public static void main(String[] args) {
        Group group1 = new Group();
		group1.id = 1;
		group1.name = "Java Fresher";
		group1.createDate = LocalDate.now();

		Group group2 = new Group();
		group2.id = 2;
		group2.name = "DB Fresher";
		group2.createDate = LocalDate.now();

		Group group3 = new Group();
		group3.id = 3;
		group3.name = "C++ Fresher";
		group3.createDate = LocalDate.now();

		// Create Deparment
		Department department1 = new Department();
		department1.departmentID = 1;
		department1.departmentName = "Sale";

		Department department2 = new Department();
		department2.departmentID = 2;
		department2.departmentName = "Marketting";

		Department department3 = new Department();
		department3.departmentID = 3;
		department3.departmentName = "HR";

		// Create Position
		Position position1 = new Position();
		position1.id = 1;
		position1.name = "Manager";

		Position position2 = new Position();
		position2.id = 2;
		position2.name = "Team Leader";

		Position position3 = new Position();
		position3.id = 3;
		position3.name = "Trainee";

		// Create account
		Account account1 = new Account();
		account1.id = 1;
		account1.createDate = LocalDate.now();
		account1.department = department1;
		account1.email = "An@gmail.com";
		account1.fullname = "Nguyen Van An";
		account1.position = position1;
		account1.username = "an.nguyenvan";

		Account account2 = new Account();
		account2.id = 2;
		account2.createDate = LocalDate.now();
		account2.department = department1;
		account2.email = "Linh@gmail.com";
		account2.fullname = "Nguyen Hoai Linh";
		account2.position = position3;
		account2.username = "Linh.nguyenhoai";

		Account account3 = new Account();
		account3.id = 3;
		account3.createDate = LocalDate.now();
		account3.department = department2;
		account3.email = "ha@gmail.com";
		account3.fullname = "Pham Hai Ha";
		account3.position = position1;
		account3.username = "Ha.phamhai";

		// add group to account
		Group[] groupOfAccount1 = { group1 };
		account1.groups = groupOfAccount1;

		Group[] groupOfAccount2 = { group3 };
		account2.groups = groupOfAccount2;

		Group[] groupOfAccount3 = { group1 };
		account3.groups = groupOfAccount3;

		// add account to group
		Account[] accountOfGroups1 = { account1, account2, account3 };
		group1.accounts = accountOfGroups1;
                
                
//                Q1
                if(account2.department == null){
                    System.out.println("Nhân viên này chưa có phòng ban");
                }else{
                    System.out.println("Phòng ban của nhân viên này là "+account2.department.departmentName);
                }
//                q2
                if(account2.groups == null || account2.groups.length ==0){
                    System.out.println("Nhân viên này chưa có group");
                }else if(account2.groups != null || account2.groups.length ==1){
                    System.out.println("Group của nhân viên này là"+ account2.groups[0].name);
                }else if(account2.groups.length ==2){
                    System.out.println("Group của nhân viên này là"+ account2.groups[0].name+"\t"+account2.groups[1].name);
                }else if(account2.groups.length ==3){
                    System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
                }else{
                    System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
                }
                
//                Q3
                System.out.println(account2.department == null ?"Nhân viên này chưa có phòng ban"
                        :"Phòng ban của nhân viên này là "+account2.department.departmentName);
//                Q4
                System.out.println(account1.position.name.equals("DEV")? "Đây là Developer"
                        :"Người này không phải là Developer");
//                Q5
                Scanner nhap = new Scanner(System.in);
                int Q5 = group1.accounts.length;
                switch(Q5){
                    case 1:
                        System.out.println("Nhóm có một thành viên");
                        break;
                    case 2:
                        System.out.println("Nhóm có 2 thành viên");
                        break;
                    case 3:
                        System.out.println("Nhóm có 3 thành viên");
                        break;
                    default:
                        System.out.println("Nhóm có nhiều thành viên");
                        break;
                }
//                Q6
                int x = account2.groups.length;
                switch(x){
                    case 0:
                        System.out.println("Nhân viên này chưa có group");
                        break;
                    case 1:
                        System.out.println("Group của nhân viên này là"+ account2.groups[0].name);
                        break;
                    case 2:
                        System.out.println("Group của nhân viên này là"+ account2.groups[0].name+"\t"+account2.groups[1].name);
                        break;
                    case 3:
                        System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
                        break;
                    default:
                        System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
                        break;
                }
//                Q7

                String Q7 = account1.position.name;
                switch(Q7){
                    case "DEV":
                        System.out.println("Đây là Developer");
                        break;                    
                    default:
                        System.out.println("Người này không phải là Developer");
                        break;
                }
//                Q8
                Account[] ax = {account1,account2,account3};
                for(Account account :ax){
                    System.out.println("Email: " + account.email);
                    System.out.println("FullName: " + account.fullname);
                    System.out.println("Name Department: " + account.department.departmentName);
                }
//                Q9
                Department[] d = {department1,department2,department3};
                for (Department department : d) {
			System.out.println("ID Department: " + department.departmentID);
			System.out.println("Name Department: " + department.departmentName);
		}
//                Q10
                
                for(int i=0; i<ax.length;i++){
                    System.out.println("Thông tin account thứ "+ (i+1)+ " là:");
                    System.out.println("Email: " + ax[i].email);
                    System.out.println("FullName: " + ax[i].fullname);
                    System.out.println("Name Department: " + ax[i].department.departmentName);
                }
//                Q11
                for(int i=0; i<d.length;i++){
                    System.out.println("Thông tin department thứ "+ (i+1)+ " là:");
                    System.out.println("ID Department: " + d[i].departmentID);
                    System.out.println("Name Department: " + d[i].departmentName);
                }
                // Q12.
		for (int i = 0; i < 2; i++) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là :");
			System.out.println("ID: " + d[i].departmentID);
			System.out.println("Name: " + d[i].departmentName);
		}

		// Q13.
		for (int i = 0; i < d.length; i++) {
			if (i != 1) {
				System.out.println("Thông tin department thứ " + (i + 1)
						+ " là :");
				System.out.println("ID: " + d[i].departmentID);
                                System.out.println("Name: " + d[i].departmentName);
			}
		}

		// Q14.
		for (int i = 0; i < ax.length; i++) {
			if (ax[i].id < 4) {
				System.out.println("Thông tin account thứ " + (i + 1) + " là :");
				System.out.println("Email: " + ax[i].email);
                                System.out.println("FullName: " + ax[i].fullname);
                                System.out.println("Name Department: " + ax[i].department.departmentName);
			}
		}

		// Q15.
		for (int i = 2; i <= 20; i = i + 2) {
			System.out.println(i);
		}
                // Q16-10.
		int i = 0;
		while (i < ax.length) {
			System.out.println("Thông tin account thứ " + (i + 1) + " là :");
			System.out.println("Email: " + ax[i].email);
			System.out.println("Fullname: " + ax[i].fullname);
			System.out.println("Department: " + ax[i].department.departmentName);
			i++;
		}

		// Q16-11.
		i = 0;
		while (i < ax.length) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là :");
			System.out.println("ID: " + d[i].departmentID);
                               System.out.println("Name: " + d[i].departmentName);
			i++;
		}

		// Q16-12.
		i = 0;
		while (i < 2) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là :");
			System.out.println("ID: " + d[i].departmentID);
                        System.out.println("Name: " + d[i].departmentName);;
			i++;
		}

		// Q16-13.
		i = 0;
		while (i < d.length) {

			if (i == 1) {
				i++;
				continue;
			}
			System.out.println("Thông tin department thứ " + (i + 1) + " là :");
			System.out.println("ID: " + d[i].departmentID);
                        System.out.println("Name: " + d[i].departmentName);
			i++;
		}

		// Q16-14.
		i = 0;
		while (i < ax.length) {
			if (ax[i].id >= 4) {
				i++;
				continue;
			}
			System.out.println("Thông tin account thứ " + (i + 1) + " là :");
				System.out.println("Email: " + ax[i].email);
                                System.out.println("FullName: " + ax[i].fullname);
                                System.out.println("Name Department: " + ax[i].department.departmentName);
			i++;
		}

		// Q16-15.
		i = 2;
		while (i <= 20) {
			System.out.println(i);
			i = i + 2;
		}
//                Q17
                
    }
}
