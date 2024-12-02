package hust.soict.dsai.aims.cart.Cart;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private List<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media media) {
        if (this.itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            if (this.itemsOrdered.contains(media)) {
                System.out.println("The media already exists in the cart.");
            } else {
                this.itemsOrdered.add(media);
                System.out.println("The media has been added to the cart.");
            }
        } else {
            System.out.println("ERROR: The number of media has reached its limit.");
        }
    }

    public void removeMedia(Media medium) {
        if (this.itemsOrdered.remove(medium)) {
            System.out.println(medium.getTitle() + " has been removed from the cart.");
        } else {
            System.out.println(medium.getTitle() + " is not in the cart.");
        }
    }

    public float totalCost() {
        float cost = 0.0f;
        for (Media medium : itemsOrdered) {
            cost += medium.getCost();
        }
        return cost;
    }

    public void print() {
        System.out.println("\n***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < this.itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ".\t" + this.itemsOrdered.get(i).getDetails() + "\n");
        }
        System.out.println("Total cost: $" + this.totalCost());
        System.out.println("***************************************************\n");
    }

    public boolean filterMedia(int id) {
        boolean found = false;
        int qty = 0;
        float cost = 0f;
        System.out.println("\n******************SEARCH RESULT********************");
        System.out.println("Product ID: " + id);
        for (int i = 0; i < this.itemsOrdered.size(); i++) {
            if (this.itemsOrdered.get(i).getId() == id) {
                System.out.println((i + 1) + ".\t" + this.itemsOrdered.get(i).getDetails() + "\n");
                qty += 1;
                cost = this.itemsOrdered.get(i).getCost();
                found = true;
            }
        }
        if (found) {
            System.out.println("Total number of product " + id + " found: " + qty);
            System.out.println("Total cost for these products: $" + (cost * qty));
            System.out.println("***************************************************\n");
            return true;
        } else {
            System.out.println("Such product is not in the cart.");
            System.out.println("***************************************************\n");
            return false;
        }
    }

    public boolean filterMedia(String title) {
        boolean found = false;
        int qty = 0;
        float cost = 0f;
        System.out.println("\n******************SEARCH RESULT********************");
        System.out.println("Product title: " + title);
        for (int i = 0; i < this.itemsOrdered.size(); i++) {
            if (this.itemsOrdered.get(i).search(title)) {
                System.out.println((i + 1) + ".\t" + this.itemsOrdered.get(i).getDetails() + "\n");
                qty += 1;
                cost = this.itemsOrdered.get(i).getCost();
                found = true;
            }
        }
        if (found) {
            System.out.println("Total number of product \"" + title + "\" found: " + qty);
            System.out.println("Total cost for these products: $" + (cost * qty));
            System.out.println("***************************************************\n");
            return true;
        } else {
            System.out.println("Such product is not in the cart.");
            System.out.println("***************************************************\n");
            return false;
        }
    }

    public Media searchMedia(String title) {
        for (Media medium : this.itemsOrdered) {
            if (medium.getTitle().equalsIgnoreCase(title)) {
                return medium;
            }
        }
        return null;
    }

    public void sortByTitle() {
        itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCost() {
        itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
    }

    public int getSize() {
        return this.itemsOrdered.size();
    }

    public List<Media> getItemsOrdered() {
        return this.itemsOrdered;
    }

    public List<Media> filterId(String str) {
        List<Media> viewFilter = new ArrayList<>();
        for (Media media : this.itemsOrdered) {
            String idStr = String.valueOf(media.getId());
            if (idStr.startsWith(str)) {
                viewFilter.add(media);
            }
        }
        return viewFilter;
    }

    public List<Media> filterTitle(String str) {
        List<Media> viewFilter = new ArrayList<>();
        for (Media media : this.itemsOrdered) {
            if (media.getTitle().startsWith(str)) {
                viewFilter.add(media);
            }
        }
        return viewFilter;
    }

    public void empty() {
        this.itemsOrdered.clear();
    }
}