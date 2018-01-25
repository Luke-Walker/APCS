public class Merchandise {

    private Store store;
    private double wholesale, retail;
    private String name;
    private int quantity;
    private boolean discounted;

    public Merchandise() {
    }

    public Merchandise(Store store, double wholesale, double retail, String name, int quantity) {
        this.store = store;
        this.wholesale = wholesale;
        this.retail = retail;
        this.name = name;
        this.quantity = quantity;
        discounted = false;
    }

    public void buy(int quantity) {
        this.quantity += quantity;
        store.loseMoney(wholesale*quantity);
    }

    public void sell(int quantity) {
        this.quantity -= quantity;
        store.addMoney(retail*quantity);
    }

    public void discount(double percent) {
        retail = retail*(percent/100);
        discounted = true;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return name + " | wholesale:" + wholesale + " | retail" + (discounted ? "(discounted):" : ":") + retail + " | quantity:" + quantity;
    }
}
