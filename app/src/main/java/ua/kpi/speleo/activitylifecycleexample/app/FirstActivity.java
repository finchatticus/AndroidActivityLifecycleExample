package ua.kpi.speleo.activitylifecycleexample.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FirstActivity extends Activity {
    private static final String TAG = FirstActivity.class.getSimpleName();
    private EditText editTextName;
    private EditText editTextSurname;
    private Button buttonToSecondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.v(TAG, "onCreate");

        //in android six levels of logging
        //verbose level log
        //Log.v(TAG, "verbose level");
        //info level log
        //Log.i(TAG, "info level");
        //warning level log
        //Log.w(TAG, "warning level");
        //error level log
        //Log.e(TAG, "error level");
        //debug level log
        //Log.d(TAG, "debug level");
        //wtf level log
        //Log.wtf(TAG, "wtf level");

        setContentView(R.layout.first);

        /*String toastText = "create FirstActivity";
        //First example of Toast
        Toast toast = new Toast(this);
        toast.makeText(this, toastText + " 1", Toast.LENGTH_SHORT).show();

        //Second example toast
        Toast.makeText(this, toastText + " 2", Toast.LENGTH_SHORT).show();

        //Third example toast
        Toast toast1 = Toast.makeText(this, toastText + " 3", Toast.LENGTH_SHORT);
        toast1.show();*/

        //get surname from SecondActivity using Intent
        Log.v(TAG, "getIntent");
        String surname = "";
        if(getIntent().getStringExtra("surname") != null) {
            surname = getIntent().getStringExtra("surname").toString();
        }

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextSurname = (EditText) findViewById(R.id.editTextSurname);
        editTextSurname.setText(surname);
        buttonToSecondActivity = (Button) findViewById(R.id.buttonToSecondActivity);
        buttonToSecondActivity.setOnClickListener(buttonToSecondActivityOnClickListener);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG,"onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG,"onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG,"onDestroy");
    }

    private View.OnClickListener buttonToSecondActivityOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.v(TAG, "buttonToSecondActivity onClick");
            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
            intent.putExtra("name", editTextName.getText().toString());
            startActivity(intent);
        }
    };
}
