package com.rsz.集合;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet: 1、可以排序--*
 * 			2、此实现为基本操作（add、remove 和 contains）提供受保证的 log(n) 时间开销。
 * 			3、此实现不是同步的--线程
 * @author EDUASK
 *
 */
public class TreeSetDemo {
	public static void main(String[] args) {
		TreeSetDemo demo=new TreeSetDemo();
		Set<Integer> set=new TreeSet<Integer>();//向上转型
//		demo.init(set);
//		demo.out(set);
		demo.sortSet3();
	}
	/**对TreeSet进行自定义排序*/
	public void sortSet(){
		Set<Integer> set=new TreeSet<Integer>(new Comparator<Integer>() {
			/**倒序*/
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1<o2){
					return 1;
				}else if(o1>o2){
					return -1;
				}
				return 0;
			}
		});
		init(set);
		out(set);
		
	}
	
	/**第二种排序方式*/
	public void sortSet2(){
		Set<Student> set=new TreeSet<Student>();
		init2(set);
		out2(set);
	}
	/**测试---排序听谁的*/
	public void sortSet3(){
		Set<Student> set=new TreeSet<Student>(new Comparator<Student>() {
			/**正序*/
			@Override
			public int compare(Student o1, Student o2) {
				if(o1.id>o2.id){//排序：根据id排序--id小的在前面
					return 1;
				}else if(o1.id<o2.id){
					return -1;
				}
				return 0;//0---相等
			}
		});
		init2(set);
		out2(set);
	}
	
	
	/**初始化数据*/
	public void init(Set<Integer> set){
		for (int i = 20; i>=0 ; i--) {
			set.add(i);
		}
	}
	/**初始化数据-*/
	public void init2(Set<Student> set){
		for (int i = 0; i < 20; i++) {
			set.add(new Student(20-i, "name"+(20-i)));
		}
	}
	/**输出*/
	public void out(Set<Integer> set){
		Iterator<Integer> iterator=set.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	/**输出*/
	public void out2(Set<Student> set){
		Iterator<Student> iterator=set.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	/**让这个类实现一个借口，让TreeSet*/
	private class Student implements Comparable<Student>{
		int id;
		String name;
		public Student(int id, String name) {
			this.id = id;
			this.name = name;
		}
		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + "]";
		}
		/**相当于Comparetor的compare方法*/
		@Override
		public int compareTo(Student o) {
			//倒序
			if(this.id>o.id){//排序：根据id排序--id大的在前面
				return -1;
			}else if(this.id<o.id){
				return 1;
			}
			return 0;//0---相等
		}
		
	}
}
