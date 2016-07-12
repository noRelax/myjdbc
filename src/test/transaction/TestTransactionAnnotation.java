package test.transaction;

import org.dc.jdbc.core.ObjectProxy;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;

/**
 * 测试事务是否有效
 * Created by wyx on 2016/4/23.
 */
public class TestTransactionAnnotation {
	private static UserService userService;

	@BeforeClass
	public static void init() {
		userService = ObjectProxy.getInstance().getTarget(UserService.class);
	}

	@Test
	public void testSelectWithReadonlyTransaction() {
		try{
			Map<String, Object> userMap = userService.login();
			Assert.assertNotNull(userMap);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Test(expected = Exception.class)
	public void testInsertWithReadonlyTransaction() throws Exception {
		userService.register();
	}
}
