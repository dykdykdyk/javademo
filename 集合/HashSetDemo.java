package com.rsz.集合;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * set和list最大不同：set不能放重复的数据
 * 		特点：1、它不保证 set 的迭代顺序；特别是它不保证该顺序恒久不变。
 * 			 2、可以放null
 * 			 3、使用iterator进行迭代，不能修改长度,包块foreach
 * 			 ？、此实现不是同步的--线程
 * @author EDUASK
 *
 */
public class HashSetDemo {
	public static void main(String[] args) {
		HashSetDemo demo=new HashSetDemo();
		Set<String> set=new HashSet<String>();
		demo.test1(set);
		demo.test2(set);
		demo.out1(set);
//		demo.out2(set);
		set.clear();
	}
	/**
	 * set是否只能放不重复的数据
	 */
	public void test1(Set<String> set){
		
		set.add(10+"");
		set.add(10+"");
		set.add(10+"");
		set.add(null);
	}
	/**向set添加100字符串*/
	public void test2(Set<String> set){
		for (int i = 0; i < 10; i++) {
			set.add(i+"");
		}
		set.add(null);
	}
	/**
	 * 使用foreach迭代set
	 * @param set
	 */
	public void out1(Set set){
		for (Object obj : set) {
			System.out.println(obj);
//			set.add(""+10000);//错误，不能添加、删除数据
		}
	}
	/**
	 * 使用迭代器进行迭代
	 */
	public void out2(Set<String> set){
		//得到set的迭代器
		Iterator iterator=set.iterator();
		//进行迭代
		while(iterator.hasNext()){
			System.out.println(iterator.next());
//			set.add(500+"");//错误，不能添加、删除数据
		}
	}
}
