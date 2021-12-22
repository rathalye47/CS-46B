package recursion_techniques;

import java.io.File;

public class Lister {
	private File file;
	private boolean showHidden;

	public Lister(File theFile, boolean isShowHidden)
	{
		file = theFile;
		showHidden = isShowHidden;
	}
	
	public void list()
	{
		listRecurse(file, "");
	}
	
	private void listRecurse(File file, String indent)
	{	
		if(!showHidden)
		{
			if(!file.getName().substring(0,1).equals("."))
			{
				if (file.isDirectory())
				{
					System.out.println(indent + file.getName() + ":");
					for (File theFile : file.listFiles())
						listRecurse(theFile, indent + "  ");
				}
				else
				{
					System.out.println(indent + file.getName());
				}
			}
		}
		else
		{
			if (file.isDirectory())
			{
				System.out.println(indent + file.getName() + ":");
				for (File theFile : file.listFiles())
					listRecurse(theFile, indent + "  ");
			}
			else
			{
				System.out.println(indent + file.getName());
			}
		}
	}
	
	public static void main(String[] args)
	{
		File dir = new File("C:\\Users\\ronro\\lab5Workspace");
		Lister list = new Lister(dir, true);
		list.list();
	}
}
