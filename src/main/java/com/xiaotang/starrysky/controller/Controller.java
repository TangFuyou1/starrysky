package com.xiaotang.starrysky.controller;

import com.xiaotang.starrysky.model.dao.Userdatadb;
import com.alibaba.fastjson.JSONObject;

import com.xiaotang.starrysky.model.db.UserDaoImp;
import org.springframework.http.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

/**
 * 文件名: Controller
 * 创建者: 友
 * 创建日期: 2020/10/21 17:19
 * 邮箱: 1738743304.com !
 * 描述: TODO
 */
@RestController
public class Controller {
    @Resource //自动装配
    private JdbcTemplate jdbcTemplate;//数据库实例


    /**
     * 查询所有用户信息
     * @return
     */
    @PostMapping("/findUserByAll")
    public List<Userdatadb> findUserByAll() {
       return  UserDaoImp.findUserByAll(jdbcTemplate);
    }

    /**
     * 查询一个用户
     * @param headers  请求信息
     * @param accout 用户账号
     * @return
     */
    @PostMapping("/findUserById")
    public Userdatadb findUserById(@RequestHeader Map<String, String> headers, @RequestBody() String accout)
    {
        if (UserDaoImp.findUserById(accout,jdbcTemplate)==null)
        {
            return new Userdatadb("空","空","空");
        }
        return UserDaoImp.findUserById(accout,jdbcTemplate);
    }
    /**
     * 添加用户
     * @param headers   请求信息
     * @param userdatadb 用户对象
     * @return
     */
    @PostMapping("/Adduser")
    public String Adduser(@RequestHeader Map<String, String> headers, @RequestBody() Userdatadb userdatadb)
    {

            //查询数据库是否存在 不为空就存在
         if(UserDaoImp.findUserById(userdatadb.getAccout(),jdbcTemplate)!=null)
         {
             return "用户已存在";
         }
        //Userdatadb userdatadb = new Userdatadb("tang","17628484731","`12345678");
        if (UserDaoImp.addUser(userdatadb,jdbcTemplate)>0) //返回执行数 大于0说明添加成功
        {
            return "添加成功";
        }
            return "添加失败";
    }

    /**
     * 修改用户
     * @param headers   请求信息
     * @param userdatadb 修改对象
     * @return
     */
    @PostMapping("/Update")
    public String Update(@RequestHeader Map<String, String> headers, @RequestBody() Userdatadb userdatadb)
    {
        if (UserDaoImp.updateUser(userdatadb,jdbcTemplate)>0) //返回执行数 大于0说明添加成功
        {
            return "修改成功";
        }
            return "修改失败";
    }

    /**
     * 删除用户
     * @param headers   请求信息
     * @param accout 删除对象的账号
     * @return
     */
    @PostMapping("/Delete")
    public String Delete(@RequestHeader Map<String, String> headers, @RequestBody() String accout)
    {
        if (UserDaoImp.deleteUser(accout,jdbcTemplate)>0) //返回执行数 大于0说明添加成功
        {
            return "删除成功";
        }
        return "删除失败";
    }

    /** 请求数据
     * @return
     */
    @RequestMapping(value = "/BalDetail", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> CreateIssueBalanceDetail() {

        //请求路径
        String url = "http://httpbin.hello-chen.cn:8520/anything";
        //使用Restemplate来发送HTTP请求
        RestTemplate restTemplate = new RestTemplate();
        //添加请求数据
        LinkedMultiValueMap<String, String> body = new LinkedMultiValueMap();
        //  TempHumi tempHumi = new TempHumi("23", "28.3", "53", "1", "2020-10-03");
        //设置请求header 为 APPLICATION_FORM_URLENCODED
        HttpHeaders headers = new HttpHeaders();
        body.set("","");

        headers.set("Authorization", "1234567890poiuytrewqasdfghjklmnb");
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);
        // 请求体，包括请求数据 body 和 请求头 headers
        HttpEntity httpEntity = new HttpEntity(body, headers);

        //使用 exchange 发送请求，以String的类型接收返回的数据
        //ps，我请求的数据，其返回是一个json

        ResponseEntity<String> req1  = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        JSONObject jsTemp = JSONObject.parseObject(req1.getBody()); //将字符串转成json数据
        System.out.println(jsTemp);

//        Postdata postdata = new Gson().fromJson(String.valueOf(jsTemp),Postdata.class);
//        System.out.println(postdata.getHeaders().get_$Accept145());

        return req1;
    }
    /**
     * 接收用户的注册信息
     *
     * @param headers 链接信息
     * @param userdatadb 对象数据
     * @return
     */
    @PostMapping("stHeaders")
    public Userdatadb listAllHeaders(@RequestHeader Map<String, String> headers, @RequestBody() Userdatadb userdatadb) {

        headers.forEach((key, value) -> {
            System.out.println(String.format("Header '%s' = %s", key, value));
        });
        System.out.println(userdatadb);
        System.out.println(headers);
        return userdatadb;
    }



}
