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
        //添加表
        Entity shoppingcar = schema.addEntity("ShoppingCar");
        shoppingcar.addIdProperty().autoincrement();
        shoppingcar.addStringProperty("goods_english_name");
        shoppingcar.addStringProperty("goods_english_name");
        shoppingcar.addStringProperty("goods_name");
        shoppingcar.addStringProperty("shop_price");
        shoppingcar.addIntProperty("num");


        Entity addressInfo=schema.addEntity("AddressInfo");
        Entity userInfo=schema.addEntity("UserInfo");
        //自动生成
        try {
            new DaoGenerator().generateAll(schema,"../ProjectTest/app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
