import com.booksystem.dao.BooksInfoDao;
import com.booksystem.po.BooksInfo;
import com.booksystem.service.ReaderOrderService;
import com.booksystem.vo.ResultInfo;
import org.junit.Test;

import java.util.List;

public class TestUser {

    @Test
    public void findAll() {
        BooksInfoDao booksInfoDao = new BooksInfoDao();
        List booksInfo =  booksInfoDao.findAll();
        System.out.println(booksInfo);
        List<BooksInfo> ComputerBooks = BooksInfoDao.findComputerBooks("计算机类");
    }



}
