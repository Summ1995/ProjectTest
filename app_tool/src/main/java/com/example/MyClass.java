package com.example;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class MyClass {
  public static Schema schema;
    public static void main(String[] args) {
        creatTable();
        addressInfo();
        userInfo();
        product();
        choiceness();
        baskbar();
    }

    private static void baskbar() {

        //添加收藏晒吧表
        Schema schema = new Schema("baskbar",1,"com.example.tianjun.projecttest.SQLite.Baskbar");
        Entity baskbar=schema.addEntity("Baskbar");
        baskbar.addIdProperty().autoincrement();
        baskbar.addStringProperty("share_id");
        baskbar.addStringProperty("images");
        baskbar.addStringProperty("content");
        baskbar.addStringProperty("nick_name");
        //自动生成
        try {
            new DaoGenerator().generateAll(schema,"D:/AndroidDemo3/ProjectTest/app/src/main/java/com/example/tianjun/projecttest/SQLite");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void choiceness() {
        //添加收藏精选表
        Schema schema = new Schema("choiceness",1,"com.example.tianjun.projecttest.SQLite.Choiceness");
        Entity choiceness=schema.addEntity("Choiceness");
        choiceness.addIdProperty().autoincrement();
        choiceness.addStringProperty("topic_id");
        choiceness.addStringProperty("topic_img");
        choiceness.addStringProperty("title");
        //自动生成
        try {
            new DaoGenerator().generateAll(schema,"D:/AndroidDemo3/ProjectTest/app/src/main/java/com/example/tianjun/projecttest/SQLite");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void product() {

        //添加收藏单品表
        Schema schema = new Schema("product",1,"com.example.tianjun.projecttest.SQLite.Product");
        Entity product=schema.addEntity("Product");
        product.addIdProperty().autoincrement();
        product.addStringProperty("goods_id");
        product.addStringProperty("goods_english_name");
        product.addStringProperty("goods_name");
        product.addStringProperty("shop_price");
        //自动生成
        try {
            new DaoGenerator().generateAll(schema,"D:/AndroidDemo3/ProjectTest/app/src/main/java/com/example/tianjun/projecttest/SQLite");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void userInfo() {
        //添加用户信息表
        Schema schema = new Schema("userInfo",1,"com.example.tianjun.projecttest.SQLite.UserInfo");
        Entity userInfo=schema.addEntity("UserInfo");
        userInfo.addIdProperty().autoincrement();
        userInfo.addStringProperty("userName");
        userInfo.addStringProperty("sex");
        userInfo.addStringProperty("birthday");
        userInfo.addStringProperty("phoneNum");
        userInfo.addStringProperty("email");
        //自动生成
        try {
            new DaoGenerator().generateAll(schema,"D:/AndroidDemo3/ProjectTest/app/src/main/java/com/example/tianjun/projecttest/SQLite");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addressInfo() {
        // 添加收货地址表
        Schema schema = new Schema("addressInfo",1,"com.example.tianjun.projecttest.SQLite.AddressInfo");
        Entity addressInfo=schema.addEntity("AddressInfo");
        addressInfo.addIdProperty().autoincrement();
        addressInfo.addStringProperty("userNamne").notNull();
        addressInfo.addStringProperty("cityInfo").notNull();
        addressInfo.addStringProperty("address").notNull();
        addressInfo.addStringProperty("phoneNum").notNull();
        addressInfo.addStringProperty("locPhoneNum");
        addressInfo.addStringProperty("postalcode").notNull();
        addressInfo.addBooleanProperty("default");
        //自动生成
        try {
            new DaoGenerator().generateAll(schema,"D:/AndroidDemo3/ProjectTest/app/src/main/java/com/example/tianjun/projecttest/SQLite");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void creatTable() {
        Schema schema = new Schema("shoppingcar",1,"com.example.tianjun.projecttest.SQLite.ShoppingCar");
        //添加购物车表
        Entity shoppingcar = schema.addEntity("ShoppingCar");
        shoppingcar.addIdProperty().autoincrement();
        shoppingcar.addStringProperty("goods_id");
        shoppingcar.addStringProperty("goods_english_name");
        shoppingcar.addStringProperty("goods_name");
        shoppingcar.addStringProperty("shop_price");
        shoppingcar.addIntProperty("num");

        //自动生成
        try {
            new DaoGenerator().generateAll(schema,"D:/AndroidDemo3/ProjectTest/app/src/main/java/com/example/tianjun/projecttest/SQLite");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
