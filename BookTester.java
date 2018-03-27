import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookTester {

    public static void main(String[] args) {
        TextBook book1 = new TextBook();
        BookInfo info1 = new BookInfo();

        TextBook book2 = new TextBook("Random Book", "Somebody Once", 1988,
                "Math", 21.99);

        Ebook ebook1 = new Ebook();
        BookInfo ebook_info1 = new BookInfo("3 Book", "Myself And-I", "Fourth", 2020,  "Space", 99.99, "Pub L. Isher");

        Ebook ebook2 = new Ebook("Parameter Constructors", "Bob Person", 1920, "Programming", 39.99, 3);

        PaperBackText paper_book1 = new PaperBackText();
        BookInfo paper_info1 = new BookInfo("Super Dog", "Puppy Love", "16th", 3019, "Zoology", 10.00, "Sub Pub");

        PaperBackText paper_book2 = new PaperBackText("Paper Planes", "Pilot John", 111, "Flight", 14.99, .8);

        try {
            getBookTest(book1);
            System.out.println();

            setBookTest(book1, info1);
            getBookTest(book1);
            System.out.println();

            getBookTest(book2);
            System.out.println();

            getBookTest(ebook1);
            System.out.println();

            setBookTest(ebook1, ebook_info1, 8);
            getBookTest(ebook1);
            System.out.println();

            getBookTest(ebook2);
            System.out.println();

            getBookTest(paper_book1);
            System.out.println();

            setBookTest(paper_book1, paper_info1, .4);
            getBookTest(paper_book1);
            System.out.println();

            getBookTest(paper_book2);
        }
        catch (IllegalAccessException | InvocationTargetException err) {
            //TODO properly handle exceptions
            System.out.println(err);
        }
    }

    private static void getBookTest(TextBook book) throws IllegalAccessException, InvocationTargetException {
        //Methods are returned in order of declaration in class file
        Method[] methods = book.getClass().getDeclaredMethods();
        //Testing public accessor/getter methods
        for (Method m : methods) {
            if (Modifier.isPublic(m.getModifiers()) && !(m.getReturnType().equals(Void.TYPE))) {
                System.out.print(m.getName() + "\t");
                System.out.println(m.invoke(book));
            }
        }
    }

    private static void getBookTest(Ebook book) throws IllegalAccessException, InvocationTargetException {
        //Methods are returned in order of declaration in class file
        List<Method> methods = new ArrayList<Method>();
        methods.addAll(Arrays.asList(book.getClass().getSuperclass().getDeclaredMethods()));
        methods.addAll(Arrays.asList(book.getClass().getDeclaredMethods()));
        //Testing public accessor/getter methods
        for (Method m : methods) {
            if (Modifier.isPublic(m.getModifiers()) && !(m.getReturnType().equals(Void.TYPE))) {
                System.out.print(m.getName() + "\t");
                System.out.println(m.invoke(book));
            }
        }
    }

    private static void getBookTest(PaperBackText book) throws IllegalAccessException, InvocationTargetException {
        //Methods are returned in order of declaration in class file
        List<Method> methods = new ArrayList<Method>();
        methods.addAll(Arrays.asList(book.getClass().getSuperclass().getDeclaredMethods()));
        methods.addAll(Arrays.asList(book.getClass().getDeclaredMethods()));
        //Testing public accessor/getter methods
        for (Method m : methods) {
            if (Modifier.isPublic(m.getModifiers()) && !(m.getReturnType().equals(Void.TYPE))) {
                System.out.print(m.getName() + "\t");
                System.out.println(m.invoke(book));
            }
        }
    }

    private static void setBookTest(TextBook book, BookInfo info) throws IllegalAccessException, InvocationTargetException {
        Method[] methods = book.getClass().getDeclaredMethods();
        Field[] fields = info.getClass().getDeclaredFields();
        int i = 0;
        for (Method m : methods) {
            if (Modifier.isPublic(m.getModifiers()) && m.getReturnType().equals(Void.TYPE)) {
                m.invoke(book, fields[i].get(info));
                i++;
            }
        }
    }

    private static void setBookTest(Ebook book, BookInfo info, int access_years) throws IllegalAccessException, InvocationTargetException {
        List<Method> methods = new ArrayList<Method>();
        methods.addAll(Arrays.asList(book.getClass().getSuperclass().getDeclaredMethods()));
        methods.addAll(Arrays.asList(book.getClass().getDeclaredMethods()));
        Field[] fields = info.getClass().getDeclaredFields();
        int i = 0;
        for (Method m : methods) {
            if (i < 7) {
                if (Modifier.isPublic(m.getModifiers()) && m.getReturnType().equals(Void.TYPE)) {
                    m.invoke(book, fields[i].get(info));
                    i++;
                }
            }
            else {
                if (Modifier.isPublic(m.getModifiers()) && m.getReturnType().equals(Void.TYPE)) {
                    m.invoke(book, access_years);
                    i++;
                }
            }
        }
    }

    private static void setBookTest(PaperBackText book, BookInfo info, double markup) throws IllegalAccessException, InvocationTargetException {
        List<Method> methods = new ArrayList<Method>();
        methods.addAll(Arrays.asList(book.getClass().getSuperclass().getDeclaredMethods()));
        methods.addAll(Arrays.asList(book.getClass().getDeclaredMethods()));
        Field[] fields = info.getClass().getDeclaredFields();
        int i = 0;
        for (Method m : methods) {
            if (i < 7) {
                if (Modifier.isPublic(m.getModifiers()) && m.getReturnType().equals(Void.TYPE)) {
                    m.invoke(book, fields[i].get(info));
                    i++;
                }
            }
            else {
                if (Modifier.isPublic(m.getModifiers()) && m.getReturnType().equals(Void.TYPE)) {
                    m.invoke(book, markup);
                    i++;
                }
            }
        }
    }
}

class BookInfo {
    public String name = "Default Name";
    public String author = "First Last";
    public String edition = "Default edition";
    public int published_year = 1000;
    public String discipline = "Default Discipline";
    public double base_price = 19.99;
    public String publisher = "Default Publisher";

    public BookInfo() {;}

    public BookInfo(String name, String author, String edition, int published_year,
                    String discipline, double base_price, String publisher) {
        this.name = name;
        this.author = author;
        this.edition = edition;
        this.published_year = published_year;
        this.discipline = discipline;
        this.base_price = base_price;
        this.publisher = publisher;
    }
}
