/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment_1;
import java.time.LocalDate;

public class Program {
	public static void main(String[] args) {
		// create department
		Department department1 = new Department();
		department1.departmentID = 1;
		department1.departmentName = "Sale";

		Department department2 = new Department();
		department2.departmentID = 2;
		department2.departmentName = "Marketting";

		// create group
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "Java";

		Group group2 = new Group();
		group2.id = 2;
		group2.name = "C# ";

		// Create position
		Position position1 = new Position();
		position1.id = 1;
		position1.name = "Sale";

		Position position2 = new Position();
		position1.id = 2;
		position1.name = "Marketing";

		// Create account
		Account account1 = new Account();
		account1.id = 1;
                account1.fullname = "Lethanhhung";
		account1.email = "hung@gmail.com";
                account1.position = position1;
		account1.department = department1;
		account1.groups = new Group[] { group1, group2 };
		account1.createDate = LocalDate.now();
		account1.username = "Hungleee";

		Account account2 = new Account();
		account2.id = 2;
		account2.email = "Hungeirk@gmail.com";
		account2.groups = new Group[] { group1 };
                account2.position = position2;
		account2.department = department2;
		account2.fullname = "Hung le";
		account2.createDate = LocalDate.now();
		account2.username = "hungleee";

		// print department
		System.out.println("\n\t\tDepartment 1 information\n");

		System.out.println("name: " + department1.departmentName);
		System.out.println("id: " + department1.departmentID);
		System.out.println("\n");

		System.out.println("\n\t\tDepartment 2 information: \n");

		System.out.println("name: " + department2.departmentName);
		System.out.println("id: " + department2.departmentID);
		System.out.println("\n");

		// print account
		System.out.println("\n\t\tAccount 1 information: \n");
		System.out.println("id: " + account1.id);
                System.out.println("Fullname "+ account1.fullname);
                System.out.println("DepartmentId "+ account1.department.departmentID);
		System.out.println("Email: " + account1.email);
		System.out.println("Create Date: " + account1.createDate);
                
                System.out.println("\n\t\tAccount 1 information: \n");
		System.out.println("id: " + account2.id);
                System.out.println("Fullname "+ account2.fullname);
                System.out.println("DepartmentId "+ account2.department.departmentID);
		System.out.println("Email: " + account1.email);
		System.out.println("Create Date: " + account1.createDate);
                
//                assignment2
                if(account2.groups == null){
                    System.out.println("nhân viên này chưa có phòng ban\n");
                }else{
                    System.out.println("Phòng ban của nhân viên này là " +department2.departmentName);
                }

	}
}
