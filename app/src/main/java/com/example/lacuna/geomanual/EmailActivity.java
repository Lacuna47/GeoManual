package com.example.lacuna.geomanual;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Lacuna on 17.05.2015.
 */
public class EmailActivity extends Activity {
    Button send;
    EditText address, emailtext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //скрываем заголовок
        setContentView(R.layout.email);

        send = (Button) findViewById(R.id.send_button);
        address = (EditText) findViewById(R.id.emailaddress);
        emailtext = (EditText) findViewById(R.id.emailtext);


        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

                emailIntent.setType("plain/text");
                // Кому
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,new String[] { address.getText().toString() });

                // О чём
                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,emailtext.getText().toString());

                startActivity(Intent.createChooser(emailIntent,
                        "Отправка письма"));
            }
        });
    }
}
