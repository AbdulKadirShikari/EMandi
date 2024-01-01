package com.example.emandi.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.emandi.Mri;
import com.example.emandi.R;
import com.example.emandi.database.UserDataHelper;
import com.example.emandi.database.UserModel;

import java.util.ArrayList;

public class ReportFragment extends Fragment {


    int calendaryear,calendarmonth,calendardayOfMonth;
    String selectyear, selectmonth, selectdday;
    String selected_date;

    TextView tv_startdate,tv_enddate;

    LinearLayout report_show , showbtn, startDate,endDate;

    Spinner  jins_Spinner,mark_spinner;


    ArrayAdapter<String> JinsAdapter;
    ArrayAdapter<String> MarkAdapter;
    ArrayList<String> JinsList = new ArrayList<>();
    ArrayList<String> MarkList = new ArrayList<>();



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_report, container, false);


        startDate = root.findViewById(R.id.report_start_date);
        endDate = root.findViewById(R.id.report_end_date);

        jins_Spinner = root.findViewById(R.id.report_jins_spinner);
        mark_spinner = root.findViewById(R.id.report_mark_spinner);

        tv_startdate = root.findViewById(R.id.tv_start_date);
        tv_enddate = root.findViewById(R.id.tv_end_date);

        showbtn = root.findViewById(R.id.showreport_btn);
        report_show = root.findViewById(R.id.linear_report_show);

       /* if (UserDataHelper.getInstance().getList().size() > 0) {


      // String  jins = UserDataHelper.getInstance().getList().get(0).getUserjins();

           // JinsList.add(jins);
        }*/

       /* for(int i =0 ;i<UserDataHelper.getInstance().getList().size(); i++){

            String  jinsname = UserDataHelper.getInstance().getList().get(i).getUserjins();
            Mri.E("jinsname:--"+jinsname);

        }
*/


        JinsAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, JinsList);
        JinsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jins_Spinner.setAdapter(JinsAdapter);

        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                                selectyear = String.valueOf(year);

                                if (month < 10) {
                                    selectmonth = String.valueOf("0" + (month + 1));
                                } else {
                                    selectmonth = String.valueOf(month + 1);
                                }
                                if (day < 10) {
                                    selectdday = String.valueOf("0" + day);
                                } else {
                                    selectdday = String.valueOf(day);
                                }

                                selected_date = selectyear + "-" + selectmonth + "-" + selectdday;
                                tv_startdate.setText(selected_date);

                            }
                        }, calendaryear, calendarmonth, calendardayOfMonth);

                datePickerDialog.updateDate(calendaryear, calendarmonth, calendardayOfMonth);
                datePickerDialog.show();

            }
        });


        endDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                                selectyear = String.valueOf(year);

                                if (month < 10) {
                                    selectmonth = String.valueOf("0" + (month + 1));
                                } else {
                                    selectmonth = String.valueOf(month + 1);
                                }
                                if (day < 10) {
                                    selectdday = String.valueOf("0" + day);
                                } else {
                                    selectdday = String.valueOf(day);
                                }

                                selected_date = selectyear + "-" + selectmonth + "-" + selectdday;
                                tv_enddate.setText(selected_date);

                            }
                        }, calendaryear, calendarmonth, calendardayOfMonth);
                datePickerDialog.updateDate(calendaryear, calendarmonth, calendardayOfMonth);
                datePickerDialog.show();

            }
        });


        showbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                report_show.setVisibility(View.VISIBLE);

               /* UserModel userModel = new UserModel();
                userModel.setUserPhone(mobile.getText().toString());
                userModel.setUserName(username.getText().toString());
                userModel.setUserPassword(password.getText().toString());
                UserDataHelper.getInstance().insertData(userModel);
*/

            }
        });




        report_show.setVisibility(View.GONE);

        return root;
    }
}