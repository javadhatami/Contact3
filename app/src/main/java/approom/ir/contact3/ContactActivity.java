package approom.ir.contact3;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.id;

/**
 * Created by javad on 10/29/2017 AD.
 */

public class ContactActivity extends AppCompatActivity implements CustomAdapter.OnContactClickListener {

    public static final String ID = "id";
    RecyclerView recyclerView;
    List<DatabaseModel> list;
    CustomAdapter adapter;
    DatabaseModel model;
//    int contactId = id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ContactActivity.this, CreateActivity.class);
                startActivity(intent);
            }
        });

        initRecyclerView();
    }

    @Override
    protected void onResume() {
        super.onResume();

        initLists();
    }

    private void initRecyclerView() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new CustomAdapter(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void initLists() {

        list = SQLite.select().from(DatabaseModel.class).queryList();

        adapter.addItems(list);

        Log.d("Contact Activity", "-----------> List size is: " + list.size());
    }

    @Override
    public void onClick(int id) {
//        Toast.makeText(this, "id is: " + id, Toast.LENGTH_SHORT).show();

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_singlechoice);
        arrayAdapter.add("Edit");
        arrayAdapter.add("Delete");

        dialog.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                switch (i){

                    case 0:

                        Toast.makeText(getBaseContext(), "id is: " + id, Toast.LENGTH_SHORT).show();
//
//
                        Intent intent = new Intent(ContactActivity.this,EditActivity.class);
                        intent.putExtra(ID,id);
                        startActivity(intent);

                        break;

                    case 1:

                        deleteContact(id);
                        initLists();
                        break;
                }
            }
        });

        dialog.show();
    }
    private void deleteContact(int id) {

            DatabaseModel model = SQLite.select()
                    .from(DatabaseModel.class)
                    .where(DatabaseModel_Table.id.eq(id))
                    .querySingle();

            if (model != null)
                model.delete();

        }

}
