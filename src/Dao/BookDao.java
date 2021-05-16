package Dao;
import Main.Main;
import model.Author;
import model.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class BookDao implements Dao1{

    public boolean insertBook1(Book b,Author a) {
        try {
            Session session= Main.getSession();
            Transaction ts=session.beginTransaction();
            session.save(a);
            ts.commit();

            Transaction ts1=session.beginTransaction();
            session.save(b);
            ts1.commit();
            session.close();
            return true;
        }catch(Exception e)
        {e.printStackTrace();}
        return false;
    }

    public boolean deleteBook1(String isbn) {
        try {
            Session session=Main.getSession();
            Transaction ts=session.beginTransaction();
            Book b=(Book)session.get(Book.class,isbn);
            session.delete(b);
            ts.commit();
            session.close();
            return true;
        }catch(Exception e)
        {e.printStackTrace();return false;}
    }

    public boolean updateBook1(Book b,Author a) {
        try {
            Session session = Main.getSession();
            Transaction ts = session.beginTransaction();
            session.saveOrUpdate(a);
            session.saveOrUpdate(b);
            ts.commit();
            session.close();
            return true;
        }catch(Exception e)
        {e.printStackTrace();}
        return false;
    }

    public ArrayList list1Book1() {
        try{
            ArrayList b=new ArrayList();
            Session session=Main.getSession();
            Transaction ts=session.beginTransaction();
            String hql="from Book";
            Query query=session.createQuery(hql);
            List<Book> list=query.list();
            b.addAll(list);
            ts.commit();
            session.close();
            return b;
        }catch(Exception e)
        {e.printStackTrace();return null;}
    }

    public ArrayList listBook1(String co) {
        try {
            ArrayList ar=new ArrayList();
            Session session=Main.getSession();
            Transaction ts=session.beginTransaction();
            String hql="from Book where title like ?1 or author.name like ?2 or isbn like ?3 " +
                    "or author.mail like ?4 or author.tell like ?5";
            Query query=session.createQuery(hql);
            query.setParameter(1,co);
            query.setParameter(2,co);
            query.setParameter(3,co);
            query.setParameter(4,co);
            query.setParameter(5,co);
            List<Book> list=query.list();
            for(Book b :list)
            {ar.add(b);}
            ts.commit();
            session.close();
            return ar;
        } catch (Exception e)
        { e.printStackTrace();return null; }
    }
}
