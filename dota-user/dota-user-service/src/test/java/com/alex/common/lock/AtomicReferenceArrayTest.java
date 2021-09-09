package com.alex.common.lock;

import com.alex.common.jojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * @version 1.0.0
 * @className AtomicReferenceArrayTest.java
 * @author: yz
 * @date: 2021/9/9 10:02
 */
@RunWith(JUnit4.class)
public class AtomicReferenceArrayTest {

    @Test
    public void testAtomicReferenceArray(){
        AtomicReferenceArray<User> array = new AtomicReferenceArray(12);
        User user = array.get(1);
    }
}
