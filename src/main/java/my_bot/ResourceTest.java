package my_bot;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static jdk.nashorn.internal.objects.NativeArray.forEach;
import static org.junit.jupiter.api.Assertions.*;

class ResourceTest {

    @Test
    void isFullSize(){
        Resource resource = new Resource();
        Assert.assertEquals(resource.Variants.size(), 2);
    }

    @Test
    void isContainDateAnswer(){
        Resource resource = new Resource();
        Assert.assertEquals(resource.Variants.containsKey(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\n"),
                true);
    }

    @Test
    void isNotContainDateRequest(){
        Resource resource = new Resource();
        Assert.assertEquals(resource.Variants.containsKey(""), false);
    }

}