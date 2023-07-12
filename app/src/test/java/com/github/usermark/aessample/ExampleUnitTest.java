package com.github.usermark.aessample;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void aesEncrypt() {
        String result = AESUtil.encrypt("Hello world", "C6DFE59F58353AEF73549370CD98F0A9");
        assertEquals("StB5b2z9qPuulJ7rt2V1hQ==", result);
    }
}