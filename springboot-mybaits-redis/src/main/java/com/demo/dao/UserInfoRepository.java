package com.demo.dao;

import com.demo.entity.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


/**
 * Created by Administrator on 2018/6/5.
 * 如果继承MongoRepository，则所有操作均会格式化，如getxxxByxxx，否则编译会报错，这种方式不是太灵活，对于复杂查询不适用
 *
 */
public interface UserInfoRepository extends MongoRepository<UserInfo, String> {
//    public interface UserInfoRepository extends PagingAndSortingRepository<UserInfo, String> {

        public UserInfo getUserInfoByFirstName(String firstName);
        public List<UserInfo> getUserInfoByLastName(String lastName);
}
