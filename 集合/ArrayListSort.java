package com.rsz.集合;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/**
 * 排序：自然排序（字典顺序）：从小到大
 * 
 * @author EDUASK
 * 
 */
public class ArrayListSort {
	public static void main(String[] args) {
		/** 对Integer的list进行排序 */
		// ArrayList<Integer> arrayList=new ArrayList<Integer>();
		// init(arrayList);
		// out(arrayList);
		// Collections.sort(arrayList);//对arrayList进行排序
		// System.out.println("----------------------");
		// out(arrayList);
		/** 对String的list进行排序 */
		ArrayList<String> arrayList1 = new ArrayList<String>();
		init1(arrayList1);
		out(arrayList1);
		System.out.println("----------------------");
		Collections.sort(arrayList1);
		out(arrayList1);
		/** 对其他数据类型-Student的list进行排序 */
		// ArrayList<Student> stuList=new ArrayList<Student>();
		// init2(stuList);
		// out(stuList);
		// Collections.sort(stuList);//使用这个方法不能对存放自定义数据类型的集合排序
		// Collections.sort(stuList,
		// new Comparator<Student>() {//匿名内部类
		// /**
		// *
		// * @param stu1 前面的student
		// * @param stu2 后面的student
		// * @return 1 交换stu1/stu2
		// * -1 不交换
		// * 0 相等
		// */
		// @Override
		// public int compare(Student stu1, Student stu2) {//对数据的两两对比
		// if(stu1.getAge()>stu2.getAge()){
		// return 1;//交换 从小到大 自然排序
		// }else if(stu1.getAge()<stu2.getAge()){
		// return -1;
		// }else{//两个age如果相等，再根据id排序
		// if(stu1.getId()>stu2.getId()){
		// return -1;//自然顺序
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
		/** 中文排序测试 */
		sortChinese(arrayList1);
//		out(arrayList1);
		/**对中文进行排序*/
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
			list.add(new Student(20 - i, "小花" + i, 10 + i));
		}
		list.add(new Student(65, "testttttttttt", 13));
		list.add(new Student(5, "testttttttttt", 13));
		list.add(new Student(9, "testttttttttt", 13));
		list.add(new Student(69, "testttttttttt", 13));
		list.add(new Student(65, "11111", 13));
		list.add(new Student(65, "222222", 13));
	}

	// 输出
	public static void out(ArrayList list) {
		for (Object object : list) {
			System.out.println(object);
		}
	}

	/**
	 * 对中文进行排序测试
	 */
	public static void sortChinese(ArrayList<String> arrayList) {
		arrayList.clear();
		arrayList.add("a");
		arrayList.add("b");
		arrayList.add("d");
		arrayList.add("c");

		arrayList.add("啊");
		arrayList.add("哦");
		arrayList.add("额");
		arrayList.add("哦");
		arrayList.add("我");
		arrayList.add("有");
		arrayList.add("与");
		arrayList.add("阿");
		arrayList.add("锕");
		arrayList.add("醃");
		arrayList.add("噢");
		arrayList.add("在");
		Collections.sort(arrayList);
		
	}
	public static void sortChineseReally(ArrayList<String> arrayList){
		Collections.sort(arrayList, new MySort());
//		Collections.sort(arrayList, new Comparator<String>() {
//
//			@Override
//			public int compare(String str1, String str2) {
//				Collator collator=Collator.getInstance(Locale.CHINA);
//				if(collator.compare(str1, str2)>0){//如果前一个大于后一个
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
		if(collator.compare(str1, str2)>0){//如果前一个大于后一个
			return 1;
		}
		if(collator.compare(str1, str2)<0){
			return -1;
		}
		return 0;
	}
	
}
