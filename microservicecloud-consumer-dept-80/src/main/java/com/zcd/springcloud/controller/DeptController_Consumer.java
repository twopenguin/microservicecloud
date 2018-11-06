package com.zcd.springcloud.controller;

import com.zcd.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Administrator on 2018/11/6.
 */
@RestController
public class DeptController_Consumer {

    public static final String REST_URL_PREFIX = "http://localhost:8001";

    /**
     *
     使用RestTemplate 访问restful服务接口非常的方便无脑
     (url, requestMap, ResponseBean.class) 这三个参数分别代表
     REST 请求地址，请求参数，HTTP响应转换成的对象类型
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * add 操作
     * @param dept
     */
    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
    }

    /**
     * get 操作
     * @param id
     */
    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }

    /**
     * list 操作
     */
    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list" , List.class);
    }

}
