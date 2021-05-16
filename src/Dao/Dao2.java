package Dao;
import model.Lend;

import java.util.ArrayList;
public interface Dao2 {
     public ArrayList listBook();
     public boolean deleteBook(String i);
     public ArrayList findBook();
     public ArrayList find1Book(String co);
     public boolean lendBook(Lend l);
}
