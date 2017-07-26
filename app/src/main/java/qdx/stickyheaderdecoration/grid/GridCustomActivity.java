package qdx.stickyheaderdecoration.grid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import qdx.stickyheaderdecoration.GridDecoration;
import qdx.stickyheaderdecoration.NormalDecoration;
import qdx.stickyheaderdecoration.R;
import qdx.stickyheaderdecoration.grid.datas.RecWomenAdapter;
import qdx.stickyheaderdecoration.grid.datas.Women;
import qdx.stickyheaderdecoration.grid.datas.WomenList;


public class GridCustomActivity extends AppCompatActivity {
    @BindView(R.id.recView)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        ButterKnife.bind(this);

        final List<Women> womens = WomenList.getWomen();

        RecWomenAdapter adapter = new RecWomenAdapter(this);
        adapter.addDatas(womens);

        final GridDecoration decoration = new GridDecoration(womens.size(), 3) {
            @Override
            public String getHeaderName(int pos) {
                return womens.get(pos).getName();
            }
        };

        decoration.setOnHeaderClickListener(new NormalDecoration.OnHeaderClickListener() {
            @Override
            public void headerClick(int pos) {

                Toast.makeText(GridCustomActivity.this, "点击到头部" + pos, Toast.LENGTH_SHORT).show();
            }
        });

        decoration.setOnDecorationHeadDraw(new NormalDecoration.OnDecorationHeadDraw() {
            @Override
            public View getHeaderView(int pos) {
                final View headView = LayoutInflater.from(GridCustomActivity.this).inflate(R.layout.decoration_men_head_view, null);
                TextView tvName = (TextView) headView.findViewById(R.id.header_tv_name);
                tvName.setText(womens.get(pos).getName());

                final ImageView ivAvatar = (ImageView) headView.findViewById(R.id.header_iv_avatar);
                decoration.loadImage(womens.get(pos).getAvatar(), pos, ivAvatar);
                return headView;
            }
        });


        GridLayoutManager manager = new GridLayoutManager(this, 3);
        mRecyclerView.addItemDecoration(decoration);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(adapter);

    }
}
