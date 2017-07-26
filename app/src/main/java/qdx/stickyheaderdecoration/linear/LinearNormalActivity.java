package qdx.stickyheaderdecoration.linear;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import qdx.stickyheaderdecoration.NormalDecoration;
import qdx.stickyheaderdecoration.R;
import qdx.stickyheaderdecoration.linear.datas.Car;
import qdx.stickyheaderdecoration.linear.datas.CarsList;
import qdx.stickyheaderdecoration.linear.datas.RecCarAdapter;

public class LinearNormalActivity extends AppCompatActivity {
    @BindView(R.id.recView)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        ButterKnife.bind(this);

        final List<Car> carList = CarsList.getCars();

        final RecCarAdapter adapter = new RecCarAdapter(this);
        adapter.addDatas(carList);


        final NormalDecoration decoration = new NormalDecoration() {
            @Override
            public String getHeaderName(int pos) {
                return carList.get(pos).getHeaderName();
            }
        };

        decoration.setOnHeaderClickListener(new NormalDecoration.OnHeaderClickListener() {
            @Override
            public void headerClick(int pos) {
                Toast.makeText(LinearNormalActivity.this, "点击到头部" + carList.get(pos).getHeaderName(), Toast.LENGTH_SHORT).show();
            }
        });


        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.addItemDecoration(decoration);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(adapter);
    }
}
