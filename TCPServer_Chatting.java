import java.net.*;
import java.io.*;
public class TCPServer
{
	public static void main( String args[]) throws Exception
	{
		ServerSocket srs = new ServerSocket(8080);
		System.out.println("Server is running...");
		Socket ss=srs.accept();
		System.out.println("connection establised");
		BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(ss.getInputStream()));
		DataOutputStream dos = new DataOutputStream(ss.getOutputStream());
 
		while(true)
		{
			String s2,s3; 
			while((s2=br.readLine())!=null)
			{
				System.out.println("Client said : "+s2);
				System.out.println("Enter text ");
				s3 = kb.readLine();
				dos.writeBytes(s3+"\n");
			}
			System.out.println("Terminated..");
			ss.close(); 
			srs.close();
			dos.close();
			kb.close();
			System.exit(0);
		}
	}
}