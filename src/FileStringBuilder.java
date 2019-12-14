import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileStringBuilder 
{
	private String filename;
	private String fileString;
	
	public FileStringBuilder(String filename)
	{
		this.filename = filename;
		this.fileString = "";
		try 
		{
			FileReader fr = new FileReader(this.filename);
			int ch;
			while((ch = fr.read()) != -1)
			{
				this.fileString += (char)ch;
			}
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getFileString() {
		return fileString;
	}
	
	
}
