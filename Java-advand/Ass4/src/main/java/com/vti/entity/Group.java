package main.java.com.vti.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name ="`Group`",catalog="TestingSystem")
public class Group {
	@Column(name="GroupID")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Id
	private int GroupID;
	
	@Column(name="GroupName",length=50,nullable= false,updatable = true)
	private String GroupName;
	
	@Column(name="CreateDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date CreateDate;

	public Group() {
	}

	public int getGroupID() {
		return GroupID;
	}

	public void setGroupID(int groupID) {
		GroupID = groupID;
	}

	public String getGroupName() {
		return GroupName;
	}

	public void setGroupName(String groupName) {
		GroupName = groupName;
	}

	public Date getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}


	@Override
	public String toString() {
		return  "Group {"+"ID= "+GroupID+",name= "+GroupName+",Date= '"+CreateDate+'\''+'}';
	}
	
	
}
