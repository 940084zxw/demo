package com.zxw.service.web;

import com.sun.jndi.ldap.Ber;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import com.zxw.service.entity.App;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import sun.java2d.pipe.SpanIterator;
import sun.net.www.http.HttpClient;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;



@RestController
@Slf4j
public class AuthController extends BaseApiService {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private TokenUtils tokenUtils;

    @RequestMapping("/accessToken")
    public ResponseBase getAccessToken(App app) {
        //1.根据appid与appsecret生成accesstoken
        //2.删除之前的token，返回最新的token，生成token与删除token要一个事务里
        return null;
    }
    @RequestMapping("/getToken")
    public String getToken(){
        String token=tokenUtils.setToken();
        return token;
    }
    @RequestMapping("/findToken")
    public String findToken(){
        HttpServletRequest request =(HttpServletRequest) RequestContextHolder.getRequestAttributes().resolveReference(RequestAttributes.REFERENCE_REQUEST);
        String token = request.getHeader("token");
        String result=null;
        if(StringUtils.isEmpty(token)){
            result = "请求头没有获取令牌信息";
        }
        if (!tokenUtils.findToken(token)) {
            result="请勿重复提交";
        }
        result = "执行业务";
        return result;
    }
}
@Data
class User implements Cloneable{
    private String name;
    private int age;
    private Date time;
 }


