import java.net.*;
import java.io.*;
public class TCPClient
{
	public static void main( String args[]) throws Exception
	{
		
		Socket cs=null;
		BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
		if(kb.readLine().equalsIgnoreCase("connect")) {
			cs = new Socket("192.168.1.2",8080);
		}
		else {
			
			System.out.println("To initialize a connection with the server type 'connect'");
			System.exit(0);
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(cs.getInputStream()));
		DataOutputStream dos = new DataOutputStream(cs.getOutputStream());
		System.out.println(" if client wants to quit type  exit");
		System.out.println(" Enter text..");
		String s1,s4=null; 
		while(!(s1=kb.readLine()).equals("exit"))
		{
			dos.writeBytes(s1+"\n");
			s4 = br.readLine();
			System.out.println("Server said : "+s4);
			System.out.println("Enter text ");
		
		}
		System.out.println("Terminated..");
		cs.close(); 
		dos.close();
		kb.close();
	}
}