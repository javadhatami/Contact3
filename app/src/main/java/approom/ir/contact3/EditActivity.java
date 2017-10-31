package approom.ir.contact3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.transaction.ITransaction;

import static android.R.attr.id;
import static com.raizlabs.android.dbflow.config.FlowLog.Level.I;

/**
 * Created by javad on 8/30/2017 AD.
 */

public class EditActivity extends AppCompatActivity {

    EditText nameEDT;
    EditText phoneEDT;
    EditText mailEDT;
    Button saveBtn;
    DatabaseModel model;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        model = new DatabaseModel();

        Intent intent = getIntent();
        int ids = intent.getIntExtra(ContactActivity.ID, id);


        nameEDT = (EditText) findViewById(R.id.name);
        phoneEDT = (EditText) findViewById(R.id.phone);
        mailEDT = (EditText) findViewById(R.id.mail);
        saveBtn = (Button) findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editContact(ids);

                onBackPressed();
            }
        });

    }

    public void editContact(int ids) {
        FlowManager.getDatabase(ContactDatabase.class).executeTransaction(new ITransaction() {
            @Override
            public void execute(DatabaseWrapper databaseWrapper) {

                SQLite.update(DatabaseModel.class)
                    .set(DatabaseModel_Table.name.eq(nameEDT.getText().toString()),
                            DatabaseModel_Table.mobile.eq(phoneEDT.getText().toString()),
                               DatabaseModel_Table.mail.eq(mailEDT.getText().toString()))
                    .where(DatabaseModel_Table.id.eq(ids))
                    .execute();

            }
        });
    }
}

//            SQLite.update(DatabaseModel.class)
//                    .set(DatabaseModel_Table.name.eq(nameEDT.getText().toString()))
//                    .where(DatabaseModel_Table.id.eq(ids))
//                    .execute();
//
////            model.setName(nameEDT.getText().toString());
////            model.setMobile(phoneEDT.getText().toString());
////            model.setMail(mailEDT.getText().toString());
////            model.update();
//
//        });
//    }
//}
