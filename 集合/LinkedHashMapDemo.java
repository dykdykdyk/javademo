package com.rsz.����;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * LinkedHashMap:��ֵ������Ϊnull
 * 				  ��Ԥ֪�ĵ���˳��
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
	 * ������ʵ����
	 */
	public void test1(){
		LinkedHashMap map;//����
		map=new LinkedHashMap();//ʵ����
		LinkedHashMap<Integer, String> map1=new LinkedHashMap<Integer, String>();
		Map map2=new LinkedHashMap();//LinkedHashMap��Map��ʵ���࣬��������ת�ͳ�Map
		HashMap map3=new LinkedHashMap();//HashMap��LinkedHashMap�ĸ���
	}
	/***
	 * ��map���г�ʼ��
	 * @param map
	 */
	public void init(Map map){
		for (int i = 0; i < 100; i++) {
			map.put(i, i*i);
		}
	}
	/**
	 * ����map
	 * ��������foreach���޸�map�ṹ��
	 * �����޸�value��ʵʱ��
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
