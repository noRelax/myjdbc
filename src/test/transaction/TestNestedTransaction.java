package test.transaction;

import org.dc.jdbc.config.JDBCConfig;
import org.dc.jdbc.core.proxy.JdbcServiceProxy;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestNestedTransaction {
	private static UserService userService;

    @BeforeClass
    public static void init() {
    	JDBCConfig.isPrintSqlLog = true;
    	userService=JdbcServiceProxy.getInstance().getTarget(UserService.class);
    }
    
    @Test
    public void testNestedTransaction() throws Exception {
       userService.updateName();
       userService.updateName();
       userService.updateName();
    }
}
