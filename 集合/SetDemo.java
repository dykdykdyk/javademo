package com.rsz.集合;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * 再测试不能放重复数据
 * @author EDUASK
 *
 */
public class SetDemo {

	public static void main(String[] args) {
		Set<Student1> set=new HashSet<Student1>();
		SetDemo demo=new SetDemo();
		demo.init(set);
		demo.out(set);
		List list=new ArrayList(set);//set转list
		new HashSet(list);//list转set
	}
	void init(Set<Student1> set){
		set.add(new Student1(1, "小明"));
		set.add(new Student1(1, "小明"));
	}
	void out(Set<Student1> set){
		for (Student1 student1 : set) {
			System.out.println(student1);
		}
	}
}
class Student1{
	int id;
	String name;
	public Student1(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student1 other = (Student1) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/*
	@Override
	public int hashCode() {
		return id+name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student1){
			Student1 student1=(Student1)obj;
			if(this.id==student1.id&&this.name.equals(student1.name)){
				return true;
			}
		}
		
		return false;
	}
*/
	@Override
	public String toString() {
		return "Student1 [id=" + id + ", name=" + name + "]";
	}
	
}
