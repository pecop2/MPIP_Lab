package com.example.petar.lab_intents;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Button explicitBtn, implicitBtn, actionSendBtn, choosePicBtn;
    private TextView explicitResultTv;
    private Intent pictureIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        explicitBtn = (Button) findViewById(R.id.explicitBtn);
        implicitBtn = (Button) findViewById(R.id.implicitBtn);
        actionSendBtn = (Button) findViewById(R.id.actionSendBtn);
        choosePicBtn = (Button) findViewById(R.id.choosePicBtn);
        explicitResultTv = (TextView) findViewById(R.id.explicitResultTv);

    }

    public void explicitBtnClick(View view) {
        Intent explicitIntent = new Intent(MainActivity.this, ExplicitActivity.class);
        startActivityForResult(explicitIntent, 1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1)
        {
            if (resultCode==RESULT_OK)
            {
                explicitResultTv.setText(data.getExtras().getString("data"));

            }

        }

        if (requestCode==2)
        {
            if (resultCode==RESULT_OK)
            {

                Uri pictureUri = data.getData();
                pictureIntent=new Intent(Intent.ACTION_VIEW, pictureUri);

               // pictureIntent.setAction(Intent.ACTION_VIEW);
                //Intent chooser = Intent.createChooser(pictureIntent, "CHOOOOOOOSER");
                if (pictureIntent.resolveActivity(getPackageManager()) != null)
                    startActivity(pictureIntent);
            }

        }


    }

    public void implicitBtnClick(View view)
    {

        Intent implicitIntent = new Intent();
        implicitIntent.setAction("mk.ukim.finki.mpip.IMPLICIT_ACTION");

        if (implicitIntent.resolveActivity(getPackageManager()) != null)
            startActivity(implicitIntent);

    }

    public void actionSendBtnClick(View view) {

        Intent send = new Intent();
        send.setAction(Intent.ACTION_SEND);
        send.setType("text/plain");
        Bundle data=new Bundle();

        //data.putString(Intent.EXTRA_TITLE, "MPiP Send Title");
        //data.putString(Intent.EXTRA_TEXT, "Content sent from MainActivity");
        //send.putExtras(data);
        send.putExtra(Intent.EXTRA_TITLE, "MPiP Send Title");
        send.putExtra(Intent.EXTRA_TEXT, "Content sent from MainActivity");


        //String title = "CHOOSER SHTO E BE";
        //Intent chooser = Intent.createChooser(send, title);
        if (send.resolveActivity(getPackageManager()) != null)
        {
            startActivity(send);
        }
            //send.setAction(Intent.ACTION_SEND);

    }

    public void choosePictureBtnClick(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        //Intent chooser = Intent.createChooser(intent, "Izberi slika");
        if (intent.resolveActivity(getPackageManager()) != null)
            startActivityForResult(intent, 2);

    }


}
