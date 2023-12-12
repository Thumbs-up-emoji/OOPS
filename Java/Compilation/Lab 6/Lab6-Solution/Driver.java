public class Driver {
    public static void main(String[] args) {
        Person p1 = new Person("Adam", 25);
        System.out.println(p1);

        BankAccount b1 = new BankAccount(p1, 1000);
        System.out.println(b1);

        BankAccount b2 = new BankAccount("Eve", 24, 2000);
        System.out.println(b2);

        b1.deposit(500);
        System.out.println(b1.getBalance());

        int ret = b2.withdraw(3000);
        if (ret == -1) {
            System.out.println("Withdrawal Failed");
        } else {
            System.out.println(b2.getBalance());
        }

        int ret2 = b2.withdraw(300);
        if (ret2 == -1) {
            System.out.println("Withdrawal Failed");
        } else {
            System.out.println(b2.getBalance());
        }

        int ret3 = b1.transfer(1000, b2);
        if (ret3 == -1) {
            System.out.println("Transfer Failed");
        } else {
            System.out.println(b1.getBalance());
            System.out.println(b2.getBalance());
        }

    }
}
