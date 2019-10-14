package service;

import model.entity.User;
import model.service.AdminService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.*;
import static org.mockito.Mockito.*;

import org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AdminServiceTest {

    @Mock
    AdminService adminService;

    @Before
    public void init() {
        adminService = spy(AdminService.getInstance());
    }

    @Test
    public void getAllUsers() {
        List<User> users = new ArrayList<>();
        User user1 = new User("Alexey", "Bavyka", "bavikalexey@yabdex.ua", "123", "+380636587297", 3);
        User user2 = new User("Alexey", "Alex", "bavikalexey@yandex.ua", "123", "+380634587297", 3);
        users.add(user1);
        users.add(user2);

        when(adminService.getAllUsers(1)).thenReturn(users);
        assertEquals(users, adminService.getAllUsers(1));
    }

}
