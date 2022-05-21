package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
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
    public static String gen="i";
    TextView t1,t2;
    SeekBar seekbar;
    TextView heightv;
    public static int ch=170;
    public static int weight=55;
    public static int age=18;
    int mi=0,fi=0;
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
                mi+=1;
                if(mi%2==0){
                    male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mf));
                    female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mf));
                    t1.setTextColor(Color.parseColor("#c2c2a3"));
                    gen="i";
                }
                else {
//                t2.setTextColor(R.color.white);
                    male.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.mfh));
                    female.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.bg));
                    t1.setTextColor(Color.parseColor("#000000"));
                    t2.setTextColor(Color.parseColor("#c2c2a3"));

                    gen = "Male";
                }
            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                fi+=1;
                if(fi%2==0){
                    male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mf));
                    female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.mf));
                    t2.setTextColor(Color.parseColor("#c2c2a3"));
                    gen="i";

                }
//                t1.setTextColor(R.color.white);
                else {
                    female.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.mfh));
                    male.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.bg));
                    gen = "Female";
                    t2.setTextColor(Color.parseColor("#000000"));
                    t1.setTextColor(Color.parseColor("#c2c2a3"));
                }

            }
        });

//  margin top
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
                if (gen=="i" || (weight==0 || age==0) || ch==0){
                    Toast.makeText(MainActivity.this, "Please select valid details", Toast.LENGTH_SHORT).show();
                    MainActivity.weight=55;
                    MainActivity.age=18;
                    mi=0;
                    fi=0;

                    Intent intent=new Intent(MainActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this, "calculating", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);

                }
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