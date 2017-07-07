package com.github.yanjiabin.extenddialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.yanjiabin.extendsdialoglib.DialogViewHolder;
import com.github.yanjiabin.extendsdialoglib.ExtendsDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExtendsDialog extendsDialog = new ExtendsDialog(this,R.layout.dialog) {
            @Override
            public void convert(DialogViewHolder holder) {

            }
        }.fromBottomToMiddle().setCanceledOnTouchOutside(true).fullWidth().showDialog();

    }
}
