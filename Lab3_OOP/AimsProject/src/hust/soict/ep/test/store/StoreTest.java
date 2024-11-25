package hust.soict.ep.aims.store;
import hust.soict.ep.aims.disc.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        // Tạo các DVD mẫu
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 88, 19.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 124, 24.99f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "Ron Clements", 90, 18.99f);

        // Thêm DVD vào cửa hàng
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        // Hiển thị danh sách DVD trong cửa hàng
        store.displayStore();

        // Xóa DVD khỏi cửa hàng
        store.removeDVD(dvd2);

        // Hiển thị lại danh sách DVD sau khi xóa
        store.displayStore();

        // Thử xóa DVD không tồn tại
        DigitalVideoDisc dvdNotExist = new DigitalVideoDisc("Frozen");
        store.removeDVD(dvdNotExist);
    }
}
