package net.naylinaung.appdesign.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by NayLinAung on 9/21/2016.
 */
public class CourseCategoryVO {

    @SerializedName("category_id")
    private int categoryId;

    @SerializedName("category_name")
    private String categoryName;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
