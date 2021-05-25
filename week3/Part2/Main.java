package Part2;

public class Main {
    public static void main(String[] args) {
        Customer ainazik = new Customer("Ainazik", "Momunalieva","ainazik@gmail.com", "Bishkek");
        Order myOrder = new Order(ainazik, new Cake("Brauni", 30, 1000, 2),
                new SoftDrinks("Snikers", true, false, 250, 250, 1));
        System.out.println(myOrder.getCheck());
    }
}
