package businessLayer;

import java.io.Serializable;
import java.util.stream.Stream;

public abstract class MenuItem implements Serializable {

    String title;

    public MenuItem(DeliveryService deliveryService, String title) {
        this.title = title;
        deliveryService.addMenu(Stream.of(this));
    }

    public abstract int computePrice();

    public String getTitle() {
        return title;
    }

}
