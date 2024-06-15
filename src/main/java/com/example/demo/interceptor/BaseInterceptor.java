package com.example.demo.interceptor;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.utils.TokenUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.plugin.Intercepts;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class BaseInterceptor implements HandlerInterceptor {

    @Resource
    private UserMapper userMapper;


    //方法执行前执行的接口
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        User user = TokenUtils.getUser();
        System.out.println("拦截器==========================");
        if (Objects.isNull(user)) {
            Map<String, String> map = new HashMap<>();
            map.put("code", "401");
            map.put("msg", "未授权");
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(map);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(jsonString);
            return false;
        }

        return true;
    }

    private boolean isValidToken(String token) {
        // 这里只是一个示例，你需要根据实际情况来判断token是否有效
        // 例如，你可以调用其他服务或方法来验证token
        if (token == null) return false;
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getToken, token));
        return user != null;
    }

    //方法执行后执行的方法
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    //返回处理的方法
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
