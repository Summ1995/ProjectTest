package com.example.tianjun.projecttest.SQLite.ShoppingCar;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "SHOPPING_CAR".
*/
public class ShoppingCarDao extends AbstractDao<ShoppingCar, Long> {

    public static final String TABLENAME = "SHOPPING_CAR";

    /**
     * Properties of entity ShoppingCar.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Goods_id = new Property(1, String.class, "goods_id", false, "GOODS_ID");
        public final static Property Goods_english_name = new Property(2, String.class, "goods_english_name", false, "GOODS_ENGLISH_NAME");
        public final static Property Goods_name = new Property(3, String.class, "goods_name", false, "GOODS_NAME");
        public final static Property Shop_price = new Property(4, String.class, "shop_price", false, "SHOP_PRICE");
        public final static Property Num = new Property(5, Integer.class, "num", false, "NUM");
    }


    public ShoppingCarDao(DaoConfig config) {
        super(config);
    }
    
    public ShoppingCarDao(DaoConfig config, ShoppingcarDaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"SHOPPING_CAR\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"GOODS_ID\" TEXT," + // 1: goods_id
                "\"GOODS_ENGLISH_NAME\" TEXT," + // 2: goods_english_name
                "\"GOODS_NAME\" TEXT," + // 3: goods_name
                "\"SHOP_PRICE\" TEXT," + // 4: shop_price
                "\"NUM\" INTEGER);"); // 5: num
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SHOPPING_CAR\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, ShoppingCar entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String goods_id = entity.getGoods_id();
        if (goods_id != null) {
            stmt.bindString(2, goods_id);
        }
 
        String goods_english_name = entity.getGoods_english_name();
        if (goods_english_name != null) {
            stmt.bindString(3, goods_english_name);
        }
 
        String goods_name = entity.getGoods_name();
        if (goods_name != null) {
            stmt.bindString(4, goods_name);
        }
 
        String shop_price = entity.getShop_price();
        if (shop_price != null) {
            stmt.bindString(5, shop_price);
        }
 
        Integer num = entity.getNum();
        if (num != null) {
            stmt.bindLong(6, num);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, ShoppingCar entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String goods_id = entity.getGoods_id();
        if (goods_id != null) {
            stmt.bindString(2, goods_id);
        }
 
        String goods_english_name = entity.getGoods_english_name();
        if (goods_english_name != null) {
            stmt.bindString(3, goods_english_name);
        }
 
        String goods_name = entity.getGoods_name();
        if (goods_name != null) {
            stmt.bindString(4, goods_name);
        }
 
        String shop_price = entity.getShop_price();
        if (shop_price != null) {
            stmt.bindString(5, shop_price);
        }
 
        Integer num = entity.getNum();
        if (num != null) {
            stmt.bindLong(6, num);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public ShoppingCar readEntity(Cursor cursor, int offset) {
        ShoppingCar entity = new ShoppingCar( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // goods_id
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // goods_english_name
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // goods_name
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // shop_price
            cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5) // num
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, ShoppingCar entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setGoods_id(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setGoods_english_name(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setGoods_name(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setShop_price(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setNum(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(ShoppingCar entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(ShoppingCar entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(ShoppingCar entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
