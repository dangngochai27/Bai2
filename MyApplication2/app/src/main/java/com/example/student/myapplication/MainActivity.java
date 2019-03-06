package com.example.student.myapplication;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtTruyen;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTruyen = (EditText)findViewById(R.id.edt_TruyenNoiDung);
        btnAdd = (Button) findViewById(R.id.btn_Add);

        FragmentManager fragmentManager = getFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentA fragmentA = new FragmentA();

                Bundle bundle = new Bundle();
                bundle.putString("Test",edtTruyen.getText().toString());
                fragmentA.setArguments(bundle);
                fragmentTransaction.add(R.id.myLinearLayout, fragmentA);
                fragmentTransaction.commit();
            }
        });
    }
}
