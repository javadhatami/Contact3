package approom.ir.contact3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by javad on 8/25/2017 AD.
 */

public class CreateActivity extends AppCompatActivity {

    EditText nameEDT;
    EditText phoneEDT;
    EditText mailEDT;
    Button saveBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        nameEDT = (EditText) findViewById(R.id.name);
        phoneEDT = (EditText) findViewById(R.id.phone);
        mailEDT = (EditText) findViewById(R.id.mail);
        saveBtn = (Button) findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ContactDBModel contactDBModel = new ContactDBModel();

                contactDBModel.setName(nameEDT.getText().toString());
                contactDBModel.setMobile(phoneEDT.getText().toString());
                contactDBModel.setMail(mailEDT.getText().toString());
                contactDBModel.save();

                Intent intent = new Intent(CreateActivity.this,MainActivity.class);
                startActivity(intent);



            }


        });




    }
}
