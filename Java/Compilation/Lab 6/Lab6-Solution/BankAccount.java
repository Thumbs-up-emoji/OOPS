public class BankAccount {
    private Person owner;
    private int balance;
    private String logger;
    static final int MIN_BALANCE = 1000;
    private static int num_of_banks;

    public BankAccount(Person owner, int initialBal) 
    {
        this.owner = owner;
        this.balance = initialBal;
        num_of_banks++;
    }

    public BankAccount(String ownerName, int ownerAge, int initialBal) 
    {
        this.owner = new Person(ownerName, ownerAge);
        this.balance = initialBal;
        num_of_banks++;
    }

    public String getOwnerName() 
    {
        return owner.getName();
    }

    public int getOwnerAge() 
    {
        return owner.getAge();
    }

    public int getBalance() 
    {
        return this.balance;
    }

    public void deposit(int amount) 
    {
        balance += amount;
    }

    public int withdraw(int amount) 
    {
        if (balance - amount < this.MIN_BALANCE)
        {
            this.logger("Failed to withdraw");
            return -1;
        }
        balance -= amount;
        return 0;
    }

    public int transfer(int amount, BankAccount other) 
    {
        if (balance - amount < this.MIN_BALANCE) 
        {
            this.logger("Failed to transfer");
            return -1;
        }
        balance -= amount;
        other.deposit(amount);
        return 0;
    }

    private void logger(String lastAction) 
    {
        this.logger = lastAction;
    }

    public String toString() 
    {
        return "Hi, I am a BankAccount. My Owner is " + getOwnerName() + " who is " + getOwnerAge()
                + " years old and my current Balance is " + getBalance() + ".";
    }

    public static void aboutBank() 
    {
        System.out.println("Hello I am the Bank.\n" +
                "With an object of my type you can\n" +
                "   withdraw, deposit or transfer money.\n" +
                "Remember to keep minimum balance\n" +
                "   before making a transaction.");
    }
}
