package com.netcracker.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yopa0716 on 6/1/2017.
 */

public class Contact {
	
	private int contactId;
	private String contactName;
	private ContactMethod contactMethod;


	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public ContactMethod getContactMethod() {
		return contactMethod;
	}

	public void setContactMethod(ContactMethod contactMethod) {
		this.contactMethod = contactMethod;
	}
}
