import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Driver 
{
	public static void main(String[] args) throws Exception
	{
		//FileStringBuilder fsb = new FileStringBuilder("index.html");
		//System.out.println(fsb.getFileString());
		
		ServerSocket listenner = new ServerSocket(8080);
		while(true)
		{
			System.out.println("listenning");
			Socket s = listenner.accept();
			(new MyThread(s)).start();
		}
		
		
		/*
		try 
		{
			ServerSocket listenner = new ServerSocket(8080);
			System.out.println("listenning");

			Socket s = listenner.accept();
			System.out.println("connection accepted");
			
			InputStream input = s.getInputStream();
			OutputStream output = s.getOutputStream();
			
			PrintStream writer = new PrintStream(output);
			writer.println("Welcome!!!!");
			writer.flush();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
}
