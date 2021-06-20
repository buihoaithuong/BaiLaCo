package com.example.bailaco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView LvCo;
    ArrayList<ClassCo> arrayListCo;
    AdapterLaCo adapterLaCo;
    int viTri = -1;
    EditText edt1, edt2;
    Button btnUdate, btnView, btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        arrayListCo = new ArrayList<>();

        arrayListCo.add(new ClassCo(R.drawable.ic_baseline_emoji_flags_24,"Lẩu","Hàn Quốc"));
        arrayListCo.add(new ClassCo(R.drawable.ic_baseline_flag_24,"Nướng","Nhật Bản"));
        arrayListCo.add(new ClassCo(R.drawable.ic_baseline_outlined_flag_24,"Kem","Việt Nam"));

        adapterLaCo = new AdapterLaCo(this, R.layout.dong_la_co, arrayListCo);
        LvCo.setAdapter(adapterLaCo);

        Delete();
        Update();
        Add();
    }

    private void Add() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1 = edt1.getText().toString();
                String text2 = edt2.getText().toString();
                arrayListCo.add(new ClassCo(
                        R.drawable.ic_baseline_flag_24, text1, text2 ));
                adapterLaCo.notifyDataSetChanged();
            }
        });
    }

    private void Delete() {
        LvCo.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                arrayListCo.remove(position);
                adapterLaCo.notifyDataSetChanged();
                return false;
            }
        });
    }

    private void Update() {
        LvCo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                viTri = position;
                edt1.setText(arrayListCo.get(position).getText1());
                edt2.setText(arrayListCo.get(position).getText2());
            }
        });
        btnUdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayListCo.set(viTri, new ClassCo(
                        R.drawable.ic_baseline_flag_24,
                        edt1.getText().toString(),
                        edt2.getText().toString()
                ));
            }
        });
    }

    private void AnhXa() {
        LvCo = (ListView) findViewById(R.id.ListView);
        edt1 = (EditText) findViewById(R.id.editText1);
        edt2 = (EditText) findViewById(R.id.editText2);
        btnUdate = (Button) findViewById(R.id.buttonUpdate);
        btnAdd = (Button) findViewById(R.id.buttonAdd);
        btnView = (Button)findViewById(R.id.buttonView);
    }

}