package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Department;
import com.vti.repository.IDepartmentRepository;

@Service
public class DepartmentService implements IDepartmentService {
	@Autowired // tu dong goi den ham khoi tao cua Departmentrepository
	private IDepartmentRepository repository;
	
	@Override
	public List<Department> getAllDepartments(int page,int size,String sortType,String sortField,String search) {
		return repository.getAllDepartments(page, size, sortType, sortField, search);
	}

	@Override
	public Department getDepartmentByID(short id) {
		return repository.getDepartmentByID(id);
	}

	@Override
	public void createDepartment(Department department) {
		repository.createDepartment(department);
		
	}

	@Override
	public void updateDepartment(Department department) {
		repository.updateDepartment(department);
		
	}

	@Override
	public void deleteDepartment(short id) {
		repository.deleteDepartment(id);
		
	}

	@Override
	public List<Department> getAllDepartments_search(String search) {
		return repository.getAllDepartments_search(search);
	}

}
