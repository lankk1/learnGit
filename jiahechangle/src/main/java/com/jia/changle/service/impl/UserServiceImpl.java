package com.jia.changle.service.impl;

import com.jia.changle.mapper.ClUserMapper;
import com.jia.changle.po.ClUser;
import com.jia.changle.po.ClUserExample;
import com.jia.changle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by slipkinem on 9/1/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ClUserMapper userMapper;

    @Override
    public Integer login(ClUser user) {
        Integer r = 1;
        try {
            ClUserExample userExample = new ClUserExample();
            userExample.createCriteria().andUserCodeEqualTo(user.getUserCode());
            List<ClUser> users = userMapper.selectByExample(userExample);

            if (users.size() == 0) {
                return 1;
            }

            ClUser clUser = users.get(0);

            if (clUser != null && clUser.getUserPassword().equals(user.getUserPassword())) {
                r = 0;
            } else {
                r = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }
}
