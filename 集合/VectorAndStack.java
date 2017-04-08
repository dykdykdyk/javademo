package com.rsz.集合;

import java.util.Stack;

/**
 * Vector-Vector 是同步的。效率低
 * 
 * Stack
 *	后进先出
 *	先进后出
 *	后出先进
 *	先出后进
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
		System.out.println(stack.empty());//测试栈是否为空
//		System.out.println(stack.peek());//如果栈是空的，不能peek（）
		stack.push(1);//压栈
		stack.push(2);//压栈
		stack.push(3);//压栈
		stack.push(4);//压栈
		System.out.println(stack.peek());//此时，4在栈顶
		Integer i=stack.pop();
		System.out.println(i);
		System.out.println(stack.peek());//此时，3在栈顶
		//返回所找对象在栈中的位置
		int distance=stack.search(100);
		System.out.println(distance);
		
	}
	/**弹出栈中所有数据*/
	public void popAll(Stack stack){
		while(!stack.empty()){
			System.out.println(stack.pop());
		}
	}
}
