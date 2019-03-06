package com.example.student.myapplication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentA extends Fragment {
    Button btnClick;
    TextView txtNoidung;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        btnClick = (Button) view.findViewById(R.id.btn_ClickA);
        txtNoidung = (TextView) view.findViewById(R.id.textViewNoidung);

        FragmentManager fragmentManager = getFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                FragmentB fragmentB = new FragmentB();
                Bundle bundle = new Bundle();
                bundle.putString("Test",txtNoidung.getText().toString());
                fragmentB.setArguments(bundle);
              //  fragmentTransaction.add(R.id.layoutA,fragmentB);
                fragmentTransaction.commit();

            }
        });

        Bundle bundle = getArguments();

        if(bundle != null){
            txtNoidung.setText(bundle.getString("Test"));
        }

        return view;
    }
}
