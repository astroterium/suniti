

import java.io.*;


class NMOTGenerator
{
	static int count=1;
	static FileWriter fw;
	
	NMOTGenerator(String fileName) throws Exception
	{
		
		fw= new FileWriter(new File(fileName));
		
	}
	
	
	static void addNode(Node node, String[] arr) throws Exception
	{
		
		fw.write("\ntag:"+node.tag);
		
		fw.write("\nID:"+count);
		
		for(int i=1; i<arr.length; i++)
		{
			
			String pair= arr[i];		//pair represents the key values pair of properties
			String[] array= pair.split("=");
			String key= array[0].trim();
			String value= array[1].trim();
			
			fw.write("\n"+key+":"+value);
			
		}
		
		fw.write("\n");
		count++;
	}
	
	
}
		
		
		
		
		
