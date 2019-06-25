
package ws.models;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CardList {

    @SerializedName("object")
    @Expose
    private String object;
    @SerializedName("total_cards")
    @Expose
    private Integer totalCards;
    @SerializedName("has_more")
    @Expose
    private Boolean hasMore;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Integer getTotalCards() {
        return totalCards;
    }

    public void setTotalCards(Integer totalCards) {
        this.totalCards = totalCards;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

}
