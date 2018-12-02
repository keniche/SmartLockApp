package com.android.ken.firetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    final String DEVICE_ID = "hoge";
    Boolean isLock = true;
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = (ToggleButton)findViewById(R.id.toggleButton) ;

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference userRef = database.getReference("DEVICE_ID").child("Status");

        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(final DataSnapshot dataSnapshot) {
                isLock = dataSnapshot.getValue(Boolean.class);

                if (isLock == true){
                    toggleButton.setChecked(true);
                }else{
                    toggleButton.setChecked(false);
                }

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

    }

    public void seeAuth(View v){
        Intent intent = new Intent(this, AuthActivity.class);
        startActivity(intent);
    }

    public void seeTimestamp(View v) {
        Intent intent = new Intent(this, TimestampActivity.class);
        startActivity(intent);
    }





}
