package com.example.pingreception;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class SearchHost extends AppCompatActivity {

    private TextView hostAnswer;
    private Button goBack;
    private String getHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_host);

        hostAnswer = findViewById(R.id.hostAnswer);
        goBack = findViewById(R.id.goBack);
        getHost = getIntent().getStringExtra("host");
        Log.e("IP",getHost);


        new Thread(
                ()->{
                    try {
                        runOnUiThread(
                                () -> {
                                    hostAnswer.setText("");
                                }
                        );

                        for (int i=0; i<254; i++){
                            InetAddress inetAddress = InetAddress.getByName(getHost+i);
                            Log.e("currentIP",inetAddress.toString());
                            boolean isReachable = inetAddress.isReachable(1000);
                            if(isReachable){
                                int finalI = i;
                                runOnUiThread(
                                        () ->{
                                            hostAnswer.append(getHost+ finalI +"\n");
                                        }
                                );

                            }
                        Thread.sleep(1000);
                        }

                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
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