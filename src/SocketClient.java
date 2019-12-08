import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;


public class SocketClient 
{
	public static void main(String[] args)
	{
		try 
		{
			Socket s = new Socket("127.0.0.1", 8080);
			InputStream input = s.getInputStream();
			OutputStream output = s.getOutputStream();
			
			Scanner reader = new Scanner(input);
			System.out.println("Client Side: " + reader.nextLine());
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
