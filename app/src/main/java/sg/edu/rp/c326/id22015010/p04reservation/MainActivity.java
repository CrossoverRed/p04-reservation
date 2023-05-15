package sg.edu.rp.c326.id22015010.p04reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView title;
    EditText Nameinuput;
    EditText Phoneinput;
    EditText Sizeinput;
    DatePicker dp;
    TimePicker tp;
    CheckBox smokebox;
    CheckBox nosmokebox;
    Button Submitbtn;
    Button resetbtn;
    TextView TVDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = findViewById(R.id.title);
        Nameinuput = findViewById(R.id.nameEdit);
        Phoneinput = findViewById(R.id.phoneEdit);
        Sizeinput = findViewById(R.id.sizeEdit);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        smokebox = findViewById(R.id.SmokingId);
        nosmokebox = findViewById(R.id.NonSmokingId);
        Submitbtn = findViewById(R.id.Submitbtn);
        resetbtn = findViewById(R.id.resetBtn);
        TVDisplay = findViewById(R.id.textView);


        if (Phoneinput.length() != 9) {
            TVDisplay.setText("Successful Phone Number" + Phoneinput);
        } else {
            TVDisplay.setText("Unsuccessful, please enter so that is within 9 numbers.");
        }
        tp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time= tp.getCurrentHour().toString()+ tp.getCurrentMinute().toString();
                TVDisplay.setText("Time is: "+time);

            }
        });

        dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = dp.getYear() + "/" + (dp.getMonth() + 1) + "/" + dp.getDayOfMonth();
                TVDisplay.setText("Date is: " + date);
            }


        });
        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tp.setCurrentHour(0);
                tp.setCurrentMinute(0);
                dp.updateDate(2020, 0,1);
            }
        });
        Submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "button is clicked", Toast.LENGTH_LONG).show();
                CheckBox checkBox1 = (CheckBox) findViewById(R.id.SmokingId);
                if (checkBox1.isChecked()) {
                    TVDisplay.setText("Smoking Booked");
                }else{
                    TVDisplay.setText("Non-Smoking Booked");
                }
            }
        });

    }
}