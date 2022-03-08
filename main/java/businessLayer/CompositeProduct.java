package businessLayer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompositeProduct extends MenuItem{

    List<MenuItem> menuItems;

    public CompositeProduct(DeliveryService deliveryService, String title, List<MenuItem> items) {
        super(deliveryService, title);
        this.menuItems = items;
    }

    @Override
    public int computePrice() {
        int suma = 0;
        for(MenuItem item : menuItems)
            suma += item.computePrice();
        return suma;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

}
