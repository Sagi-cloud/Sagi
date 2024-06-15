// Tommer Elankri 211468921
// Sagi Dreshman 322283458
import java.util.Scanner;

public class TommerElankri_SagiDreshman {

    public static User[] validateArr(User[] arr1, int arrSize) {
        if (arrSize == arr1.length) {
            int newSize = arrSize * 2;
            newSize = Math.max(2, newSize);
            User[] temp = new User[newSize];
            for (int i = 0; i < arr1.length; i++) {
                temp[i] = arr1[i];
            }
            arr1 = temp;
        }
        return arr1;
    }

    public static boolean find(User[] arr1, String name, int size) {
        if (arr1[0] == null) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (arr1[i].getUser().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public static void printArr(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                System.out.println((i + 1) + ". " + arr[i]);
            }
        }

    }

    public static String[] addName(String[] arr1, String name, int size) {
        arr1[size] = name;
        return arr1;
    }
    public static String [] addPerson(Seller[] arr1, int arr1Size, Buyer[] arr2, Scanner scanner, int arr2Size)
    {
        System.out.print("Enter your name :  ");
        String personName = scanner.next();
        while (find(arr1, personName, arr1Size)) {
            System.out.print("this name is already in the store please enter new name : ");
            personName = scanner.next();
        }
        while (find(arr2, personName, arr2Size)) {
            System.out.print("this name is already in the store please enter new name : ");
            personName = scanner.next();
        }
        arr1 = validateArr(arr1, arr1Size);
        arr1 = addName(arr1, personName, arr1Size);
        System.out.println("The name added successfully\n");
        return arr1;

    }

    public static void addProductToSeller(Scanner scanner)
    {
        System.out.println("Enter the seller name :  ");
        String sellerName = scanner.next();
        System.out.println("Enter the Product Name :  ");
        String productName = scanner.next();
        System.out.println("Enter the Product price of the arr1 :  ");
        int productPrice = scanner.nextInt();
        System.out.println("Enter the category of the arr1 :  ");
        String category = scanner.next();
    }

    public static  void addProductToBuyer(Scanner scanner)
    {
        System.out.println("Enter the buyer name :  ");
        String buyerName = scanner.next();
        System.out.println("from who Seller you want to buy : ");
        String sellerName = scanner.next();
    }
    public static void runEbay()
    {
        Seller.getSellers()[0].g
        Scanner scanner = new Scanner(System.in);
        Seller[] sellers = new Seller[1];
        Buyer[] buyers = new Buyer[1];
        int sellersSize = 0;
        int buyersSize = 0;
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
                    sellers=addPerson(sellers, sellersSize,buyers,scanner,buyersSize);
                    sellersSize++;
                    break;
                }
                case(2): {
                    buyers = addPerson(buyers,buyersSize,sellers,scanner,sellersSize);
                    buyersSize++;
                    break;
                }
                case(3): {
                    addProductToSeller(scanner);
                    break;
                }
                case( 4): {
                    addProductToBuyer(scanner);
                    break;
                }
                case(5): {
                    System.out.println("enter the name of the buyer that you want to pay for :  ");
                    String buyerName = scanner.next();
                    break;
                }
                case( 6): {
                    System.out.println("The list of the buyers is :  ");
                    printArr(buyers);
                    break;
                }
                case(7): {
                    System.out.println("The list of the sellers is :  ");
                    printArr(sellers);
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

