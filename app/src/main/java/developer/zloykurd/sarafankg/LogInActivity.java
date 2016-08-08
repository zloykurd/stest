package developer.zloykurd.sarafankg;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class LogInActivity extends AppCompatActivity {

    EditText etenter_number; // ввод номера для входа
    EditText enterpassword_enter; // ввод пароля для входа
    Button buttonEnter; // кнопка для входа
    TextView tvmisspassword_enter; // забыли пароль?
    Button reg_button_enter; // переход для регистрации
    String data = "";
    private ArrayList<String> mUsers;
    private JSONObject jsonObject;
    private ProgressBar progressBar;
    public static String LOG_TAG = "LogMain";
    InputStream is;

    public static String fn;
    public static String fn1;
    public static String fn2;
    public static String value1;
    public static String value2;
    public static String value3;

    public static final String URLPOST = "http://radzho4w.bget.ru/config/post.php?";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        getSupportActionBar().hide();

        etenter_number = (EditText) findViewById(R.id.etenter_number);
        enterpassword_enter = (EditText) findViewById(R.id.enterpassword_enter);
        buttonEnter = (Button) findViewById(R.id.buttonEnter);
        tvmisspassword_enter = (TextView) findViewById(R.id.tvmisspassword_enter);
        reg_button_enter = (Button) findViewById(R.id.reg_button_enter);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonEnter:
                        String etnumber = etenter_number.getText().toString();
                        String etpassword = enterpassword_enter.getText().toString();


                        if (etnumber.equals("")) {
                            Toast check = Toast.makeText(LogInActivity.this, "Введите номер телефона", Toast.LENGTH_LONG);
                            check.show();
                        } else if (etpassword.equals("")) {
                            Toast check = Toast.makeText(LogInActivity.this, "Введите пароль", Toast.LENGTH_LONG);
                            check.show();
                        } else {

                            BackGround backGround = new BackGround();
                            backGround.execute(etnumber, etpassword);


                        }
                        break;
                    case R.id.reg_button_enter:

                        Log.d("Logtest", "all ok");
                        break;
                    case R.id.tvmisspassword_enter:
                        break;
                }
            }
        };
        buttonEnter.setOnClickListener(onClickListener);
        reg_button_enter.setOnClickListener(onClickListener);
        tvmisspassword_enter.setOnClickListener(onClickListener);
    }



    class BackGround extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            String etenter_number = params[0];
            String password = params[1];

            int tmp;

            try {
                URL url = new URL("http://radzho4w.bget.ru/config/login.php?");
                String urlParams = "etenter_number=" + etenter_number + "&password=" + password;
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                Log.d("Logtest", "all ok " + httpURLConnection.toString());
                httpURLConnection.setRequestMethod("POST");

                os.write(urlParams.getBytes());
                Log.d("Logtest", "urlParams  " + urlParams.toString());
                Log.d("Logtest", "os " + os.toString());
                os.flush();
                os.close();
                is = httpURLConnection.getInputStream();
                Log.d("Logtest", "is " + is.toString());
                while ((tmp = is.read()) != -1) {
                    data += (char) tmp;
                }
                is.close();
                httpURLConnection.disconnect();
                Log.d("Logtest", "data " + data.toString());

                return data;

            } catch (MalformedURLException e) {
                e.printStackTrace();
                return "Exception: " + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "Exception: " + e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String res) {
            super.onPostExecute(res);
            Log.d("Logtest", "res " + res.toString());
            Toast t = Toast.makeText(LogInActivity.this, res, Toast.LENGTH_LONG);
            t.show();

            JSONArray jArray = null;

            try {
                JSONObject parentObject = new JSONObject(res);
                String name = parentObject.getString("user_name");
                String phone = parentObject.getString("user_phone");
                String id = parentObject.getString("id");
                Log.d("Logtest", "phone " + phone);
                Intent intent = new Intent(LogInActivity.this, SarafanNDActivity.class);
//                intent.putExtra("id", id);
//                intent.putExtra("user_name", name);
//                intent.putExtra("user_phone", phone);
                startActivity(intent);
                finish();
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        }
    }


}