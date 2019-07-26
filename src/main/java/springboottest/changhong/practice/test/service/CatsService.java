package springboottest.changhong.practice.test.service;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboottest.changhong.practice.test.dao.CatMapper;
import springboottest.changhong.practice.test.pojo.DO.Cat;
import springboottest.changhong.practice.test.pojo.Dto.CatDto;
import springboottest.changhong.practice.test.provider.MockCatProvider;
import java.util.List;

/**
 * @Author: DoremiTiny
 * Create at: 2019/7/23 11:56
 */
@Service
@RequiredArgsConstructor
@Setter
public class CatsService {
    @Autowired
    private final MockCatProvider mockCatProvider;
    @Autowired
    private CatMapper catMapper;

    public void add(CatDto dto){
        mockCatProvider.add(dto);
    }
    public void delete(long id){
        mockCatProvider.delete(id);
    }
    public List<Cat> getCats(){
        return mockCatProvider.getCats();
    }
    public Cat getCatById(long id){
        return catMapper.selectByPrimaryKey(id);
    }
}
