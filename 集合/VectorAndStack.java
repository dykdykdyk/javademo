package com.rsz.����;

import java.util.Stack;

/**
 * Vector-Vector ��ͬ���ġ�Ч�ʵ�
 * 
 * Stack
 *	����ȳ�
 *	�Ƚ����
 *	����Ƚ�
 *	�ȳ����
 */
public class VectorAndStack {
	public static void main(String[] args) {
		VectorAndStack andStack=new VectorAndStack();
		Stack<Integer> stack=new Stack<Integer>();
		stack.add(1);
		stack.add(2);
		stack.add(3);
		stack.remove(0);
		stack.set(0, 2);
		stack.get(1);
		andStack.testStack();
	}
	public void testStack(){

		Stack<Integer> stack=new Stack<Integer>();
		System.out.println(stack.empty());//����ջ�Ƿ�Ϊ��
//		System.out.println(stack.peek());//���ջ�ǿյģ�����peek����
		stack.push(1);//ѹջ
		stack.push(2);//ѹջ
		stack.push(3);//ѹջ
		stack.push(4);//ѹջ
		System.out.println(stack.peek());//��ʱ��4��ջ��
		Integer i=stack.pop();
		System.out.println(i);
		System.out.println(stack.peek());//��ʱ��3��ջ��
		//�������Ҷ�����ջ�е�λ��
		int distance=stack.search(100);
		System.out.println(distance);
		
	}
	/**����ջ����������*/
	public void popAll(Stack stack){
		while(!stack.empty()){
			System.out.println(stack.pop());
		}
	}
}
