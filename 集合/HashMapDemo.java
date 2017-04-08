package com.rsz.����;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Map:��-ֵ		��
 * 	   key	value
 * HashMap��1��������ʹ�� null ֵ�� null ��
 * 			2�����಻��֤ӳ���˳���ر���������֤��˳���ò���
 * 			3����ʵ�ֲ���ͬ����
 * 		���ܸ���values���ж�key�Ƿ����
 * 		ֵ�����ظ������������ظ�
 * 		����ֵ����Ϊnull
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
	/**��map���г�ʼ��*/
	private void init1(Map<Integer,String> map) {
		for (int i = 0; i < 30; i++) {
			map.put(i, "name"+i);
		}
	}
	/**1��entrySet() �õ�ÿһ����ֵ�Եļ���*/
	public void out1(Map<Integer,String> map){
		Set<Entry<Integer, String>> set=map.entrySet();//mapת����set
		Iterator<Entry<Integer,String>> iterator=set.iterator();
		while (iterator.hasNext()) {
			/**entry������	һ��	��ֵ��*/
			 Entry<Integer, String> entry=iterator.next();
			 Integer key=entry.getKey();
			 String value=entry.getValue();
//			 System.out.println("key:"+key+",value:"+value);
			 System.out.println(entry);
		}
	}
	
	/**2��keySet() �õ����м��ļ���*/
	public void out2(Map<Integer,String> map){
		/**���ļ���*/
		 Set<Integer> set=map.keySet();
		 Iterator iterator=set.iterator();
		 while(iterator.hasNext()){
			 Object key= iterator.next();
			 String value=map.get(key);
			 System.out.println("key:"+key+",value:"+value);
		 }
 	}
	/**3��values() �õ�����ֵ�ļ���Collection*/
	public void out3(Map<Integer,String> map){
		Collection<String> c=map.values();
		//3��
//		c.toArray();//1��ͨ������������
		for (String string : c) {//2��foreach����
			System.out.println(string);
		}
//		c.iterator();//3��ͨ��iterator
	}
	
	/**
	 * �����ݵ�����ɾ���ġ���
	 * @param map
	 */
	public void test2(Map<Integer,String> map){
//		put/get
		map.put(1, "�Ÿ���");
		map.put(2, "������");
		map.put(3, "������");
//		1-name	2-sex	3-id	4-sex
		//�޸�
		map.put(2, null);
		System.out.println(map.get(2));
		map.remove(3);
		System.out.println(map.get(4));
		//ֵ�ܷ��ظ���
		map.put(4, "��ǹ");
		map.put(5, "��ǹ");
		System.out.println(map.get(4));
		System.out.println(map.get(5));
		//������Ϊ�գ�
		map.put(null, "����null");
		System.out.println(map.get(null));
		map.isEmpty();//�Ƿ�Ϊ��
		map.size();//�ж��ټ�ֵ��
		map.containsKey(1);//�Ƿ�������key
		map.containsValue("");///�Ƿ�������value
	}
	/**
	 * ����ֵ��
	 */
	public void test1(){
		HashMap<String, String> map=new HashMap<String, String>();
		//��map��������
		map.put("name", "С��");
		map.put("�Ա�", "��");
		map.put("����", "�Ҹ�");
		//ȡ��ֵ������key��
		String str1=map.get("����");
		System.out.println(str1);
	}
}
