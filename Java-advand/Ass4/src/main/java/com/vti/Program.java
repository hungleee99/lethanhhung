package main.java.com.vti;

import java.util.Date;
import java.util.List;

import main.java.com.vti.entity.Group;
import main.java.com.vti.repository.GroupRepository;

public class Program {
	public static void main(String[] args) {
		GroupRepository repository = new GroupRepository();
		System.out.println("\t\t GET ALL GROUP\n");
		List<Group> groups = repository.getAllGroup();
		for (Group group : groups) {
			System.out.println(group);
		}
		System.out.println("\t\tGET GROUP BY ID\n");
		Group groupid = repository.getGroupbyID(2);
		System.out.println(groupid);
		System.out.println("\n\n***********CREATE GROUP***********");

		System.out.println("\t\tGET GROUP BY NAME\n");
		Group groupname = repository.getGroupbyName("hung");
		System.out.println(groupname);
		
		
		System.out.println("\n\n***********CREATE GROUP***********");
		Group groupCreate = new Group();
		groupCreate.setGroupName("quangquacs");
		groupCreate.setCreateDate(new Date(2010,10,10));
		repository.createGroup(groupCreate);
		System.out.println(groupCreate);
		
		System.out.println("\t\t UPDATE GROUP BY ID");
		Group updategroup = new Group();
		updategroup.setGroupID((short)2);
		updategroup.setGroupName("ABC");
		updategroup.setCreateDate(new Date(2020,10,14));
		repository.updateGroup(updategroup);
		System.out.println(updategroup);
		
		System.out.println("\t\t DELETE GROUP BY ID");
		repository.deleteGroupbyID(2);
		
		System.out.println("\t\t CHECK GROUP ID EXISTS !");
		System.out.println(repository.isGroupbyID((short)15));
		
		System.out.println("\t\t CHECK GROUP BY NAME\n");
		System.out.println(repository.isGroupbyName("quyen"));
	}
}
