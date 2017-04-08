package com.rsz.集合;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 集合：容器-数据
 * 		容量-动态增长
 * 		对数据进行比较方便的操作-对数据的增、删、改、查		
 * @author EDUASK
 *
 */
public class ArrayList01 {
	public static void main(String[] args) {
		ArrayList<Integer> strList=new ArrayList<Integer>();
//		strList.clear();
		init(strList);
		strList.remove(0);//根据下标删除元素
		strList.remove(new Integer(3));//根据元素的值删除元素
		strList.set(1, 1000);
//		out1(strList);
//		strList.remove(100);
		strList.remove(new Integer(10000));
		strList.set(4, 1000);
//		out1(strList);
//		out2(strList);
//		out3(strList);
		test1();
		
	}
	/**
	 * 测试声明集合对象时，泛型的要求
	 * 声明、创建对象的时候-泛型可以：两边都有、两边都没有、其中一边有
	 */
	public static void test1(){
		ArrayList<String> arrayList=new ArrayList();
		arrayList.add("1234567890");
		arrayList.add("35");
		for (Object object : arrayList) {
			if(object instanceof java.lang.String)
				System.out.println(object);
		}
	}
	/**对集合进行初始化*/
	public static void init(ArrayList<Integer> arrayList){
		for (int i = 0; i <10; i++) {
			arrayList.add(i);
		}
	}
	/**
	 * 输出：for--下标进行遍历
	 * @param arrayList
	 */
	public static void out1(ArrayList<Integer> arrayList){
		for (int i = 0; i < arrayList.size(); i++) {//size()---得到数据的个数
			int k=arrayList.get(i);
			System.out.println(k);
		}
	}
	/**
	 * 输出：for-foreach
	 * 		一般不要对arraylist长度进行改变
	 */
	public static void out2(ArrayList<Integer> arraylist){
		for (Integer integer : arraylist) {
//			arraylist.clear();
//			arraylist.add(3);
//			arraylist.remove(2);
//			arraylist.set(1, -1);//修改可以，查询可以
			System.out.println(integer);
			
		}
		System.out.println("--------------------------------");
		for (Integer integer : arraylist) {
//			arraylist.clear();
			arraylist.set(0, -1);
			System.out.println(integer);
			
		}
	}
	
	/**
	 * 使用迭代器进行数据的迭代
		 * 通过调用iterator得到迭代器
		 * 然后通过迭代器进行迭代
	 */
	public static void out3(ArrayList<Integer> arrayList){
		//得到迭代器
		Iterator<Integer> iterator=arrayList.iterator();
		while(iterator.hasNext()){
			Integer integer=iterator.next();
			System.out.println(integer);
		}
	}
}



















