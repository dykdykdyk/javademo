package com.rsz.集合;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * LinkedHashMap:键值都可以为null
 * 				  可预知的迭代顺序
 * 
 * @author EDUASK
 *
 */
public class LinkedHashMapDemo {
	public static void main(String[] args) {
		Map<Integer, Integer> map=new LinkedHashMap<Integer, Integer>();
		LinkedHashMapDemo demo=new LinkedHashMapDemo();
		map.put(null, null);
		demo.init(map);
		map.remove(1);
		map.put(1, 1000);
		demo.out(map);
		
		
	}
	/**
	 * 声明、实例化
	 */
	public void test1(){
		LinkedHashMap map;//声明
		map=new LinkedHashMap();//实例化
		LinkedHashMap<Integer, String> map1=new LinkedHashMap<Integer, String>();
		Map map2=new LinkedHashMap();//LinkedHashMap是Map的实现类，所以向上转型成Map
		HashMap map3=new LinkedHashMap();//HashMap是LinkedHashMap的父类
	}
	/***
	 * 对map进行初始化
	 * @param map
	 */
	public void init(Map map){
		for (int i = 0; i < 100; i++) {
			map.put(i, i*i);
		}
	}
	/**
	 * 遍历map
	 * 不可以在foreach中修改map结构，
	 * 可以修改value（实时）
	 * @param map
	 */
	public void out(Map map){
		Set<Map.Entry> set= map.entrySet();
		for (Map.Entry entry : set) {

//			map.put(entry.getKey(), "");
			System.out.println("key:"+entry.getKey()+",value:"+entry.getValue());
//			map.remove(entry.getKey());
		}
	}
}
