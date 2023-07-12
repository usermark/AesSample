package com.github.usermark.aessample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void aesEncrypt() {
        String result = AESBySunUtil.encrypt("Hello world", "C6DFE59F58353AEF73549370CD98F0A9");
        System.out.println(result);
        assertEquals("StB5b2z9qPuulJ7rt2V1hQ==", result);
        result = AESUtil.encrypt("Hello world", "C6DFE59F58353AEF73549370CD98F0A9"); // 每次結果都不同
        System.out.println(result);
        assertNotEquals("StB5b2z9qPuulJ7rt2V1hQ==", result);
    }
}