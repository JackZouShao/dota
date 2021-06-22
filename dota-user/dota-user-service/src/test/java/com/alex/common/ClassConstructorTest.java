package com.alex.common;

import com.alex.common.jojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@RunWith(JUnit4.class)
public class ClassConstructorTest {


	@Test
	public void jdk8Con() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		Class<User> userClass = User.class;
		Constructor<User> constructor = userClass.getConstructor(String.class, Integer.class);
		final User zoy = constructor.newInstance("zoy", 22);
		System.out.println(zoy);
	}

	@Test
	public void jdk9Con() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		Class<User> userClass = User.class;
		Constructor<User> constructor = userClass.getDeclaredConstructor(String.class, Integer.class);
		final User zoy = constructor.newInstance("zoy", 22);
		System.out.println(zoy);
	}
}
