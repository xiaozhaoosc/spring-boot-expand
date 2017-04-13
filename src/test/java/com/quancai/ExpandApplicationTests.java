package com.quancai;

import com.quancai.utils.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExpandApplicationTests {

	@Test
	public void contextLoads() {
		String dateStr = DateUtils.getCertainDate(-8);
		System.out.println(dateStr);
	}

}
