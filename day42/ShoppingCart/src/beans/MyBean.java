package beans;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class MyBean {
	private ArrayList<String> v = new ArrayList<String>();
	private String submit = null;
	String item = null;

	private void addItem(String name) {
		v.add(name);
	}

	private void removeItem(String name) {
		v.remove(name);
	}

	private void reset() {
		submit = null;
		item = null;
	}

	public String[] getItems() {
		String[] temp = null;
		temp = new String[v.size()];
		for(int i = 0; i < temp.length; i++) {
			temp[i] = v.get(i);
		}
		return temp;
	}

	public void processRequest(HttpServletRequest request) {
		// null value for submit - user hits enter instead of clicking on
		// "add" or "remove"
		if(submit == null) addItem(item);
		if(submit.equals("add")) addItem(item);
		if(submit.equals("remove")) removeItem(item);

		// reset at the end of request
		reset();
	}

	public void setItem(String item) {
		this.item = item;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}
}
