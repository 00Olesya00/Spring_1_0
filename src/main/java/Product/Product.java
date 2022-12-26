package Product;

public class Product {
    private int id;
    private String title;
    private double cost;

    public Product(int id, String title, double coast) {
        this.id = id;
        this.title = title;
        this.cost = coast;
    }

    @Override
    public String toString() {

        return "№:"+ id + " " + title +" - "+ String.format("%.2f",cost) + " рублей";
    }

    public int getId() {
        return id;
    }

}