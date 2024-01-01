package com.example.emandi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class Mri {

    public static void E(String msg) {
        if (true)
            Log.e("Log.E By Mrityunjay", msg);
    }

    public static void T(Context c, String msg) {
        Toast.makeText(c, msg, Toast.LENGTH_SHORT).show();
    }



    public static void I_clear(Context cx, Class<?> startActivity) {
        Intent i = new Intent(cx, startActivity);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        cx.startActivity(i);
    }
}
