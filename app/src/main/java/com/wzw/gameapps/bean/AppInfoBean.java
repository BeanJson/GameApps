package com.wzw.gameapps.bean;

/**
 * Created by wuzhongwei on 2017/2/13.
 */

public class AppInfoBean {
    // "id": 1525490,
    // "name": "有缘网",
    // "packageName": "com.youyuan.yyhl",
    // "iconUrl": "app/com.youyuan.yyhl/icon.jpg",
    // "stars": 4,
    // "size": 3876203,
    // "downloadUrl": "app/com.youyuan.yyhl/com.youyuan.yyhl.apk",
    // "des": "产品介绍：有缘是时下最受大众单身男女亲睐的婚恋交友软件。有缘网专注于通过轻松、"
    /***
     * id表示的是编号
     * name表示的是名称
     * packageName app的包名称
     * iconUrl app的图标url的后缀
     * stars app的星级
     * size app的大小
     * downloadUrl 下载app的地址
     * des 描述
     */
    // 定义数据
    private long id;
    private String name;
    private String packageName;
    private String iconUrl;
    private float stars;
    private long size;
    private String downloadUrl;
    private String des;

    @Override
    public String toString() {
        return "AppInfoBean [id=" + id + ", name=" + name + ", packageName="
                + packageName + ", iconUrl=" + iconUrl + ", stars=" + stars
                + ", size=" + size + ", downloadUrl=" + downloadUrl + ", des="
                + des + "]";
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }


    public String getIconUrl() {
        return iconUrl;
    }


    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public float getStars() {
        return stars;
    }


    public void setStars(float stars) {
        this.stars = stars;
    }

    public long getSize() {
        return size;
    }


    public void setSize(long size) {
        this.size = size;
    }


    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }


    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

}
