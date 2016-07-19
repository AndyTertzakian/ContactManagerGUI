package broker;

/*
 * Author: Andre Tertzakian
 * September, 2014
 */

import java.util.Vector;

public interface Broker {

	public Vector<String> getAllContacts() throws Exception;

	public boolean saveContacts(Vector<String> listData) throws Exception;
}
