package com.qianma.community.provider;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qianma.community.dto.AccessTokenDTO;
import com.qianma.community.dto.GitHubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/3/22
 */
@Component
public class GithubProvider {


    public String getAccessToken(AccessTokenDTO accessToken) throws IOException {
        String url = "https://github.com/login/oauth/access_token";

        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();

        String json = JSONObject.toJSONString(accessToken);
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            string = string.split("&")[0].split("=")[1];
            return string;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public GitHubUser getUser(String accessToken){
        try {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessToken)
                .build();
        Response response = null;
        response = client.newCall(request).execute();
        String string = response.body().string();
        GitHubUser gitHubUser = JSON.parseObject(string, GitHubUser.class);
        return gitHubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

}
