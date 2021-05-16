package Action;
import java.util.ArrayList;

import Dao.Dao;
import Dao.UserDao;

import com.opensymphony.xwork2.ActionSupport;
import model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class UserAction extends ActionSupport {
    private User user1;
    private ArrayList users;
    private String message;
    private String condition="";

    public ArrayList getUsers() { return users; }
    public void setUsers(ArrayList users) { this.users = users; }

    public void setCondition(String condition1){this.condition=condition1;}
    public String getCondition(){return this.condition;}

    public void setMessage(String message1){this.message=message1;}
    public String getMessage(){return this.message;}

    public User getUser1() {return user1;}
    public void setUser1(User user2) {this.user1=user2;}

    public String login ()
    {
        try {
            String user = user1.getUsername();
            String pwd = user1.getPassword();
            ApplicationContext context=new FileSystemXmlApplicationContext("F:\\大学\\之前学期\\大三上\\javaEE\\test1516\\web课设\\web\\WEB-INF\\applicationContext.xml");
            Dao dao=(Dao)context.getBean("userdao");
            User u=dao.validateUser(user,pwd);
            //UserDao userDao = new UserDao();
            //User u = userDao.validateUser(user, pwd);
            if (u != null) {
                if (u.getRole().equals("admin")) {
                    return "success";
                } else {
                    return "success1";
                }
            }
        }catch(Exception e)
        {e.printStackTrace();}
        return "error";
    }

    public String insertUser()
    {
      //UserDao userDao=new UserDao();
      //boolean a=userDao.insertUser(user1);
        ApplicationContext context=new FileSystemXmlApplicationContext("F:\\大学\\之前学期\\大三上\\javaEE\\test1516\\web课设\\web\\WEB-INF\\applicationContext.xml");
        Dao dao=(Dao)context.getBean("userdao");
        boolean a=dao.insertUser(user1);
      if(a)
      {message="成功保存用户:"+user1.getUsername()+"   "+user1.getRole();return "success";}
      else{message="添加失败"; return "error";}
    }

    public String listUser()
    {
        //UserDao userDao=new UserDao();
        //users=userDao.listUser();
        ApplicationContext context=new FileSystemXmlApplicationContext("F:\\大学\\之前学期\\大三上\\javaEE\\test1516\\web课设\\web\\WEB-INF\\applicationContext.xml");
        Dao dao=(Dao)context.getBean("userdao");
        users=dao.listUser();
        if(users!=null)
        {return "success";}
        else{return "error";}
    }

    public String list1User()
    {
        String co=this.condition+"%";
        //UserDao userDao=new UserDao();
        //users=userDao.list1User(co);
        ApplicationContext context=new FileSystemXmlApplicationContext("F:\\大学\\之前学期\\大三上\\javaEE\\test1516\\web课设\\web\\WEB-INF\\applicationContext.xml");
        Dao dao=(Dao)context.getBean("userdao");
        users=dao.list1User(co);
        if(users!=null)
        {return "success";}
        else{return "error";}
    }

    public String updateUser()
    {
        //UserDao userDao=new UserDao();
        //boolean b=userDao.updateUser(user1);
        ApplicationContext context=new FileSystemXmlApplicationContext("F:\\大学\\之前学期\\大三上\\javaEE\\test1516\\web课设\\web\\WEB-INF\\applicationContext.xml");
        Dao dao=(Dao)context.getBean("userdao");
        boolean b=dao.updateUser(user1);
        if(b){ message="修改成功";return "success";}
        else{message="修改失败";return "error";}
    }

    public String deleteUser()
    {
        String u=user1.getUsername();
        //UserDao userDao=new UserDao();
        //boolean b=userDao.deleteUser(u);
        ApplicationContext context=new FileSystemXmlApplicationContext("F:\\大学\\之前学期\\大三上\\javaEE\\test1516\\web课设\\web\\WEB-INF\\applicationContext.xml");
        Dao dao=(Dao)context.getBean("userdao");
        boolean b=dao.deleteUser(u);
        if(b){return "success";}
        else{return "error";}
    }

    //public void validateLogin ()
    //{ if(this.user1.getUsername()==null||this.user1.getUsername().trim().equals(""))
    //{addFieldError("user1.username","用户名必须填");}
    //}
    //public void validate ()
    //{
    //    if(this.user1.getPassword()==null||this.user1.getPassword().equals(""))
     //   {addFieldError("user1.password","密码必须填");}
    //}

}
