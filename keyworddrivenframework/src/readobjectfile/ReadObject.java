package readobjectfile;

import java.io.*;
import java.io.InputStream;
import java.util.Properties;

public class ReadObject {
	Properties p = new Properties();
	public Properties getXYZ() throws IOException{
		  //Read object repository file
		  File f = new File(System.getProperty("user.dir")+"\\src\\objects\\objects.properties");
		  InputStream stream = new FileInputStream(f);
		  //load all objects
		   p.load(stream);
		   return p;
		 }
}
