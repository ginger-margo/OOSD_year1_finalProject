import java.util.*;
import java.io.*;

public class Driver {
    ArrayList<LeatherGoods> items;

    public Driver() {
        items = new ArrayList<LeatherGoods>();

        System.out.print("\f");

        if (readFromFile()) {
            System.out.println("System is populated with items");
        } else {
            System.out.println("There are no items in this system");
        }

        MainMenu();
        saveToFile();
    }

    // a method to save all data to a file (creted or recreated)
    public void saveToFile() {
        ObjectOutputStream fileOut;
        try {
            fileOut = new ObjectOutputStream(new FileOutputStream("items.dat"));
            for (LeatherGoods anItem : items) {
                fileOut.writeObject(anItem);
            }
            fileOut.close();
            System.out.println("All items have been saved");
        } catch (IOException e) {
            System.out.println("IO Error : " + e.getMessage());
        }
    }

    // a method to copy all information from a data file to a program
    public boolean readFromFile() {
        int index = 0;
        ObjectInputStream fileIn = null;
        LeatherGoods s;

        try {
            fileIn = new ObjectInputStream(new FileInputStream("items.dat"));
            System.out.println("Opened file successfully");
            s = (LeatherGoods) fileIn.readObject();
            index = 1;
            while (s != null) {
                items.add(s);
                s = (LeatherGoods) fileIn.readObject();
                index++;
            }
            fileIn.close();
            return true;
        } catch (IOException e) {
            if (index > 0) {
                return true;
            } else {
                System.out.println("Data file does not exist\n");
                return false;
            }
        }

        catch (ClassNotFoundException e) {
            System.out.println("Class Error : " + e.getMessage());
            // fileIn.close();
            return false;
        }
    }

    public void MainMenu() {
        Scanner scan = new Scanner(System.in);
        int menuOption = 0;

        // 2.1 display the menu
        do {
            do {
                // 2.2 ask the user to choose an option
                System.out.println("Ecco store - Stock Control System ");
                System.out.println("1. Customer Menu ");
                System.out.println("2. Staff Menu ");
                System.out.println("3. Exit ");

                try {
                    menuOption = scan.nextInt();
                } catch (InputMismatchException e) {
                    System.out.print("Please input a NUMBER between 1 and 3");
                }

                scan.nextLine();
                System.out.println("");

                // display an error if the number they input is not 1, 2 or 3
                if (menuOption != 1 && menuOption != 2 && menuOption != 3) {
                    System.out.println("An error has occured. Please input a number between 1 and 3 ");
                }

            } while (menuOption != 1 && menuOption != 2 && menuOption != 3);

            if (menuOption == 1) {
                CustomerMenu();
            } else if (menuOption == 2) {
                StaffMenu();
            }

        } while (menuOption != 3);
    }

    public void CustomerMenu() {
        Scanner scan = new Scanner(System.in);
        int menuOption = 0;

        // 2.1 display the menu
        do {
            do {
                // 2.2 ask the user to choose an option
                System.out.println("1. Display leather goods for sale ");
                System.out.println("2. Purchase one or more leather item ");
                System.out.println("3. Return item ");
                System.out.println("4. Exit customer menu ");

                try {
                    menuOption = scan.nextInt();
                } catch (InputMismatchException e) {
                    System.out.print("Please input a NUMBER between 1 and 4");
                }

                scan.nextLine();
                System.out.println("");

                // display an error if the number they input is not 1, 2 or 3 4
                if (menuOption != 1 && menuOption != 2 && menuOption != 3 && menuOption != 4) {
                    System.out.println("An error has occured. Please input a number between 1 and 4 ");
                }

            } while (menuOption != 1 && menuOption != 2 && menuOption != 3 && menuOption != 4);

            if (menuOption == 1) {
                displayItems();
            } else if (menuOption == 2) {
                purchaseItem();
            } else if (menuOption ==4){
                returnItem();
            }

        } while (menuOption != 4);
    }

    public void StaffMenu() {
        Scanner scan = new Scanner(System.in);
        int menuOption = 0;

        // 2.1 display the staff menu
        do {
            do {
                // 2.2 ask the user to choose an option
                System.out.println("1. Add a new type of shoes/bags to the stock list ");
                System.out.println("2. Display the details of the best-selling items ");
                System.out.println("3. Update stock with the delivery ");
                System.out.println("4. Exit staff menu ");

                try {
                    menuOption = scan.nextInt();
                } catch (InputMismatchException e) {
                    System.out.print("Please input a NUMBER between 1 and 4");
                }

                scan.nextLine();
                System.out.println("");

                // display an error if the number they input is not 1, 2 or 4
                if (menuOption != 1 && menuOption != 2 && menuOption != 3 && menuOption != 4) {
                    System.out.println("Please input a number between 1 and 4 ");
                }

            } while (menuOption != 1 && menuOption != 2 && menuOption != 3 && menuOption != 4);

            if (menuOption == 1) {
                PopulateList();
            } else if (menuOption == 2) {
                displayBestSellers();
            } else if (menuOption == 3) {
                updateStock();
            }

        } while (menuOption != 4);
    }

