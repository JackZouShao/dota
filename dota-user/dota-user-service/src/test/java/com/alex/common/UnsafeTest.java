package com.alex.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

@RunWith(JUnit4.class)
public class UnsafeTest {


	@Test
	public void testUnsafe() throws NoSuchFieldException, IllegalAccessException {
		System.out.println(getClass().getClassLoader());
//		Unsafe unsafe = Unsafe.getUnsafe();
		Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
		theUnsafe.setAccessible(true);
		Unsafe unsafe = (Unsafe) theUnsafe.get(null);
	}

}
