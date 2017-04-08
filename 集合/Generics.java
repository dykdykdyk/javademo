package com.rsz.����;

import java.util.ArrayList;
import java.util.List;

/**
 *  Generics:����
 *  		��֤�����ݵİ�ȫ��
 *  		���Զ����ݽ�������ɾ���ġ���
 *  			new int[100];
 *  			new int[10]
 * @author EDUASK
 *
 */
public class Generics {
	public static void main(String[] args) {
		List list=new ArrayList();
		list.add("");
		list.add(2);
		byte[] btArray=new byte[10];
		Generics[] gArray=new Generics[10];
		gArray[0]=new Generics();//�������д��һ�����󣬶����������ͣ�Generics
		List<String> list1=new ArrayList<String>();
		list1.add("asdf");
		List<Integer> list2=new ArrayList<Integer>();
		list2.add(new Integer(1));
		test1();
	}
	static void test1(){
		GTest1<String,Integer> gt=new GTest1<String,Integer>();
		gt.test1("asdf");
		gt.test2(2);
		gt.test3(new Generics());
		System.out.println(gt.size());
		gt.add("1");
		gt.add("1");
		gt.add("1");
		System.out.println(gt.size());
	}
}
class GTest1<K,L>{
	Object[] obj=new Object[10];
	/**������ʵ����Ч������*/
	int counts=0;
	public void test1(K k){
		System.out.println(k.getClass());//�õ�����Class
	}
	public void test2(L l){
		System.out.println(l);
	}
	public <E extends Generics> void test3(E e){
		System.out.println(e.getClass());
	}
	/**�������������*/
	public void add(K k){
		obj[counts++]=k;
	}
	/**�����е����ݸ�����*/
	public int size(){
		return counts;
	}
}




interface AAAA{}
interface BBBB extends AAAA{}