package ln.butterknife.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindBitmap;
import butterknife.BindBool;
import butterknife.BindColor;
import butterknife.BindDimen;
import butterknife.BindInt;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import ln.butterknife.R;
import ln.butterknife.adapter.DemoAdapter;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txt_string)
    TextView txtDemoString;

    @BindView(R.id.ed_name)
    TextView edName;

    @BindView(R.id.btn_displaylist)
    TextView btnDisplayList;

    @BindView(R.id.rv_demorv)
    RecyclerView recyclerView;

    @BindView(R.id.iv_data_notfound)
    ImageView ivDataNotFound;

    @BindString(R.string.item1) String listItem1;

    @BindString(R.string.item2) String listItem2;

    @BindString(R.string.item3) String listItem3;

    @BindInt(R.integer.count_item) int countItem;

    @BindBool(R.bool.iftrue) boolean check;

    @BindColor(R.color.colorAccent)
    int btnTextColor;

    @BindDimen(R.dimen.txtpadding)
    int txtPadding;

    @BindBitmap(R.drawable.datanotfound)
    Bitmap dataNotFoundImg;

    ArrayList<String> stringArrayList;

    DemoAdapter demoAdapter;

    //If you wanna use bindArray then make a string array and bind it and display it in spinner or list.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        txtDemoString.setText("Enter Key :");

        stringArrayList = new ArrayList<>();

        stringArrayList.add(listItem1);
        stringArrayList.add(listItem2);
        stringArrayList.add(listItem3);


    }

    @OnClick(R.id.btn_displaylist)
    public void setBtnDisplayList(View view)
    {
//        if (check)
        if (edName.getText().toString().equals("3"))
        {

            recyclerView.setVisibility(View.VISIBLE);
            ivDataNotFound.setVisibility(View.GONE);

            txtDemoString.setText(String.valueOf(countItem) + " records found");
            txtDemoString.setPadding(0,txtPadding,0,0);

            btnDisplayList.setTextColor(btnTextColor);

            demoAdapter = new DemoAdapter(this, stringArrayList);
            recyclerView.setAdapter(demoAdapter);



        }
        else
        {
            recyclerView.setVisibility(View.GONE);
            ivDataNotFound.setVisibility(View.VISIBLE);
            ivDataNotFound.setImageBitmap(dataNotFoundImg);

        }

    }

    @OnLongClick(R.id.btn_displaylist)
    boolean onLongClick() {

        Toast.makeText(this,String.valueOf(1),Toast.LENGTH_SHORT).show();

        return true;
    }

}
