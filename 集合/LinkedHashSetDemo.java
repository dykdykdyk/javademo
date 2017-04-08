package com.rsz.集合;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * LinkedHashSet-1、增加、删除稍快
 * 				 2、输出顺序=添加顺序
 * 				 3、此实现不是同步的--线程再讲
 */
public class LinkedHashSetDemo {
	public static void main(String[] args) {
		LinkedHashSetDemo demo=new LinkedHashSetDemo();
		Set<Integer> set=new LinkedHashSet<Integer>();
		demo.init(set);
		demo.out(set);
	}
	/**添加*/
	public void init(Set<Integer> set){
		for (int i = 100; i >=0; i--) {
			set.add(i);
		}
		/*
		//因为原来有0-100，所以再添加一遍，set顺序不变
		for (int i = 100; i >=0; i--) {
			set.add(i);
		}*/
	}
	/**删除*/
	public void remove(Set<Integer> set,Integer i){
		set.remove(i);
	}
	/**修改-NO Set  Method*/
	/**遍历*/
	public void outEveryOne1(Set<Integer> set){
		for (Integer integer : set) {
			if(integer>100){
				System.out.println("没啥，晚上吃饭。不约，谢谢~、");
			}
		}
	}
	/**输出每一个数据-测试输出顺序是否是插入顺序*/
	public void out(Set<Integer> set){
		for (Integer integer : set) {
			System.out.println(integer);
		}
	}
	/**查询-某个对象是否存在*/
	public void isContains(Set<Integer> set,Integer i){
		System.out.println(set.contains(i));
	}
	
}
