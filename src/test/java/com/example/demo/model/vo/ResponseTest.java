package com.example.demo.model.vo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.enumeration.ResponseEnum;

/**
 *
 * @author Phil
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResponseTest {

	@Test
	public void test() {
		// assert ("Success".equals(ResponseEnum.valueOf(1).stringValue()));
		Assert.assertEquals(ResponseEnum.valueOf(1).stringValue(), "Success");
	}

	@Test
	public void test2() {
		Response<String> response = new Response<>(ResponseEnum.SUCCESS, "haaaaaaaaaaaa");
		assert ("haaaaaaaaaaaa".equals(response.getData()));
	}
}
