package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button b;
    LinearLayout male;
    LinearLayout female;
    String gen;
    TextView t1,t2;
    SeekBar seekbar;
    TextView heightv;
    int ch=170;
    int weight=55;
    int age=18;
    TextView weight1,age1;
    ImageView weightinc,weightdec,ageinc,agedec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.button);
        male=findViewById(R.id.male);
        female=findViewById(R.id.female);
        t1=findViewById(R.id.textView);
        t2=findViewById(R.id.textView2);
        seekbar=findViewById(R.id.seekBar);
        heightv=findViewById(R.id.heightv);
        weight1=findViewById(R.id.textView7);
        age1=findViewById(R.id.textView8);
        weightdec=findViewById(R.id.weightdec);
        weightinc=findViewById(R.id.weightinc);
        ageinc=findViewById(R.id.ageinc);
        agedec=findViewById(R.id.agedec);

        male.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
//                t2.setTextColor(R.color.white);
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mfh));
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.bg));
                t1.setTextColor(R.color.black);

                gen="male";

            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
//                t1.setTextColor(R.color.white);
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mfh));
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.bg));
                gen="female";
                t2.setTextColor(R.color.black);


            }
        });
//        deselect,margin top
        seekbar.setMax(300);
        seekbar.setProgress(170);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                ch=i;
                heightv.setText(String.valueOf(ch));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "calculating", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
        ageinc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                age=age+1;
                age1.setText(String.valueOf(age));

            }
        });
        agedec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                age=age-1;
                if(age<=0){
                    Toast.makeText(MainActivity.this, "Please enter valid age", Toast.LENGTH_SHORT).show();
                    age=0;
                }
                age1.setText(String.valueOf(age));

            }
        });
        weightinc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weight++;
                weight1.setText(String.valueOf(weight));
            }
        });
        weightdec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weight--;
                if(weight<=0){
                    Toast.makeText(MainActivity.this, "Please enter valid weight", Toast.LENGTH_SHORT).show();
                weight=0;
                }
                weight1.setText(String.valueOf(weight));
            }
        });
    }

}