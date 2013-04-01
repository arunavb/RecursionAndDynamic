package binaryTreeStruct;

public class TestPredAndSucc 
{
	public static void main(String args[])
	{
		BinaryTree<Integer> bt=new BinaryTree();
		bt.insert(7);
		bt.insert(9);
		bt.insert(1);
		bt.insert(5);
		bt.insert(2);
		bt.insert(8);
		bt.insert(12);
		bt.insert(13);
		bt.insert(17);
		bt.insert(29);
		bt.insert(37);
		bt.insert(3);
		bt.insert(4);
		bt.insert(11);
		PredAndSucc ps=new PredAndSucc(bt);
		ps.getLinkList();
		
	}
}
