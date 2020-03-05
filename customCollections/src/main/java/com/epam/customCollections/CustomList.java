package com.epam.customCollections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomList {
	//private static final Logger LOGGER= LogManager.getLogger(CustomList.class);
	Node head;
	Node tail;
	public CustomList()
	{
		head=tail=null;
	}
	public void add(String newItem)
	{
		Node n=new Node(newItem);
		if(head==null)
		{
			head=tail=n;
		}
		else
		{
			tail.next=n;
			tail=n;
		}
	}
	public boolean fetch(String key)
	{
		Node temp=head;
		while(temp!=null)
		{
			if(temp.data.equals(key))
				return true;
			temp=temp.next;
		}
		return false;
	}
	public void remove(String key)
	{
		Node currentNode=head,nextNode=head;
		if(head!=null)
		{
			if(head.data.equals(key))
			{
				if(head.next==null)
					head=tail=null;
				else
					head=head.next;
			}
			else
			{
				while(nextNode!=null)
				{
					currentNode=nextNode;
					nextNode=nextNode.next;
					if(nextNode.data.equals(key))
					{
						break;
					}
				}
				if(nextNode.data.equals(key))
				{
					if(nextNode!=tail)
						currentNode.next=nextNode.next;
					else
					{
						currentNode.next=null;
						tail=currentNode;
					}
				}
			}
		}
	}
	public void printList()
	{
		Node currentNode=head;
		while(currentNode!=null)
		{
			System.out.print(currentNode.data+" ");
			currentNode=currentNode.next;
		}
	}
}
