
package com.test.androidtest.model.FoodModel;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Fields {

    @SerializedName("item_id")
    @Expose
    private String itemId;
    @SerializedName("item_name")
    @Expose
    private String itemName;
    @SerializedName("brand_name")
    @Expose
    private String brandName;
    @SerializedName("nf_calories")
    @Expose
    private Double nfCalories;
    @SerializedName("nf_total_fat")
    @Expose
    private Double nfTotalFat;
    @SerializedName("nf_serving_size_qty")
    @Expose
    private Integer nfServingSizeQty;
    @SerializedName("nf_serving_size_unit")
    @Expose
    private String nfServingSizeUnit;

    /**
     * 
     * @return
     *     The itemId
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * 
     * @param itemId
     *     The item_id
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * 
     * @return
     *     The itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 
     * @param itemName
     *     The item_name
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * 
     * @return
     *     The brandName
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * 
     * @param brandName
     *     The brand_name
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * 
     * @return
     *     The nfCalories
     */
    public Double getNfCalories() {
        return nfCalories;
    }

    /**
     * 
     * @param nfCalories
     *     The nf_calories
     */
    public void setNfCalories(Double nfCalories) {
        this.nfCalories = nfCalories;
    }

    /**
     * 
     * @return
     *     The nfTotalFat
     */
    public Double getNfTotalFat() {
        return nfTotalFat;
    }

    /**
     * 
     * @param nfTotalFat
     *     The nf_total_fat
     */
    public void setNfTotalFat(Double nfTotalFat) {
        this.nfTotalFat = nfTotalFat;
    }

    /**
     * 
     * @return
     *     The nfServingSizeQty
     */
    public Integer getNfServingSizeQty() {
        return nfServingSizeQty;
    }

    /**
     * 
     * @param nfServingSizeQty
     *     The nf_serving_size_qty
     */
    public void setNfServingSizeQty(Integer nfServingSizeQty) {
        this.nfServingSizeQty = nfServingSizeQty;
    }

    /**
     * 
     * @return
     *     The nfServingSizeUnit
     */
    public String getNfServingSizeUnit() {
        return nfServingSizeUnit;
    }

    /**
     * 
     * @param nfServingSizeUnit
     *     The nf_serving_size_unit
     */
    public void setNfServingSizeUnit(String nfServingSizeUnit) {
        this.nfServingSizeUnit = nfServingSizeUnit;
    }

}
