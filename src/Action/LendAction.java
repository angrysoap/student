package Action;


import Dao.BookDao;
import Dao.Dao2;
import Dao.lendDao;
import model.Book;
import model.Lend;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LendAction {
    private ArrayList lends;
    private Lend lend;
    private String message;
    private ArrayList books;
    private String condition="";
    private Book book1;
    private String uploadText=" ";

    public ArrayList getLends() { return lends; }
    public void setLends(ArrayList lends) { this.lends = lends; }

    public Lend getLend() { return lend; }
    public void setLend(Lend lend) { this.lend = lend; }

    public void setMessage(String message1){this.message=message1;}
    public String getMessage(){return this.message;}

    public ArrayList getBooks() { return books; }
    public void setBooks(ArrayList books1) { this.books = books1; }

    public void setCondition(String condition1){this.condition=condition1;}
    public String getCondition(){return this.condition;}

    public Book getBook() {return this.book1;}
    public void setBook(Book book2) { this.book1 = book2; }

    public void setUploadText(String uploadText){this.uploadText=uploadText;}
    public String getUploadText(){return this.uploadText;}

    public String list ()
    {
        //lendDao lenddao=new lendDao();
        //lends=lenddao.listBook();
        ApplicationContext context=new FileSystemXmlApplicationContext("F:\\大学\\之前学期\\大三上\\javaEE\\test1516\\web课设\\web\\WEB-INF\\applicationContext.xml");
        Dao2 dao2=(Dao2)context.getBean("lenddao");
        lends=dao2.listBook();
        if(lends!=null) {return "success";}
        else{ return "error";}
    }

    public String delete()
    {String i=lend.getIsbn();
        //lendDao lenddao=new lendDao();
        //boolean a=lenddao.deleteBook(i);
        ApplicationContext context=new FileSystemXmlApplicationContext("F:\\大学\\之前学期\\大三上\\javaEE\\test1516\\web课设\\web\\WEB-INF\\applicationContext.xml");
        Dao2 dao2=(Dao2)context.getBean("lenddao");
        boolean a=dao2.deleteBook(i);
        if(a){ message="还书成功，书名为："+lend.getTitle();return "success";}
        else{message="还书失败";return "error";}
    }

    public String find()
    {
        //lendDao lenddao=new lendDao();
        //books=lenddao.findBook();
        ApplicationContext context=new FileSystemXmlApplicationContext("F:\\大学\\之前学期\\大三上\\javaEE\\test1516\\web课设\\web\\WEB-INF\\applicationContext.xml");
        Dao2 dao2=(Dao2)context.getBean("lenddao");
        books=dao2.findBook();
        if(books!=null) {return "success";}
        else{ return "error";}
    }

    public String find1()
    {
        String co=this.condition+"%";
        //lendDao lenddao=new lendDao();
        //books=lenddao.find1Book(co);
        ApplicationContext context=new FileSystemXmlApplicationContext("F:\\大学\\之前学期\\大三上\\javaEE\\test1516\\web课设\\web\\WEB-INF\\applicationContext.xml");
        Dao2 dao2=(Dao2)context.getBean("lenddao");
        books=dao2.find1Book(co);
        if(books!=null) {return "success";}
        else{ return "error";}
    }

    public String read() throws Exception
    {
        FileInputStream fis=new FileInputStream("c:\\1\\"+book1.getIntro());
        InputStreamReader is=new InputStreamReader(fis,"UTF-8");
        BufferedReader br=new BufferedReader(is);
        String str=br.readLine();
        while(str!=null)
        {uploadText=uploadText+str;
            str=br.readLine();}
        br.close();
        return "success";
    }

    public String lend()
    {
        Lend l=new Lend(book1.getIsbn(),book1.getTitle(),book1.getPrice(),book1.getAuthor().getName());
        //lendDao lenddao=new lendDao();
       // boolean a=lenddao.lendBook(l);
        ApplicationContext context=new FileSystemXmlApplicationContext("F:\\大学\\之前学期\\大三上\\javaEE\\test1516\\web课设\\web\\WEB-INF\\applicationContext.xml");
        Dao2 dao2=(Dao2)context.getBean("lenddao");
        boolean a=dao2.lendBook(l);
        if(a)
        {message="借书成功:"+book1.getTitle();return "success";}
        else{message="借书失败";return "error";}
    }
}
