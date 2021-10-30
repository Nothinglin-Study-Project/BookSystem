
import com.booksystem.util.DBUtil;
import org.junit.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;


/**
 * 测试数据库连接是否成功,单元测试方法
 */
public class TestDB {

    // ①使用日志工厂类，记录日志,我们要测试记录的内容在TestDB.class文件中，所以获取对应文件的内容，进行日志记录
//    private Logger logger = LoggerFactory.getLogger(TestDB.class);


    /**
     * 单元测试方法
     * 1、方法的返回值，建议使用void，一般没有返回值
     * 2、参数列表，建议为空参，一般是没有参数的
     * 3、方法上需要设置@Test注解，不然就不能单独运行
     * 4、每个方法都能独立运行
     */

    @Test
    public void testDB() {
        //这里的DBUtil.getConnection()就是数据库的驱动连接，我们使用Junit进行单元测试，如果成功的话就绿色，不能成功连接数据库的话就是红色
        System.out.println(DBUtil.getConnection());

    }
}
