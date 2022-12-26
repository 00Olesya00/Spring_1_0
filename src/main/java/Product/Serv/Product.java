package Product.Serv;

public class Product {
    private int id;
    private String title;
    private float cost;

    public Product(int id, String title, float coast) {
        this.id = id;
        this.title = title;
        this.cost = coast;
    }

    @Override
    public String toString() {

        return "№:"+ id + " " + title +" - "+ String.format("%.2f",cost) + " рублей";
    }
}