package ln.butterknife.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;
import ln.butterknife.R;

/**
 * Created by comp-1 on 10/2/17.
 */

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.MyViewHolder> {

    ArrayList<String> demoList;

    public DemoAdapter(Context context, ArrayList<String> demoList) {

        this.demoList = demoList;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_item1) TextView txtIteam1;
        @BindView(R.id.txt_item2) TextView txtIteam2;
        @BindView(R.id.txt_item3) TextView txtIteam3;
        @BindView(R.id.iv_image)
        ImageView ivImage;

        @BindDrawable(R.drawable.images)
         Drawable imgDrawable;

        public MyViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);

        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Log.d("abcd",demoList.get(0));

        holder.txtIteam1.setText(demoList.get(0));
        holder.txtIteam2.setText(demoList.get(1));
        holder.txtIteam3.setText(demoList.get(2));
        holder.ivImage.setImageDrawable(holder.imgDrawable);
    }

    @Override
    public int getItemCount() {
        return demoList.size();
    }
}