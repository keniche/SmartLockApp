package com.android.ken.firetest;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class AuthActivity extends AppCompatActivity {

    ListView listView;
    List<Auth> authList;
    AuthAdapter authAdapter;

    int i = 0;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference refAuth = database.getReference("DEVICE_ID").child("UserId");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        listView = (ListView) findViewById(R.id.listView);
        authList = new ArrayList<Auth>();
        authAdapter = new AuthAdapter(this, R.layout.listview_item_auth, authList);

        listView.setAdapter(authAdapter);

        refAuth.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Auth value = dataSnapshot.getValue(Auth.class);

                authList.add(value);
                authAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void plus(View v) {
        Intent intent = new Intent(this, AddAuthActivity.class);
        startActivity(intent);
    }
}
