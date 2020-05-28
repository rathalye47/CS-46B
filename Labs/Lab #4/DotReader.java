package dotlab;

import java.io.*;

import com.sun.jdi.connect.Connector.Argument;


public class DotReader 
{
	private BufferedReader br;
	
	public DotReader(BufferedReader br)
	{
		this.br = br;
	}
	
	public Dot readDot() throws DotException, IOException {
		String line = br.readLine();
		if (line == null) {
			return null;
		}
		
		String[] arguments = line.split(",");
		if(arguments.length != 4) {
			DotException de = new DotException("You need EXACTLY 4 arguments!");
			throw de;
		}
		
		String name = arguments[0].trim();
		int x = Integer.parseInt(arguments[1].trim());
		int y = Integer.parseInt(arguments[2].trim());
		int r = Integer.parseInt(arguments[3].trim());
		Dot newDot = new Dot(name, x, y, r);
		return newDot;
	}
	

}
