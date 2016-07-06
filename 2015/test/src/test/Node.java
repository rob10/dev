package test;


public class Node {
	private String data;
	private Node lchild;
	private Node rchild;
	
	public Node() {
		lchild = rchild = null;
		data = null;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	public Node getLchild() {
		return lchild;
	}
	public void setLchild(Node lchild) {
		this.lchild = lchild;
	}
	public Node getRchild() {
		return rchild;
	}
	public void setRchild(Node rchild) {
		this.rchild = rchild;
	}
	
	
}