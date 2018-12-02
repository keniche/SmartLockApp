package com.android.ken.firetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    final String DEVICE_ID = "hoge";
    Boolean isLock = true;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference userRef = database.getReference("DEVICE_ID").child("Status");

        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(final DataSnapshot dataSnapshot) {
                isLock = dataSnapshot.getValue(Boolean.class);
                textView.setText(isLock.toString());
            }

            @Override
            public void onCancelled(final DatabaseError databaseError) {
            }
        });



    }

    public void touch (View v){
        isLock = !isLock;

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference userRef = database.getReference("DEVICE_ID").child("Status");

        userRef.setValue(isLock);

        postTimestamp(v);

    }

    public void postTimestamp(View v) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference timestampRef = database.getReference("DEVICE_ID").child("Timestamp");

        Timestamp timestamp = new Timestamp();
        timestamp.setDatetime("2001-03-10_17:16:18");
        timestamp.setUserName("konatsu_p");
        timestamp.setLocked(isLock);

        timestampRef.push().setValue(timestamp);
    }

    public void seeTimestamp(View v) {
        Intent intent = new Intent(this, TimestampActivity.class);
        startActivity(intent);
    }





}
