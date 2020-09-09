package com.example.pingreception;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class SearchHost extends AppCompatActivity {

    private TextView hostAnswer;
    private Button goBack;
    private String textVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_host);

        hostAnswer = findViewById(R.id.hostAnswer);
        goBack = findViewById(R.id.goBack);

        textVisible = "";

        new Thread(
                ()->{
                    try {
                        for (int i=0; i<254; i++){
                            InetAddress inetAddress = InetAddress.getByName("");
                            boolean isReachable = inetAddress.isReachable(1000);
                            textVisible = ("192.168.0."+i+"\n");
                        }

                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        ).start();

        hostAnswer.setText(textVisible);
    }
}