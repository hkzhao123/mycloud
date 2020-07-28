package com.zhao.user.service.impl;


import com.zhao.user.domain.User;
import com.zhao.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <h3>cloud</h3>
 * <p></p>
 *
 * @author : hkzhao
 * @date : 2020-07-23 18:07
 **/
@Service
public class UserSerivceImpl  implements UserService {
    private List<User> userList;

    @Override
    public void create(User user) {
        userList.add(user);
    }

    @Override
    public User getUser(Long id) {
        List<User> findUserList = userList.stream().filter(item -> item.getId().equals(id)).collect(Collectors.toList());
        if(!CollectionUtils.isEmpty(findUserList)){
            return findUserList.get(0);
        }
        return null;
    }

    @Override
    public void update(User user) {
        userList.stream().filter(userItem -> userItem.getId().equals(user.getId())).forEach(userItem -> {
            userItem.setUsername(user.getUsername());
            userItem.setPassword(user.getPassword());
        });
    }

    @Override
    public void delete(Long id) {
        User user = getUser(id);
        if (user != null) {
            userList.remove(user);
        }
    }

    @Override
    public User getByUsername(String username) {
        List<User> findUserList = userList.stream().filter(userItem -> userItem.getUsername().equals(username)).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(findUserList)) {
            return findUserList.get(0);
        }
        return null;
    }

    @Override
    public List<User> getUserByIds(List<Long> ids) {
        return userList.stream().filter(userItem -> ids.contains(userItem.getId())).collect(Collectors.toList());
    }
    @PostConstruct
    public void initData(){
        userList = new ArrayList<>();
        userList.add(User.builder().id(1L).username("macro").password("123456").build());
        userList.add(User.builder().id(2L).username("andy").password("123456").build());
        userList.add(User.builder().id(3L).username("mark").password("123456").build());
    }
}
