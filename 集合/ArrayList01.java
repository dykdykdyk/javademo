package com.rsz.����;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ���ϣ�����-����
 * 		����-��̬����
 * 		�����ݽ��бȽϷ���Ĳ���-�����ݵ�����ɾ���ġ���		
 * @author EDUASK
 *
 */
public class ArrayList01 {
	public static void main(String[] args) {
		ArrayList<Integer> strList=new ArrayList<Integer>();
//		strList.clear();
		init(strList);
		strList.remove(0);//�����±�ɾ��Ԫ��
		strList.remove(new Integer(3));//����Ԫ�ص�ֵɾ��Ԫ��
		strList.set(1, 1000);
//		out1(strList);
//		strList.remove(100);
		strList.remove(new Integer(10000));
		strList.set(4, 1000);
//		out1(strList);
//		out2(strList);
//		out3(strList);
		test1();
		
	}
	/**
	 * �����������϶���ʱ�����͵�Ҫ��
	 * ���������������ʱ��-���Ϳ��ԣ����߶��С����߶�û�С�����һ����
	 */
	public static void test1(){
		ArrayList<String> arrayList=new ArrayList();
		arrayList.add("1234567890");
		arrayList.add("35");
		for (Object object : arrayList) {
			if(object instanceof java.lang.String)
				System.out.println(object);
		}
	}
	/**�Լ��Ͻ��г�ʼ��*/
	public static void init(ArrayList<Integer> arrayList){
		for (int i = 0; i <10; i++) {
			arrayList.add(i);
		}
	}
	/**
	 * �����for--�±���б���
	 * @param arrayList
	 */
	public static void out1(ArrayList<Integer> arrayList){
		for (int i = 0; i < arrayList.size(); i++) {//size()---�õ����ݵĸ���
			int k=arrayList.get(i);
			System.out.println(k);
		}
	}
	/**
	 * �����for-foreach
	 * 		һ�㲻Ҫ��arraylist���Ƚ��иı�
	 */
	public static void out2(ArrayList<Integer> arraylist){
		for (Integer integer : arraylist) {
//			arraylist.clear();
//			arraylist.add(3);
//			arraylist.remove(2);
//			arraylist.set(1, -1);//�޸Ŀ��ԣ���ѯ����
			System.out.println(integer);
			
		}
		System.out.println("--------------------------------");
		for (Integer integer : arraylist) {
//			arraylist.clear();
			arraylist.set(0, -1);
			System.out.println(integer);
			
		}
	}
	
	/**
	 * ʹ�õ������������ݵĵ���
		 * ͨ������iterator�õ�������
		 * Ȼ��ͨ�����������е���
	 */
	public static void out3(ArrayList<Integer> arrayList){
		//�õ�������
		Iterator<Integer> iterator=arrayList.iterator();
		while(iterator.hasNext()){
			Integer integer=iterator.next();
			System.out.println(integer);
		}
	}
}



















