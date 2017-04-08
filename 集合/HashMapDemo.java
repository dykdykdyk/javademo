package com.rsz.集合;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Map:键-值		对
 * 	   key	value
 * HashMap：1、并允许使用 null 值和 null 键
 * 			2、此类不保证映射的顺序，特别是它不保证该顺序恒久不变
 * 			3、此实现不是同步的
 * 		不能根据values来判断key是否存在
 * 		值可以重复、键不可以重复
 * 		键、值均可为null
 * @author EDUASK
 *
 */
public class HashMapDemo {
	public static void main(String[] args) {
		HashMapDemo demo=new HashMapDemo();
		
		Map<Integer,String> map=new HashMap<Integer,String>();
//		demo.test2(map);
		demo.init1(map);
		demo.out1(map);
		System.out.println("over");
	}
	/**对map进行初始化*/
	private void init1(Map<Integer,String> map) {
		for (int i = 0; i < 30; i++) {
			map.put(i, "name"+i);
		}
	}
	/**1、entrySet() 得到每一个键值对的集合*/
	public void out1(Map<Integer,String> map){
		Set<Entry<Integer, String>> set=map.entrySet();//map转换成set
		Iterator<Entry<Integer,String>> iterator=set.iterator();
		while (iterator.hasNext()) {
			/**entry本身是	一对	键值对*/
			 Entry<Integer, String> entry=iterator.next();
			 Integer key=entry.getKey();
			 String value=entry.getValue();
//			 System.out.println("key:"+key+",value:"+value);
			 System.out.println(entry);
		}
	}
	
	/**2、keySet() 得到所有键的集合*/
	public void out2(Map<Integer,String> map){
		/**键的集合*/
		 Set<Integer> set=map.keySet();
		 Iterator iterator=set.iterator();
		 while(iterator.hasNext()){
			 Object key= iterator.next();
			 String value=map.get(key);
			 System.out.println("key:"+key+",value:"+value);
		 }
 	}
	/**3、values() 得到所有值的集合Collection*/
	public void out3(Map<Integer,String> map){
		Collection<String> c=map.values();
		//3种
//		c.toArray();//1、通过数组来遍历
		for (String string : c) {//2、foreach遍历
			System.out.println(string);
		}
//		c.iterator();//3、通过iterator
	}
	
	/**
	 * 对数据的增、删、改、查
	 * @param map
	 */
	public void test2(Map<Integer,String> map){
//		put/get
		map.put(1, "撑杆跳");
		map.put(2, "自助跳");
		map.put(3, "三级跳");
//		1-name	2-sex	3-id	4-sex
		//修改
		map.put(2, null);
		System.out.println(map.get(2));
		map.remove(3);
		System.out.println(map.get(4));
		//值能否重复？
		map.put(4, "打枪");
		map.put(5, "打枪");
		System.out.println(map.get(4));
		System.out.println(map.get(5));
		//键可以为空？
		map.put(null, "这是null");
		System.out.println(map.get(null));
		map.isEmpty();//是否为空
		map.size();//有多少键值对
		map.containsKey(1);//是否包含这个key
		map.containsValue("");///是否包含这个value
	}
	/**
	 * 理解键值对
	 */
	public void test1(){
		HashMap<String, String> map=new HashMap<String, String>();
		//向map放入数据
		map.put("name", "小黄");
		map.put("性别", "男");
		map.put("婚姻", "幸福");
		//取出值（根据key）
		String str1=map.get("婚姻");
		System.out.println(str1);
	}
}
