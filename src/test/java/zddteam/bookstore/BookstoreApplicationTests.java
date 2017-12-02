package zddteam.bookstore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zddteam.bookstore.dao.BookRepository;

import java.io.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookstoreApplicationTests {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testCrud() {
        System.out.println(bookRepository.findAll());
    }

    @Test
    public void testImages() {

        try {
            FileInputStream inputStream = new FileInputStream(new File("D:\\Idea_work\\bookstore\\src\\main\\resources\\static\\images\\java思想.jpg"));
            InputStream in = new BufferedInputStream(inputStream);
            FileOutputStream outputStream = new FileOutputStream("D:\\Idea_work\\bookstore\\src\\main\\resources\\static\\images\\java思想1.jpg");
            byte temp[] = new byte[1024 * 8];
            int len;
            while ((len = in.read(temp)) != -1) {
                outputStream.write(temp, 0, len);
            }
            inputStream.close();
            in.close();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
