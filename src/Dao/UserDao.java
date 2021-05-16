package Dao;

import model.Book;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import Main.Main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserDao implements Dao{
    public User validateUser(String username, String password) {
        try {
            Session session = Main.getSession();
            Transaction ts = session.beginTransaction();
            Query query = session.createQuery("from User  where username=?1 and password=?2 ");
            query.setParameter(1, username);
            query.setParameter(2, password);
            List list = query.list();
            Iterator it=list.iterator();
            while(it.hasNext())
            {if(list.size()!=0)
            {User user=(User)it.next();
                return user;
            }
            }
            ts.commit();
            session.close();

        }catch(Exception e)
        {e.printStackTrace();}
        return null;
    }


    public boolean insertUser(User u) {
        try {
            Session session= Main.getSession();
            Transaction ts=session.beginTransaction();
            session.save(u);
            ts.commit();
            session.close();
            return true;
        }catch(Exception e)
        {e.printStackTrace();}
        return false;
    }


    public ArrayList listUser() {
        try{
            ArrayList b=new ArrayList();
            Session session=Main.getSession();
            Transaction ts=session.beginTransaction();
            String hql="from User where role=?1";
            Query query=session.createQuery(hql);
            query.setParameter(1,"normal");
            List<User> list=query.list();
            b.addAll(list);
            ts.commit();
            session.close();
            return b;
        }catch(Exception e)
        {e.printStackTrace();return null;}
    }


    public ArrayList list1User(String co) {
        try{
            ArrayList ar=new ArrayList();
            Session session=Main.getSession();
            Transaction ts=session.beginTransaction();
            String hql="from User where role=?1 and username like ?2  or password like ?3 ";
            Query query=session.createQuery(hql);
            query.setParameter(1,"normal");
            query.setParameter(3,co);
            query.setParameter(2,co);
            List<User> list=query.list();
            for(User b :list)
            {ar.add(b);}
            ts.commit();
            session.close();
            return ar;
          } catch (Exception e)
          { e.printStackTrace();return null; }
        }


    public boolean updateUser(User u) {
        try {
            Session session = Main.getSession();
            Transaction ts = session.beginTransaction();
            session.saveOrUpdate(u);
            ts.commit();
            session.close();
            return true;
        }catch(Exception e)
        {e.printStackTrace();}
        return false;
    }


    public boolean deleteUser(String s) {
        try {
            Session session=Main.getSession();
            Transaction ts=session.beginTransaction();
            User u=(User)session.get(User.class,s);
            session.delete(u);
            ts.commit();
            session.close();
            return true;
        }catch(Exception e)
        {e.printStackTrace();return false;}
    }
}
