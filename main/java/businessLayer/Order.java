package businessLayer;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Order implements Serializable {

    private static int maxID;
    private int id;
    private int clientID;
    private LocalDateTime date;

    public Order(int clientID) {
        this.id = maxID++;
        this.clientID = clientID;
        this.date = this.determineDate();
    }

    public LocalDateTime determineDate()
    {
        LocalDateTime data;
        data = LocalDateTime.now();

        return data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientID, date.hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && clientID == order.clientID && Objects.equals(date, order.date);
    }

    public int getId() {
        return id;
    }

    public int getClientID() {
        return clientID;
    }

    public LocalDateTime getDate() {
        return date;
    }

}
