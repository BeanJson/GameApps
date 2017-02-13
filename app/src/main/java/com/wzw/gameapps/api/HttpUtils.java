package com.wzw.gameapps.api;

import com.wzw.gameapps.util.LogUtils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wuzhongwei on 2017/2/13.
 * 执行get请求，返回json字符串
 */

public class HttpUtils {

    private static String tag = HttpUtils.class.getSimpleName();

    // 请求服务器.得到一个字符串
    // 执行Get请求.返回Json字符串
    public static String get(String url) {
        // 定义需要返回的字符串
        String result = null;

        // 创建HttpClient的对象
        HttpClient httpClient = new DefaultHttpClient();
        // 创建httpGet请求的对象
        HttpGet httpGet = new HttpGet(url);
        try {
            // 执行当前的Get请求
            HttpResponse response = httpClient.execute(httpGet);
            // 得到当前的响应
            if (response.getStatusLine().getStatusCode() == 200) {
                // 得到当前的输入流
                InputStream is = response.getEntity().getContent();
                // 转换输入流
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                // 定义缓冲区
                byte buffer[] = new byte[1024];
                // 临时变量
                int len = -1;

                // 循环读取数据
                while ((len = is.read(buffer)) != -1) {
                    // 循环写入数据
                    baos.write(buffer, 0, len);
                }
                // 关闭IO流
                is.close();
                // 关闭连接
                httpClient.getConnectionManager().closeExpiredConnections();
                // 准换当前的数据为字符串
                result = new String(baos.toByteArray(), "UTF-8");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        // 返回当前的结果
        return result;
    }

    /**
     * 下载文件，返回流对象
     *
     * @param url
     * @return
     */
    public static HttpResult download(String url) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        boolean retry = true;
        while (retry) {
            try {
                HttpResponse httpResponse = httpClient.execute(httpGet);
                if (httpResponse != null) {
                    return new HttpResult(httpClient, httpGet, httpResponse);
                }
            } catch (Exception e) {
                retry = false;
                e.printStackTrace();
                LogUtils.e(tag, "download: " + e.getMessage());
            }
        }
        return null;
    }

    /**
     * Http返回结果的进一步封装
     *
     * @author Administrator
     */
    public static class HttpResult {
        private HttpClient httpClient;
        private HttpGet httpGet;
        private HttpResponse httpResponse;
        private InputStream inputStream;

        public HttpResult(HttpClient httpClient, HttpGet httpGet,
                          HttpResponse httpResponse) {
            super();
            this.httpClient = httpClient;
            this.httpGet = httpGet;
            this.httpResponse = httpResponse;

        }

        /**
         * 获取状态码
         *
         * @return
         */
        public int getStatusCode() {
            StatusLine status = httpResponse.getStatusLine();
            return status.getStatusCode();
        }

        /**
         * 获取输入流
         *
         * @return
         */
        public InputStream getInputStream() {
            if (inputStream == null && getStatusCode() < 300) {
                HttpEntity entity = httpResponse.getEntity();
                try {
                    inputStream = entity.getContent();
                } catch (Exception e) {
                    e.printStackTrace();
                    LogUtils.e(this, "getInputStream: " + e.getMessage());
                }
            }
            return inputStream;
        }

        /**
         * 关闭链接和流对象
         */
        public void close() {
            if (httpGet != null) {
                httpGet.abort();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    LogUtils.e(this, "close: " + e.getMessage());
                }
            }
            // 关闭链接
            if (httpClient != null) {
                httpClient.getConnectionManager().closeExpiredConnections();
            }
        }
    }

}
