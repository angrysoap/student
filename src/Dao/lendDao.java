package Dao;

import Main.Main;
import model.Book;
import model.Lend;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class lendDao implements Dao2{

    public ArrayList listBook() {
        try{
            ArrayList b=new ArrayList();
            Session session= Main.getSession();
            Transaction ts=session.beginTransaction();
            String hql="from Lend";
            Query query=session.createQuery(hql);
            List<Lend> list=query.list();
            b.addAll(list);
            ts.commit();
            session.close();
            return b;
        }catch(Exception e)
        {e.printStackTrace();return null;}
    }


    public boolean deleteBook(String i) {
        try {
            Session session=Main.getSession();
            Transaction ts=session.beginTransaction();
            Lend b=(Lend)session.get(Lend.class,i);
            session.delete(b);
            ts.commit();
            session.close();
            return true;
        }catch(Exception e)
        {e.printStackTrace();return false;}
    }

    @Override
    public ArrayList findBook() {
        try{
            ArrayList b=new ArrayList();
            Session session=Main.getSession();
            Transaction ts=session.beginTransaction();
            String hql="from Book where isbn not in (select isbn from Lend)";
            Query query=session.createQuery(hql);
            List<Book> list=query.list();
            b.addAll(list);
            ts.commit();
            session.close();
            return b;
        }catch(Exception e)
        {e.printStackTrace();return null;}
    }

    @Override
    public ArrayList find1Book(String co) {
        try {
            ArrayList ar=new ArrayList();
            Session session=Main.getSession();
            Transaction ts=session.beginTransaction();
            String hql="from Book where isbn not in (select isbn from Lend) and title like ?1 or author.name like ?2 or isbn like ?3 ";
            Query query=session.createQuery(hql);
            query.setParameter(1,co);
            query.setParameter(2,co);
            query.setParameter(3,co);
            List<Book> list=query.list();
            for(Book b :list)
            {ar.add(b);}
            ts.commit();
            session.close();
            return ar;
        } catch (Exception e)
        { e.printStackTrace();return null; }
    }

    @Override
    public boolean lendBook(Lend l) {
        try {
            Session session = Main.getSession();
            Transaction ts = session.beginTransaction();
            session.save(l);
            ts.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

