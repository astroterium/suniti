
/*status codes:
0: null state
1: opening tag
2: tag contents
3: closing tag
*/


import java.io.*;

class Parser
{
	static FileReader fr;
	static NMOTGenerator generator;
	static int status;
	static Node current, parent;
	
	
	Parser(String fileName) throws Exception
	{
		fr= new FileReader(new File(fileName+".html"));
		System.out.println(fileName+".html");
		generator= new NMOTGenerator(fileName+".nmot");
		status=0;
		
		current=null;
		parent=null;
		
		parse();
		
	}
	
	
	void parse() throws Exception
	{
		int ch=' ';
		
		while((ch= fr.read())!= -1)
		{
			System.out.println((char)ch);
			if(ch=='<')
				readTag();
			else
			{
				String token="";
				while(((ch= fr.read())!= -1) && (ch!='<'))
					token+=(char) ch;
				
				generator.fw.write("text:"+token);
			}
				
		}
		
		fr.close();
		generator.fw.close();
	}
	
	
	static void readTag() throws Exception
	{
		int ch=' ';
		String token="";
		while(((ch= fr.read())!= -1) && (ch!='>'))
		{
			token+=(char) ch;
			System.out.println(token);
		}
		
		
		//split the token
		String[] arr= token.split(" ");
		System.out.println("split results: "+arr[0]+"\t");
		
		//check if tag is closing or opening
		if(arr[0].charAt(0) == '/')
		{
			status=3;
			processClosingTag();
		}
		else
		{
			status=2;
			processOpeningTag(arr);
		}
		System.out.println(status);
		
	}
			
	
	static void processClosingTag() throws Exception
	{
		
		current= parent;
		parent= parent.parent;
	}
	
	
	static void processOpeningTag(String[] arr) throws Exception
	{
		
		parent=current;
		current= new Node(parent, arr[0]);
		generator.addNode(current, arr);
	}		
}
