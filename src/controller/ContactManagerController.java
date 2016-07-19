package controller;

/*
 * Author: Andre Tertzakian
 * September, 2014
 */

import java.util.Vector;

import broker.Broker;
import broker.ContactManagerBroker;
import broker.ContactManagerDbBroker;

public class ContactManagerController {

	Broker broker;
	
	public void useFileDb() {
		broker = new ContactManagerBroker();
	}
	
	public void useMySql() {
		broker = new ContactManagerDbBroker();
	}
	
	public Vector<String> getAllContacts() throws Exception {
		return broker.getAllContacts();
	}

	public boolean saveList(Vector<String> listData) throws Exception {
		return broker.saveContacts(listData);
	}

}
