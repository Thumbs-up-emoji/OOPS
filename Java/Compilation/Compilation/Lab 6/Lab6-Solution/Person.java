public class Person {
    public String name;
    private int age;
    private String address;
    public static int num_of_people;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.address = "NOT SET";
        num_of_people++;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void birthday() {
        this.age++;
    }

    public int setAddress(String adr) {
        this.address = adr;
        return 1;
    }

    public String getAddress() {
        return this.address;
    }

    public String toString() {
        return "Hi! Welcome to OOP. \nI'm " + this.name + " and am " + this.age + " years old.";
    }
}
