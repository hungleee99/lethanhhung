package com.vti.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.vti.entity.Department;
import com.vti.utils.hibernateUtils;

@Repository
public class DepartmentRepository implements IDepartmentRepository{

	private hibernateUtils hibernateUtil;

	public DepartmentRepository() {
		hibernateUtil = hibernateUtils.getInstance();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Department> getAllDepartments(int page,int size,String sortType,String sortField,String search) {
		Session session = null;

		try {

			// get session
			session = hibernateUtil.openSession();

			// create hql query
			Criteria criteria =  session.createCriteria(Department.class);
			
			// paging
			criteria.setFirstResult((page - 1) * size);
			criteria.setMaxResults(size);
			
			//sort
			if(sortType.equals("ASC")) {
				criteria.addOrder(Order.asc(sortField));
			}else {
				criteria.addOrder(Order.desc(sortField));
			}
			
			//search
			criteria.add(Restrictions.ilike("name", search+"%"));
			
			
			//finter by id tu 1 -10
			return criteria.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public Department getDepartmentByID(short id) {
		
		Session session = null;

		try {

			// get session
			session = hibernateUtil.openSession();

			// get department by id
			Department department = session.get(Department.class, id);

			return department;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void createDepartment(Department department) {
		
		Session session = null;

		try {

			// get session
			session = hibernateUtil.openSession();
			session.beginTransaction();

			// create
			session.save(department);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
	}

	@Override
	public void updateDepartment(Department department) {

		Session session = null;

		try {

			// get session
			session = hibernateUtil.openSession();
			session.beginTransaction();

			// update
			session.update(department);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	@Override
	public void deleteDepartment(short id) {
		Session session = null;

		try {

			// get session
			session = hibernateUtil.openSession();
			session.beginTransaction();

			// get department
			Department department = (Department) session.load(Department.class, id);

			// delete
			session.delete(department);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		
	}

	@Override
	public List<Department> getAllDepartments_search(String search) {
		Session session = null;

		try {

			// get session
			session = hibernateUtil.openSession();

			// create hql query
			Criteria criteria =  session.createCriteria(Department.class);		
			//search
			criteria.add(Restrictions.ilike("name", search+"%"));
			return criteria.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
