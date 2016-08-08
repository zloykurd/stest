package developer.zloykurd.sarafankg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import developer.zloykurd.sarafankg.db.DataBase;

public class CreateActivity extends AppCompatActivity {
EditText themeQuestion,textQuestion;
    TextView vopros,poyasneniya,kategory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        setTitle("ЗАДАТЬ ВОПРОС");
        vopros = (TextView)findViewById(R.id.etlqcreatetv);
        poyasneniya = (TextView)findViewById(R.id.qst);
        kategory = (TextView)findViewById(R.id.kategoriya);
        themeQuestion = (EditText)findViewById(R.id.etlqcreate);
        textQuestion = (EditText)findViewById(R.id.dialogEditText);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();


        if (id == R.id.createfinish) {
            EditText someEditText = (EditText) findViewById(R.id.etlqcreate);
            EditText some2EditText = (EditText) findViewById(R.id.dialogEditText);
            String categoty ="Афиша города";
            String str = someEditText.getText().toString();
            String str2 = some2EditText.getText().toString();

            String userName = "userOncreate";
            String questionimage = "https://drive.google.com/open?id=0BwPHKLZxoHpATi1HM2d0UWtON00";
            String userimage = "https://drive.google.com/open?id=0BwPHKLZxoHpATi1HM2d0UWtON00";
            String usercountcomm = "UCC";

            DataBase db = new DataBase(CreateActivity.this);
            Calendar c = Calendar.getInstance();
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String formatedDate = df.format(c.getTime());
            formatedDate.substring(0,17);
            QuestionCreate questionCreate = new QuestionCreate(str,str2,formatedDate,questionimage,userimage,userName,usercountcomm,categoty);
            Log.d("LogTest", "db.addLitleQuestion(lilteQuestion)" + questionCreate.toString());
            db.addLitleQuestion(questionCreate);
            db.close();
            Intent intent = new Intent(this, SarafanNDActivity.class);
//            lqtext = str.toString();
//            lqdreator = str.toString();
//            lqdate = str.toString();
//            intent.putExtra("lqtext",lqtext);
//            intent.putExtra("lqdreator",lqdreator);
//            intent.putExtra("lqdate",lqdate);
            startActivity(intent);
            finish();


            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
