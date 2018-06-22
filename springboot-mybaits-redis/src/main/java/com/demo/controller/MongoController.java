package com.demo.controller;

import com.demo.dao.UserInfoRepository;
import com.demo.entity.UserInfo;
import com.mongodb.DB;
import com.mongodb.client.MongoDatabase;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

/**
 * Created by Administrator on 2018/6/5.
 */

@RestController
@RequestMapping("/mongo")
public class MongoController {

    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/test1")
    public void test1(){
        repository.deleteAll();

        UserInfo u1 = new UserInfo("f1","l1");
        UserInfo u2 = new UserInfo("f2","l1");
        UserInfo u3 = new UserInfo("f3","l3");

        repository.save(u1);
        repository.save(u2);
        repository.save(u3);

        UserInfo user1 = repository.getUserInfoByFirstName("f1");
        UserInfo user2 = repository.getUserInfoByFirstName("f2");
        UserInfo user3 = repository.getUserInfoByFirstName("f3");
        System.out.println("user1:" + user1);
        System.out.println("user2:" + user2);
        System.out.println("user3:" + user3);

        List<UserInfo> list1 = repository.getUserInfoByLastName("l1");
        List<UserInfo> list2 = repository.getUserInfoByLastName("l3");
        System.out.println("list1:\r\n");
        for(int i = 0; i < list1.size(); i++){
            System.out.println(list1.get(i));
        }

        System.out.println("list2:\r\n");
        for(int i = 0; i < list2.size(); i++){
            System.out.println(list2.get(i));
        }

        //对于复杂查询还是需要使用mongoTemplate来实现
        MongoTemplate mongoTemplate;

    }

    @GetMapping("/test2")
    public String test2(){
        UserInfo userInfo = new UserInfo("f4", "f4_lastname");

        mongoTemplate.save(userInfo);

        return userInfo.toString();
    }

    @GetMapping("/test3")
    public String test3(){
        DB db = null;
        try {
            File file = new File("c:\\test.png");
            db = mongoTemplate.getMongoDbFactory().getLegacyDb();

            // 存储fs的根节点
            GridFS gridFS = new GridFS(db, "mytest");
            GridFSInputFile gfs = gridFS.createFile(file);
            gfs.put("aliases", "jiurong");
            gfs.put("filename", "com.demo.userinfo.filename.png");
            gfs.put("contentType", "png");
            gfs.save();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("存储文件时发生错误！！！");
        }

        return db.getName();
    }

    //从mongodb读取文件
    @GetMapping("/test4")
    public String test4(String filename){
        System.out.println("begin-----------------------------");
        try {
            DB db = mongoTemplate.getMongoDbFactory().getLegacyDb();
            System.out.println("db.getName:" + db.getName());
            // 获取fs的根节点
            GridFS gridFS = new GridFS(db, "mytest");
            GridFSDBFile dbfile = gridFS.findOne(filename);
            System.out.println("dbfile.getName:" + dbfile.getFilename());

            if (dbfile != null) {
                File file = new File("c:\\b.png");
                if(!file.exists()){
                    file.createNewFile();
                }
                System.out.println("create file success.");
                dbfile.writeTo(file);

                System.out.println("write file success.");

                return file.getTotalSpace() + "";
            }
        } catch (Exception e) {
            e.printStackTrace();;
        }

        return null;

    }

    @GetMapping("/test5")
    public String test5(String name){
        return "hello: " + name;
    }
}
