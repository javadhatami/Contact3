package approom.ir.contact3;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ContactDBModel> list;
    ContactDBModel contactDBModel;
//    String name ;
//    String phone;

    RecyclerView recyclerView;
    //Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

//        mButton = (Button) findViewById(R.id.add_button);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,CreateActivity.class);
                startActivity(intent);
            }
        });


        initLists();
        initRecyclerView();
    }
    //g
    private void initRecyclerView(){

        //JH
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        CustomAdapter adapter = new CustomAdapter(this,list);
//dakhele paranteze setLayoutManager,layoutManager ke do khat bala tarif kardim ro behesh midim
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    private void initLists(){


        list = new ArrayList<>();

        list = new Select().from(ContactDBModel.class).queryList();



//        name = new ArrayList<>();
//        phone = new ArrayList<>();

//        name.add("javad");
//        name.add("javad");
//
//
//        phone.add("hatami");
//        phone.add("hatami");

    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
