package com.vrired.barcodescanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button scanBtn;
    //private TextView formatTxt;
    private int SCAN_WITH_CAMERA = 1;
    private TextView contentTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scanBtn = (Button)findViewById(R.id.scan_button);
        //formatTxt = (TextView)findViewById(R.id.scan_format);
        contentTxt = (TextView)findViewById(R.id.scan_content);

        scanBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.scan_button){
            //scan
            Intent intent=new Intent(MainActivity.this,CameraTestActivity.class);
            startActivityForResult(intent,SCAN_WITH_CAMERA);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SCAN_WITH_CAMERA){
            if(resultCode==RESULT_OK){
                String content=data.getStringExtra("CONTENT");
                Log.e("MainActivity::",content);
                contentTxt.setText("Content : "+content);

            }else{
                Log.e("MainActivity::","Error while reading");
                Toast.makeText(getApplicationContext(),"Some Error Occured",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
