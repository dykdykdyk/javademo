package com.rsz.����;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/**
 * ������Ȼ�����ֵ�˳�򣩣���С����
 * 
 * @author EDUASK
 * 
 */
public class ArrayListSort {
	public static void main(String[] args) {
		/** ��Integer��list�������� */
		// ArrayList<Integer> arrayList=new ArrayList<Integer>();
		// init(arrayList);
		// out(arrayList);
		// Collections.sort(arrayList);//��arrayList��������
		// System.out.println("----------------------");
		// out(arrayList);
		/** ��String��list�������� */
		ArrayList<String> arrayList1 = new ArrayList<String>();
		init1(arrayList1);
		out(arrayList1);
		System.out.println("----------------------");
		Collections.sort(arrayList1);
		out(arrayList1);
		/** ��������������-Student��list�������� */
		// ArrayList<Student> stuList=new ArrayList<Student>();
		// init2(stuList);
		// out(stuList);
		// Collections.sort(stuList);//ʹ������������ܶԴ���Զ����������͵ļ�������
		// Collections.sort(stuList,
		// new Comparator<Student>() {//�����ڲ���
		// /**
		// *
		// * @param stu1 ǰ���student
		// * @param stu2 �����student
		// * @return 1 ����stu1/stu2
		// * -1 ������
		// * 0 ���
		// */
		// @Override
		// public int compare(Student stu1, Student stu2) {//�����ݵ������Ա�
		// if(stu1.getAge()>stu2.getAge()){
		// return 1;//���� ��С���� ��Ȼ����
		// }else if(stu1.getAge()<stu2.getAge()){
		// return -1;
		// }else{//����age�����ȣ��ٸ���id����
		// if(stu1.getId()>stu2.getId()){
		// return -1;//��Ȼ˳��
		// }else if(stu1.getId()<stu2.getId()){
		// return 1;
		// }
		// }
		// return 0;
		// }
		// }
		//
		// );
		// out(stuList);
		/** ����������� */
		sortChinese(arrayList1);
//		out(arrayList1);
		/**�����Ľ�������*/
		sortChineseReally(arrayList1);
		out(arrayList1);
		List<Student> list=new ArrayList<Student>();
	}

	public static void init(ArrayList list) {
		for (int i = 0; i < 40; i++) {
			list.add((40 - i));// 20,19,18,17,16,15,14
		}
	}

	public static void init1(ArrayList<String> list) {
		for (int i = 0; i < 40; i++) {
			list.add("" + (40 - i));// 20,19,18,17,16,15,14
		}
	}

	public static void init2(ArrayList<Student> list) {
		for (int i = 0; i < 20; i++) {
			list.add(new Student(20 - i, "С��" + i, 10 + i));
		}
		list.add(new Student(65, "testttttttttt", 13));
		list.add(new Student(5, "testttttttttt", 13));
		list.add(new Student(9, "testttttttttt", 13));
		list.add(new Student(69, "testttttttttt", 13));
		list.add(new Student(65, "11111", 13));
		list.add(new Student(65, "222222", 13));
	}

	// ���
	public static void out(ArrayList list) {
		for (Object object : list) {
			System.out.println(object);
		}
	}

	/**
	 * �����Ľ����������
	 */
	public static void sortChinese(ArrayList<String> arrayList) {
		arrayList.clear();
		arrayList.add("a");
		arrayList.add("b");
		arrayList.add("d");
		arrayList.add("c");

		arrayList.add("��");
		arrayList.add("Ŷ");
		arrayList.add("��");
		arrayList.add("Ŷ");
		arrayList.add("��");
		arrayList.add("��");
		arrayList.add("��");
		arrayList.add("��");
		arrayList.add("�");
		arrayList.add("�Z");
		arrayList.add("��");
		arrayList.add("��");
		Collections.sort(arrayList);
		
	}
	public static void sortChineseReally(ArrayList<String> arrayList){
		Collections.sort(arrayList, new MySort());
//		Collections.sort(arrayList, new Comparator<String>() {
//
//			@Override
//			public int compare(String str1, String str2) {
//				Collator collator=Collator.getInstance(Locale.CHINA);
//				if(collator.compare(str1, str2)>0){//���ǰһ�����ں�һ��
//					return 1;
//				}
//				if(collator.compare(str1, str2)<0){
//					return -1;
//				}
//				return 0;
//			}
//		});
	}
}

class Student {
	private int id;
	private String name;
	private int age;

	public Student(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}
class MySort implements Comparator<String>{

	@Override
	public int compare(String str1, String str2) {
		Collator collator=Collator.getInstance(Locale.CHINA);
		if(collator.compare(str1, str2)>0){//���ǰһ�����ں�һ��
			return 1;
		}
		if(collator.compare(str1, str2)<0){
			return -1;
		}
		return 0;
	}
	
}
