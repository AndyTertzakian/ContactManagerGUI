package broker;

/*
 * Author: Andre Tertzakian
 * September, 2014
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class ContactManagerBroker implements Broker {

	public Vector<String> getAllContacts() throws IOException {
		Vector<String> contacts = new Vector<String>();
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("./res/contacts.txt");
			br = new BufferedReader(fr);

			String line = br.readLine();
			while (line != null) {
				contacts.add(line);
				line = br.readLine();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null && fr != null) {
				br.close();
				fr.close();
			}
		}
		return contacts;
	}

	public boolean saveContacts(Vector<String> listData) throws IOException {
		boolean result = false;
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter("./res/contacts.txt");
			bw = new BufferedWriter(fw);
			for (int i = 0; i < listData.size(); i++) {
				bw.write(listData.get(i) + "\n");
			}
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bw != null && fw != null) {
				bw.close();
				fw.close();
			}
		}

		return result;
	}

}
