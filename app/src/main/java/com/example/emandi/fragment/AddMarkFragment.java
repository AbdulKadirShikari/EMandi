package com.example.emandi.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.emandi.Mri;
import com.example.emandi.R;
import com.example.emandi.database.UserDataHelper;
import com.example.emandi.database.UserModel;

public class AddMarkFragment extends Fragment {


    EditText mark;
    TextView savemark;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_addmark, container, false);

        mark = root.findViewById(R.id.edt_mark);
        savemark = root.findViewById(R.id.tv_add_mark);





        savemark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(mark.getText().toString())){
                    mark.findFocus();
                    mark.setError("Please Add Mark");
                }


              /* else if(!mark.getText().equals("")){
                    UserModel userModel = new UserModel();
                    Mri.E("GETMark:--"+mark.getText().toString());
                    userModel.setUser_mark(mark.getText().toString());
                    UserDataHelper.getInstance().insertData(userModel);
                    Mri.T(getActivity(),"mark Add Successfull");
                }*/

            }
        });



        return root;
    }
}