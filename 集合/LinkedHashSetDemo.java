package com.rsz.����;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * LinkedHashSet-1�����ӡ�ɾ���Կ�
 * 				 2�����˳��=���˳��
 * 				 3����ʵ�ֲ���ͬ����--�߳��ٽ�
 */
public class LinkedHashSetDemo {
	public static void main(String[] args) {
		LinkedHashSetDemo demo=new LinkedHashSetDemo();
		Set<Integer> set=new LinkedHashSet<Integer>();
		demo.init(set);
		demo.out(set);
	}
	/**���*/
	public void init(Set<Integer> set){
		for (int i = 100; i >=0; i--) {
			set.add(i);
		}
		/*
		//��Ϊԭ����0-100�����������һ�飬set˳�򲻱�
		for (int i = 100; i >=0; i--) {
			set.add(i);
		}*/
	}
	/**ɾ��*/
	public void remove(Set<Integer> set,Integer i){
		set.remove(i);
	}
	/**�޸�-NO Set  Method*/
	/**����*/
	public void outEveryOne1(Set<Integer> set){
		for (Integer integer : set) {
			if(integer>100){
				System.out.println("ûɶ�����ϳԷ�����Լ��лл~��");
			}
		}
	}
	/**���ÿһ������-�������˳���Ƿ��ǲ���˳��*/
	public void out(Set<Integer> set){
		for (Integer integer : set) {
			System.out.println(integer);
		}
	}
	/**��ѯ-ĳ�������Ƿ����*/
	public void isContains(Set<Integer> set,Integer i){
		System.out.println(set.contains(i));
	}
	
}
