package com.src.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.src.entity.User;


@Service
public class MyServiceHelper {

    public static final String CLIENT_ID = "trusted_client";
    public static final String CLIENT_SECRET = "secret";
    public static final String REDIRECT_URI = "http://springapp-hirte.rhcloud.com/AuthorizationCodeClient/home";
    public static final String GRANT_TYPE = "authorization_code";
    public static final String AUTHORIZATION_URL = "http://springapp-hirte.rhcloud.com/AuthorizationCodeServer/oauth/token";
    public static final String DATA_URL = "http://springapp-hirte.rhcloud.com/AuthorizationCodeServer/user/information";

    private String code;
//    private User user;
    private String access_token;

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        code = req.getParameter("code");
        if (code == null || "".equals(code)) {
            System.out.println("Error!");
        } else {
            String token = null;
            URL url = new URL(AUTHORIZATION_URL);
            token = this.getTokenFromHttp(url);
            System.out.println(token);

            if (token == null || "".equals(token)) {

            } else {
                this.access_token = getTokenValue(token, "access_token");

            }
        }
    }
    public User getUserProfile() throws IOException {
        System.out.println(this.access_token);
        User user  = getUserInfoFromServer(this.access_token);

        return user;
    }

    public List<User> getListUser() throws IOException{
        List<User> list = getListUserFromServer(this.access_token);
        return list;
    }

    private List<User> getListUserFromServer(String access_token) throws IOException {
        // TODO Auto-generated method stub

        String dataResult = getDataAsString(access_token);
        JSONArray data =  new JSONArray(dataResult);

        List<User> users = new ArrayList<User>();
        for (int i = 0; i < data.length(); i++) {
            JSONObject obj = data.getJSONObject(0);
            User user = convertJSONtoObject(obj);
            if (user != null) {
                users.add(user);
            }
        }

        return users;
    }
    /**
     *
     * @param tokenValue
     * @return
     * get user information from server with access token
     * @throws IOException
     */
    private User getUserInfoFromServer(String tokenValue) throws IOException {
        // TODO Auto-generated method stub
        String dataResult = getDataAsString(tokenValue);
        JSONObject data =  new JSONObject(dataResult);
        User user = convertJSONtoObject(data);


        return user;
    }

    private User convertJSONtoObject(JSONObject obj) {

        String name = obj.getString("name");
        String phone = obj.getString("phone");
        String email = obj.getString("email");
        int id = obj.getInt("id");
        User user = new User(id, name, email, phone);
        return user;
    }
    /**
     *
     * @param tokenValue
     * @return
     * get raw data
     * @throws IOException
     */
    private String getDataAsString(String tokenValue, String username) throws IOException {
        // TODO Auto-generated method stub
        String urlRequest = new StringBuilder(DATA_URL)
                            .append("?access_token=" + tokenValue)
                            .append("&user=" + username).toString();
        URL url = new URL(urlRequest);
        HttpURLConnection  connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");

        String result = sendRequest(connection);

        return result;
    }
    private String getDataAsString(String tokenValue) throws IOException {
        // TODO Auto-generated method stub
        String urlRequest = new StringBuilder(DATA_URL)
                            .append("?access_token=" + tokenValue).toString();
        URL url = new URL(urlRequest);
        HttpURLConnection  connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");

        String result = sendRequest(connection);

        return result;
    }

    private String sendRequest(HttpURLConnection connection) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer b = new StringBuffer();
        while ((inputLine = in.readLine()) != null)
            b.append(inputLine + "\n");
        in.close();
        return b.toString();
    }

    /**
     *
     * @param token
     * @param value
     * @return
     * get token value from server response string
     */
    private String getTokenValue(String token, String value) {
        // TODO Auto-generated method stub
        JSONObject obj = new JSONObject(token);
        return obj.get(value).toString();
    }

    /**
     *
     * @param url
     * @return
     * @throws IOException
     * description: get token, expire time, scope from server
     */
    private String getTokenFromHttp(URL url) throws IOException {
        // TODO Auto-generated method stub
        HttpURLConnection  connection = (HttpURLConnection)url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        String reqParam = "";
        reqParam = buildTokenRequestQuery();
        System.out.println(reqParam);
        connection.setFixedLengthStreamingMode(reqParam.getBytes().length);
        PrintWriter out = new PrintWriter(connection.getOutputStream());
        out.print(reqParam);
        out.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer b = new StringBuffer();
        while ((inputLine = in.readLine()) != null)
            b.append(inputLine + "\n");
        in.close();
        return b.toString();
    }



    private String buildTokenRequestQuery() {
        // TODO Auto-generated method stub
        String query = new StringBuilder("").append("client_id=" + CLIENT_ID)
                                            .append("&client_secret=" + CLIENT_SECRET)
                                            .append("&redirect_uri=" +REDIRECT_URI)
                                            .append("&grant_type="+ GRANT_TYPE)
                                            .append("&code=" + this.code).toString()
                                            ;
        return query;
    }
}
