package Mezzogori.Alessandro.BookmarkerDatabase;

import android.provider.BaseColumns;

public final class SiteModelContract {
    private SiteModelContract(){}

    public static class SiteModel implements BaseColumns{
        public static final String TABLE_NAME = "sitemodel";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_URL = "url";

        public static final String SQL_CREATE_SITES =
                "CREATE TABLE " + SiteModel.TABLE_NAME +
                        " (" +
                        SiteModel._ID + " INTEGER PRIMARY KEY," +
                        SiteModel.COLUMN_NAME_NAME + " VARCHAR(30)," +
                        SiteModel.COLUMN_NAME_URL + " VARCHAR(100)" +
                        ")";

        public static final String SQL_DELETE_SITES =
                "DROP TABLE IF EXISTS " + SiteModel.TABLE_NAME;
    }
}
