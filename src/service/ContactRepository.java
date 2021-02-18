package service;

import config.CrudRepository;
import model.Contact;

public class ContactRepository extends CrudRepository<Contact> {

    private static ContactRepository contactRepository;

    private ContactRepository(){
    }

    public static ContactRepository getInstance(){
        if (contactRepository == null)
            contactRepository = new ContactRepository();
        return contactRepository;
    }

    @Override
    protected Class<Contact> getEntityClass() {
        return Contact.class;
    }
}



