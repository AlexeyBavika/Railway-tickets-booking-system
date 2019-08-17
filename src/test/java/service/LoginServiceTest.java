package service;

import model.service.LoginService;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class LoginServiceTest {
    @Test
    public void loginServiceInstanceShouldBeNotNull() {
        assertNotNull(LoginService.getInstance());
    }
}
