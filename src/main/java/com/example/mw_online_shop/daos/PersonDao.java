package com.itstep.springapp.daos;

import com.itstep.springapp.models.Person;
import com.itstep.springapp.utils.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDao implements Dao<Person> {
    private SessionFactoryUtil sessionFactoryUtil;

    @Autowired
    public PersonDao(SessionFactoryUtil sessionFactoryUtil) {
        this.sessionFactoryUtil = sessionFactoryUtil;
    }

    @Override
    public void save(Person item) {
        Session session = sessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(item);
        transaction.commit();
        session.close();
    }

    @Override
    public void edit(Person item) {
        Session session = sessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(item);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Person item) {
        Session session = sessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(item);
        transaction.commit();
        session.close();
    }

    @Override
    public Person getById(int id) {
        Session session = sessionFactoryUtil.getSessionFactory().openSession();
        Person person = session.get(Person.class, id);
        session.close();
        return person;
    }

    @Override
    public List<Person> getAll() {
        Session session = sessionFactoryUtil.getSessionFactory().openSession();
        List<Person> result = session.createQuery("from Person").list();
        session.close();
        return result;
    }
}
