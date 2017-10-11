package com.homework.android.tinkoffhomework2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView message;
    private Button btnOK;
    private Button btnCancel;
    private String text;
    public static final int REQ_CODE = 0;

    public static void startForResult(Activity activity, int requestCode, String text) {
        Intent starter = new Intent(activity, ResultActivity.class);
        starter.putExtra("newText", text);
        activity.startActivityForResult(starter, requestCode);
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        message = (TextView) findViewById(R.id.text);
        btnOK = (Button) findViewById(R.id.btn_ok);
        btnCancel = (Button) findViewById(R.id.btn_cancel);

        Intent intent = getIntent();

        text = intent.getStringExtra("newText");

        message.setText(text);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("result", text);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
