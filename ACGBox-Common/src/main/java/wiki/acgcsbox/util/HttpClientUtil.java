package wiki.acgcsbox.util;


import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

/**
 * @author : XiaoBai
 * @apiNote : 实现http get以及post请求
 * @date : 2023/4/4 22:36
 */
public class HttpClientUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    /**
     * post方法form表单
     * @param url
     * @param form
     * @return
     */
    public static JSONObject post(String url, JSONObject form) {
        JSONObject result = new JSONObject();
        CloseableHttpClient client = HttpClients.createDefault();
        // POST
        HttpPost post = new HttpPost(url);
        List<NameValuePair> params = new ArrayList<>();
        //遍历form
        Iterator keys = form.keys();
        while (keys.hasNext()) {
            String key = keys.next().toString();
            params.add(new BasicNameValuePair(key, form.optString(key)));
        }
        UrlEncodedFormEntity urfEntity;
        try {
            urfEntity = new UrlEncodedFormEntity(params, "UTF-8");
            post.setEntity(urfEntity);
            CloseableHttpResponse response = client.execute(post);
            try {
                HttpEntity entity = response.getEntity();
                if (null != entity) {
                    result = new JSONObject(new JSONTokener(new InputStreamReader(entity.getContent(), "UTF-8")));
                }
            } finally {
                response.close();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * get请求
     *
     * @param url
     * @param params
     * @return
     */
    public static JSONObject get(String url, JSONObject params) {
        JSONObject result = new JSONObject();
        CloseableHttpClient client = HttpClients.createDefault();
        try {
            if (params.length() > 0) {
                //遍历form
                url = url + "?";
                Iterator keys = params.keys();
                while (keys.hasNext()) {
                    String key = keys.next().toString();
                    logger.debug("current key : " + key);
                    String value = params.optString(key);
                    value = URLEncoder.encode(value, "UTF-8");
                    logger.debug("current value : " + value);
                    if (url.contains("{" + key + "}")) {// Rest风格处理
                        url = url.replace("{" + key + "}", value);
                        continue;
                    }
                    url = url + key + "=" + value + "&";
                }
                url = url.substring(0, url.length() - 1);
                //System.out.println("url---"+url);
            }
            //url = URLEncoder.encode(url);
            logger.debug("Request Url: " + url);
            HttpGet get = new HttpGet(url);
            CloseableHttpResponse response = client.execute(get);
            try {
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode == 200) {
                    HttpEntity entity = response.getEntity();
                    result = new JSONObject(new JSONTokener(new InputStreamReader(entity.getContent(), "UTF-8")));
                    if (null != entity) {
                        logger.debug("Response Content Length: " + entity.getContentLength());
                        logger.debug("Response Content: " + EntityUtils.toString(entity));
                    }
                }
            } finally {
                response.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 发送JSON字符串
     */
    public static String doJsonPost(String urlPath, String json) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(urlPath);
            httpPost.addHeader("Content-Type", "application/json");
            // 解决中文乱码问题
            StringEntity stringEntity = new StringEntity(json, "UTF-8");
            stringEntity.setContentEncoding("UTF-8");
            httpPost.setEntity(stringEntity);

            CloseableHttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String responseContent = EntityUtils.toString(entity, "UTF-8");

            response.close();
            httpClient.close();
            return responseContent;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String doSapJsonPost(String urlPath, String json, String username, String password) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(urlPath);
            httpPost.addHeader("Content-Type", "application/json");
            //sap的http需要设置用户名密码  如果用户名和密码不为空，设置密码
            if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
                String encoded = Base64.getEncoder().encodeToString((username + ":" + password).getBytes(StandardCharsets.UTF_8));  //Java 8
                httpPost.addHeader("Authorization", "Basic " + encoded);
            }
            // 解决中文乱码问题
            StringEntity stringEntity = new StringEntity(json, "UTF-8");
            stringEntity.setContentEncoding("UTF-8");
            httpPost.setEntity(stringEntity);

            CloseableHttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String responseContent = EntityUtils.toString(entity, "UTF-8");

            response.close();
            httpClient.close();
            return responseContent;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * 向指定的地址post XML格式数据
     *
     * @param urlStr
     * @param xml
     */
    public static String postXML(String urlStr, String xml) {
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(urlStr);
            httpPost.addHeader("Content-Type", "text/html;charset=UTF-8");
            //解决中文乱码问题
            StringEntity stringEntity = new StringEntity(xml, "UTF-8");
            stringEntity.setContentEncoding("UTF-8");
            httpPost.setEntity(stringEntity);
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                @Override
                public String handleResponse(final HttpResponse response)
                        throws ClientProtocolException, IOException {//
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity, "UTF-8") : null;
                    } else {
                        throw new ClientProtocolException(
                                "Unexpected response status: " + status);
                    }
                }
            };
            String responseBody = httpclient.execute(httpPost, responseHandler);
            return responseBody;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
