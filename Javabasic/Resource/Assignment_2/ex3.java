/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment_1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

public class ex3 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		// Create group
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

		// Create CategoryQuestion
		CategoryQuestion category1 = new CategoryQuestion();
		category1.id = 1;
		category1.categoryName = "JAVA";

		CategoryQuestion category2 = new CategoryQuestion();
		category2.id = 2;
		category2.categoryName = "DB";

		CategoryQuestion category3 = new CategoryQuestion();
		category3.id = 3;
		category3.categoryName = "C++";

		// Create TypeQuestion
		TypeQuestion type1 = new TypeQuestion();
		type1.id = 1;
		type1.typeName = "Essay";

		TypeQuestion type2 = new TypeQuestion();
		type2.id = 2;
		type2.typeName = "Multi-choice";

		// Create Question
		Question question1 = new Question();
		question1.categoryQuestion = category1;
		question1.content = "Dac diem chinh cua Java";
		question1.createDate = LocalDate.now();
		question1.account = account1;
		question1.id = 1;
		question1.typeQuestion = type1;

		Question question2 = new Question();
		question2.categoryQuestion = category1;
		question2.content = "Cac chuong trinh Java chu yeu";
		question2.createDate =  LocalDate.now();
		question2.account = account1;
		question2.id = 2;
		question2.typeQuestion = type2;

		Question question3 = new Question();
		question3.categoryQuestion = category1;
		question3.content = "Quy tac thiet ke Database";
		question3.createDate = LocalDate.now();
		question3.account = account2;
		question3.id = 3;
		question3.typeQuestion = type1;

		// Create exam
		Exam exam1 = new Exam();
		exam1.code = "JV01";
		exam1.createDate = LocalDate.now();
		exam1.account = account1;
		exam1.duration = 60;
		exam1.id = 1;
		exam1.title = "Kien thuc co ban ve Java";

		Exam exam2 = new Exam();
		exam2.code = "DB01";
		exam2.createDate = LocalDate.now();
		exam2.account = account2;
		exam2.duration = 60;
		exam2.id = 2;
		exam1.title = "Kien thuc co ban ve Database";

		// add question to exam
		Question[] questionOfExam1 = { question1, question2 };
		exam1.questions = questionOfExam1;

		Question[] questionOfExam2 = { question3 };
		exam1.questions = questionOfExam2;

		// Create Answer
		Answer answer1 = new Answer();
		answer1.id = 1;
		answer1.content = "JAVA la ngon ngu lap trinh pho bien nhat";
		answer1.isCorrect = true;
		answer1.question = question1;

		Answer answer2 = new Answer();
		answer2.id = 2;
		answer2.content = "JAVA la ngon ngu lap trinh mat phi";
		answer2.isCorrect = false;
		answer2.question = question1;

		// Q1.
		Locale locale = new Locale("vi", "VN");

		DateFormat dateformat = DateFormat.getDateInstance(DateFormat.DEFAULT,
				locale);

		String date = dateformat.format(account1.createDate);

		System.out.println(exam1.code + ": " + date);

		// Q2.
		String pattern = "yyyy-MM-dd-HH-mm-ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		Exam[] exams = { exam1, exam2 };
		for (Exam exam : exams) {
			date = simpleDateFormat.format(exam.createDate);
			System.out.println(exam.code + ": " + date);
		}

		// Q3.
		pattern = "yyyy";
		simpleDateFormat = new SimpleDateFormat(pattern);
		for (Exam exam : exams) {
			date = simpleDateFormat.format(exam.createDate);
			System.out.println(exam.code + ": " + date);
		}

		// Q4.
		pattern = "yyyy-MM";
		simpleDateFormat = new SimpleDateFormat(pattern);
		for (Exam exam : exams) {
			date = simpleDateFormat.format(exam.createDate);
			System.out.println(exam.code + ": " + date);
		}

		// Q6.
		pattern = "MM-dd";
		simpleDateFormat = new SimpleDateFormat(pattern);
		for (Exam exam : exams) {
			date = simpleDateFormat.format(exam.createDate);
			System.out.println(exam.code + ": " + date);
		}
	}
}
