package ng.com.ioi.blogx;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ViewNews extends AppCompatActivity {

    Context context;

    TextView newsTitle, newsContent, newsTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_news);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarNews);
        //setSupportActionBar(toolbar);

        newsTitle = findViewById(R.id.viewTitle);
        newsContent = findViewById(R.id.viewContent);
        newsTime = findViewById(R.id.Time);

        String title = getIntent().getExtras().getString("Title");
        newsTitle.setText(title);
        String content = getIntent().getExtras().getString("Content");
        newsContent.setText(content);
        String time = getIntent().getExtras().getString("Time");
        newsTime.setText(time);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabNews);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Title = newsTitle.getText().toString().trim();
                String Content = newsContent.getText().toString().trim();
                String Time = newsTime.getText().toString().trim();

                Intent share = new Intent(Intent.ACTION_SEND);
                //share.putExtra(android.content.Intent.EXTRA_TEXT, Title);
                //share.putExtra(android.content.Intent.EXTRA_TEXT, Content);
                share.putExtra(Intent.EXTRA_TEXT, "Check out this post from BLOG X" + System.lineSeparator() + System.lineSeparator() + Title + System.lineSeparator() + System.lineSeparator() + Content + System.lineSeparator() + System.lineSeparator() + Time);
                share.setType("text/plain");
                startActivity(Intent.createChooser(share, "Share"));
            }
        });
    }
}
