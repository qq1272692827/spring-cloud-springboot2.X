package com.zztl.testapi.dao.zzkj_user;

import com.zztl.testapi.vo.StudentVo;
import com.zztl.testapi.vo.UserVo;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Map;

@Qualifier("userSqlSessionFactory")
public interface UserMapper {

    public void saveUser(UserVo userVo);


//    public Map<String ,String> getUserInfo();

}
