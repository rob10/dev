package test;


public class MyBTree {

	private Node root;
	
	public void add(String a) {
		if (empty()) {
			root = new Node();
			root.setData(a);
		} else {
			adder(root, a);
		}
	}
	
	private void adder(Node n, String a) {
		if (a.compareToIgnoreCase(n.getData()) < 0) {
			if (n.getLchild() == null) {
				//insert this string here
				Node newNode = new Node();
				newNode.setData(a);
				n.setLchild(newNode);
			} else {
				adder(n.getLchild(), a);
			}
		} else {
			if (n.getRchild() == null) {
				// Insert this string here
				Node newNode = new Node();
				newNode.setData(a);
				n.setRchild(newNode);
			} else {
				adder(n.getRchild(), a);
			}
		}
	}
	
	public void printTree() {
		System.out.println("Pre-Order Traversal");
		preOrder(root, 0);
		System.out.println("In-Order Traversal");
		inOrder(root, 0);
		System.out.println("Post-Order Traversal");
		postOrder(root, 0);
	}
	
	public void preOrder(Node root, int level) {
		if (root == null) {
			return;
		}
		System.out.println(root.getData() + " (" + level + ")" );
		preOrder(root.getLchild(), level+1);
		preOrder(root.getRchild(), level+1);
	}
	
	public void inOrder(Node root, int level) {
		if (root == null) {
			return;
		}
		inOrder(root.getLchild(), level+1);
		System.out.println(root.getData() + " (" + level + ")" );
		inOrder(root.getRchild(), level+1);
	}
	
	public void postOrder(Node root, int level) {
		if (root == null) {
			return;
		}
		postOrder(root.getLchild(), level+1);
		postOrder(root.getRchild(), level+1);
		System.out.println(root.getData() + " (" + level + ")" );
	}
	
	public boolean empty() {
		return root == null;
	}
	
	private String grd(Node root) {
		if (root.getRchild() == null) {
			return root.getData();
		}
		
		return grd(root.getRchild());
	}
	
	public String getRightmostData() {
		return grd(root);
	}

	private String gld(Node root) {
		if (root.getLchild() == null) {
			return root.getData();
		}
		
		return gld(root.getLchild());
	}
	
	public String getLeftmostData() {
		return gld(root);
	}
	
}
