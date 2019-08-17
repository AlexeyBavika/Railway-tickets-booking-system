package service;

import model.service.AdminService;
import org.junit.Test;

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
        assertFalse(AdminService.getInstance().getAllUsers(1).isEmpty());
    }

    @Test
    public void getAllTrainShouldBeNotEmpty() {
        assertFalse(AdminService.getInstance().getAllTrains(1).isEmpty());
    }

    @Test
    public void getAllPricesShouldBeNotEmpty() {
        assertFalse(AdminService.getInstance().getAllPrices(1).isEmpty());
    }

    @Test
    public void getAllOrdersShouldBeEmpty() {
        assertTrue(AdminService.getInstance().getAllOrders(1).isEmpty());
    }

    @Test
    public void getAllChangeRoleRequestsShouldBeNotEmpty() {
        assertFalse(AdminService.getInstance().getAllChangeRoleRequests(1).isEmpty());
    }

}
