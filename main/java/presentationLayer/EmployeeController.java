package presentationLayer;

import businessLayer.BaseProduct;
import businessLayer.MenuItem;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Collectors;

public class EmployeeController implements Observer {

    ViewEmployee view;

    public EmployeeController(ViewEmployee view) {

        this.view = view;
        view.getDeliveryService().addObserver(this);

    }

    @Override
    public void update(Observable o, Object arg) {
        List<MenuItem> listed = (List<MenuItem>) arg;
        System.out.println("RECEIVED + " + listed.size());
        view.getEmployeePane1()
                .setText(view.getDeliveryService().toDisplay(listed)
                        .stream().filter(item -> item instanceof BaseProduct).map(item -> (BaseProduct) item)
                        .map(MenuItem::getTitle).collect(Collectors.joining(",")));
    }
}
