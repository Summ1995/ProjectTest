package com.example;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class MyClass {
    public static void main(String[] args) {
        creatTable();
    }

    private static void creatTable() {
        Schema schema = new Schema("fulishe",1,"com.androidxx.yangjw.day38_greendao_curd_demo");
        //添加购物车表
        Entity shoppingcar = schema.addEntity("ShoppingCar");
        shoppingcar.addIdProperty().autoincrement();
        shoppingcar.addStringProperty("goods_id");
        shoppingcar.addStringProperty("goods_english_name");
        shoppingcar.addStringProperty("goods_english_name");
        shoppingcar.addStringProperty("goods_name");
        shoppingcar.addStringProperty("shop_price");
        shoppingcar.addIntProperty("num");

        // 添加收货地址表
        Entity addressInfo=schema.addEntity("AddressInfo");
        addressInfo.addIdProperty().autoincrement();
        addressInfo.addStringProperty("userNamne").notNull();
        addressInfo.addStringProperty("cityInfo").notNull();
        addressInfo.addStringProperty("address").notNull();
        addressInfo.addStringProperty("phoneNum").notNull();
        addressInfo.addStringProperty("locPhoneNum");
        addressInfo.addStringProperty("postalcode").notNull();
        addressInfo.addBooleanProperty("default");

        //添加用户信息表
        Entity userInfo=schema.addEntity("UserInfo");
        addressInfo.addIdProperty().autoincrement();
        userInfo.addStringProperty("userName");
        userInfo.addStringProperty("sex");
        userInfo.addStringProperty("birthday");
        userInfo.addStringProperty("phoneNum");
        userInfo.addStringProperty("email");



        //自动生成
        try {
            new DaoGenerator().generateAll(schema,"../ProjectTest/app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
