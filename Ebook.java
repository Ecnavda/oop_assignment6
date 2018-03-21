public class Ebook extends TextBook{

    private String access_code;
    private int access_years;

    // Constructors
    public Ebook() {
        super();
        this.access_code = super.getIsbnNum();
        this.access_years = 1;
    }

    public Ebook(int access_years) {
        super();
        this.access_years = access_years;
    }

    // Mutators - Setters
    public void setAccessYears(int access_years) {
        this.access_years = access_years;
    }

    // Accessors - Getters
    public int getAccessYears() {
        return this.access_years;
    }

    public String getAccessCode() {
        return this.access_code;
    }

    // Methods
    public double calculatePrice() {
        if (access_years < 5) {
            return getBasePrice() * this.access_years;
        }
        else {
            return getBasePrice() * 5;
        }
    }

    //TODO implement .toString method somewhere
}