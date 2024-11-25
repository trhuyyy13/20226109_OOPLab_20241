package hust.soict.ep.aims.disc;

public class DigitalVideoDisc {

    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    // Thuộc tính id của đối tượng
    private int id;

    // Thuộc tính tĩnh để đếm số lượng DVD đã tạo
    private static int nbDigitalVideoDiscs = 0;

    // Constructor chỉ với tiêu đề
    public DigitalVideoDisc(String title) {
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs; // Gán id tự động
        this.title = title;
    }

    // Constructor với tiêu đề, thể loại, giá
    public DigitalVideoDisc(String title, String category, float cost) {
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs; // Gán id tự động
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Constructor với tiêu đề, thể loại, đạo diễn, giá
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs; // Gán id tự động
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
    }

    // Constructor đầy đủ
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs; // Gán id tự động
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    // Getter cho id
    public int getId() {
        return id;
    }

    // Getter cho nbDigitalVideoDiscs
    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }

    // Getter và Setter cho các thuộc tính khác
    public String getTitle() {
        return title;
    }

    public void setTitle(String titleSet) {
        title = titleSet;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String categorySet) {
        category = categorySet;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String directorSet) {
        director = directorSet;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int lengthSet) {
        length = lengthSet;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float costSet) {
        cost = costSet;
    }

    // Phương thức kiểm tra khớp tiêu đề
    public boolean isMatch(String title) {
        return this.title.equalsIgnoreCase(title); // So sánh không phân biệt chữ hoa/thường
    }
    
    // Phương thức toString để hiển thị thông tin DVD
    @Override
    public String toString() {
        return "DigitalVideoDisc [ID=" + id + ", Title=" + title + ", Category=" + category +
               ", Director=" + director + ", Length=" + length + " mins, Cost=$" + cost + "]";
    }
}
