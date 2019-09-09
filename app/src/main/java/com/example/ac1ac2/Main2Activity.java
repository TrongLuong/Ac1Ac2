package com.example.ac1ac2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;
import java.util.TimeZone;


public class Main2Activity extends AppCompatActivity {
    private TextView hoTen, tuoi;
    private Button submit2, submit3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        hoTen = findViewById(R.id.txtTen);
        tuoi = findViewById(R.id.txtTuoi);
        submit2 = findViewById(R.id.btnSubmit2);
        submit3 = findViewById(R.id.btnSubmit3);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("THONGTIN");


        final String ht = bundle.getString("HOTEN");
        final String ns = bundle.getString("NAMSINH");
        //MONTH //chỉ lấy giá trị từ 0-11 tương ứng với tháng từ 1-12
        hoTen.setText("Họ tên: " + ht);
        tuoi.setText("Năm sinh: " + ns);


        submit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+7"));
                int year = calendar.get(Calendar.YEAR);

                int ns1 = Integer.parseInt(ns);
                int tuoi1 = year-ns1;
                sedToMain(tuoi1,MainActivity.TUOI);


            }
        });

    }

    public void sedToMain(int value, int ketqua) {
        Intent intent = getIntent();
        Bundle bundle = new Bundle();
        bundle.putInt("kqTUOI", value);
        intent.putExtra("tuoi", bundle);
        setResult(ketqua, intent);
        finish();


    }


}
