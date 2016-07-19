package broker;

/*
 * Author: Andre Tertzakian
 * September, 2014
 */

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import com.mysql.jdbc.Connection;

public class ContactManagerDbBroker implements Broker {

	Connection conn = new MySqlConnection().getConn();

	@Override
	public Vector<String> getAllContacts() throws Exception {
		Vector<String> list = new Vector<String>();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("Select Email from contacts.Contact_Table;");
		while (rs.next()) {
			String email = rs.getString("EMAIL");
			list.add(email);
		}
		return list;
	}

	@Override
	public boolean saveContacts(Vector<String> listData) throws Exception {
		throw new Exception("use ContactManagerUsingMySqlGUI project instead");
	}

}
