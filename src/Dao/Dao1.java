package Dao;

import model.Author;
import model.Book;

import java.util.ArrayList;

public interface Dao1 {
    public boolean insertBook1(Book b,Author a);
    public boolean deleteBook1(String isbn);
    public boolean updateBook1(Book b,Author a);
    public ArrayList list1Book1();
    public ArrayList listBook1(String co);
}
