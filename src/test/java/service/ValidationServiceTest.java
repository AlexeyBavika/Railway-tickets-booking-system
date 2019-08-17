package service;

import model.service.ValidationService;
import org.junit.Ignore;
import org.junit.Test;

import javax.validation.Valid;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class ValidationServiceTest {
    @Test
    public void validationServiceInstanceShouldBeNotNull() {
        assertNotNull(ValidationService.getInstance());
    }

    @Ignore
    @Test
    public void isNameUAValidShouldReturnTrue() {
        assertTrue(ValidationService.isUANameValid("\\u0410\\u043b\\u0435\\u043a\\u0441\\u0435\\u0439"));
    }

    @Ignore
    @Test
    public void isNameRUValidShouldReturnTrue() {
        assertTrue(ValidationService.isRUNameValid("Алексей"));
    }

    @Test
    public void isNameENValidShouldReturnTrue() {
        assertTrue(ValidationService.isENNameValid("Alexey"));
    }

    @Test
    public void isEmailValidShouldReturnTrue() {
        assertTrue(ValidationService.isEmailValid("testemail@yandex.ua"));
    }

    @Test
    public void isPhoneValidShouldReturnTrue() {
        assertTrue(ValidationService.isPhoneValid("+380987654321"));
    }
}