    public void PopulateList() {
        Scanner scan = new Scanner(System.in);
        LeatherGoods item;
        Bags bag1;
        Shoes shoes1;
        int amount, size, amountItems, code;
        String leather, color, bs, typeBag, fit;
        double price;

        int count = 0; // we don't need to input it, it is going to be 0 for everything at the
                       // beggining

        System.out.print("How many items would you like to enter? "); // so that they can add as much as they need
        amount = scan.nextInt();
        scan.nextLine();

        for (int i = 1; i <= amount; i++) {
            System.out.print("Is the item " + i + " a BAG (b) or SHOES (s)? ");
            bs = scan.nextLine();
            System.out.print("Please input TYPE OF LEATHER ");
            leather = scan.nextLine();
            System.out.print("Please input PRICE ");

            price = scan.nextDouble();
            scan.nextLine();
            System.out.print("Please input COLOR ");
            color = scan.nextLine();
            System.out.print("Please input AMOUNT OF ITEMS ");
            amountItems = scan.nextInt();
            scan.nextLine();
            System.out.print("Please input ITEM CODE ");
            code = scan.nextInt();
            scan.nextLine();

            if (bs.equalsIgnoreCase("b")) {
                System.out.print("What TYPE OF BAG is it (backpack, purse, handbag, shoulder bag? ");
                typeBag = scan.nextLine();

                bag1 = new Bags(leather, price, color, amountItems, count, code, typeBag);
                items.add(bag1);
                System.out.println("An item was added to stock");
            } else if (bs.equalsIgnoreCase("s")) {
                System.out.print("What is the SIZE ");
                size = scan.nextInt();
                scan.nextLine();

                System.out.print("What is the FIT (f - female, m - male) ");
                fit = scan.nextLine();

                shoes1 = new Shoes(leather, price, color, amountItems, count, code, size, fit);
                items.add(shoes1);
                System.out.println("An item was added to stock");
            } else {
                System.out.print("Incorrect input ");
            }
        }

    }

    public void displayItems() {
        System.out.println("Store catalogue ");

        for (LeatherGoods i : items)
            if (i instanceof Bags)
                System.out.println(i.toString());
        System.out.print(" ");

        for (LeatherGoods i : items)
            if (i instanceof Shoes)
                System.out.println(i.toString());
        System.out.print(" ");

    }

