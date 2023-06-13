package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

import java.util.Scanner;

public class Aims {
    private static Store store = new Store();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            showMenu();
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (option) {
                case 1:
                    viewStore(scanner);
                    break;
                case 2:
                    updateStore(scanner);
                    break;
                case 3:
                    viewCurrentCart(scanner);
                    break;
                case 0:
                    System.out.println("Exiting AIMS...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose a number from the menu.");
                    break;
            }
        }
    }

    public static void showMenu() {
        System.out.println("AIMS:");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void viewStore(Scanner scanner) {
        store.displayStore();

        while (true) {
            storeMenu();
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (option) {
                case 1:
                    seeMediaDetails(scanner);
                    break;
                case 2:
                    addMediaToCart(scanner);
                    break;
                case 3:
                    playMedia(scanner);
                    break;
                case 4:
                    viewCurrentCart(scanner);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please choose a number from the menu.");
                    break;
            }
        }
    }

    public static void storeMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void seeMediaDetails(Scanner scanner) {
        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();

        Media media = store.search(title);
        if (media != null) {
            media.toString();

            while (true) {
                mediaDetailsMenu();
                int option = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (option) {
                    case 1:
                        store.addToCart(media);
                        System.out.println("The media has been added to the cart.");
                        return;
                    case 2:
                        if (media instanceof Playable) {
                            ((Playable) media).play();
                        } else {
                            System.out.println("This media cannot be played.");
                        }
                        return;
                    case 0:
                        return;
                    default:
                        System.out.println("Invalid option. Please choose a number from the menu.");
                        break;
                }
            }
        } else {
            System.out.println("No media found with the given title.");
        }
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void addMediaToCart(Scanner scanner) {
        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();

        Media media = store.search(title);
        if (media != null) {
            store.addToCart(media);
            System.out.println("The media has been added to the cart.");
        } else {
            System.out.println("No media found with the given title.");
        }
    }

    public static void playMedia(Scanner scanner) {
        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();

        Media media = store.search(title);
        if (media != null) {
            if (media instanceof Playable) {
                ((Playable) media).play();
            } else {
                System.out.println("This media cannot be played.");
            }
        } else {
            System.out.println("No media found with the given title.");
        }
    }

    public static void updateStore(Scanner scanner) {
        while (true) {
            updateStoreMenu();
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (option) {
                case 1:
                    addMediaToStore(scanner);
                    break;
                case 2:
                    removeMediaFromStore(scanner);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please choose a number from the menu.");
                    break;
            }
        }
    }

    public static void updateStoreMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Add a media to store");
        System.out.println("2. Remove a media from store");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void addMediaToStore(Scanner scanner) {
        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();

        System.out.println("Enter the cost of the media:");
        float cost = scanner.nextFloat();
        scanner.nextLine(); // Consume newline character

        System.out.println("Enter the category of the media:");
        String category = scanner.nextLine();

        if (category.equalsIgnoreCase("book")) {
            System.out.println("Enter the author of the book:");
            String author = scanner.nextLine();

            Book book = new Book();
            book.addAuthor(author);
            store.addMedia(book);
            System.out.println("The book has been added to the store.");
        } else if (category.equalsIgnoreCase("cd")) {

            CompactDisc cd = new CompactDisc();
            store.addMedia(cd);
            System.out.println("The CD has been added to the store.");
        } else if (category.equalsIgnoreCase("dvd")) {
            System.out.println("Enter the director of the DVD:");
            String director = scanner.nextLine();

            System.out.println("Enter the length of the DVD:");
            int length = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
            store.addMedia(dvd);
            System.out.println("The DVD has been added to the store.");
        } else {
            System.out.println("Invalid category. Media cannot be added to the store.");
        }
    }

    public static void removeMediaFromStore(Scanner scanner) {
        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();

        Media media = store.search(title);
        if (media != null) {
            store.removeMedia(media);
            System.out.println("The media has been removed from the store.");
        } else {
            System.out.println("No media found with the given title.");
        }
    }

    public static void viewCurrentCart(Scanner scanner) {
        store.displayCart();

        while (true) {
            cartMenu();
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (option) {
                case 1:
                    filterMediasInCart(scanner);
                    break;
                case 2:
                    sortMediasInCart(scanner);
                    break;
                case 3:
                    removeMediaFromCart(scanner);
                    break;
                case 4:
                    playMediaFromCart(scanner);
                    break;
                case 5:
                    placeOrder();
                    return;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please choose a number from the menu.");
                    break;
            }
        }
    }

    public static void cartMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void filterMediasInCart(Scanner scanner) {
        while (true) {
            filterMenu();
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (option) {
                case 1:
                    filterMediasById(scanner);
                    return;
                case 2:
                    filterMediasByTitle(scanner);
                    return;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please choose a number from the menu.");
                    break;
            }
        }
    }

    public static void filterMenu() {
        System.out.println("Filter options:");
        System.out.println("--------------------------------");
        System.out.println("1. Filter by id");
        System.out.println("2. Filter by title");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void filterMediasById(Scanner scanner) {
        System.out.println("Enter the id of the media:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        store.filterCartById(id);
    }

    public static void filterMediasByTitle(Scanner scanner) {
        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();

        store.filterCartByTitle(title);
    }

    public static void sortMediasInCart(Scanner scanner) {
        while (true) {
            sortMenu();
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (option) {
                case 1:
                    sortMediasByTitle(scanner);
                    return;
                case 2:
                    sortMediasByCost(scanner);
                    return;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please choose a number from the menu.");
                    break;
            }
        }
    }

    public static void sortMenu() {
        System.out.println("Sort options:");
        System.out.println("--------------------------------");
        System.out.println("1. Sort by title");
        System.out.println("2. Sort by cost");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void sortMediasByTitle(Scanner scanner) {
        store.sortCartByTitle();
    }

    public static void sortMediasByCost(Scanner scanner) {
        store.sortCartByCost();
    }

    public static void removeMediaFromCart(Scanner scanner) {
        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();

        Media media = store.searchCart(title);
        if (media != null) {
            store.removeFromCart(media);
            System.out.println("The media has been removed from the cart.");
        } else {
            System.out.println("No media found with the given title in the cart.");
        }
    }

    public static void playMediaFromCart(Scanner scanner) {
        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();

        Media media = store.searchCart(title);
        if (media != null) {
            if (media instanceof Playable) {
                ((Playable) media).play();
            } else {
                System.out.println("This media cannot be played.");
            }
        } else {
            System.out.println("No media found with the given title in the cart.");
        }
    }

    public static void placeOrder() {
        store.placeOrder();
        System.out.println("An order has been created. The current cart has been emptied.");
    }
}

