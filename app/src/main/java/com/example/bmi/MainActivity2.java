package com.example.bmi;

import static com.example.bmi.R.drawable.wrong;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
Button b;
int hei=MainActivity.ch;
int wei=MainActivity.weight;
String gen= MainActivity.gen;
int age=MainActivity.age;
TextView bmiindex;
TextView gender;
TextView cat;
ImageView img;
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b=findViewById(R.id.button2);
        bmiindex=findViewById(R.id.bmiindex);
        gender=findViewById(R.id.gender);
        cat=findViewById(R.id.cat);
        img=findViewById(R.id.imageView5);
        double bmi= (double) wei/(((double) hei/100)*((double) hei/100));
        double d=Math.round(bmi*100)/100.0;
        bmiindex.setText(String.valueOf(d));


        gender.setText(gen);

            if(bmi<18.5){

                cat.setText("Under weight");

                cat.setTextColor(Color.parseColor("#ffff00"));
                img.setImageResource(R.drawable.wrong);


            }
            else if(bmi<25){
                cat.setText("Healthy weight");
//                cat.setTextColor(R.color.green);
                cat.setTextColor(Color.parseColor("#33cc33"));
                img.setImageResource(R.drawable.tick);
            }
            else if(bmi<30){
                cat.setText("Over weight");
//                cat.setTextColor(R.color.orange);
                cat.setTextColor(Color.parseColor("#ff9900"));
                img.setImageResource(R.drawable.wrong);
            }
            else{
                cat.setText("Obesity");
//                cat.setTextColor(R.color.red);
                cat.setTextColor(Color.parseColor("#cc0000"));
                img.setImageResource(R.drawable.wrong);
            }






        b.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Toast.makeText(MainActivity2.this, "redirecting", Toast.LENGTH_SHORT).show();
                MainActivity.gen="i";
                MainActivity.weight=55;
                MainActivity.age=18;

                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}