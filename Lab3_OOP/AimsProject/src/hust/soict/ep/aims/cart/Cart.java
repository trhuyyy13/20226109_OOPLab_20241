package hust.soict.ep.aims.cart;
import hust.soict.ep.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered;

    public Cart() {
        itemOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
        qtyOrdered = 0;
    }

    // Thêm một đĩa DVD vào giỏ hàng
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc \"" + disc.getTitle() + "\" has been added.");
        } else {
            System.out.println("The cart is almost full.");
        }
    }

    // // Thêm danh sách DVD (mảng)
    // public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
    //     for (DigitalVideoDisc disc : dvdList) {
    //         if (disc != null) {
    //             if (qtyOrdered < MAX_NUMBERS_ORDERED) {
    //                 itemOrdered[qtyOrdered] = disc;
    //                 qtyOrdered++;
    //                 System.out.println("The disc \"" + disc.getTitle() + "\" has been added.");
    //             } else {
    //                 System.out.println("The cart is full. Cannot add more DVDs.");
    //                 break;
    //             }
    //         }
    //     }
    // }

    // Thêm số lượng DVD bất kỳ (varargs)
    public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
        for (DigitalVideoDisc disc : dvds) {
            if (disc != null) {
                if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                    itemOrdered[qtyOrdered] = disc;
                    qtyOrdered++;
                    System.out.println("The disc \"" + disc.getTitle() + "\" has been added.");
                } else {
                    System.out.println("The cart is full. Cannot add more DVDs.");
                    break;
                }
            }
        }
    }

    // Thêm hai DVD
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    // Xóa một đĩa DVD khỏi giỏ hàng
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrdered[i] != null && itemOrdered[i].getTitle().equals(disc.getTitle())) {
                // Xóa đĩa DVD
                itemOrdered[i] = null;
                // Dồn các phần tử phía sau lên trước để giữ cấu trúc
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemOrdered[j] = itemOrdered[j + 1];
                }
                itemOrdered[qtyOrdered - 1] = null; // Giải phóng phần tử cuối
                qtyOrdered--; // Giảm số lượng
                System.out.println("The disc \"" + disc.getTitle() + "\" has been removed.");
                return;
            }
        }
        System.out.println("The disc \"" + disc.getTitle() + "\" was not found in the cart.");
    }

    // List item, Tính tổng chi phí
    public float totalCost() {
        float total = 0;
        System.out.println("Items in cart:");
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrdered[i] != null) {
                System.out.println((i + 1) + ". " + itemOrdered[i].getTitle() + " - $" + itemOrdered[i].getCost());
                total += itemOrdered[i].getCost();
            }
        }
        System.out.println("Total cost: $" + total);
        return total;
    }

        // Tìm kiếm DVD theo ID
    public DigitalVideoDisc searchById(int id) {
        for (DigitalVideoDisc disc : itemOrdered) {
            if (disc != null && disc.getId() == id) {
                System.out.println("Found: " + disc);
                return disc;
            }
        }
        System.out.println("No match found for ID: " + id);
        return null;
    }

    // Tìm kiếm DVD theo tiêu đề
    public DigitalVideoDisc searchByTitle(String title) {
        for (DigitalVideoDisc disc : itemOrdered) {
            if (disc != null && disc.isMatch(title)) {
                System.out.println("Found: " + disc);
                return disc;
            }
        }
        System.out.println("No match found for title: \"" + title + "\"");
        return null;
    }

}
