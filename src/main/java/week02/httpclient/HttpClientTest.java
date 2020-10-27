package week02.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @Author: guanys
 * @version: V1.0
 * @Package: week02.httpclient
 * @ClassName: HttpClientTest
 * @Description: 写一段代码，使用 HttpClient 或 OkHttp 访问 http://localhost:8801，代码提交到 Github。
 * @Date: 2020/10/27 15:55
 */

public class HttpClientTest {

    public static void main(String[] args) {
            testGet("http://localhost:8801");
    }

    private static String testGet(String url) {
        //创建 CloseableHttpClient
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String result = null;
        try {
            URIBuilder uri = new URIBuilder(url);
            HttpGet httpGet = new HttpGet(uri.build());
            //设置请求状态参数
            RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(3000).
                    setSocketTimeout(3000).setConnectTimeout(3000).build();
            httpGet.setConfig(requestConfig);
            response = httpClient.execute(httpGet);
            int status = response.getStatusLine().getStatusCode();//获取返回状态值
            if (status == HttpStatus.SC_OK) {//请求成功
                HttpEntity httpEntity = response.getEntity();
                if(httpEntity != null){
                    result = EntityUtils.toString(httpEntity, "UTF-8");
                    EntityUtils.consume(httpEntity);//关闭资源
                    System.out.println("====页面请求后返回结果:" + result);
                    return result;
                }
            }
        } catch (Exception e) {
            System.out.println("====页面请求失败，无法连接到该页面！====");
            e.printStackTrace();
        } finally {
            if(response != null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(httpClient != null){
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

}
