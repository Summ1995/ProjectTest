package com.example.tianjun.projecttest.SQLite.AddressInfo;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ADDRESS_INFO".
*/
public class AddressInfoDao extends AbstractDao<AddressInfo, Long> {

    public static final String TABLENAME = "ADDRESS_INFO";

    /**
     * Properties of entity AddressInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property UserNamne = new Property(1, String.class, "userNamne", false, "USER_NAMNE");
        public final static Property CityInfo = new Property(2, String.class, "cityInfo", false, "CITY_INFO");
        public final static Property Address = new Property(3, String.class, "address", false, "ADDRESS");
        public final static Property PhoneNum = new Property(4, String.class, "phoneNum", false, "PHONE_NUM");
        public final static Property LocPhoneNum = new Property(5, String.class, "locPhoneNum", false, "LOC_PHONE_NUM");
        public final static Property Postalcode = new Property(6, String.class, "postalcode", false, "POSTALCODE");
        public final static Property Default = new Property(7, Boolean.class, "default", false, "DEFAULT");
    }


    public AddressInfoDao(DaoConfig config) {
        super(config);
    }
    
    public AddressInfoDao(DaoConfig config, AddressInfoDaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ADDRESS_INFO\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"USER_NAMNE\" TEXT NOT NULL ," + // 1: userNamne
                "\"CITY_INFO\" TEXT NOT NULL ," + // 2: cityInfo
                "\"ADDRESS\" TEXT NOT NULL ," + // 3: address
                "\"PHONE_NUM\" TEXT NOT NULL ," + // 4: phoneNum
                "\"LOC_PHONE_NUM\" TEXT," + // 5: locPhoneNum
                "\"POSTALCODE\" TEXT NOT NULL ," + // 6: postalcode
                "\"DEFAULT\" INTEGER);"); // 7: default
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ADDRESS_INFO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, AddressInfo entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getUserNamne());
        stmt.bindString(3, entity.getCityInfo());
        stmt.bindString(4, entity.getAddress());
        stmt.bindString(5, entity.getPhoneNum());
 
        String locPhoneNum = entity.getLocPhoneNum();
        if (locPhoneNum != null) {
            stmt.bindString(6, locPhoneNum);
        }
        stmt.bindString(7, entity.getPostalcode());
 
        Boolean defaults = entity.getDefault();
        if (defaults != null) {
            stmt.bindLong(8, defaults ? 1L: 0L);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, AddressInfo entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getUserNamne());
        stmt.bindString(3, entity.getCityInfo());
        stmt.bindString(4, entity.getAddress());
        stmt.bindString(5, entity.getPhoneNum());
 
        String locPhoneNum = entity.getLocPhoneNum();
        if (locPhoneNum != null) {
            stmt.bindString(6, locPhoneNum);
        }
        stmt.bindString(7, entity.getPostalcode());
 
        Boolean defaults = entity.getDefault();
        if (defaults != null) {
            stmt.bindLong(8, defaults ? 1L: 0L);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public AddressInfo readEntity(Cursor cursor, int offset) {
        AddressInfo entity = new AddressInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // userNamne
            cursor.getString(offset + 2), // cityInfo
            cursor.getString(offset + 3), // address
            cursor.getString(offset + 4), // phoneNum
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // locPhoneNum
            cursor.getString(offset + 6), // postalcode
            cursor.isNull(offset + 7) ? null : cursor.getShort(offset + 7) != 0 // default
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, AddressInfo entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setUserNamne(cursor.getString(offset + 1));
        entity.setCityInfo(cursor.getString(offset + 2));
        entity.setAddress(cursor.getString(offset + 3));
        entity.setPhoneNum(cursor.getString(offset + 4));
        entity.setLocPhoneNum(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setPostalcode(cursor.getString(offset + 6));
        entity.setDefault(cursor.isNull(offset + 7) ? null : cursor.getShort(offset + 7) != 0);
     }
    
    @Override
    protected final Long updateKeyAfterInsert(AddressInfo entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(AddressInfo entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(AddressInfo entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
