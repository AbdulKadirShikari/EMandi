package com.example.emandi.fragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.emandi.Mri;
import com.example.emandi.R;
import com.example.emandi.database.UserDataHelper;
import com.example.emandi.database.UserModel;

import java.util.Calendar;

public class HomeFragment extends Fragment {


    EditText  ent_jins,ent_mark,ent_city,ent_rate,ent_amount,ent_qty;
    TextView ent_save,textshowDate,sendemail;
    LinearLayout ent_selectdate;


    int calendaryear,calendarmonth,calendardayOfMonth;
    String selectyear, selectmonth, selectdday;
    String selected_date;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


        View root = inflater.inflate(R.layout.fragment_home, container, false);






        Calendar calendar = Calendar.getInstance();
        calendaryear = calendar.get(Calendar.YEAR);
        calendarmonth = calendar.get(Calendar.MONTH);
        calendardayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);


        textshowDate = root.findViewById(R.id.tv_show_date);
        ent_save = root.findViewById(R.id.entry_save);

        ent_selectdate = root.findViewById(R.id.entry_selectdate);
        ent_jins = root.findViewById(R.id.entry_jins);
        ent_mark = root.findViewById(R.id.entry_mark);
        ent_city = root.findViewById(R.id.entry_city);
        ent_rate = root.findViewById(R.id.entry_rate);
        ent_qty = root.findViewById(R.id.entry_qty);
        ent_amount = root.findViewById(R.id.entry_amount);



        ent_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String jins = ent_jins.getText().toString();
                String mark = ent_mark.getText().toString();
                String city = ent_city.getText().toString();
                String rate = ent_rate.getText().toString();
                String itemqty = ent_qty.getText().toString();
                String amount = ent_amount.getText().toString();
                String date = textshowDate.getText().toString();



                 if(textshowDate.getText().equals("Select Date")){
                     Mri.T(getActivity(),"Please Select Date");
                }


                 else if(TextUtils.isEmpty(jins)){
                    ent_jins.findFocus();
                    ent_jins.setError("Please Enter Jins");
                }
                else if(TextUtils.isEmpty(mark)){
                    ent_mark.findFocus();
                    ent_mark.setError("Please Enter Mark");
                }
                else if(TextUtils.isEmpty(city)){
                    ent_city.findFocus();
                    ent_city.setError("Please Enter City");
                }
                else if(TextUtils.isEmpty(rate)){
                    ent_rate.findFocus();
                    ent_rate.setError("Please Enter Rate");
                }
                else if(TextUtils.isEmpty(itemqty)){
                    ent_qty.findFocus();
                    ent_qty.setError("Please Enter Quantity");
                }
                else if(TextUtils.isEmpty(amount)){
                    ent_amount.findFocus();
                    ent_amount.setError("Please Enter Amount");
                }

                else{
                    insetdata();
                }

            }
        });


        ent_selectdate.setOnClickListener(new View.OnClickListener() {
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
                                textshowDate.setText(selected_date);

                            }
                        }, calendaryear, calendarmonth, calendardayOfMonth);
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });




        return root;
    }

    private void insetdata() {


     /*   UserModel userModel = new UserModel();

       // userModel.setUser_date(selected_date);


        UserDataHelper.getInstance().insertData(userModel);
        Mri.T(getActivity(),"Data Saved");
*/
    }
}





