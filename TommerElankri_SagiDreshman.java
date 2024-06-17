// Tommer Elankri 211468921
// Sagi Dreshman 322283458
import java.util.Scanner;

public class TommerElankri_SagiDreshman {

    public static void addUser(boolean isBuyer)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name :  ");
        String personName = scanner.next();
        while (Seller.isExist(personName).getExist()) {
            System.out.print("this name is already in the store please enter new name : ");
            personName = scanner.next();
        }
        while (Buyer.isExist(personName).getExist()) {
            System.out.print("this name is already in the store please enter new name : ");
            personName = scanner.next();
        }
        System.out.print("Enter your Password :  ");
        String password = scanner.next();
        if(isBuyer)
        {
            System.out.print("Enter your Adress :");
            String address = scanner.next();
            Buyer newBuyer = new Buyer(personName, password, address);
            Buyer.addBuyer(newBuyer);
        }
        else {
            Seller newSeller = new Seller(personName, password);
            Seller.addSeller(newSeller);
        }


    }

    public static void runEbay()
    {
        Scanner scanner = new Scanner(System.in);
        int opp;
        boolean exit = false;
        do {
            System.out.println("Welcome to our store : \n" +
                    " to exit press 0 \n" +
                    " for create new seller press 1 \n " +
                    "for create new buyer press 2 \n" +
                    " for add arr1 to seller press 3 \n" +
                    " for add arr1 to seller press 4 \n" +
                    " for pay press 5 \n " +
                    "to show all the details buyers press 6 \n " +
                    "to show all the details of seller press 7 ");
            System.out.print("Enter your choose : ");
            opp = scanner.nextInt();
            switch (opp) {
                case (0): {
                    exit = true;
                    break;
                }
                case (1): {
                    addUser(false);
                    break;
                }
                case(2): {
                   addUser(true);
                   break;
                }
                case(3): {
                    Seller.addProductToSeller();
                    break;
                }
                case( 4): {
                    Buyer.addProductToBuyer();
                    break;
                }
                case(5): {
                    Buyer.finishOrder();
                    break;
                }
                case( 6): {
                    System.out.println("The list of the buyers is :  ");
                    Buyer.printListBuyers();
                    break;
                }
                case(7): {
                    System.out.println("The list of the sellers is :  ");
                    Seller.printListSellers();
                    break;
                } default:{
                    System.out.println("Invalid option, please try again.");
                    break;
                }
            }
        }while (!exit);
        System.out.println("Thank you for visiting in our shop. \n Have a good day :)");
    }

    public static void main(String[] args) {
        runEbay();
    }
}

