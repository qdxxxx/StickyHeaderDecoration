package qdx.stickyheaderdecoration.linear;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import qdx.stickyheaderdecoration.NormalDecoration;
import qdx.stickyheaderdecoration.R;
import qdx.stickyheaderdecoration.linear.datas.Car;
import qdx.stickyheaderdecoration.linear.datas.CarsList;
import qdx.stickyheaderdecoration.linear.datas.RecCarAdapter;


public class LinearCustomActivity extends AppCompatActivity {
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
                Toast.makeText(LinearCustomActivity.this, "点击到头部" + carList.get(pos).getHeaderName(), Toast.LENGTH_SHORT).show();
            }
        });
        decoration.setOnDecorationHeadDraw(new NormalDecoration.OnDecorationHeadDraw() {
            @Override
            public View getHeaderView(final int pos) {
                final View headView = LayoutInflater.from(LinearCustomActivity.this).inflate(R.layout.decoration_car_head_view, null);
                final ImageView ivAvatar = (ImageView) headView.findViewById(R.id.header_iv_avatar);
                decoration.loadImage(carList.get(pos).getLetter(), pos, ivAvatar);
                Log.e("QDX", "view inflate " + pos + "头部" + headView.hashCode());
                return headView;
            }
        });


        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.addItemDecoration(decoration);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(adapter);
    }
}
