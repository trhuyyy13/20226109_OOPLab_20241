package hust.soict.dsai.aims.store.Store;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("Media added to store.");
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("Media removed from store.");
        } else {
            System.out.println("Media not found in store.");
        }
    }

    public Media searchMedia(String title) {
        for (Media medium : itemsInStore) {
            if (medium.getTitle().equalsIgnoreCase(title)) {
                return medium;
            }
        }
        return null;
    }

    public void print() {
        System.out.println("\n***********************STORE***********************");
        System.out.println("Items in Store:");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ".\t" + itemsInStore.get(i).getDetails());
        }
        System.out.println("***************************************************\n");
    }
}