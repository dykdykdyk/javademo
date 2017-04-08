package com.rsz.����;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet: 1����������--*
 * 			2����ʵ��Ϊ����������add��remove �� contains���ṩ�ܱ�֤�� log(n) ʱ�俪����
 * 			3����ʵ�ֲ���ͬ����--�߳�
 * @author EDUASK
 *
 */
public class TreeSetDemo {
	public static void main(String[] args) {
		TreeSetDemo demo=new TreeSetDemo();
		Set<Integer> set=new TreeSet<Integer>();//����ת��
//		demo.init(set);
//		demo.out(set);
		demo.sortSet3();
	}
	/**��TreeSet�����Զ�������*/
	public void sortSet(){
		Set<Integer> set=new TreeSet<Integer>(new Comparator<Integer>() {
			/**����*/
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
	
	/**�ڶ�������ʽ*/
	public void sortSet2(){
		Set<Student> set=new TreeSet<Student>();
		init2(set);
		out2(set);
	}
	/**����---������˭��*/
	public void sortSet3(){
		Set<Student> set=new TreeSet<Student>(new Comparator<Student>() {
			/**����*/
			@Override
			public int compare(Student o1, Student o2) {
				if(o1.id>o2.id){//���򣺸���id����--idС����ǰ��
					return 1;
				}else if(o1.id<o2.id){
					return -1;
				}
				return 0;//0---���
			}
		});
		init2(set);
		out2(set);
	}
	
	
	/**��ʼ������*/
	public void init(Set<Integer> set){
		for (int i = 20; i>=0 ; i--) {
			set.add(i);
		}
	}
	/**��ʼ������-*/
	public void init2(Set<Student> set){
		for (int i = 0; i < 20; i++) {
			set.add(new Student(20-i, "name"+(20-i)));
		}
	}
	/**���*/
	public void out(Set<Integer> set){
		Iterator<Integer> iterator=set.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	/**���*/
	public void out2(Set<Student> set){
		Iterator<Student> iterator=set.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	/**�������ʵ��һ����ڣ���TreeSet*/
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
		/**�൱��Comparetor��compare����*/
		@Override
		public int compareTo(Student o) {
			//����
			if(this.id>o.id){//���򣺸���id����--id�����ǰ��
				return -1;
			}else if(this.id<o.id){
				return 1;
			}
			return 0;//0---���
		}
		
	}
}
