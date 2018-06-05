package ng.com.ioi.blogx;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    public List<DataModel> NewsList;

    public DataAdapter(List<DataModel> newsList) {

        this.NewsList = newsList;
    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_design, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, int position) {

        holder.newsTitle.setText(NewsList.get(position).getNewsTitle());
        holder.newsContent.setText(NewsList.get(position).getNewsContent());

        //holder.bitcoinValue.setText(NewsList.get(position).getBitcoinValue());
    }

    @Override
    public int getItemCount() {
        return NewsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        View mView;

        public TextView newsTitle;
        public TextView newsContent;

        public TextView bitcoinValue;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            newsTitle = mView.findViewById(R.id.title);
            newsContent = mView.findViewById(R.id.content);

            bitcoinValue = mView.findViewById(R.id.bitcoin);
        }
    }
}
