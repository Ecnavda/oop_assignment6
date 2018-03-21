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

    private void setIsbnNum(String isbn_num) {
        this.isbn_num = isbn_num;
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

    public String getIsbnNum() {
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
        return this.base_price;
    }

    public String getPublisher() {
        return this.publisher;
    }

    private void CreateISBN() {
        Random r = new Random();
        int isbn_digits = r.nextInt(100000);
        char isbn_first_letter = this.author.charAt(0);
        char isbn_second_letter = this.name.charAt(0);
        String isbn = String.format("%05d", isbn_digits) + "-" + isbn_first_letter + isbn_second_letter;
        setIsbnNum(isbn);
        //TODO check digits for uniqueness before assigning
    }

    // Temporary Method for testing -- REMOVE
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
}
