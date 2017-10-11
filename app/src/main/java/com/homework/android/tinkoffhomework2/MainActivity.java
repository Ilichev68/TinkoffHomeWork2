package com.homework.android.tinkoffhomework2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button shareText;
    private Button newActivity;
    private Button btnTrap;
    private TextView viewResult;
    private EditText newText;
    private String input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shareText = (Button) findViewById(R.id.share_text);
        newActivity = (Button) findViewById(R.id.new_activity);
        newText = (EditText) findViewById(R.id.text);
        viewResult = (TextView) findViewById(R.id.result_text);
        btnTrap = (Button) findViewById(R.id.trap_btn);

        shareText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = newText.getText().toString();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("newText/plain");
                intent.putExtra(Intent.EXTRA_TEXT, input);
                startActivity(Intent.createChooser(intent, "Share with"));
            }
        });

        newActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ResultActivity.startForResult(MainActivity.this, ResultActivity.REQ_CODE, newText.getText().toString());
                newText.setText("");
            }
        });

        btnTrap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TrapActivity.start(MainActivity.this);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (data == null) {return;}
        String result = data.getStringExtra("result");
        viewResult.setText(result);

    }
}
