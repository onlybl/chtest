package springboottest.changhong.practice.test.controller;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboottest.changhong.practice.test.pojo.DO.Cat;
import springboottest.changhong.practice.test.pojo.Dto.CatDto;
import springboottest.changhong.practice.test.service.CatsService;

import java.util.List;

/**
 * @Author: DoremiTiny
 * Create at: 2019/7/23 12:00
 */
@RestController
@RequestMapping("/cats")
@RequiredArgsConstructor
@Setter
public class CatsController {
    @Autowired
    private CatsService catsService;
    
    @GetMapping
    public List<Cat> getCats(){
        return catsService.getCats();
    }
    @PostMapping
    public void postCats(@RequestBody CatDto dto){
        catsService.add(dto);
    }

    @GetMapping("/{id}")
    public Cat getById(@PathVariable(required = true) long id){
        return catsService.getCatById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(required = true) long id){
        catsService.delete(id);
    }
}