    public void purchaseItem() {

        Scanner scan = new Scanner(System.in);
        String reply, reply2;
        int code, amount, stock, count;
        boolean allGood = true;
        boolean found = false;

        String type, color, bagType, fit;
        int size;

        System.out.println("Thank you for your interest! Do you know the code of the item you would like to purchse? ");
        reply = scan.nextLine(); // add try-catch here

        // add do while in case they enter something dumb
        if (reply.equalsIgnoreCase("yes")) {
            System.out.println("That is perfect. Please enter the code ");
            code = scan.nextInt();
            scan.nextLine(); // add try-catch here

            for (LeatherGoods i : items) {
                if (i.getItemCode() == code) {
                    found = true;
                    System.out.println("Please check the information for the item with this code ");
                    System.out.println(i.toString());
                    System.out.print("Is this the item you were looking for?");
                    reply2 = scan.nextLine(); // add try-catch here
                    if (reply2.equalsIgnoreCase("yes")) {
                        System.out.print("Exelent");
                        do {
                            System.out.print("How many would you like to purchase? ");
                            amount = scan.nextInt();
                            scan.nextLine();

                            if (amount > i.getLeftInStock()) {
                                System.out.print("Unfortunately, there are not enought items in stock.");
                            }

                        } while (amount > i.getLeftInStock());

                        System.out.print("Congadulations! Purchace completed succesfully.");

                        // decrease amount of items in stock
                        stock = i.getLeftInStock();
                        i.setLeftInStock(stock-amount);
                        

                        // increase count
                        count = i.getCount();
                        i.setCount(count+amount);

                    } else if (reply2.equalsIgnoreCase("no")) {
                        System.out.print("No worries. We will be able to find an item by description");
                        allGood = false;
                    }

                }
            }
            if (!found) {
                allGood = false;
            }

        } else if (reply.equalsIgnoreCase("no")) {
            System.out.print("No worries. We will be able to find an item by description");
            allGood = false;
        }

        if (!allGood) {
            System.out.println("Please provide us with information below ");
            System.out.print("Is the item a pair of shoes or a bag? ");
            type = scan.nextLine();

            if (type.equalsIgnoreCase("bag")) {
                System.out.print("What is the color of the bag? ");
                color = scan.nextLine();
                System.out.print("What kind of bag is it? (backpack, purse, handbag, shoulder bag)");
                bagType = scan.nextLine();


                Bags b = null;
                for (LeatherGoods l : items) {
                    if (l instanceof Bags) {
                        b = (Bags) l;
                        if (l.getColor().equalsIgnoreCase(color) && b.getTypeOfBag().equalsIgnoreCase(bagType)) {
                            do {
                                System.out.print("How many would you like to purchase? ");
                                amount = scan.nextInt();
                                scan.nextLine();
    
                                if (amount > l.getLeftInStock()) {
                                    System.out.print("Unfortunately, there are not enought items in stock.");
                                }
    
                            } while (amount > l.getLeftInStock());
                            System.out.print("Congadulations! Purchace completed succesfully.");

                            // decrease amount of items in stock
                            stock = l.getLeftInStock();
                            l.setLeftInStock(stock-amount);
                            ;

                            // increase count
                            count = l.getCount();
                            l.setCount(count+amount);
                        } else {
                            System.out.print("Unfortunatelly, we do not sell this item");
                        }
                    }
                }
            } else if (type.equalsIgnoreCase("shoes")) {
                System.out.println("What color are the shoes? ");
                color = scan.nextLine();
                System.out.println("Are the shoes for women or men? (type women or men)");
                fit = scan.nextLine();
                System.out.println("What size are you looking for ");
                size = scan.nextInt();
                scan.nextLine();

                Shoes s = null;
                for (LeatherGoods l : items) {
                    if (l instanceof Shoes) {
                        s = (Shoes) l;
                        if (l.getColor().equalsIgnoreCase(color) && s.getFit().equalsIgnoreCase(fit)
                                && s.getSize() == size) {
                                    do {
                                        System.out.print("How many would you like to purchase? ");
                                        amount = scan.nextInt();
                                        scan.nextLine();
            
                                        if (amount > l.getLeftInStock()) {
                                            System.out.print("Unfortunately, there are not enought items in stock.");
                                        }
            
                                    } while (amount > l.getLeftInStock());
                            System.out.print("Congadulations! Purchace completed succesfully.");

                            // decrease amount of items in stock
                            stock = l.getLeftInStock();
                            l.setLeftInStock(stock-amount);
                            ;

                            // increase count
                            count = l.getCount();
                            l.setCount(count+amount);
                        }

                    }

                }

            } else {
                System.out.print("Unfortunatelly, we do not sell this item");
            }

        }

    }

    public void returnItem() {
        Scanner scan = new Scanner(System.in);
        int code, stock;
        boolean found;


        System.out.print("We are very sorry something went wrong");
        System.out.print("Could you please enter the shoe code (It can be found on the inside of the shoe");
        code = scan.nextInt(); scan.nextLine();

        for (LeatherGoods i : items) {
            if (i.getItemCode() == code){
                stock = i.getLeftInStock();
                i.setLeftInStock(stock++);
            } else{
                System.out.print("Sorry, unfortunately we do not sell that item anymore so we will not be able to take it back");
            } }

                
    }

    public void displayBestSellers() {
        int maxB = 0; // max value for bags
        int maxS = 0; // max value for shoes

        // find best selling bag - I decided to separate them so that there is a separate list of best selling shoes and bags
        Bags b = null;
        for (LeatherGoods i : items) {
            if (i instanceof Bags && i.getCount() > maxB) {
                maxB = i.getCount();
                b = (Bags) i; // store the information
            }
        }

        // find the best selling shoes
        Shoes s = null;
        for (LeatherGoods i : items) {
            if (i instanceof Shoes && i.getCount() > maxS) {
                maxS = i.getCount();
                s = (Shoes) i; // store the information
            }
        }

        // display information
        System.out.print("Our best selling bag is " + b.toString());
        System.out.print("Our best selling shoes are " + s.toString());
    }

    public void updateStock() {
        Scanner scan = new Scanner(System.in);
        int code, update, past;

        System.out.print("You have chosen to update stock");
        System.out.print("Please enter the code for an item that was delivered: ");
        code = scan.nextInt();
        scan.nextLine();

        for (LeatherGoods i : items) {
            if (i.getItemCode() == code) {
                System.out.println("The information for the item is below ");
                System.out.println(i.toString());

                System.out.println("How many itams would you like to add to stock? ");
                update = scan.nextInt();
                scan.nextLine();

                past = i.getLeftInStock(); // set past as what was in stock before delivery
                i.setLeftInStock(past + update); // set stock to past + delivery

            }
        }

    }

    public static void main(String[] args) {
        new Driver();
    }
}
