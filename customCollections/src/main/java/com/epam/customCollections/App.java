package com.epam.customCollections;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App 
{
	private static final Logger LOGGER= LogManager.getLogger(App.class);
    public static void main( String[] args)
    {
    	Scanner sc=new Scanner(System.in);
    	CustomList list=new CustomList();
    	LOGGER.info("Enter no of intial elements(Minimum 10 elements):");
    	int n=sc.nextInt();
    	String data;
    	if(n<10)
    	{
    		LOGGER.info("You should enter atleast 10 elements");
    	}
    	else
    	{
    		LOGGER.info("Enter elements:");
    		for(int i=0;i<n;i++)
    		{
    			data=sc.next();
    			list.add(data);
    		}
    		int choice;
    		LOGGER.info("");
    		String [] name= {"insert","delete","search"};
    		while(true)
    		{
    			LOGGER.info("1.Add\n2.Delete\n3.Fetch\n4.printList");
    			LOGGER.info("Enter an operation:");
    			choice=sc.nextInt();
    			if(choice<1 || choice>4)
    				LOGGER.info("Invalid choice");
    			else
    			{
    				if(choice==4)
    				{
    					list.printList();
    				}
    				else 
    				{
    					LOGGER.info("Enter element to "+name[choice-1]);
    					data=sc.next();
    					if(choice==1)
    						list.add(data);
    					else if(choice==2)
    						list.remove(data);
    					else
    					{
    						if(list.fetch(data))
    							LOGGER.info("Element found");
    						else
    							LOGGER.info("Element not found");
    					}		
    				}
    			}
    		}
    	}
    }
}
