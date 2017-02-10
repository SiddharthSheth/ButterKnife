package ln.butterknife.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
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

    @BindString(R.string.item1) String listItem1;

    @BindString(R.string.item2) String listItem2;

    @BindString(R.string.item3) String listItem3;

    ArrayList<String> stringArrayList;

    DemoAdapter demoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        stringArrayList = new ArrayList<>();

        stringArrayList.add(listItem1);
        stringArrayList.add(listItem2);
        stringArrayList.add(listItem3);


    }

    @OnClick(R.id.btn_displaylist)
    public void setBtnDisplayList(View view)
    {
        demoAdapter = new DemoAdapter(this, stringArrayList);
        recyclerView.setAdapter(demoAdapter);
    }
}
