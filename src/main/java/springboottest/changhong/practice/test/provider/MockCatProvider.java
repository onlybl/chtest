package springboottest.changhong.practice.test.provider;

import org.springframework.stereotype.Component;
import springboottest.changhong.practice.test.pojo.DO.Cat;
import springboottest.changhong.practice.test.pojo.Dto.CatDto;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DoremiTiny
 * Create at: 2019/7/23 11:42
 */
@Component
public class MockCatProvider {
    private List<Cat> mockCatStore;
    public MockCatProvider(){
        mockCatStore = new ArrayList<>();
        mockCatStore.add(Cat.of(1,"Deisi",6 ));
        mockCatStore.add(Cat.of(2,"Kitty",3 ));
        mockCatStore.add(Cat.of(3,"Mimi",5 ));
        mockCatStore.add(Cat.of(4,"Jiji",6 ));
        mockCatStore.add(Cat.of(5,"Kuci",9 ));
    }

    public List<Cat> getCats(){
        return mockCatStore;
    }

    public Cat findCatById(long id){
        for (Cat cat:mockCatStore){
            if (cat.getId() == id){
                return cat;
            }
        }
        return null;
    }

    public void add(CatDto dto){
        mockCatStore.add(Cat.of(dto.getId(),dto.getName() ,dto.getAge() ));
    }
    public void delete(long id){
        int idx = 0;
        for(;idx < mockCatStore.size();idx++){
            if(mockCatStore.get(idx).getId() == id){
                break;
            }
        }
        mockCatStore.remove(idx);
    }
}
