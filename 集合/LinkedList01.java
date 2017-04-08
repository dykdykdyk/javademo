package com.rsz.����;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ���ϣ������ݽ��в���������ɾ���ġ���
 * 		����һ�£�LinekedList��ArrayList��Ч��
 * 					��index-0	index=size-1
 * 						�������ݣ�10w		
 * 						ɾ�����ݣ�10W/ɾ��
 * 					���
 * 						�������ݣ�10w		
 * 						ɾ�����ݣ�10W/ɾ��
 * 					
 * 		10s
 * 		5s
 * @author EDUASK
 *
 */
public class LinkedList01 {
	public static void main(String[] args) {
		long start=System.currentTimeMillis();
		LinkedList<Integer> linkedList=new LinkedList<Integer>();
		//ArrayList-List-Collection
		LinkedList<Integer> linkedList1=new LinkedList<Integer>(linkedList);
		//����ת��
		List<Integer> list=new LinkedList<Integer>();
		add(list);
//		out(list);
		
		testMethod(list);
		out(list);
		Object[] arr=list.toArray();
		test2();
		long end=System.currentTimeMillis();
		System.out.println(end-start);
	}
	public static void testMethod(List<Integer> list){
		LinkedList<Integer>integersList=new LinkedList<Integer>();
		integersList.addAll(list);
//		out(integersList);
		//5�롰5����һ��
//		System.out.println(integersList.contains(5));
//		int index=integersList.indexOf("5");
//		System.out.println(index);
		list.isEmpty() ;//���Ϊ�գ�����true
		list.remove(5);//���õ���remove��int index��
		list.remove(Integer.valueOf(5));//���õ���remove��Object object��
		/*�����л��У�1/2/3/5*/
		List<Integer> arrList=new LinkedList<Integer>();
		//���Ե�ʱ��С��
		arrList.add(1);
		arrList.add(2);
		list.removeAll(arrList);
	}
	public static void add(List list){
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("5");
		list.add(1, 5);
		list.add(4);
	}
	public static void remove(List list,int index){
		list.remove(index);
	}
	public static void set(List list,int index,Object element){
		list.set(index, element);
	}
	public static void out(List list){
		for (Object object : list) {
			System.out.println(object);
		}
	}
	public static void test2(){
		ArrayList<String> arrayList=new ArrayList<String>();
		initString(arrayList);
		delete(arrayList);
		out(arrayList);
	}
	//2  4  6 7 8 9 10
	public static void initString(ArrayList<String> arrayList){
		for (int i = 0; i < 10000000; i++) {
			arrayList.add(""+i);
		}
	}
	public static void delete(ArrayList<String> arrayList){
//		int length=arrayList.size();
//		for (int i = 0; i < length; i++) {
//			arrayList.remove(0);
//		}
		
		for (int i = arrayList.size()-1; i >=0 ; i--) {
			arrayList.remove(i);
		}
//		arrayList.clear();
	}
}
