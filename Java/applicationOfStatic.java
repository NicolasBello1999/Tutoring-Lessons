package Java;
import java.util.Random;

// Program description
/* This program will demonstrate the use case of the static keyword and more in-depth analysis of the keyword. */

public class applicationOfStatic {
    public static void main(String[] args) {
        Random rand = new Random();
        Bank[] chaseBank = new Bank[5]; // an array of bank objects 

        for (int i = 0; i < chaseBank.length; i++) {
            chaseBank[i] = new Bank(10000 * rand.nextInt(10) + rand.nextInt(1000)); // create a new object and add it to the array
            System.out.printf("Chase bank [%d] has $%d in its balance.\n", i + 1, chaseBank[i].getBalance());
        }

        Bank.printSystemBalance(); // prints the system balance, notice that we are NOT using an object but instead calling the method through the class itself
    }
}

class Bank {
    private int balance = 0; // attribute/data member/field
    private static int systemBalance = 0; // class variable

    public Bank(int cash) {
        this.balance += cash; // adds cash to the instance of the class and stores it in the field
        Bank.systemBalance += cash; // adds cash from all instances of the class to the class variable so we are able to get the total sum of all instances balance
    }

    public int getBalance() { return this.balance; } // returns the instances' current balance

    // this is a static method meaning that we are able to access this through the class not through an object (an instance of the class Bank)
    public static void printSystemBalance() {
        System.out.printf("The current total amount of money in the bank system is: $%d\n", systemBalance);
    }
}
