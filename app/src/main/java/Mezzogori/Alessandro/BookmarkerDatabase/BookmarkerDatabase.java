package Mezzogori.Alessandro.BookmarkerDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import static Mezzogori.Alessandro.BookmarkerDatabase.SiteModelContract.*;

public class BookmarkerDatabase{
    BookmarkerDBHelper dbHelper;
    SQLiteDatabase db;

    public BookmarkerDatabase(Context context){
        dbHelper = new BookmarkerDBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void insertSite(Site site){
        ContentValues values = new ContentValues();
        values.put(SiteModel.COLUMN_NAME_NAME, site.name);
        values.put(SiteModel.COLUMN_NAME_URL, site.url);

        try {
            site.id = db.insert(SiteModel.TABLE_NAME, null, values);
        } catch (SQLException sqlException){
            sqlException.printStackTrace();
            throw new RuntimeException(); //temporary
        }
    }

    public Site getSite(int id){
        String[] projection = {SiteModel._ID, SiteModel.COLUMN_NAME_NAME, SiteModel.COLUMN_NAME_URL,};
        String selection = SiteModel._ID + " = ?" + Integer.toString(id);
        String[] selectionArgs = {Integer.toString(id)};

        Cursor cursor = db.query(SiteModel.TABLE_NAME, projection, selection, selectionArgs, null, null, null);
        if(cursor.getCount() == 1){
            return new Site(cursor.getString(0), cursor.getString(1));
        }
        else{
            return null;
        }
    }

    public ArrayList<Site> getAllSites(){
        String[] projection = {SiteModel._ID, SiteModel.COLUMN_NAME_NAME, SiteModel.COLUMN_NAME_URL,};
        Cursor cursor = db.query(SiteModel.TABLE_NAME, projection, null, null, null, null, null);
        ArrayList<Site> list = new ArrayList<Site>();
        while(cursor.moveToNext()){
            list.add(
              new Site(
                      cursor.getLong(0),
                      cursor.getString(1),
                      cursor.getString(2)
              )
            );
        }
        return list;
    }

    public void close(){
        dbHelper.close();
    }

}
