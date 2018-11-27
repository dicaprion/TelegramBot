package TelegramBot;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class UsersBaseTest {

    @Test
    void isContains() {
        UsersBase base = new UsersBase();
        Assert.assertEquals(base.isContains(56651950), true);
    }

    @Test
    void AddNewUser() throws FileNotFoundException {
        UsersBase base = new UsersBase();
        base.AddNewUser(56651950);
        Assert.assertEquals(base.isContains(56651950), true);
    }

    @Test
    void isNewUser() throws FileNotFoundException {
        UsersBase base = new UsersBase();
        base.IsNewUser(56651950);
        Assert.assertEquals(base.isContains(56651950), true);
    }

    @Test
    void getUserById() {
        UsersBase base = new UsersBase();
        User user = base.GetUserById(56651950);
        Assert.assertEquals(user.GetName(), null);
    }
}