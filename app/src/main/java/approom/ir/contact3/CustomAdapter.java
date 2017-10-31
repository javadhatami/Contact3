package approom.ir.contact3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;

import static android.R.attr.id;

/**
 * Created by javad on 8/25/2017 AD.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {


    public interface OnContactClickListener{
        void onClick(int id);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        View item;
        TextView name;
        TextView phone;
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);

            item = itemView;
            name = (TextView) itemView.findViewById(R.id.name_contact);
            phone = (TextView) itemView.findViewById(R.id.phone_number);
            image = (ImageView) itemView.findViewById(R.id.contact_image);

        }
    }

    private List<DatabaseModel> list;
    private Context context;
    private OnContactClickListener contactListener;

    public CustomAdapter(Context context) {
        this.context = context;
        contactListener = (ContactActivity) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View rootView = LayoutInflater.from(context).inflate(R.layout.item_view,parent,false);

        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        DatabaseModel model = list.get(position);

        holder.name.setText(model.getName());
        holder.phone.setText(model.getMobile());

        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contactListener.onClick(model.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addItems(List<DatabaseModel> list){
        this.list = list;
        notifyDataSetChanged();
    }
}