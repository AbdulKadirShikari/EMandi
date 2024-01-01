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

public class AddJinsFragment extends Fragment {

    EditText jins;
    TextView savejins;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_addjins, container, false);


        jins = root.findViewById(R.id.edt_jins);
        savejins = root.findViewById(R.id.tv_jins_save);



       savejins.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {


               if(TextUtils.isEmpty(jins.getText().toString())){
                   jins.findFocus();
                   jins.setError("Please Add Jins");
               }
                   else{

                   UserModel model = new UserModel();
                   model.setUser_jins(jins.getText().toString());
                   Mri.E("inser01:-"+jins.getText().toString());
                   UserDataHelper.getInstance().insertData(model);
                   Mri.T(getActivity(),"Jins Add Successfull");
               }
           }
       });

        return root;
    }
}