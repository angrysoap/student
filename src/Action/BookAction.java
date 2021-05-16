package Action;

import Dao.BookDao;
import Dao.Dao1;
import com.opensymphony.xwork2.ActionSupport;
import model.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.*;
import java.util.ArrayList;

public class BookAction extends ActionSupport {
    private Book book1;
    private ArrayList books;
    private String message;
    private String condition="";
    private File upload;
    private String uploadFileName;
    private String uploadContentType;
    private String uploadText=" ";

    public void setUploadText(String uploadText){this.uploadText=uploadText;}
    public String getUploadText(){return this.uploadText;}

    public File getUpload() { return upload; }
    public void setUpload(File upload) { this.upload = upload; }

    public String getUploadFileName(){return uploadFileName;}
    public void setUploadFileName(String uploadFileName){this.uploadFileName = uploadFileName;}

    public String getUploadContentType(){return this.uploadContentType;}
    public void setUploadContentType(String uploadContentType) { this.uploadContentType = uploadContentType; }

    public void setMessage(String message1){this.message=message1;}
    public String getMessage(){return this.message;}

    public Book getBook() {return this.book1;}
    public void setBook(Book book2) { this.book1 = book2; }

    public ArrayList getBooks() { return books; }
    public void setBooks(ArrayList books1) { this.books = books1; }

    public void setCondition(String condition1){this.condition=condition1;}
    public String getCondition(){return this.condition;}

    public String read() throws Exception
    {
        FileInputStream fis=new FileInputStream("F:\\test9\\"+book1.getIntro());
        InputStreamReader is=new InputStreamReader(fis,"UTF-8");
        BufferedReader br=new BufferedReader(is);
        String str=br.readLine();
        while(str!=null)
        {uploadText=uploadText+str;
            str=br.readLine();}
        br.close();
        return "success";
    }

    public void write(File file,String filename) throws Exception {
        InputStream is = new FileInputStream(file);
        OutputStream os = new FileOutputStream("F:\\test9\\" +filename);
        byte buffer[] = new byte[1024];
        int count = 0;
        while ((count = is.read(buffer)) > 0)
        { os.write(buffer, 0, count); }
        os.close();
        is.close();
    }

    public String update() throws Exception {
        book1.setIntro(uploadFileName);
        //BookDao bookDao=new BookDao();
        //boolean b=bookDao.updateBook1(book1,book1.getAuthor());
        ApplicationContext context=new FileSystemXmlApplicationContext("F:\\大学\\之前学期\\大三上\\javaEE\\test1516\\web课设\\web\\WEB-INF\\applicationContext.xml");
        Dao1 dao1=(Dao1)context.getBean("bookdao");
        boolean b=dao1.updateBook1(book1,book1.getAuthor());
        if(b)
        {write(getUpload(), getUploadFileName());
            message="修改成功";return "success";}
        else{message="修改失败";return "error";}
    }

    public String add() throws Exception {
        book1.setIntro(uploadFileName);
        ApplicationContext context=new FileSystemXmlApplicationContext("F:\\大学\\之前学期\\大三上\\javaEE\\test1516\\web课设\\web\\WEB-INF\\applicationContext.xml");
        Dao1 dao1=(Dao1)context.getBean("bookdao");
        boolean a=dao1.insertBook1(book1,book1.getAuthor());
        if(a)
        { message = "添加书籍成功，书名为:" +book1.getTitle()+ "作者：" + book1.getAuthor().getName()+ "价格：" +book1.getPrice();
            write(getUpload(), getUploadFileName());
            return "success"; }
        else{ message="添加书籍失败"; return "error";}
    }

    public String list()
    {
        String co=this.condition+"%";
        //BookDao bookDao=new BookDao();
        //books=bookDao.listBook1(co);
        ApplicationContext context=new FileSystemXmlApplicationContext("F:\\大学\\之前学期\\大三上\\javaEE\\test1516\\web课设\\web\\WEB-INF\\applicationContext.xml");
        Dao1 dao1=(Dao1)context.getBean("bookdao");
        books=dao1.listBook1(co);
        if(books!=null) {return "success";}
        else{ return "error";}
    }
    public String list1 ()
    {
        //BookDao bookDao=new BookDao();
        //books=bookDao.list1Book1();
        ApplicationContext context=new FileSystemXmlApplicationContext("F:\\大学\\之前学期\\大三上\\javaEE\\test1516\\web课设\\web\\WEB-INF\\applicationContext.xml");
        Dao1 dao1=(Dao1)context.getBean("bookdao");
        books=dao1.list1Book1();
        if(books!=null) {return "success";}
        else{ return "error";}
    }

    public String delete()
    {String i=book1.getIsbn();
        //BookDao bookDao=new BookDao();
        //boolean a=bookDao.deleteBook1(i);
        ApplicationContext context=new FileSystemXmlApplicationContext("F:\\大学\\之前学期\\大三上\\javaEE\\test1516\\web课设\\web\\WEB-INF\\applicationContext.xml");
        Dao1 dao1=(Dao1)context.getBean("bookdao");
        boolean a=dao1.deleteBook1(i);
        if(a){return "success";}
        else{return "error";}
    }

}

