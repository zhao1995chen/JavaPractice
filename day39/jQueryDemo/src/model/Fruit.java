package model;

public class Fruit {
    private String name;
    private String place;
    private int price;
    private String image;

    public Fruit(String name, String place, int price, String image) {
        this.name = name;
        this.place = place;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Fruit fruit = (Fruit) object;
        return price == fruit.price &&
                name.equals(fruit.name) &&
                java.util.Objects.equals(place, fruit.place) &&
                java.util.Objects.equals(image, fruit.image);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), name, place, price, image);
    }
}