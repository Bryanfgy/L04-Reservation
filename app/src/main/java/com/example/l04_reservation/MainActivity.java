package com.example.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    DatePicker dp;
    TimePicker tp;
    EditText nameIn, phoneNo, noOfPeople;
    CheckBox smoke;
    Button submit, reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        nameIn = findViewById(R.id.nameInput);
        phoneNo = findViewById(R.id.PhoneNumber);
        noOfPeople = findViewById(R.id.NumberOfpeople);
        smoke = findViewById(R.id.smoking);
        submit = findViewById(R.id.Submit);
        reset = findViewById(R.id.Reset);

        dp.updateDate(2023, 0, 01);
        tp.setHour(12);
        tp.setMinute(0);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameVal = nameIn.getText().toString();
                String phoneVal = phoneNo.getText().toString();
                String personVal = noOfPeople.getText().toString();

                int curYear = dp.getYear();
                int curMonth = dp.getMonth();
                int curDay = dp.getDayOfMonth();
                int month = curMonth + 1;
                String date = +curDay+"/"+month+"/"+curYear;

                int curHour = tp.getHour();
                int curMin =  tp.getMinute();
                String Min = String.format("%02d", curMin);
                String time  = curHour +":"+ Min;
                String smokeSeat = "";

                if(smoke.isChecked()){
                    smokeSeat = "Smoking area selected";
                } else{
                    smokeSeat = "Non-Smoking area selected";
                }

                Toast.makeText(MainActivity.this,
                        "Reservation Details:\nName: "+nameVal+
                        "\nPhone No:"+phoneVal+"\nNo. of People:"+personVal+
                        "\nDate:"+date+"\nTime:"+time+"\nSmoking Area: "+smokeSeat,Toast.LENGTH_LONG).show();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameIn.setText("");
                phoneNo.setText("");
                noOfPeople.setText("");
                dp.updateDate(2023, 0, 01);
                tp.setHour(12);
                tp.setMinute(0);
                smoke.setChecked(false);

            }
        });


    }
}