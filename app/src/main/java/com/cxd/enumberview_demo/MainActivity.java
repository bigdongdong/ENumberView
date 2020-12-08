package com.cxd.enumberview_demo;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


import com.cxd.enumberview.ECharView;
import com.cxd.enumberview.ENumberView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ENumberView eNumberView ;
    private ENumberView eNumberView2 ;
    private Button button ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eNumberView = findViewById(R.id.eNumberView);
        eNumberView2 = findViewById(R.id.eNumberView2);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < 6; i++) {
                    sb.append(new Random().nextInt(10));
                }
                long l = Long.parseLong(sb.toString()) ;
                eNumberView.set(l);
                eNumberView2.set(l,true);
            }
        });
    }
}