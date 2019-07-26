package test.springboottest.changhong.practice.test.junitdemo;

//import org.junit.Assert;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import springboottest.changhong.practice.test.junitdemo.CaicDemo;

import static org.junit.Assert.assertEquals;

/**
 * CaicDemo Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 26, 2019</pre>
 */
public class CaicDemoTest {
    private CaicDemo caicDemo = new CaicDemo();

    @Before
    public void before() throws Exception {
        System.out.println("方法测试开始");
    }

    @After
    public void after() throws Exception {
        System.out.println("方法测试结束");
    }

    /**
     * Method: add(int a, int b)
     */
    @Test
    public void testAdd() throws Exception {
//TODO: Test goes here...
        assertEquals(5, caicDemo.add(2, 3));
    }

    /**
     * Method: sub(int a, int b)
     */
    @Test
    public void testSub() throws Exception {
//TODO: Test goes here...
        assertEquals(1, caicDemo.sub(3, 2));
    }

    /**
     * Method: multi(int a, int b)
     */
    @Test
    public void testMulti() throws Exception {
//TODO: Test goes here...
        assertEquals(6, caicDemo.multi(3, 2));
    }

    /**
     * Method: div(double a, double b)
     */
    @Test
    public void testDiv() throws Exception {
//TODO: Test goes here...
        assertEquals(1.5, caicDemo.div(3.0, 2.0), 0.01);
    }

} 
