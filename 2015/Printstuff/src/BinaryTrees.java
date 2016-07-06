
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Driver me = new Driver();
		me.doIt();

	}
	
	void doIt()
	{
		//initialize binary tree
		BinaryTree bt =  new BinaryTree();
		//used to keep count of how many words are in file
		int totalWords = 0;
		
		//try catch block for opening the file
		try{
			//read the file
			FileReader fr = new FileReader("345.txt");
			BufferedReader br = new BufferedReader(fr);
			//string where file text is stored
			String str;
			
			//while loop to read through the whole file
			while((str = br.readLine())!=null)
			{
				//set everything to lower case
				str = str.toLowerCase();
				//remove punctuation and symbols
				str = str.replaceAll("[^a-z0-9 ]", "");
				//remove all white spaces
				str = str.trim();
				
				//this if statement is used to make sure no empty lines get read as words
				if(str.length()>0)
				{
					//split the line that was read into an array of 
					//words
					String[] words = str.split("\\s+");
					//add each word in array to binry tree
					for(int i = 0; i<words.length; i++)
					{
						//keep count of how many words are being added
						totalWords++;
						bt.add(words[i]);
					}
					//System.out.println(str);
				}
					
			}
			br.close();
		}
		catch(IOException e){
			System.out.println("file not found");
		}
		
		//print total words
		System.out.println("Text contains " + totalWords + " Total words.");
		//call the method that provides how many times the give word appears
		//and print the returned result
		System.out.println("Transylvania occurs: " + bt.occurence("transylvania") + " times");
		System.out.println("Harker occurs: " + bt.occurence("harker") + " times");
		System.out.println("Renfield occurs: " + bt.occurence("renfield") + " times");
		System.out.println("Vampire occurs: " + bt.occurence("vampire") + " times");
		System.out.println("Expostulate occurs: " + bt.occurence("expostulate") + " times");
		
		//call this method so that every node in binary tree is visited and to be able to get the following
		//info
		bt.deep();
		//call getter methods and display info
		System.out.println("Tree is : " + bt.getDeepestLevel() + " nodes deep");
		System.out.println("Tree contains : " + bt.getCount() + " distinct words");
		System.out.println("Word at root is: " + bt.getRoot());
		System.out.println("Deepest Word is : " + bt.getDeepest());
		System.out.println("Most Frequent is: '" + bt.getFrequent() + "' occurring " + bt.getFrequentCount() + " times");
		
		
		}

}

public class BinaryTrees {
	
private Node root;
private String deepest;
private int count;
private int deepestLevel;
private int frequentCount;
private String frequent;
	
	public void add(String a) {
		
		if (empty()) {
			root = new Node();
			root.setData(a);
			root.setCount(1);
		} else {
			adder(root, a);
		}
	}
	
	private void adder(Node n, String a) {
		
		//Check if the String data equals the data of the node
		//if it does then add to the counter for the node
		if(n.getData().equals(a))
		{
			n.setCount(n.getCount()+1);
			return;
		}
		else if (a.compareToIgnoreCase(n.getData()) < 0) {
			if (n.getLchild() == null) {
				//insert this string here
				Node newNode = new Node();
				newNode.setData(a);
				newNode.setCount(1);
				n.setLchild(newNode);
			} else {
				adder(n.getLchild(), a);
			}
		} else {
			if (n.getRchild() == null) {
				// Insert this string here
				Node newNode = new Node();
				newNode.setData(a);
				newNode.setCount(1);
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
		System.out.println(root.getData() + " (" + level + ")");
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
	
	//call recursive method to find the occurrence of the given word
	public int occurence(String a)
	{
		return getOccurence(root, a);
	}
	
	//start at root, check if the give word is less than greater then or equal
	//if less than then call method again passing the left child, if greater than
	//call method again passing the right child. if equal then get count of the node
	//and return it.
	private int getOccurence(Node n, String a)
	{
		if(n.getData().equals(a)){
			return n.getCount();
		}
		else if (a.compareToIgnoreCase(n.getData()) < 0) {
			
				return getOccurence(n.getLchild(), a);
			
		} else {
			
				return getOccurence(n.getRchild(), a);
		}
		
	}
	//call recursive method to go through all nodes in binary tree
	public void deep()
	{
		deepestNode(root, 0);
	}
    
	//this method goes through every node in the binary tree and gets specific data
	//to be displayed later. it has a counter that keeps count of every node in the
	//binary tree, which would give us the amount of distinct words. it has an if statement
	//that checks how deep the level that passed in is, if it is deeper than the current deepest
	//level then we set the new level as the deepest level and also set the String deepest to be the
	//data in that node. This will tell us what the deepest level is and what the deepest node is.
	//Finally we check to see if the count of the current node is greater than the current most frequent node
	//if it is then we set the new most frequent node to be the current node. This helps us get the most frequent
	//word and how many times it appears
	private void deepestNode(Node root, int level)
	{
		if (root == null) {
			return;
		}
		
		count++;
		if(deepestLevel < level)
		{
			deepestLevel = level;
			deepest = root.getData();
		}
		if(root.getCount() > frequentCount)
		{
			frequent = root.getData();
			frequentCount = root.getCount();
		}
		deepestNode(root.getLchild(), level+1);
		deepestNode(root.getRchild(), level+1);
	}
	
	//getter methods 
	public String getDeepest()
	{
		return deepest;
	}
	public int getDeepestLevel()
	{
		return deepestLevel;
	}
	public int getCount(){
		return count;
	}
	public String getFrequent()
	{
		return frequent;
	}
	public int getFrequentCount()
	{
		return frequentCount;
	}
	public String getRoot()
	{
		return root.getData();
	}
	
}

/*
 * Robert Gomez
 * 
 * 
 * 
 */
public class Node {
	private String data;
	private Node lchild;
	private Node rchild;
	//used to keep a count of how many times the word occurs
	private int count;
	
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
