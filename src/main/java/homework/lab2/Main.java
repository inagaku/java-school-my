package homework.lab2;



public class Main {
    public static void main(String[] args) {
        Client client = Client.build()
                .setDebt(10)
                .setBonus(100)
                .setName("Max")
                .setSalary(1000)
                .clientBuild();

        System.out.println(client.toString());
    }
}