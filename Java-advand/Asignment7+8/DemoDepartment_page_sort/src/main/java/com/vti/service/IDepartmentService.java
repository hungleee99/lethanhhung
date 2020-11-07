package com.vti.service;

import java.util.List;

import com.vti.entity.Department;

public interface IDepartmentService {
	public List<Department> getAllDepartments(int page,int size,String sortType,String sortField,String search);
	public List<Department> getAllDepartments_search(String search);
	public Department getDepartmentByID(short id);
//	public Department getDepartmentByName(String name);
	public void createDepartment(Department department);
	public void updateDepartment(Department department);
	public void deleteDepartment(short id);
//	public boolean isDepartmentExistsByID(short id);
//	public boolean isDepartmentExistsByName(String name);
}
