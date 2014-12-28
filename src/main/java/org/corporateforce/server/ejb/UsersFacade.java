/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import org.corporateforce.server.model.Users;
import org.hibernate.criterion.Order;

/**
 *
 * @author Chep
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> implements UsersFacadeLocal {

    public UsersFacade() {
        super(Users.class);
    }

    @Override
    public Users createUsers(Users entity) {
        return this.create(entity);
    }

    @Override
    public void editUsers(Users entity) {
        this.edit(entity);
    }

    @Override
    public void deleteUsers(Users entity) {
        this.delete(entity);
    }

    @Override
    public Users getUsers(int id) {
        return this.get(id);
    }

    @Override
    public List<Users> listUsers() {
        return this.list();
    }

    @Override
    public int countUsers() {
        return this.count();
    }   

    @Override
    public Users loginUsers(String username, String password) {
        Users res = null;
        session.clear();
        this.session.beginTransaction();
        int id = (Integer) session.createSQLQuery("SELECT `userSignIn`(:username, :password)")
                .setString("username", username)
                .setString("password", password)
                .uniqueResult();
        this.session.getTransaction().commit();
        if (id > 0) {
            res = this.get(id);
        }
        return res;
    }

    @Override
    public Users createSimpleUsers(int profile, int office, int role, int manager, String username, String password) {
        Users res = null;
        this.session.beginTransaction();
        Integer id = (Integer) session.createSQLQuery("CALL `userCreate`(:profile, :office, :role, :manager, :username, :password)")
                .setLong("profile", profile)
                .setLong("office", office)
                .setLong("role", role)
                .setLong("manager", manager)
                .setString("username", username)
                .setString("password", password)
                .uniqueResult();
        this.session.getTransaction().commit();
        session.clear();
        if (id > 0) {
            res = this.get(id);
        }
        return res;
    }

    @Override
    public Users createWithContactsUsers(int profile, int office, int role,
            int manager, String username, String password, String firstname,
            String lastname, int gender, Date date) {
        Users res = null;
        this.session.beginTransaction();
        Integer id = (Integer) session.createSQLQuery("CALL `userCreateWithContact`(:profile, :office, :role, :manager, :username, :password, :firstname, :lastname, :gender, :date)")
                .setLong("profile", profile)
                .setLong("office", office)
                .setLong("role", role)
                .setLong("manager", manager)
                .setString("username", username)
                .setString("password", password)
                .setString("firstname", firstname)
                .setString("lastname", lastname)
                .setInteger("gender", gender)
                .setDate("date", date)
                .uniqueResult();
        this.session.getTransaction().commit();
        session.clear();
        if (id > 0) {
            res = this.get(id);
        }
        return res;
    }

    @Override
    public void changePasswordUsers(Integer id, String password) {
        this.session.beginTransaction();
        session.createSQLQuery("CALL `userChangePassword`(:id, :password)")
                .setLong("id", id)
                .setString("password", password)
                .executeUpdate();
        this.session.getTransaction().commit();
        session.clear();
    }

    @Override
    public void changePasswordSecureUsers(Integer id, String oldpassword,
            String newpassword) {
        this.session.beginTransaction();
        session.createSQLQuery("CALL `userChangePasswordSecure`(:id, :oldpassword, :newpassword)")
                .setLong("id", id)
                .setString("oldpassword", oldpassword)
                .setString("newpassword", newpassword)
                .executeUpdate();
        this.session.getTransaction().commit();
        session.clear();

    }

    @Override
    public List<Users> listByUsernameUsers() {
        this.session.beginTransaction();
        List<Users> res = (List<Users>) session.createCriteria(Users.class).addOrder(Order.asc("username")).list();
        this.session.getTransaction().commit();
        return res;
    }

    @Override
    public void changeManagerUsers(int id, int manager) {
        this.session.beginTransaction();
        session.createSQLQuery("CALL `userChangeManager`(:id, :manager)")
                .setLong("id", id)
                .setLong("manager", manager)
                .executeUpdate();
        this.session.getTransaction().commit();
        session.clear();
    }

    @Override
    public void changeOfficeUsers(int id, int office) {
        this.session.beginTransaction();
        session.createSQLQuery("CALL `userChangeOffice`(:id, :office)")
                .setLong("id", id)
                .setLong("office", office)
                .executeUpdate();
        this.session.getTransaction().commit();
        session.clear();

    }

    @Override
    public void changeProfileUsers(int id, int profile) {
        this.session.beginTransaction();
        session.createSQLQuery("CALL `userChangeProfile`(:id, :profile)")
                .setLong("id", id)
                .setLong("profile", profile)
                .executeUpdate();
        this.session.getTransaction().commit();
        session.clear();

    }

    @Override
    public void changeRoleUsers(int id, int role) {
        this.session.beginTransaction();
        session.createSQLQuery("CALL `userChangeRole`(:id, :role)")
                .setLong("id", id)
                .setLong("role", role)
                .executeUpdate();
        this.session.getTransaction().commit();
        session.clear();
    }
}
