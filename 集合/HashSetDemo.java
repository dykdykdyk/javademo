package com.rsz.����;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * set��list���ͬ��set���ܷ��ظ�������
 * 		�ص㣺1��������֤ set �ĵ���˳���ر���������֤��˳���ò��䡣
 * 			 2�����Է�null
 * 			 3��ʹ��iterator���е����������޸ĳ���,����foreach
 * 			 ������ʵ�ֲ���ͬ����--�߳�
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
	 * set�Ƿ�ֻ�ܷŲ��ظ�������
	 */
	public void test1(Set<String> set){
		
		set.add(10+"");
		set.add(10+"");
		set.add(10+"");
		set.add(null);
	}
	/**��set���100�ַ���*/
	public void test2(Set<String> set){
		for (int i = 0; i < 10; i++) {
			set.add(i+"");
		}
		set.add(null);
	}
	/**
	 * ʹ��foreach����set
	 * @param set
	 */
	public void out1(Set set){
		for (Object obj : set) {
			System.out.println(obj);
//			set.add(""+10000);//���󣬲�����ӡ�ɾ������
		}
	}
	/**
	 * ʹ�õ��������е���
	 */
	public void out2(Set<String> set){
		//�õ�set�ĵ�����
		Iterator iterator=set.iterator();
		//���е���
		while(iterator.hasNext()){
			System.out.println(iterator.next());
//			set.add(500+"");//���󣬲�����ӡ�ɾ������
		}
	}
}
