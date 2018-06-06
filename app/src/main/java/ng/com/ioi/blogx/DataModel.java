package ng.com.ioi.blogx;

import java.util.Date;

public class DataModel {

    private String NewsTitle, NewsContent, BitcoinValue;
    private Date PostTime;

    public DataModel(){}

    public DataModel(String newsTitle, String newsContent, String bitcoinValue, Date postTime) {

        this.NewsTitle = newsTitle;
        this.NewsContent = newsContent;
        this.PostTime = postTime;

        this.BitcoinValue = bitcoinValue;
    }

    public String getNewsTitle() {
        return NewsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        NewsTitle = newsTitle;
    }

    public String getNewsContent() {
        return NewsContent;
    }

    public void setNewsContent(String newsContent) {
        NewsContent = newsContent;
    }

    public String getBitcoinValue() {
        return BitcoinValue;
    }

    public void setBitcoinValue(String bitcoinValue) {
        BitcoinValue = bitcoinValue;
    }

    public Date getPostTime() {
        return PostTime;
    }

    public void setPostTime(Date postTime) {
        PostTime = postTime;
    }
}
