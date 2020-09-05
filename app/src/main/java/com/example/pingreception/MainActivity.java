package com.example.pingreception;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText iP1;
    private EditText iP2;
    private EditText iP3;
    private EditText iP4;
    private Button btnPing;
    private Button btnSearhHost;
    private String inputIP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iP1 = findViewById(R.id.Ip1);
        iP2 = findViewById(R.id.Ip2);
        iP3 = findViewById(R.id.Ip3);
        iP4 = findViewById(R.id.Ip4);
        btnPing = findViewById(R.id.btnPing);
        btnSearhHost = findViewById(R.id.btnSearchHost);





        btnPing.setOnClickListener(
                (v)->{
                    if(iP1.getText().toString().equals("") || iP2.getText().toString().equals("")
                            || iP3.getText().toString().equals("") || iP4.getText().toString().equals("")){
                        Toast.makeText(this,"Por favor digite un IP Adress",Toast.LENGTH_LONG).show();
                    } else {
                        inputIP = iP1.getText().toString()+"."+iP2.getText().toString()+"."+iP3.getText().toString()+"."+iP4.getText().toString();
                        Intent i = new Intent(this,makePing.class);
                        i.putExtra("input",inputIP);
                        Log.e("IP",inputIP);
                        startActivity(i);
                    }

                }
        );

    }
}