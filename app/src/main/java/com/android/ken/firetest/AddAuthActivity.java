package com.android.ken.firetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddAuthActivity extends AppCompatActivity {

    EditText editUserName;
    EditText editExpireAt;

    String addUserName;
    String addExpireAt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_auth);

        editUserName = (EditText)findViewById(R.id.editUserName);
        editExpireAt = (EditText)findViewById(R.id.editExpireAt);
    }

    public void add (View v){
        addUserName = editUserName.getText().toString();
        addExpireAt = editExpireAt.getText().toString();

        Auth auth = new Auth(addUserName, addExpireAt);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference userRef = database.getReference("DEVICE_ID").child("UserId");


        userRef.push().setValue(auth);

        finish();
    }
}
