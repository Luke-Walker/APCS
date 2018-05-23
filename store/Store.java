public class Store {

    private double money = 0;

    public static void main(String[] args) {
        Store store = new Store();
        Merchandise apple = new Merchandise(store, 1, 1.5, "Apple", 10);
        Merchandise orange = new Merchandise(store, 1.2, 2, "Orange", 25);
        Merchandise tomato = new Merchandise(store, 2, 2.5, "Tomato", 15);

        System.out.println(apple.toString());
        System.out.println(orange.toString());
        apple.buy(1);
        System.out.println(apple.toString());
        System.out.println(store.getMoney());
        orange.sell(2);
        System.out.println(orange.toString());
        System.out.println(store.getMoney());
        tomato.discount(50);
        tomato.sell(3);
        System.out.println(tomato.toString());
        System.out.println(store.getMoney());
    }

    public double getMoney() {
        return money;
    }

    public void addMoney(double money) {
        this.money += money;
    }

    public void loseMoney(double money) {
        this.money -= money;
    }
}
