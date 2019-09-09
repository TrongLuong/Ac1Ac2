package com.example.ac1ac2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int NAMSINH = 0;
    public static final int TUOI =0;

    EditText hoTen, namSinh;
    Button submit;
    TextView tuoi;
    public  void  anhXa(){
        hoTen = findViewById(R.id.edtTen);
        namSinh = findViewById(R.id.edtTuoi);
        submit =  findViewById(R.id.btnSubmit);
        tuoi = findViewById(R.id.txtTT);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         anhXa();
         setClick();


    }
    public void setClick(){
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                Bundle bundle = new Bundle();
                bundle.putString("HOTEN", hoTen.getText().toString());
                bundle.putString("NAMSINH",namSinh.getText().toString());
                intent.putExtra("THONGTIN",bundle);
                startActivityForResult(intent,NAMSINH);
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode,  Intent data) {

        if (data == null) {
            return;
        }
        if (requestCode == NAMSINH) {

            Bundle bundle = data.getBundleExtra("tuoi");

            String kq = bundle.getString("kqTUOI");
            if(resultCode==TUOI)

                tuoi.setText(kq);

        }




    }
}
