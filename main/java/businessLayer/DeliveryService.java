package businessLayer;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The type Delivery service.
 */
public class DeliveryService extends Observable implements IDeliveryServiceProcessing, Serializable {

    private ArrayList<Account> accounts;
    private ArrayList<MenuItem> menu;
    private Map<Order, List<MenuItem>> orders;

    /**
     * Instantiates a new Delivery service.
     */
    public DeliveryService() {
        this.accounts = new ArrayList<>();
        this.menu = new ArrayList<>();
        this.orders = new HashMap<>();
    }

    /**
     * Gets orders.
     *
     * @return the orders
     */
    public Map<Order, List<MenuItem>> getOrders() {
        return orders;
    }

    /**
     * Add order.
     *
     * @param order the order
     * @param items the items
     */
    public void addOrder(Order order, List<MenuItem> items) {
        orders.put(order, items);
    }

    /**
     * Add account.
     *
     * @param source the source
     */
    public void addAccount(Stream<Account> source)
    {
        assert(this.accounts.size() < 50);
        source.collect(Collectors.toCollection(() -> this.accounts));
        assert(this.accounts.size() < 51);
    }

    /**
     * Add menu.
     *
     * @param source the source
     */
    public void addMenu(Stream<MenuItem> source)
    {
        assert(menu.isEmpty());
        MenuItem item2 = source.findAny().get();
        String title = item2.getTitle();
        AtomicBoolean add = new AtomicBoolean(true);
        menu.stream()
                .filter(item -> item.getTitle().equals(title))
                .findAny()
                .ifPresent(item -> add.set(false));
        if(add.get())
            menu.add(item2);
        assert(menu.isEmpty());
    }

    /**
     * To display list.
     *
     * @param items the items
     * @return the list
     */
    public List<MenuItem> toDisplay(List<MenuItem> items) {

        int value, replacement;
        List<MenuItem> result = new ArrayList<>();

        for(MenuItem item : items) {
            if(item instanceof BaseProduct)
                result.add(item);
        }

        for(MenuItem item : items) {
            if(item instanceof CompositeProduct) {
                result.add(item);
                result.addAll(toDisplay(((CompositeProduct)item).getMenuItems()));
                result.add(null);
            }
        }

        return result;

    }

    /**
     * Send info.
     *
     * @param listed the listed
     */
    public void sendInfo(List<MenuItem> listed) {
        setChanged();
        notifyObservers(listed);
        System.out.println("SENT " + listed.size());
    }

    /**
     * From name menu item.
     *
     * @param name the name
     * @return the menu item
     */
    public MenuItem fromName(String name) {
        return menu.stream().filter(item -> item.getTitle().equals(name)).findAny().get();
    }

    /**
     * Remove menu.
     *
     * @param source the source
     */
    public void removeMenu(MenuItem source) {
        menu.remove(source);
    }

    /**
     * Gets menu.
     *
     * @return the menu
     */
    public ArrayList<MenuItem> getMenu() {
        return menu;
    }

    /**
     * Gets accounts.
     *
     * @return the accounts
     */
    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    /**
     * Sets accounts.
     *
     * @param accounts the accounts
     */
    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }
}
