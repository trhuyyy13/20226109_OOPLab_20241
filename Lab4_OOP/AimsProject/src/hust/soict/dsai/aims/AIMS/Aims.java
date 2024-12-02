package hust.soict.dsai.aims.AIMS;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store.Store;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        initStore();
        showMenu();
    }

    public static void showMenu() {
        while (true) {
            System.out.println("\nAIMS: ");
            System.out.println("--------------------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3");

            int choice = getValidChoice(0, 3);
            switch (choice) {
                case 1:
                    storeMenu();
                    break;
                case 2:
                    updateStoreMenu();
                    break;
                case 3:
                    cartMenu();
                    break;
                case 0:
                    System.out.println("Thank you for using our service. We hope to see you again.");
                    return;
            }
        }
    }

    public static void storeMenu() {
        while (true) {
            System.out.println();
            store.print();
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media's details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4");

            int choice = getValidChoice(0, 4);
            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMediaInStore();
                    break;
                case 4:
                    cartMenu();
                    break;
                case 0:
                    return;
            }
        }
    }

    public static void seeMediaDetails() {
        System.out.println("Enter the title of the media:");
        String title = scan.nextLine();
        Media media = store.searchMedia(title);
        if (media != null) {
            System.out.println(media.toString());
            mediaDetailsMenu(media);
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void mediaDetailsMenu(Media media) {
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            if (media instanceof Playable) {
                System.out.println("2. Play");
            }
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            if (media instanceof Playable) {
                System.out.println("Please choose a number: 0-1-2");
            } else {
                System.out.println("Please choose a number: 0-1");
            }

            int choice;
            if (media instanceof Playable) {
                choice = getValidChoice(0, 2);
            } else {
                choice = getValidChoice(0, 1);
            }

            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    System.out.println("Media added to cart. Total items in cart: " + cart.getSize());
                    break;
                case 2:
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    }
                    break;
                case 0:
                    return;
            }
        }
    }

    public static void addMediaToCart() {
        System.out.println("Enter the title of the media:");
        String title = scan.nextLine();
        Media media = store.searchMedia(title);
        if (media != null) {
            cart.addMedia(media);
            System.out.println("Media added to cart. Total items in cart: " + cart.getSize());
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void playMediaInStore() {
        System.out.println("Enter the title of the media:");
        String title = scan.nextLine();
        Media media = store.searchMedia(title);
        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else if (media != null) {
            System.out.println("Media is not playable.");
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void updateStoreMenu() {
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add media to the store");
            System.out.println("2. Remove media from the store");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");

            int choice = getValidChoice(0, 2);
            switch (choice) {
                case 1:
                    addMediaToStore();
                    break;
                case 2:
                    removeMediaFromStore();
                    break;
                case 0:
                    return;
            }
        }
    }

    public static void addMediaToStore() {
        System.out.println("Enter the type of media to add (Book/CD/DVD):");
        String type = scan.nextLine().trim().toLowerCase();
        Media media = null;
        System.out.println("Enter title:");
        String title = scan.nextLine();
        System.out.println("Enter category:");
        String category = scan.nextLine();
        System.out.println("Enter cost:");
        float cost = scan.nextFloat();
        scan.nextLine(); // Consume newline

        switch (type) {
            case "book":
                media = new Book(title, category, cost);
                break;
            case "cd":
                System.out.println("Enter artist:");
                String artist = scan.nextLine();
                media = new CompactDisc(title, category, artist, artist, 0, cost);
                break;
            case "dvd":
                System.out.println("Enter director:");
                String director = scan.nextLine();
                media = new DigitalVideoDisc(title, category, director, 0, cost);
                break;
            default:
                System.out.println("Invalid media type.");
                return;
        }
        store.addMedia(media);
        System.out.println("Media added to store.");
    }

    public static void removeMediaFromStore() {
        System.out.println("Enter the title of the media to remove:");
        String title = scan.nextLine();
        Media media = store.searchMedia(title);
        if (media != null) {
            store.removeMedia(media);
            System.out.println("Media removed from store.");
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void cartMenu() {
        while (true) {
            cart.print();
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4-5");

            int choice = getValidChoice(0, 5);
            switch (choice) {
                case 1:
                    filterCartMenu();
                    break;
                case 2:
                    sortCartMenu();
                    break;
                case 3:
                    removeFromCart();
                    break;
                case 4:
                    playMediaInCart();
                    break;
                case 5:
                    placeOrder();
                    break;
                case 0:
                    return;
            }
        }
    }

    public static void filterCartMenu() {
        System.out.println("Filter by:");
        System.out.println("1. ID");
        System.out.println("2. Title");
        int choice = getValidChoice(1, 2);
        switch (choice) {
            case 1:
                System.out.println("Enter ID:");
                int id = scan.nextInt();
                scan.nextLine();
                cart.filterMedia(id);
                break;
            case 2:
                System.out.println("Enter title:");
                String title = scan.nextLine();
                cart.filterMedia(title);
                break;
        }
    }

    public static void sortCartMenu() {
        System.out.println("Sort by:");
        System.out.println("1. Title");
        System.out.println("2. Cost");
        int choice = getValidChoice(1, 2);
        switch (choice) {
            case 1:
                cart.sortByTitle();
                break;
            case 2:
                cart.sortByCost();
                break;
        }
        cart.print();
    }

    public static void removeFromCart() {
        System.out.println("Enter the title of the media to remove:");
        String title = scan.nextLine();
        Media media = cart.searchMedia(title);
        if (media != null) {
            cart.removeMedia(media);
            System.out.println("Media removed from cart.");
        } else {
            System.out.println("Media not found in cart.");
        }
    }

    public static void playMediaInCart() {
        System.out.println("Enter the title of the media:");
        String title = scan.nextLine();
        Media media = cart.searchMedia(title);
        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else if (media != null) {
            System.out.println("Media is not playable.");
        } else {
            System.out.println("Media not found in cart.");
        }
    }

    public static void placeOrder() {
        System.out.println("Order placed successfully.");
        cart.empty();
    }

    private static int getValidChoice(int min, int max) {
        int choice = -1;
        while (choice < min || choice > max) {
            if (scan.hasNextInt()) {
                choice = scan.nextInt();
                scan.nextLine(); 
                if (choice < min || choice > max) {
                    System.out.println("Invalid choice. Please enter a number between " + min + " and " + max);
                }
            } else {
                System.out.println("Invalid input. Please enter a number between " + min + " and " + max);
                scan.nextLine(); 
            }
        }
        return choice;
    }

    private static void initStore() {
        store.addMedia(new Book("The Great Gatsby", "Classic", 15.99f));
        store.addMedia(new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 24.99f));
        store.addMedia(new CompactDisc("Thriller", "Pop", "Michael Jackson", "Michael Jackson", 42, 19.99f));
    }
}