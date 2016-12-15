package Z_RecycleView.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhangwx.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import Z_RecycleView.data.ListData;
import Z_RecycleView.holder.CardHolder;

/**
 * Created by zhangwx on 2016/12/10.
 */
public class RecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ListData> feedData = new ArrayList<ListData>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclecard, parent, false);
        CardHolder cardHolder = new CardHolder(parent.getContext(), view);
        return cardHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof CardHolder && feedData.size() > 0) {
            ((CardHolder) holder).setText(R.id.recycle_text, feedData.get(position).getText());
            ((CardHolder) holder).setImageDrawable(R.id.recycle_pic, feedData.get(position).getDrawable());
        }
    }

    @Override
    public int getItemCount() {
        return feedData.size();
    }

    public void setFeedData(List<ListData> data) {
        feedData.clear();
        feedData.addAll(data);
    }

    public void addFeedData(List<ListData> data) {
        feedData.addAll(data);
    }

    public void addFeedDataToTop(List<ListData> data) {
        feedData.addAll(0, data);
    }
}
