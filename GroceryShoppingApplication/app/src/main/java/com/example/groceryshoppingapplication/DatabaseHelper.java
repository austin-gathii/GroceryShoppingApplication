package com.example.groceryshoppingapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "Database Helper";
    private static final String TABLE_NAME = "Users";
    private static final String COL_1 = "Username";
    private static final String COL_2 = "EmailAddress";
    private static final String COL_3 = "PhoneNumber";
    private static final String COL_4 = "Password";
    private static final String COL_5 = "Status";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "Users.db",null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE "+ TABLE_NAME + " ("+COL_1+" TEXT," +
                " "+COL_2+" TEXT," +
                " "+COL_3+" TEXT," +
                " "+COL_4+" TEXT," +
                " "+COL_5+" TEXT);";
        db.execSQL(createTable);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME+";");
        onCreate(db);

    }

    public void addData(String Username,String Email,String Password,String PhoneNumber,String Status)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentVals = new ContentValues();
        contentVals.put("Username",Username);
        contentVals.put("EmailAddress",Email);
        contentVals.put("Password",Password);
        contentVals.put("PhoneNumber",PhoneNumber);
        contentVals.put("Status",Status);
        db.insertOrThrow(TABLE_NAME,"",contentVals);



    }

    public void deleteUser(String Username)
    {
        this.getWritableDatabase().execSQL("DELETE FROM "+TABLE_NAME+" WHERE Username = '"+Username+"'");
    }

    public void Update(String Username,String column,String data)
    {
        this.getWritableDatabase().execSQL("UPDATE "+TABLE_NAME+" SET "+column+" = '"+data+"' WHERE Username = ''"+Username+"'" );
    }

    public void DisplayVals(TextView txt)
    {
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM "+TABLE_NAME,null);
        while (cursor.moveToNext())
        {
            for (int i = 0;i < 5;i++)
            {
                txt.setText(cursor.getString(i)+" ");
            }
            txt.setText("\n");
        }
    }

    public boolean Authentication(String Username,String InputPassword)
    {
        try
        {
            Cursor cursor = this.getReadableDatabase().rawQuery("SELECT Password FROM "+TABLE_NAME+" WHERE Username = '"+Username+"'",null);
            String Pass = "";
            while(cursor.moveToNext())
            {
                Pass = cursor.getString(0);
            }
            if (InputPassword.equals(Pass))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(Exception e)
        {
            return false;
        }

    }

    public String getStatus(String Username)
    {
        Cursor status = this.getReadableDatabase().rawQuery("SELECT Status FROM "+TABLE_NAME+" WHERE Username = '"+Username+"'",null);
        while(status.moveToNext())
        {
            return status.getString(0).toString();
        }
        return "Null";
    }
}
