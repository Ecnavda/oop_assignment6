import java.util.ArrayList;
import java.util.Random;

public class TextBook {

    private String name;
    private String author;
    private String isbn_num;
    private String edition;
    private int published_year;
    private String discipline;
    private double base_price;
    private String publisher;

    private static ArrayList<String> isbn_tracking = new ArrayList<String>();

    // Constructors
    public TextBook() {
        this.name = "Nameless";
        this.author = "John Doe";
        this.published_year = 1901;
        this.discipline = "Unknown";
        this.base_price = 0.0;
        CreateISBN();
    }

    public TextBook(String name, String author, int published_year, String discipline, double base_price) {
        this.name = name;
        this.author = author;
        this.published_year = published_year;
        this.discipline = discipline;
        this.base_price = base_price;
        CreateISBN();
    }

    // Mutators - Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    private void setISBNNum(String isbn_num) {
        this.isbn_num = isbn_num;
        addToISBNTracking(isbn_num);
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setPublishedYear(int published_year) {
        this.published_year = published_year;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public void setBasePrice(double base_price) {
        this.base_price = base_price;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    // Accessors - Getters
    public String getName() {
        return this.name;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getISBNNum() {
        return this.isbn_num;
    }

    public String getEdition() {
        return this.edition;
    }

    public int getPublishedYear() {
        return this.published_year;
    }

    public String getDiscipline() {
        return this.discipline;
    }

    public double getBasePrice() {
        //TODO return this value displayed as currency
        return this.base_price;
    }

    public String getPublisher() {
        return this.publisher;
    }

    private void addToISBNTracking(String isbn_num) {
        isbn_tracking.add(isbn_num);
    }

    private boolean checkUnique(String isbn) {
        boolean unique = true;
        if (!(isbn_tracking.isEmpty())) {
            for (int i = 0; i < isbn_tracking.size(); i++) {
                if (isbn.equals(isbn_tracking.get(i))) {
                    unique = false;
                    break;
                }
            }
        }
        return unique;
    }

    private String generateRandomISBN() {
        Random r = new Random();
        int isbn_digits = r.nextInt(100000);
        char isbn_first_letter = this.author.charAt(0);
        char isbn_second_letter = this.name.charAt(0);
        if (Character.isDigit(isbn_second_letter)) {
            isbn_second_letter = 'X';
        }
        String isbn = String.format("%05d", isbn_digits) + "-" + isbn_first_letter + isbn_second_letter;
        return isbn;
    }

    private void CreateISBN() {
        String isbn = generateRandomISBN();
        boolean unique = checkUnique(isbn);
        if (unique) {
            setISBNNum(isbn);
        }
        else {
            CreateISBN();
        }
    }

    //TODO Temporary Method for testing -- REMOVE
    public void getEverything() {
        System.out.println(
                this.name + "\n" +
                this.author + "\n" +
                this.isbn_num + "\n" +
                this.edition + "\n" +
                Integer.toString(this.published_year) + "\n" +
                this.discipline + "\n" +
                Double.toString(this.base_price) + "\n" +
                this.publisher
        );
    }

    public ArrayList<String> getISBNTracking() {
        return isbn_tracking;
    }

}
