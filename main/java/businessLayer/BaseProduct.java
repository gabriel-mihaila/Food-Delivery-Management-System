package businessLayer;

public class BaseProduct extends MenuItem{

    double rating;
    int calories;
    int protein;
    int fat;
    int sodium;
    int price;

    public BaseProduct(DeliveryService deliveryService, String title, double rating, int calories, int protein, int fat, int sodium, int price) {
        super(deliveryService, title);
        this.rating = rating;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.price = price;
    }

    @Override
    public int computePrice() {
        return this.price;
    }

    public double getRating() {
        return rating;
    }

    public int getCalories() {
        return calories;
    }

    public int getProtein() {
        return protein;
    }

    public int getFat() {
        return this.fat;
    }

    public int getSodium() {
        return this.sodium;
    }

    public int getPrice() {
        return price;
    }

}
