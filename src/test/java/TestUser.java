import com.booksystem.dao.BooksInfoDao;
import com.booksystem.po.BooksInfo;
import org.junit.Test;

import java.util.List;

public class TestUser {

    @Test
    public void findAll() {
        BooksInfoDao booksInfoDao = new BooksInfoDao();
        List booksInfo =  booksInfoDao.findAll();
        System.out.println(booksInfo);
    }
}
