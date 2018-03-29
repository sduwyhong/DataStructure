package stackDomain;

import java.util.ArrayList;
import java.util.List;

public class MyStack {

	private List<Object> objs;
	private int size;
	private boolean isEmpty = true;
	
	public MyStack(){
		this.objs = new ArrayList<Object>();
	}
	
	public int getSize() {
		return size;
	}
	public boolean isEmpty() {
		return isEmpty;
	}
	//进栈
	public void put(Object obj){
		objs.add(obj);
		this.size = objs.size();
		isEmpty = false;
	}
	//出栈
	public Object get(){
		if(objs.size()>0){
			this.size = objs.size()-1;
			return objs.remove(objs.size()-1);
		}else{
			isEmpty = true;
			System.out.println("the stack is empty!");
			return null;
		}
	}
	//全部清空
	public Object[] getAll(){
		Object[] objs = new Object[this.size];
		for(int i=0;i<objs.length;i++){
			objs[i] = this.get();
		}
		return objs;
	}
}
