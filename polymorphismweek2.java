// Base class
class BankAccount {
    double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    double calculateInterest() {
        return 0.0; // Default implementation
    }
}

// Subclass 1: SavingsAccount
class SavingsAccount extends BankAccount {
    SavingsAccount(double balance) {
        super(balance);
    }

    @Override
    double calculateInterest() {
        return balance * 0.04;
    }
}

// Subclass 2: CurrentAccount
class CurrentAccount extends BankAccount {
    CurrentAccount(double balance) {
        super(balance);
    }

    @Override
    double calculateInterest() {
        return 0.0; // No interest
    }
}

// Main class to demonstrate polymorphism
public class PolymorphismDemo {
    public static void main(String[] args) {
        // Create objects using the base class reference
        BankAccount[] accounts = {
            new SavingsAccount(10000),
            new CurrentAccount(10000)
        };

        // Call calculateInterest() polymorphically
        for (BankAccount account : accounts) {
            System.out.println(account.getClass().getSimpleName() +
                               " Interest: $" + account.calculateInterest());
        }
    }
}
