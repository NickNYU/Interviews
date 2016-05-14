package jUnit;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DemoTest {
	private Demo demo;
	
	@Before
	public void before() {
		demo = new Demo();
	}
	
	
	@Test
	public void testGetName() {
		assertEquals("this", demo.getName());
	}
	
	@After
	public void after() {
		demo = null;
	}

}
