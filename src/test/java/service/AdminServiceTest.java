package service;

import model.entity.Route;
import model.service.AdminService;
import model.service.PassengerService;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class AdminServiceTest {

    @Test
    public void adminServiceInstanceShouldBeNotNull() {
        assertNotNull(AdminService.getInstance());
    }

    @Test
    public void getAllUsersShouldBeNotEmpty() {
        assertFalse(AdminService.getInstance().getAllUsers().isEmpty());
    }

    @Test
    public void getAllTrainShouldBeNotEmpty() {
        assertFalse(AdminService.getInstance().getAllTrains().isEmpty());
    }

    @Test
    public void getAllPricesShouldBeNotEmpty() {
        assertFalse(AdminService.getInstance().getAllPrices().isEmpty());
    }

    @Test
    public void getAllOrdersShouldBeEmpty() {
        assertTrue(AdminService.getInstance().getAllOrders().isEmpty());
    }

    @Test
    public void getAllChangeRoleRequestsShouldBeNotEmpty() {
        assertFalse(AdminService.getInstance().getAllChangeRoleRequests().isEmpty());
    }

}
