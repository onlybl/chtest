package springboottest.changhong.practice.test.pojo.DO;

import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * @Author: DoremiTiny
 * Create at: 2019/7/23 11:35
 */
@Data
@AllArgsConstructor(staticName = "of")
public class Cat{
    private long id;
    private String name;
    private int age;
}
