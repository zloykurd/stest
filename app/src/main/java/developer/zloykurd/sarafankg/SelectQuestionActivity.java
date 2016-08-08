package developer.zloykurd.sarafankg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

import developer.zloykurd.sarafankg.adapters.GetAdapterforNDView;
import developer.zloykurd.sarafankg.db.DataBase;

public class SelectQuestionActivity extends AppCompatActivity {
    ListView listView;

    GetAdapterforNDView adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Вопрос");
        setContentView(R.layout.activity_select_question);
//        button = (Button) findViewById(R.id.button);
//        nameTV = (TextView) findViewById(R.id.nameacc);
//        NumberphoneTV = (TextView) findViewById(R.id.textView6);
//        passwordTV = (TextView) findViewById(R.id.textView7);
//
//
//        password = getIntent().getStringExtra("id");//work
//        name= getIntent().getStringExtra("user_name");//work
//        Numberphone = getIntent().getStringExtra("user_phone");//work
//
//        nameTV.setText( name);
//        passwordTV.setText( password);
//        NumberphoneTV.setText(Numberphone);
    }
    private ArrayList<QuestionCreate> getData() {
        DataBase db = new DataBase(getApplicationContext());
        final ArrayList<QuestionCreate> stringItems = new ArrayList<QuestionCreate>();
        ArrayList<QuestionCreate> pr = (ArrayList<QuestionCreate>) db.getAllQuestions();
        for (QuestionCreate p : pr) {
            stringItems.add(p);
        }
        Log.d("getAllLitleQuestions", stringItems.toString());
        return stringItems;

    }
}
