package ng.com.ioi.blogx;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import javax.security.auth.callback.Callback;

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
    public void onBindViewHolder(@NonNull final DataAdapter.ViewHolder holder, int position) {

        holder.newsTitle.setText(NewsList.get(position).getNewsTitle());
        holder.newsContent.setText(NewsList.get(position).getNewsContent());
        holder.postTime.setText("Posted on: " +NewsList.get(position).getPostTime().toString());

        //holder.bitcoinValue.setText(NewsList.get(position).getBitcoinValue());

        final Callback callback = null;

        holder.newsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = holder.newsTitle.getText().toString().trim();
                String content = holder.newsContent.getText().toString().trim();
                String time = holder.postTime.getText().toString().trim();

                Intent viewNews = new Intent(v.getContext(), ViewNews.class);

                viewNews.putExtra("Title", title);
                viewNews.putExtra("Content", content);
                viewNews.putExtra("Time", time);

                v.getContext().startActivity(viewNews);
            }
        });
    }

    @Override
    public int getItemCount() {
        return NewsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        View mView;

        public TextView newsTitle;
        public TextView newsContent;
        public TextView postTime;

        public TextView bitcoinValue;

        public CardView newsCard;

        public TextView NewsTitle, NewsContent;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            newsTitle = mView.findViewById(R.id.title);
            newsContent = mView.findViewById(R.id.content);
            postTime = mView.findViewById(R.id.postTime);

            bitcoinValue = mView.findViewById(R.id.bitcoin);

            newsCard = mView.findViewById(R.id.newsViewClick);

            //NewsTitle = mView.findViewById(R.id.title);
            //NewsContent = mView.findViewById(R.id.content);
        }
    }
}
