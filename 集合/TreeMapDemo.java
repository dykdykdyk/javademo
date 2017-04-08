package com.rsz.集合;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * TreeMap：树
 * 			1、可以排序：在构造器中可以放入Comparetor的对象
 * 			2、此实现不是同步的
 * 			3、一般key不要放null
 * @data 2015-8-17
 * @author EDUASK
 *
 */
public class TreeMapDemo {
	public static void main(String[] args) {
		TreeMapDemo demo=new TreeMapDemo();
		demo.testPutNull();
		Map<PersonQ,ContryInfo> map=new TreeMap<PersonQ,ContryInfo>();
		for (int i = 0; i < 1000; i++) {
			map.put(new PersonQ(i, "花花"), new ContryInfo("中国"));
		}
		demo.out(map);
//		PersonQ personQ=null;
//		personQ.compareTo(null);
	}
	public void testPutNull(){
		Map<Integer,Integer> map=new TreeMap<Integer,Integer>();
		map.put(1, 1);
		map.put(2, null);
		map.put(3, null);
//		map.put(null, 34);
		
		out(map);
	}
	public void out(Map map){
		Set<Map.Entry> set=map.entrySet();
		for (Map.Entry entry : set) {
			System.out.println("key:"+entry.getKey()+",value:"+entry.getValue());
		}
	}
	
}
/**个人信息*/
class PersonQ implements Comparable<PersonQ>{
	private int id;
	private String name;
	public PersonQ(int id, String name) {
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	@Override
	public int compareTo(PersonQ o) {
		if(null==o){
			return -1;
		}
		if(id>o.id){
			return 1;
		}else if(id<o.id){
			return -1;
		}
		return 0;
	}
	
}
/**国家信息*/
class ContryInfo{
	String name;

	public ContryInfo(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "ContryInfo [name=" + name + "]";
	}
	
}
