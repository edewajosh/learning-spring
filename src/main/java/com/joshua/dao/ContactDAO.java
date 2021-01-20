/**
 * 
 */
package com.joshua.dao;

import java.util.List;

import com.joshua.model.Contact;

/**
 * @author Josh
 *
 */
public interface ContactDAO {
	public void saveOrUpdate(Contact contact);
	public void delete(int contactId);
	public Contact get(int contactId);
	public List<Contact> list();
}
