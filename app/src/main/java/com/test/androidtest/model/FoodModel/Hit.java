
package com.test.androidtest.model.FoodModel;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Hit {

    @SerializedName("_index")
    @Expose
    private String Index;
    @SerializedName("_type")
    @Expose
    private String Type;
    @SerializedName("_id")
    @Expose
    private String Id;
    @SerializedName("_score")
    @Expose
    private Double Score;
    @SerializedName("fields")
    @Expose
    private Fields fields;

    /**
     * 
     * @return
     *     The Index
     */
    public String getIndex() {
        return Index;
    }

    /**
     * 
     * @param Index
     *     The _index
     */
    public void setIndex(String Index) {
        this.Index = Index;
    }

    /**
     * 
     * @return
     *     The Type
     */
    public String getType() {
        return Type;
    }

    /**
     * 
     * @param Type
     *     The _type
     */
    public void setType(String Type) {
        this.Type = Type;
    }

    /**
     * 
     * @return
     *     The Id
     */
    public String getId() {
        return Id;
    }

    /**
     * 
     * @param Id
     *     The _id
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     * 
     * @return
     *     The Score
     */
    public Double getScore() {
        return Score;
    }

    /**
     * 
     * @param Score
     *     The _score
     */
    public void setScore(Double Score) {
        this.Score = Score;
    }

    /**
     * 
     * @return
     *     The fields
     */
    public Fields getFields() {
        return fields;
    }

    /**
     * 
     * @param fields
     *     The fields
     */
    public void setFields(Fields fields) {
        this.fields = fields;
    }

}
