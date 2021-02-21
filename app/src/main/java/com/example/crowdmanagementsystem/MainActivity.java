package com.example.crowdmanagementsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();
    }

    public void onLogInButtonClicked(View view){
        EditText editUN = findViewById(R.id.editUN);
        EditText editPwd = findViewById(R.id.editPassword);
        String email = editUN.getText().toString();
        String password = editPwd.getText().toString();
        if (email.equals("")){
            Toast.makeText(this, "Username can't be blank.", Toast.LENGTH_SHORT).show();
            return;
        }
        else if (password.equals("")){
            Toast.makeText(this, "Password can't be blank.", Toast.LENGTH_SHORT).show();
            return;
        }
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.d(TAG, "Sign in success");
                    FirebaseUser user = auth.getCurrentUser();
                    Intent intent = new Intent(MainActivity.this, EventListActivity.class);
                    startActivity(intent);
                }
                else {
                    Log.w(TAG, "Sign in failed",  task.getException());
                    Toast.makeText(MainActivity.this, "Log In failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void onRegisterButtonClicked(View view){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

}