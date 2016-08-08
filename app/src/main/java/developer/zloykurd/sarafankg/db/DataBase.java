package developer.zloykurd.sarafankg.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import developer.zloykurd.sarafankg.QuestionCreate;

/**
 * Created by ZloykurD on 07.08.2016.
 */
public class DataBase extends SQLiteOpenHelper {
    String LOG_TAG = "zloykurd_DB";

    private static final String DATABASE_NAME = "mylitledb";
    private static final int DATABASE_VERSION = 3;

    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        String sQuery = "CREATE TABLE questionDB(id integer primary key autoincrement, question_text text,question_text2 text, question_date text, question_image text, question_image_acc text, question_creator text,question_countcomm text, question_category text);";

        db.execSQL(sQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addLitleQuestion(QuestionCreate questionCreate) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("question_text", questionCreate.getThemeQuestion());
        cv.put("question_text2", questionCreate.getTextQuestion());
        cv.put("question_date", questionCreate.getDateQuestion());
        cv.put("question_image", questionCreate.getImageQuestion());
        cv.put("question_image_acc", questionCreate.getImageAccountUser());
        cv.put("question_creator", questionCreate.getCreatorQuestion());
        cv.put("question_countcomm", questionCreate.getCountCommyQuestion());
        cv.put("question_category", questionCreate.getCategoryQuestion());
        db.insert("questionDB", null, cv);
        Log.d("Add questionDB", questionCreate.toString());
        db.close();
    }


    public List<QuestionCreate> getAllQuestions() {
        List<QuestionCreate> questionList = new ArrayList<>();
        Log.d(LOG_TAG, "List<QuestionCreate> getAllquestions");
        String selectQuery = "SELECT * FROM questionDB ORDER BY id DESC";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                QuestionCreate questionCreate = new QuestionCreate();
                questionCreate.setId(cursor.getString(0));
                questionCreate.setThemeQuestion(cursor.getString(1));
                questionCreate.setTextQuestion(cursor.getString(2));
                questionCreate.setDateQuestion(cursor.getString(3));
                questionCreate.setImageQuestion(cursor.getString(4));
                questionCreate.setImageAccountUser(cursor.getString(5));
                questionCreate.setCreatorQuestion(cursor.getString(6));
                questionCreate.setCountCommyQuestion(cursor.getString(7));
                questionCreate.setCategoryQuestion(cursor.getString(8));

            } while (cursor.moveToNext());
        }
        db.close();
        return questionList;
    }
}