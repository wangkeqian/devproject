package com.example.api.api.api;

import com.example.api.api.entity.Car;
import com.example.api.api.entity.GoodsInfo;
import com.example.api.api.utils.HtmlParseCrawler;
import com.example.api.api.utils.RedisUtil;
import com.example.api.api.utils.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2019/12/4
 */
@RestController
@CrossOrigin
public class StudentApi {
    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/getAll")
    public List<Car> getInfo(){
        Map<Object, Object> carMap = redisUtil.hmget("car");
        ArrayList<Car> cars = new ArrayList<>();
        Collection<Object> values = carMap.values();
        Iterator<Object> iter = values.iterator() ;
        while(iter.hasNext())
        {
            Car car = (Car) iter.next();
            cars.add(car);
        }
        return cars;
    }
    @PostMapping("/add")
    public Car getInfo(@RequestBody Car carData) {
        LinkedHashMap<String, Car> linkedHashMap = new LinkedHashMap<>();
        carData.setId(UUID.randomUUID().toString());
        linkedHashMap.put(carData.getId(),carData);
        redisUtil.hmset("car",linkedHashMap);
        
        return carData;
    }
    @DeleteMapping("/del/{id}")
    public void del(@PathVariable("id") String id){
         redisUtil.hdel("car",id);
    }

    @GetMapping("/crawler/{keys}")
    public String crawlerPage(@PathVariable String keys){
        Map<String, List> map = new HashMap<>();
        List<GoodsInfo> collect = HtmlParseCrawler.parseJDLatch(keys)
                .stream()
                .filter(e -> !e.getName().isEmpty() )
                .collect(Collectors.toList());
        map.put(keys, collect);
        redisUtil.hmset("GoodsInfo",map);
        return "ok";
    }

    @GetMapping("/category/search")
    public ReturnT getCategoryData(String keys){

        List<GoodsInfo> goodsInfo = (List<GoodsInfo>) redisUtil.hget("GoodsInfo", keys);

        return new ReturnT(goodsInfo);
    }

}
