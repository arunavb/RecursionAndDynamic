package binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSum 
{
	private BinarySearchTree thisTree;
	private Map<Integer,List<Pair>> tableOfTwo;	
	private class Pair
	{
		Node node1;
		Node node2;
		public Pair(Node node1,Node node2)
		{
			this.node1=node1;
			this.node2=node2;
		}
		public Node getNode1()
		{
			return this.node1;
		}
		public Node getNode2()
		{
			return this.node2;
		}
	}
	public FindSum(BinarySearchTree b)
	{
		this.thisTree=b;
	}
	public List<Node> returnNodes(int sum)
	{
		List<Node> returnList=new ArrayList<Node>();
		tableOfTwo=new HashMap<Integer,List<Pair>>();
		List<Node> inOrderList=thisTree.getInOrderNodes();
//		tableOfTwo=populateMap(tableOfTwo,inOrderList);
		for(int i:tableOfTwo.keySet())
		{
			
		}
		return returnList;
	}
//	private Map<Integer, List<Pair>> populateMap(Map<Integer,List<Pair>> map,List<Node> list) 
//	{
//		for(Node mainNode:list)
//		{
//			for(Node innerNode:list)
//			{
//				if(mainNode!=innerNode)
//				{
//					Pair thisPair=new Pair(mainNode,innerNode);
//					List<Pair> thisList=map.get((mainNode.getValue()+innerNode.getValue()));
//					if(thisList==null)
//					{
//						thisList=new ArrayList<Pair>();
//					}
//					thisList.add(thisPair);
//					map.put((mainNode.getValue()+innerNode.getValue()), thisList);
//				}
//			}
//		}
//		return map;
//	}
	public void displayNodes()
	{
		for(int i:tableOfTwo.keySet())
		{
			System.out.println(i+":  ");
			for(Pair p:tableOfTwo.get(i))
			{
				System.out.println(p.getNode1()+"   "+p.getNode2());
			}
		}
	}
}

