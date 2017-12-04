package zddteam.bookstore.util;

import java.util.UUID;

public class OrderUtil {
    public static String makeID(){
        return UUID.randomUUID().toString();
    }
}
