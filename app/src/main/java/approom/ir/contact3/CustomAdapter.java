package approom.ir.contact3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;

import static approom.ir.contact3.R.id.phone;

/**
 * Created by javad on 8/25/2017 AD.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    List<ContactDBModel> list;
    ContactDBModel contactDBModel;


    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView phone;
        ImageView image;


        //be itemView dakhele pranteze constructor,iteView ro ke dorost kardim ro midim
        public ViewHolder(View itemView) {
            super(itemView);
//z
            name = (TextView) itemView.findViewById(R.id.name_contact);
            phone = (TextView) itemView.findViewById(R.id.phone_number);
            image = (ImageView) itemView.findViewById(R.id.contact_image);

        }
    }

    //private list<ContactDBModel> list;
    //private String phone;
    private Context context;

    public CustomAdapter(Context context,List<ContactDBModel> list) {
        this.list = list;
        //this.phone = phone;
        this.context = context;
    }
    //l
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//x
        View rootView = LayoutInflater.from(context).inflate(R.layout.item_view,parent,false);

//ViewHolder dar bala be constructoresh deghat koni,ye view migire,ke inja ma rootViw ke
// inflate kardim ro behesh midim.ViewHolder in itemView ro goftim ke handel mikone
        return new ViewHolder(rootView);
    }
    //m
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        list = new Select().from(ContactDBModel.class).queryList();

        contactDBModel= list.get(position);


////q
        holder.name.setText(contactDBModel.getName());
        holder.phone.setText(contactDBModel.getMobile());

    }
    //n
    @Override
    public int getItemCount() {
        return list.size();
    }
}
