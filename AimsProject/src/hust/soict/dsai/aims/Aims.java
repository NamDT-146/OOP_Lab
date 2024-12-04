package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Book; 
import hust.soict.dsai.aims.store.Store;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store(); // Instance of Store
    private static Cart cart = new Cart();   // Instance of Cart

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            showMainMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> viewStore(scanner);
                case 2 -> updateStore(scanner);
                case 3 -> seeCurrentCart(scanner);
                case 0 -> System.out.println("Exiting AIMS... Goodbye!");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
    }

    private static void showMainMenu() {
        System.out.println("\nAIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number (0-1-2-3): ");
    }

    private static void viewStore(Scanner scanner) {
        int choice;
        do {
            System.out.println("\nStore: ");
            store.displayStore();
            System.out.println("--------------------------------");
            System.out.println("Options: ");
            System.out.println("1. See a media's details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("0. Back to main menu");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number (0-1-2-3): ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> seeMediaDetails(scanner);
                case 2 -> addMediaToCart(scanner);
                case 3 -> playMedia(scanner);
                case 0 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
    }

    private static void seeMediaDetails(Scanner scanner) {
        System.out.print("\nEnter media title: ");
        String title = scanner.nextLine();
        store.displayMediaDetails(title);
    }

    private static void addMediaToCart(Scanner scanner) {
        System.out.print("\nEnter media title to add to cart: ");
        String title = scanner.nextLine();
        if ( store.inStore(title) ) {
            cart.addMedia(store.getByTitle(title));
            System.out.println("Media added to cart.");
        } else {
            System.out.println("Media not found.");
        }
        System.out.println("Number of DVDs in cart: " + cart.getNumMedia());
    }

    private static void playMedia(Scanner scanner) {
        System.out.print("\nEnter media title to play: ");
        String title = scanner.nextLine();

        if ( store.inStore(title) ) {
            Media md = store.getByTitle(title);
            if (md instanceof Book){
                System.out.println("Cannot play");
            }
            else{
                if (md instanceof CompactDisc){
                    CompactDisc CD = (CompactDisc)md;
                    CD.play();
                } else if (md instanceof DigitalVideoDisc){
                    DigitalVideoDisc DVD = (DigitalVideoDisc)md;
                    DVD.play();
                } else System.out.println("Cannot Play");
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    private static void updateStore(Scanner scanner) {
        System.out.println("\nUpdate Store: ");
        System.out.println("1. Add a media");
        System.out.println("2. Remove a media");
        System.out.println("0. Back to main menu");
        System.out.print("Please choose a number (0-1-2): ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1 -> {
                System.out.print("Enter media title to add: ");
                System.out.print("Type: ");
                String type = scanner.nextLine();
                System.out.print("Title: ");
                String title = scanner.nextLine();
                if (type.equals( "CD" ))
                store.addMedia( new CompactDisc(title) );
                System.out.println("Media added to store.");
            }
            case 2 -> {
                System.out.print("Enter media title to remove: ");
                String title = scanner.nextLine();
                if (store.removeMedia(title)) {
                    System.out.println("Media removed from store.");
                } else {
                    System.out.println("Media not found in store.");
                }
            }
            case 0 -> System.out.println("Returning to main menu...");
            default -> System.out.println("Invalid choice! Please try again.");
        }
    }

    private static void seeCurrentCart(Scanner scanner) {
        int choice;
        do {
            System.out.println("\nCart: ");
            cart.displayItems();
            System.out.println("--------------------------------");
            System.out.println("Options: ");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Place order");
            System.out.println("0. Back to main menu");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number (0-1-2-3-4): ");
            int choice_2;
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> {
                        System.out.println("1. Filter By ID");
                        System.out.println("2. Filter By Title");
                        choice_2 = Integer.parseInt(scanner.nextLine());
                        switch (choice_2) {
                            case 1 -> {
                                System.out.println("Input ID");
                                int ID = Integer.parseInt(scanner.nextLine());
                                cart.displayByID(ID);
                                break;
                            }

                            case 2 -> {
                                System.out.println("Input Title");
                                String title = scanner.nextLine();
                                cart.displayByTitle(title);
                                break;
                            }
                        
                            default -> System.out.println("Invalid choice! Please try again.");
                        }
                        break;
                    }
                case 2 -> {
                    System.out.println("1. Sort By Title");
                    System.out.println("2. Sort By Cost");
                    choice_2 = Integer.parseInt(scanner.nextLine());
                    switch (choice_2) {
                        case 1 -> {
                            cart.SortByTitle();
                            cart.displayItems();
                            break;
                        }

                        case 2 -> {
                            cart.SortByCost();
                            cart.displayItems();
                            break;
                        }
                    
                        default -> System.out.println("Invalid choice! Please try again.");
                    }
                }

                case 3 -> {
                    System.out.print("Enter media title to remove: ");
                    String title = scanner.nextLine();
                    if (cart.removeMedia(title)) {
                        System.out.println("Media removed from cart.");
                    } else {
                        System.out.println("Media not found in cart.");
                    }
                }
                case 4 -> {

                }
                case 5 -> {
                    System.out.println("Order placed!");
                    cart.clearCart();
                }
                case 0 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
    }
}

    