package queueDoamin;

import java.util.ArrayList;
import java.util.List;

public class MyQueue {

	private List<Object> objs;
	private int length;
	private boolean isEmpty = true;
	public MyQueue(){
		objs = new ArrayList<Object>();
	}
	public int getLength() {
		return length;
	}
	public boolean isEmpty() {
		return isEmpty;
	}
	//进队列
	public void put(Object obj){
		objs.add(obj);
		length++;
		isEmpty = false;
	}
	//出队列
	public Object get(){
		if(length>0){
			length--;
			return objs.remove(0);
		}else{
			isEmpty = true;
			System.out.println("the queue is empty!");
			return null;
		}
	}
	//全部清空
		public Object[] getAll(){
			Object[] objs = new Object[length];
			for(int i=0;i<objs.length;i++){
				objs[i] = this.get();
			}
			return objs;
		}
}
