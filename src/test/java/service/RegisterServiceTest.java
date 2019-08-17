package service;

import model.service.PassengerService;
import model.service.RegisterService;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class RegisterServiceTest {
    @Test
    public void registerServiceInstanceShouldBeNotNull() {
        assertNotNull(RegisterService.getInstance());
    }

    @Test
    public void registerServiceCheckEmailAndPasswordShouldReturnFalse() {
        assertFalse(RegisterService.getInstance().checkIfExistsEmailOrPhone("bavikaalexey@gmail.com", "+380636587296"));
    }
}
