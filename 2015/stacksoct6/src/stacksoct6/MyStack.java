package stacksoct6;

public interface MyStack {

	boolean push(String data);

	String pop();

	boolean stackFull();

	boolean stackEmpty();

	void clear();

	String stackTop();

	int stackDepth();

}