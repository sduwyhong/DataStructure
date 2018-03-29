package stackDemo;

import java.io.File;

import java.util.Stack;

import stackDomain.MyStack;

public class stackDemo1 {
	public static void main(String[] args){
		MyStack stack = new MyStack();
		stack.put(1);
		stack.put(2);
		stack.put(3);
		stack.put(4);
		stack.put(5);
		System.out.println("size"+stack.getSize());
		Object[] objs = stack.getAll();
		for(Object obj:objs){
			System.out.println((Integer)obj);
		}
		
		Stack s = new Stack();
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		s.add(5);
		for(int i=0;i<5;i++){
			System.out.println(s.pop());
		}
		
	}
}
