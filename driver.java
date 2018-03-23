public class driver {

    public static void main(String[] args) {
        PaperBackText test = new PaperBackText();
        test.getEverything();
        System.out.println(test.getRegistration_id());
        System.out.println(test.getISBNNum());

        System.out.println();

        Ebook test2 = new Ebook();
        test2.getEverything();
        System.out.println(test2.getISBNNum());

        System.out.println();

        TextBook test3 = new TextBook("1 Some Body", "Once Told", 2018, "Me the World",
                99.99);
        test3.setEdition("Fifth");
        test3.setPublisher("Smash Mouf");
        test3.getEverything();
        System.out.println(test3.getISBNTracking());

        System.out.println();

        TextBook test4 = new TextBook();
        test4.getEverything();

        System.out.println(test4.getISBNTracking());
    }

}
