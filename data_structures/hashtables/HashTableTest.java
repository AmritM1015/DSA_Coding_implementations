package data_structures.hashtables;

import java.util.Scanner;

public class HashTableTest {
    public static void main(String[] args)
    {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Direct Addressing Table Test\n\n");
            
            /* Make object of DirectAddressingTable */
            DirectAddressTable dat = new DirectAddressTable();
            
            char ch;
            /*  Perform DirectAddressingTable operations  */
            do
            {
                System.out.println("\nDirect Addressing Table Operations\n");
                System.out.println("1. insert ");
                System.out.println("2. remove");
                System.out.println("3. get");
                System.out.println("4. clear");
                
                
                int choice = scan.nextInt();
                switch (choice)
                {
                    case 1 -> {
                        System.out.println("Enter int key and string value");
                        dat.insert( scan.nextInt(), scan.next() );
                    }
                    case 2 -> {
                        System.out.println("Enter int key");
                        dat.delete( scan.nextInt() );
                    }
                    case 3 -> {
                        System.out.println("Enter int key");
                        System.out.println("Value = "+ dat.get( scan.nextInt() ));
                    }
                    case 4 -> {
                        dat.clear();
                        System.out.println("Direct Addressing Table Cleared\n");
                    }
                    default -> System.out.println("Wrong Entry \n ");
                }
                /* Display hash table */
                dat.printTable();
                
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            } while (ch == 'Y'|| ch == 'y');
        } catch (Error error){
            System.err.println("An error has occured: "+error.getMessage());
        }
    }
}
