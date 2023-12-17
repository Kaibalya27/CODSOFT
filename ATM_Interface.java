import java.util.Scanner;

class BankAccount {
    protected double balance=1000;
}

class ATM {
    private BankAccount user;

    public ATM(BankAccount user) {
        this.user = user;
    }
    public void deposit(double amount) {
        user.balance += amount;
    }
    public double checkBalance() {
        return user.balance;
    }
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= user.balance) {
            user.balance -= amount;
            return true;
        } else {
            return false;
        }
    }
    public void displayOptions() {
        System.out.println("\nATM Options:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void processOption(int option) {
        Scanner scanner = new Scanner(System.in);

        switch (option) {
            case 1:
                System.out.println("Current Balance: $" + checkBalance());
                break;
            case 2:
                System.out.print("Enter amount: $");
                double depositAmount = scanner.nextDouble();
                deposit(depositAmount);
                System.out.println("Deposit successful. New Balance: $" + checkBalance());
                break;
            case 3:
                System.out.print("Enter amount: $");
                double withdrawalAmount = scanner.nextDouble();
                boolean success = withdraw(withdrawalAmount);

                if (success) {
                    System.out.println("Withdrawal successful. New Balance: $" + checkBalance());
                } else {
                    System.out.println("Invalid amount or insufficient funds. Withdrawal failed.");
                }
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }
    }
}

public class ATM_Interface {
    public static void main(String[] args) {
        BankAccount user = new BankAccount();
        ATM atm = new ATM(user);
        while (true) {
            atm.displayOptions();
            System.out.print("Choose an option (1-4): ");
            Scanner scanner = new Scanner(System.in);
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            int option = scanner.nextInt();
            atm.processOption(option);
        }

    }

}
