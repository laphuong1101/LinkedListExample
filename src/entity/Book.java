package entity;

import org.w3c.dom.ls.LSOutput;

public class Book {
    private String Id;
    private String Name;
    private int total;
    private double price;
    private String lender;
    private float value;

    public Book(String id, String name, int total, double price, String lender) {
        Id = id;
        Name = name;
        this.total = total;
        this.price = price;
        this.lender = lender;
        this.value = (float) (total * price);
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLender() {
        return lender;
    }

    public void setLender(String lender) {
        this.lender = lender;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                ", total=" + total +
                ", price=" + price +
                ", lender='" + lender + '\'' +
                ", value=" + value +
                '}';
    }
}
