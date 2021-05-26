package Part2;

public class Main {
    public static void main(String[] args) {
        Customer ainazik = new Customer("Ainazik", "Momunalieva","ainazik@gmail.com", "Bishkek");
        Cake cake1 = new Cake("Brauni", 20,400);
        Order firstOrder = new Order(ainazik, cake1);
        System.out.println(firstOrder.toString());

    }
}
