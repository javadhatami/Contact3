package approom.ir.contact3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.transaction.ITransaction;

import java.util.ArrayList;
import java.util.List;

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

                saveContact();

                onBackPressed();
            }
        });

    }


        public void saveContact() {

        FlowManager.getDatabase(ContactDatabase.class).executeTransaction(new ITransaction() {
            @Override
            public void execute(DatabaseWrapper databaseWrapper) {

                DatabaseModel model = new DatabaseModel();

                String name = nameEDT.getText().toString();
                String phone = phoneEDT.getText().toString();
                String email = mailEDT.getText().toString();

                model.setName(name);
                model.setMobile(phone);
                model.setMail(email);

                Log.d("LocalContactRepository", "--------->model name is :" + model.getName());

                model.save(databaseWrapper);
            }
        });
    }

}
