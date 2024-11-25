import hust.soict.ep.aims.cart.Cart;
import hust.soict.ep.aims.disc.DigitalVideoDisc;

public class Aims {

    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion", "Animation","Roger Allers",87,19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation",18.99f);
		Cart anOrder = new Cart();


        anOrder.addDigitalVideoDisc(dvd1);
        anOrder.addDigitalVideoDisc(dvd2);
		anOrder.addDigitalVideoDisc(dvd3);
		anOrder.totalCost();
        anOrder.removeDigitalVideoDisc(dvd2);
            
		anOrder.removeDigitalVideoDisc(dvd3);
        anOrder.totalCost();

        // Tìm kiếm DVD theo ID
        anOrder.searchById(2); // ID của "Star Wars"

        // Tìm kiếm DVD theo tiêu đề
        anOrder.searchByTitle("Aladdin");

        // Tìm kiếm không thành công
        anOrder.searchByTitle("Frozen");

        // Hiển thị giỏ hàng và tính tổng chi phí
        anOrder.totalCost();

        // Xóa DVD
        anOrder.removeDigitalVideoDisc(dvd2);

        // Hiển thị lại giỏ hàng
        anOrder.totalCost();
			
    }
}