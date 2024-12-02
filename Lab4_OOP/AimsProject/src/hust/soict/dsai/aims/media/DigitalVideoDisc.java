package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {

    public String getType() {
        return "DVD";
    }

    public String getDetails() {
        return "Product ID: " + this.getId()
                + "\n\tTitle: " + this.getTitle()
                + "\n\tCategory: " + this.getCategory()
                + "\n\tDirector: " + this.getDirector()
                + "\n\tLength: " + this.getLength() + " minutes"
                + "\n\tPrice: $" + this.getCost();
    }

    public void play() {
        if (this.getLength() <= 0) {
            System.out.println("ERROR: DVD length is non-positive!");
        } else {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength() + " minutes");
        }
    }

    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.setDirector(director);
        this.setLength(length);
    }
}