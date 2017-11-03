package controllers;

import java.io.File;
import java.util.Collection;

import models.Movie;
import models.Rating;
import models.User;
import utils.Serializer;
import utils.XMLSerializer;
import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellFactory;

public class Main 
{
	
	public static void main(String [] args) throws Exception
	{
		
			File datastore = new File("datastore.xml");
			Serializer serializer = new XMLSerializer(datastore);
			
			OdysseyAPI Odyssey = new OdysseyAPI(serializer);
		
			if(datastore.isFile())
			{
				Odyssey.load();
			}else {
				Odyssey.prime();
			}
			
			Odyssey.store();
			
			Movie result = OdysseyAPI.getMovie(Long.valueOf(2));
	        
	        System.out.println(result);
	        
	}
}
