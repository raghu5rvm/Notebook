package com.raghucheekatla.notebook;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.raghucheekatla.notebook.SharedPreferences.VaultPreferences;
import com.raghucheekatla.notebook.HashFactory.shaHash;

import java.io.Console;
import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    private String passcodeStr;
    private TextView passCodeField;
    private Button checkBtn,recoverBtn,hiddenBtn;
    private static LoginActivity ActivityContext = null;
    private static Boolean crossChecked = false;
    private String TAG = "LoginActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActivityContext = this;
        passCodeField = (TextView) findViewById(R.id.passcodeField);
        checkBtn = (Button) findViewById(R.id.checkBtn);
        recoverBtn = (Button) findViewById(R.id.recoverBtn);
        hiddenBtn = (Button) findViewById(R.id.hiddenBtn);

    }
    protected void authenticate(View view){
        String passCodeHash,targetHash;
        passcodeStr = passCodeField.getText().toString();
        passCodeHash = stringToHash(passcodeStr);
        targetHash = VaultPreferences.getLoginHashString(ActivityContext);
        if(Objects.equals(targetHash,passCodeHash) && crossChecked){
            Intent intentHome = new Intent(LoginActivity.this,HomeActivity.class);
            startActivity(intentHome);
            finish();
        }
        else{
            //take snap and save info
            Log.d(TAG,"save face clip");

        }
    }

    protected void recover(View view){



    }
    protected void checked(View view){
        crossChecked = true;
    }

    protected String stringToHash(String passcodeStr){
        String hashStr;
        hashStr = shaHash.get_SHA_1_SecurePassword(passcodeStr);
        return hashStr;
    }

}
