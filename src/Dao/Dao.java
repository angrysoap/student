package Dao;

import model.User;

import java.util.ArrayList;

public interface Dao {
    public User validateUser(String name, String password);
    public boolean insertUser(User u);
    public ArrayList listUser();
    public ArrayList list1User(String co);
    public boolean updateUser(User u);
    public boolean deleteUser(String s);
}
