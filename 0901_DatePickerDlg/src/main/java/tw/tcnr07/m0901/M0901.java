package tw.tcnr07.m0901;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class M0901 extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnTimePicDlg;
    private Button mBtnDatePicDlg;
    private TextView mTxtResult;
    private String u_date="";
     private String u_time="";
    private int minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0901);
        setupViewcomponent();
    }

    private void setupViewcomponent() {
        mBtnTimePicDlg = (Button) findViewById(R.id.m0901_b001);
        mBtnDatePicDlg = (Button) findViewById(R.id.m0901_b002);
        mTxtResult = (TextView) findViewById(R.id.m0901_t001);

        mBtnTimePicDlg.setOnClickListener(this);
        mBtnDatePicDlg.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        mTxtResult.setText("");
        Calendar now=Calendar.getInstance();
        //============================

        switch (v.getId()){
            case R.id.m0901_b001:
                DatePickerDialog dd01=new DatePickerDialog(
                this,
                        datePicDlgOnDateSelLis,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH));
                    dd01.setTitle(getString(R.string.m0901_datetitle));
                    dd01.setMessage(getString(R.string.m0901_datemessage));
                    dd01.setIcon(android.R.drawable.btn_star_big_on);
                    dd01.setCancelable(false);
                    dd01.show();
                break;
            case R.id.m0901_b002:
                TimePickerDialog dd02=new TimePickerDialog(
//                TimePickerDialog dd02=new TimePickerDialog(
                        this,
                        timePicDlgOnDateSelLis,
                        now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE),
                        false);
                dd02.setTitle(getString(R.string.m0901_datetitle));
                dd02.setMessage(getString(R.string.m0901_datemessage));
                dd02.setIcon(android.R.drawable.btn_star_big_on);
                dd02.setCancelable(false);
                dd02.show();
                break;
        }
    }



    private  DatePickerDialog.OnDateSetListener datePicDlgOnDateSelLis=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            u_date = Integer.toString(year) + getString(R.string.n_yy) +
                    Integer.toString(month+1) + getString(R.string.n_mm) +
                    Integer.toString(dayOfMonth) + getString(R.string.n_dd);
            mTxtResult.setText(getString(R.string.m0901_datetitle) +
                    u_date + "\n " + u_time);
        }
    };


    private  TimePickerDialog.OnTimeSetListener timePicDlgOnDateSelLis=new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            u_time = getString(R.string.m0901_timetitle) +
                    Integer.toString(hourOfDay) + getString(R.string.d_hh) +
                    Integer.toString(minute) + getString(R.string.d_mm);
            mTxtResult.setText(getString(R.string.m0901_datetitle) +
                    u_date + "\n" + u_time);
        }
    };
}