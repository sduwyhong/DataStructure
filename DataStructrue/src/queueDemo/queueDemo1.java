package queueDemo;

import java.util.PriorityQueue;
import java.util.Queue;

import queueDoamin.MyQueue;

public class queueDemo1 {
	public static void main(String[] args){
	
		MyQueue queue = new MyQueue();
		queue.put(1);
		queue.put(2);
		queue.put(3);
		queue.put(4);
		queue.put(5);
		for(int i=0;i<5;i++){
			System.out.println(queue.get());
		}
		//util中的优先队列实现类PriorityQueue
		Queue q = new PriorityQueue();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		for(int i=0;i<5;i++){
			System.out.println(q.poll());
		}
	}
}
