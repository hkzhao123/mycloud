package com.zhao.oauth.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import com.zhao.oauth.constant.RedisConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * <h3>cloud</h3>
 * <p>资源与角色匹配关系管理业务类</p>
 *
 * @author : hkzhao
 * @date : 2020-07-26 13:49
 **/
@Service
public class ResourceServiceImpl {
    private Map<String, List<String>> resourceRolesMap;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @PostConstruct
    public void initData(){
        resourceRolesMap = new TreeMap<>();
        resourceRolesMap.put("/api/hello", CollUtil.toList("ADMIN"));
        resourceRolesMap.put("/api/user/currentUser", CollUtil.toList("ADMIN", "TEST"));
        redisTemplate.opsForHash().putAll(RedisConstant.RESOURCE_ROLES_MAP, resourceRolesMap);
    }
}
