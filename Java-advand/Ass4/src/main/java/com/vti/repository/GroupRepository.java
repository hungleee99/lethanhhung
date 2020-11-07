package main.java.com.vti.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import main.java.com.vti.Ultils.hibernateUtils;
import main.java.com.vti.entity.Group;

public class GroupRepository implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private hibernateUtils hibernateUtil;

	public GroupRepository() {
		hibernateUtil = hibernateUtils.getInstance();
	}
	@SuppressWarnings("unchecked")
	public List<Group> getAllGroup(){
		Session session= null;
		try{
			session = hibernateUtil.openSession();
			Query<Group> query = session.createQuery("FROM Group");
			return query.list();
		}finally{
			if(session != null){
				session.close();
			}
		}
	}
	public Group getGroupbyID(int id){
		Session session = null;
		try{
			session = hibernateUtil.openSession();
			Group group = session.get(Group.class, id);
			return group;
		}finally{
			if(session !=null){
				session.close();
			}
		}
	}
	public Group getGroupbyName(String name){
		Session session = null;
		try{
			session = hibernateUtil.openSession();
			Query<Group> query = session.createQuery("FROM Group WHERE GroupName =:name");
			query.setParameter("name", name);
			Group group = query.uniqueResult();
			return group;
		}finally{
			if(session !=null){
				session.close();
			}
		}
	}
	public void createGroup(Group group) {

		Session session = null;

		try {

			// get session
			session = hibernateUtil.openSession();
			session.beginTransaction();

			// create
			session.save(group);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void updateGroup(Group group){
		Session session = null;
		try{
			session = hibernateUtil.openSession();
			session.beginTransaction();
			
			session.update(group);
			session.getTransaction().commit();
		}finally{
			if(session !=null){
				session.close();
			}
		}
	}
	public void deleteGroupbyID(int id){
		Session session = null;
		try{
			session = hibernateUtil.openSession();
			session.beginTransaction();
			Group group = (Group) session.load(Group.class, id);
			session.delete(group);
			session.getTransaction().commit();
		}finally{
			if(session !=null){
				session.close();
			}
		}
	}
	
	public boolean isGroupbyID(int id){
		Group group = getGroupbyID(id);
			if(group !=null){
			return true;
			}else return false;
	}
	public boolean isGroupbyName(String name){
		Group group = getGroupbyName(name);
			if(group !=null){
			return true;
			}else return false;
	}
}
