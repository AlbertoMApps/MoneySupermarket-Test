
package com.test.androidtest.model.FoodModel;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Food {

    @SerializedName("total_hits")
    @Expose
    private Long totalHits;
    @SerializedName("max_score")
    @Expose
    private Double maxScore;
    @SerializedName("hits")
    @Expose
    private List<Hit> hits = new ArrayList<Hit>();

    /**
     * 
     * @return
     *     The totalHits
     */
    public Long getTotalHits() {
        return totalHits;
    }

    /**
     * 
     * @param totalHits
     *     The total_hits
     */
    public void setTotalHits(Long totalHits) {
        this.totalHits = totalHits;
    }

    /**
     * 
     * @return
     *     The maxScore
     */
    public Double getMaxScore() {
        return maxScore;
    }

    /**
     * 
     * @param maxScore
     *     The max_score
     */
    public void setMaxScore(Double maxScore) {
        this.maxScore = maxScore;
    }

    /**
     * 
     * @return
     *     The hits
     */
    public List<Hit> getHits() {
        return hits;
    }

    /**
     * 
     * @param hits
     *     The hits
     */
    public void setHits(List<Hit> hits) {
        this.hits = hits;
    }

}
