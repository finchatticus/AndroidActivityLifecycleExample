package ua.kpi.speleo.activitylifecycleexample.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends Activity {
    private static final String TAG = SecondActivity.class.getSimpleName();
    private EditText editTextSurname;
    private EditText editTextName;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.v(TAG, "onCreate");

        setContentView(R.layout.second);

        //get name from FirstActivity using Intent
        Log.v(TAG, "getIntent");
        String name = getIntent().getStringExtra("name");

        editTextSurname = (EditText) findViewById(R.id.editTextSurname);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextName.setText(name);
        buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(buttonBackOnClickListener);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG, "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "onDestroy");
    }

    private View.OnClickListener buttonBackOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.v(TAG, "buttonBack onClick");
            Intent intent = new Intent(getApplicationContext(), FirstActivity.class);
            intent.putExtra("surname", editTextSurname.getText().toString());
            startActivity(intent);
        }
    };
}
