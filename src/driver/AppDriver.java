package driver;

/*
 * Author: Andre Tertzakian
 * September, 2014
 */

import java.io.IOException;

import view.ContactManagerGUI;

public class AppDriver {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws Exception {
		ContactManagerGUI manager = new ContactManagerGUI();
		manager.execute();
	}

}
