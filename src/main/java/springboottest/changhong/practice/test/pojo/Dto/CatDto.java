package springboottest.changhong.practice.test.pojo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: DoremiTiny
 * Create at: 2019/7/23 11:39
 */
@Data
@AllArgsConstructor(staticName = "of")
public class CatDto {
    private long id;
    private String name;
    private int age;
}
