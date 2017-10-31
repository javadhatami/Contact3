package approom.ir.contact3;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.id;

public class MainActivity extends AppCompatActivity {

    //public static final String ID = "id";

    int p;
//    List<ContactDBModel> list;
//    ContactDBModel contactDBModel;

    RecyclerView recyclerView;
    final Context context = this;
    //Button mButton;
    ItemClickSupport mItemClickSupport;
//    int contactId = contactDBModel.getId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

//        mButton = (Button) findViewById(R.id.add_button);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, CreateActivity.class);
                startActivity(intent);
            }
        });

        initLists();
        initRecyclerView();

        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent intent = new Intent(MainActivity.this,EditActivity.class);
                intent.putExtra("position",position);

                startActivity(intent);
                p= position;
                Toast.makeText(getBaseContext(),"clicked",Toast.LENGTH_SHORT).show();

            }
        });



        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {


                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set title
                alertDialogBuilder.setTitle("Your Title");

                // set dialog message
                alertDialogBuilder
                        .setMessage("delete & edit")
                        .setCancelable(false)
                        .setPositiveButton("Delete",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
//                                deleteContact(contactId);
                            }
                        })
                        .setNegativeButton("Edit",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
//                                Intent intent = new Intent(MainActivity.this,EditActivity.class);
//                                startActivity(intent);
                            }
                        });
//                        .setNeutralButton("cancel",new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog,int id) {
//                        dialog.cancel();
//                    }
//                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();



                Toast.makeText(context, "javad", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
//
    }

    //g
    private void initRecyclerView() {

        //JH
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        CustomAdapter adapter = new CustomAdapter(this, list);
////dakhele paranteze setLayoutManager,layoutManager ke do khat bala tarif kardim ro behesh midim
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);

    }

    private void initLists() {


//        list = new ArrayList<>();
//
//        list = new Select().from(ContactDBModel.class).queryList();

    }

//    public void deleteContact(int contactId) {
//
//        ContactDBModel model = SQLite.select()
//                .from(ContactDBModel.class)
//                .where(ContactDBModel_Table.id.eq(contactId))
//                .querySingle();
//
//        if (model != null)
//            model.delete();
//
//    }


    @Override
    protected void onResume() {
        super.onResume();

    }
}