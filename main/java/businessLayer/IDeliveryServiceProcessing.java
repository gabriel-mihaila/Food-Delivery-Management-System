package businessLayer;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The interface Delivery service processing.
 */
public interface IDeliveryServiceProcessing extends Serializable {

    /**
     * Add order.
     *
     * @param order the order
     * @param items the items
     */
    public void addOrder(Order order, List<MenuItem> items);

    /**
     * Add account.
     *
     * @param source the source
     */
    public void addAccount(Stream<Account> source);

    /**
     * Add menu.
     *
     * @pre menu.isEmpty()
     * @param source the source
     * @post menu.isEmpty()
     */
    public void addMenu(Stream<MenuItem> source);

    /**
     * Remove menu.
     *
     * @param source the source
     */
    public void removeMenu(MenuItem source);

    /**
     * To display list.
     *
     * @param items the items
     * @return the list
     */
    public List<MenuItem> toDisplay(List<MenuItem> items);
}
