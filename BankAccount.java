import java.util.*;
class BankDetails {
    private static int accountNumberCounter = 1000;
    private String Acc_no;
    private String Name;
    private String Acc_type;
    private long Balance;
    Scanner sc = new Scanner (System.in);
    // Constructor to generate unique account number
    public BankDetails() { 
        this.Acc_no = "ACC" + accountNumberCounter++; 
    }

    // method to open new account
    public void openAccount() {
        System.out.print("Your Account no: " + Acc_no);
        System.out.print("Enter Account type.: ");
        Acc_type = sc.next();
        System.out.print("Enter Name.: ");
        Name = sc.next();
        System.out.print("Enter Balance.: ");
        Balance = sc.nextLong();
    }
    // method to display account details
    public void showAccount() {
        System.out.print("name of Acount holder: " + Name);
        System.out.print("Account N0.: " + Acc_type);
        System.out.print("Emter balance: " + Balance);
    }
    // Method to deposit money
    public void deposit () {
        long amount;
        System.out.println("Enter the amopunt of money you want to deposit");
        amount = sc.nextLong();

        Balance = Balance+amount;
    }
    // Method to withdraw amount
    public void withdraw() {
        long amount;
        System.out.println("Enter the amount you want to withdraw: ");
        amount = sc.nextLong();
        if (Balance >= amount) {
            Balance = Balance - amount;
            System.out.println("Balance after withdrawl: " + Balance);
        } else {
            System.out.println("your balance is insufficient" + "transaction is failed");
        }
    }
    // method to searcth an account number
    public boolean search(String Acc_no) {
        if (Acc_no.equals(Acc_no)) {
            showAccount();
            return true;
        } else {
            return false;
        }
    }
}
    public class BankAccount {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            // create initial accounts
            System.out.print("No. of customers you want to input");
            int n = sc.nextInt();
            BankDetails C[] = new BankDetails[n];
            for (int i = 0; i < C.length; i++) {
                C[i] = new BankDetails();
                C[i].openAccount();
            }
            // loop runs until 5 is pressed
            int pr;
            do {
                System.out.println(
                    "1. Display all account details\n 2. search account number\n 3. Deposit the amount\n3. Deposit the amount\n 4. withdraw the amount");
                System.out.println("Enter your choice");
                pr = sc.nextInt();
                switch (pr) {
                    case 1:
                        for (int i = 0; i < C.length; i++) {
                              C[i].showAccount();
                        }
                        break;
                    case 2: 
                        System.out.print("Enter Account No. you want ton search");
                        String Acc_no = sc.next();
                        boolean found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i]. search(Acc_no);
                            if (found) {
                                break;
                            }
                            if(!found) {
                               System.out.println("search failed! Account doesn't exist");
                            }
                            break;
                        }
                    case 3:
                        System.out.print("Enter Account No : ");
                        Acc_no = sc.next();
                        found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].search(Acc_no);
                            if (found) {
                                C[i]. deposit();
                                break;
                            }
                            if (!found) {
                                System.out.println("search failed! account doesn't exist");
                            }
                            break;
                        }
                    case 4:
                        System.out.print("Enter Account No.: ");
                        Acc_no = sc.next();
                        found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].search(Acc_no);
                            if (found) {
                                C[i].withdraw();
                                break;
                            }
                            if (!found) {
                                System.out.println("search failed! Account doesn't exist");
                            }
                            break;
                        }
                    case 5:
                        System.out.println("See you soon...");
                        break;
                    default: System.out.println("a");
                }
                //default: System.out.println("a");
            }
            while (pr != 5) ;
        }
    }