package qdx.stickyheaderdecoration.grid.datas;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import qdx.stickyheaderdecoration.R;


public class RecWomenAdapter extends RecyclerView.Adapter<RecWomenAdapter.Holder> {

    private List<Women> mList;

    private Activity mActivity;

    public RecWomenAdapter(Activity activity) {
        mList = new ArrayList<>();
        mActivity = activity;
    }

    public void addDatas(List<Women> data) {
        this.mList.clear();
        this.mList.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rec_women, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Women women = mList.get(position);

        Glide.with(mActivity).load(women.getPhoto()).into(holder.iv_logo);
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }


    static class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_iv)
        ImageView iv_logo;

        Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.item_content)
        void tvClick() {
            Toast.makeText(iv_logo.getContext(), "点击item" + getAdapterPosition(), Toast.LENGTH_SHORT).show();
        }
    }

}
