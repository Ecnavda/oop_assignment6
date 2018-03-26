import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BookTester {

    public static void main(String[] args) {
        //Testing Textbook default constructor
        TextBook book1 = new TextBook();
        //Methods are returned in order of declaration in class file
        Method[] methods = book1.getClass().getDeclaredMethods();
        try {
            //Testing public accessor/getter methods
            for (Method m : methods) {
                if (Modifier.isPublic(m.getModifiers()) && !(m.getReturnType().equals(Void.TYPE))) {
                        System.out.print(m.getName() + "\t");
                        System.out.println(m.invoke(book1));
                }
            }

            System.out.println();

            //Testing public mutator/setter methods
            BookInfo book1_info = new BookInfo();
            Field[] fields = book1_info.getClass().getDeclaredFields();
            int i = 0;
            for (Method m : methods) {
                if (Modifier.isPublic(m.getModifiers()) && m.getReturnType().equals(Void.TYPE)) {
                    m.invoke(book1, fields[i].get(book1_info));
                    i++;
                }
            }
            for (Method m : methods) {
                if (Modifier.isPublic(m.getModifiers()) && !(m.getReturnType().equals(Void.TYPE))) {
                    System.out.print(m.getName() + "\t");
                    System.out.println(m.invoke(book1));
                }
            }
        }
        catch (IllegalAccessException | InvocationTargetException err) {
            //TODO properly handle exceptions
            System.out.println(err);
        }
    }
}

class BookInfo {
    public String name = "Book Name";
    public String author = "First Last";
    public String edition = "Fourth edition";
    public int published_year = 1999;
    public String discipline = "Science";
    public double base_price = 19.99;
    public String publisher = "Publishing Company";
}
