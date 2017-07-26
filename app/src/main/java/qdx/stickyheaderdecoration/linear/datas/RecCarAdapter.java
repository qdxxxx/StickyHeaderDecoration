package qdx.stickyheaderdecoration.linear.datas;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import qdx.stickyheaderdecoration.R;

public class RecCarAdapter extends RecyclerView.Adapter<RecCarAdapter.Holder> {

    private List<Car> mList;

    private Activity mActivity;

    public RecCarAdapter(Activity activity) {
        mList = new ArrayList<>();
        mActivity = activity;
    }

    public void addDatas(List<Car> data) {
        this.mList.clear();
        this.mList.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rec_car, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Car car = mList.get(position);

        holder.tv_name.setText(car.getName());
        Glide.with(mActivity).load(car.getLogo()).into(holder.iv_logo);
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }


    static class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_tv)
        TextView tv_name;

        @BindView(R.id.item_iv)
        ImageView iv_logo;

        Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.item_content)
        void tvClick() {
            Toast.makeText(itemView.getContext(), "你点击到了" + tv_name.getText(), Toast.LENGTH_SHORT).show();
        }
    }

}
