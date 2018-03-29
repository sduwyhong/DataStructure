package graph.exception;

public class NodeNotFoundException extends Exception {

	public NodeNotFoundException(){
		super();
	}
	
	public NodeNotFoundException(String message){
		super(message);
	}
}
