import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class MyThread extends Thread
{
	private Socket clientSocket;
	private PrintStream writer;
	private Scanner reader;
	
	public MyThread(Socket clientSocket) throws Exception
	{
		this.clientSocket = clientSocket;
		InputStream input = this.clientSocket.getInputStream();
		OutputStream output = this.clientSocket.getOutputStream();
		writer = new PrintStream(output, true);
		this.reader = new Scanner(input);
	}
	
	public void run()
	{
		String input = this.reader.nextLine();
		System.out.println(input);
		FileStringBuilder fsb = new FileStringBuilder("index.html");
		this.writer.println("HTTP/1.1 200 OK");
		this.writer.println("Content-Type: text/html;");
		String s = "Date: Sat, 14 Dec 2019 22:21:05 GMT\n" + 
				"Expires: -1\n" + 
				"Cache-Control: private, max-age=0\n" + 
				"Content-Type: text/html; charset=ISO-8859-1\n" + 
				"P3P: CP=\"This is not a P3P policy! See g.co/p3phelp for more info.\"\n" + 
				"Server: gws\n" + 
				"X-XSS-Protection: 0\n" + 
				"X-Frame-Options: SAMEORIGIN\n" + 
				"Set-Cookie: 1P_JAR=2019-12-14-22; expires=Mon, 13-Jan-2020 22:21:05 GMT; path=/; domain=.google.com\n" + 
				"Set-Cookie: NID=193=id3MFNxAfAOpm-bGk1n-myco1abW9vcz-J1SVxureBuRWu5h2GYxXLS6GftzmxJg-B18OZQth6E-EmBjb4qYu_FDxifSkFXUngmlSEWthbVpUbbiFTqy0dcIJLdxDAxAJVFLtaBqmkdpDtddLtnCzL-OREkuSmzCK8OdxM0TmQg; expires=Sun, 14-Jun-2020 22:21:05 GMT; path=/; domain=.google.com; HttpOnly\n" + 
				"Accept-Ranges: none\n" + 
				"Vary: Accept-Encoding";
		this.writer.println(s);
		this.writer.println(fsb.getFileString());
		this.writer.flush();
	}
}
