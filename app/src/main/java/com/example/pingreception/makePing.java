package com.example.pingreception;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class makePing extends AppCompatActivity {

    private Button goBack;
    private TextView pingAnswer;
    private String getInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_ping);

        goBack = findViewById(R.id.goBack);
        pingAnswer = findViewById(R.id.pingAnswer);
        getInput = getIntent().getStringExtra("input");
        Log.e("inputPass",getInput);

        new Thread(
                () ->{
                    try {
                        InetAddress inetAddress = InetAddress.getByName(getInput);

                        pingAnswer.setText("");
                        /////// falta la variable para sumar
                        for (int i=0; i<4;i++){

                            boolean reach =inetAddress.isReachable(1000);
                            Log.e("Status",getInput);
                            if(reach){
                                pingAnswer.append("Sé conecto" + " " + getInput+"\n");

                            } else {
                                pingAnswer.append("No sé conecto"+"\n");
                            }
                            Thread.sleep(2000);
                        }

                    } catch (UnknownHostException e) {
                        //por si encuentre el HOST
                        e.printStackTrace();
                    } catch (IOException e) {
                        //por si no es alcanzable
                        e.printStackTrace();
                        //para el sleep
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        ).start();


        goBack.setOnClickListener(
                (view) -> {
                    finish();
                }
        );


    }
}