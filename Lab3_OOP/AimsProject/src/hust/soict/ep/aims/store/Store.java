package hust.soict.ep.aims.store;
import hust.soict.ep.aims.disc.DigitalVideoDisc;

public class Store {
    public static final int MAX_ITEMS_IN_STORE = 100; // Giới hạn số lượng DVD trong cửa hàng
    private DigitalVideoDisc[] itemsInStore; // Mảng lưu trữ DVD
    private int qtyInStore; // Số lượng DVD hiện tại

    // Constructor
    public Store() {
        itemsInStore = new DigitalVideoDisc[MAX_ITEMS_IN_STORE];
        qtyInStore = 0;
    }

    // Thêm một DVD vào cửa hàng
    public void addDVD(DigitalVideoDisc disc) {
        if (qtyInStore < MAX_ITEMS_IN_STORE) {
            itemsInStore[qtyInStore] = disc;
            qtyInStore++;
            System.out.println("The disc \"" + disc.getTitle() + "\" has been added to the store.");
        } else {
            System.out.println("The store is full. Cannot add more DVDs.");
        }
    }

    // Xóa một DVD khỏi cửa hàng
    public void removeDVD(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] != null && itemsInStore[i].getTitle().equals(disc.getTitle())) {
                // Xóa DVD
                itemsInStore[i] = null;
                // Dồn các phần tử phía sau lên trước để giữ cấu trúc mảng
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null; // Giải phóng phần tử cuối
                qtyInStore--; // Giảm số lượng
                System.out.println("The disc \"" + disc.getTitle() + "\" has been removed from the store.");
                return;
            }
        }
        System.out.println("The disc \"" + disc.getTitle() + "\" was not found in the store.");
    }

    // Hiển thị danh sách DVD trong cửa hàng
    public void displayStore() {
        System.out.println("Items in the store:");
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] != null) {
                System.out.println((i + 1) + ". " + itemsInStore[i].toString());
            }
        }
        System.out.println("Total items in store: " + qtyInStore);
    }
}
