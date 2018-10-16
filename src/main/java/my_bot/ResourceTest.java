package my_bot;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;


class ResourceTest {

    @Test
    void isFullSize(){
        SimpleResource resource = new SimpleResource();
        Assert.assertEquals(resource.Variants.size(), 2);
    }

    @Test
    void isContainDateAnswer(){
        SimpleResource resource = new SimpleResource();
        Assert.assertEquals(resource.Variants.containsKey(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\n"),
                true);
    }

    @Test
    void isNotContainDateRequest(){
        SimpleResource resource = new SimpleResource();
        Assert.assertEquals(resource.Variants.containsKey(""), false);
    }

}