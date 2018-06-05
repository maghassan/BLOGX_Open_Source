package ng.com.ioi.blogx;

public class DataModel {

    private String NewsTitle, NewsContent, BitcoinValue;

    public DataModel(){}

    public DataModel(String newsTitle, String newsContent, String bitcoinValue) {

        this.NewsTitle = newsTitle;
        this.NewsContent = newsContent;

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
}
