package com.example.android.notificationexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;

import java.util.ArrayList;
import java.util.Arrays;

public class HeadActivity extends AppCompatActivity implements android.widget.AdapterView.OnItemSelectedListener{

    private DatabaseReference mdb;

    private Spinner headfaculty, headdepartment;
    private ArrayList<String> listApplied = new ArrayList<String>(Arrays.asList("Boteny", "Chemistry",
            "Computer Science", "Forestry and Environmental Sciences",
            "Food Science and Technology", "Mathematics", "Physics",
            "Statistics", "Zoology", "Sport Science"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head);

        mdb = FirebaseDatabase.getInstance().getReference();

        headfaculty = (Spinner) findViewById(R.id.head_faculty);
        headdepartment = (Spinner) findViewById(R.id.head_department);
        addListenerOnSpinnerItemSelection();
    }

    private void addListenerOnSpinnerItemSelection() {
        //headfaculty = (Spinner) findViewById(R.id.spinner_faculty);
        headfaculty.setOnItemSelectedListener(this);
    }

    public void headnextclicked(View view) {
        String token_id = FirebaseInstanceId.getInstance().getToken();

        mdb.child("faculty").child(headfaculty.getSelectedItem().toString().trim())
                .child(headdepartment.getSelectedItem().toString().trim()).child("token").setValue(token_id).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Intent intent = new Intent(HeadActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        ArrayList<String> list = new ArrayList<String>();
        if (adapterView.getItemAtPosition(i).toString().equals("Applied Sciences")) {
            list = listApplied;
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        headdepartment.setAdapter(dataAdapter);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
