package service;

import model.entity.Route;
import model.service.PassengerService;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertNotNull;


public class PassengerServiceTest {

    @Test
    public void PassengerServiceGetInstanceShouldBeNotNull() {
        assertNotNull(PassengerService.getInstance());
    }

    @Test
    public void getAvailableRoutesShouldBeNotEmpty() {
        List<Route> availableRoutes = PassengerService.getInstance().getAvailableRoutes(new Date(), 1);
        assertFalse(availableRoutes.isEmpty());
    }

    @Test
    public void getAvailableTrainShouldBeNotEmpty() {
        assertFalse(PassengerService.getInstance().getAvailableTrains(1).isEmpty());
    }

    @Test
    public void getAvailablePriceShouldBeNotNull() {
        assertNotNull(PassengerService.getInstance().getAvailablePrice(1));
    }
}
