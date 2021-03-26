package Mezzogori.Alessandro.BookmarkerDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static Mezzogori.Alessandro.BookmarkerDatabase.SiteModelContract.*;

public class BookmarkerDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Bookmarker.db";


    public BookmarkerDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SiteModel.SQL_CREATE_SITES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SiteModel.SQL_DELETE_SITES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db, oldVersion, newVersion);
    }

    public ContentValues convertSiteToValues(Site site){
        ContentValues values = new ContentValues();
        values.put(SiteModel.COLUMN_NAME_NAME, site.name);
        values.put(SiteModel.COLUMN_NAME_URL, site.url);

        return values;
    }
}

