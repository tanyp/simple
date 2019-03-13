package cn.com.yunyoutianxia.commons.http;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by tanyp on 2018/3/5
 */
public class HttpClient {
    public static String post(String json, String url) {
        if (StringUtils.isNotEmpty(url)) {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            StringEntity se = new StringEntity(json, Charset.forName("UTF-8"));
            se.setContentType("application/json");
            httpPost.setHeader("Accept", "*/*");
            httpPost.setHeader("Accept-Charset", "UTF-8");
            httpPost.setEntity(se);
            CloseableHttpResponse response = null;
            try {
                response = httpclient.execute(httpPost);
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    HttpEntity entity = response.getEntity();
                    return EntityUtils.toString(entity, "UTF-8");
                }
            } catch (Exception e) {
            } finally {
                try {
                    if (response != null) {
                        response.close();
                    }
                    if (httpclient != null) {
                        httpclient.close();
                    }
                } catch (IOException e) {
                }
            }
        }
        return null;
    }

    public static String get(String url) {
        HttpGet httpget = new HttpGet(url);
        CloseableHttpResponse response = null;
        CloseableHttpClient httpclient = null;
        try {
            httpclient = HttpClients.createDefault();
            response = httpclient.execute(httpget);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                return EntityUtils.toString(entity, "UTF-8");
            }
        } catch (Exception e) {
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                if (httpclient != null) {
                    httpclient.close();
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
