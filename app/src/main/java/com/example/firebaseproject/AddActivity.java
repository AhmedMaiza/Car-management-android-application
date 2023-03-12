package com.example.firebaseproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddActivity extends AppCompatActivity {
    EditText name,manufacturer,origin,price,surl;
    Button btnAdd,btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name = (EditText)findViewById(R.id.txtname);
        manufacturer = (EditText)findViewById(R.id.txtmanu);
        origin = (EditText)findViewById(R.id.txtorigin);
        price = (EditText)findViewById(R.id.txtprice);
        surl = (EditText)findViewById(R.id.txtImageUrl);

        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnBack = (Button)findViewById(R.id.btnBack);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
                clearAll();

            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

    }
    private void insertData()
    {
        Map<String,Object> map = new HashMap<>();
        map.put("name",name.getText().toString());
        map.put("manufacturer",manufacturer.getText().toString());
        map.put("origin",origin.getText().toString());
        map.put("price",price.getText().toString());
        map.put("turl",surl.getText().toString());
        FirebaseDatabase.getInstance().getReference().child("cars").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddActivity.this, "Error", Toast.LENGTH_SHORT).show();

                    }
                });
    }
    private  void clearAll()
    {
        name.setText("");
        manufacturer.setText("");
        origin.setText("");
        price.setText("");
        surl.setText("");

    }
}