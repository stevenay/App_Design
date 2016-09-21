package net.naylinaung.appdesign.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by NayLinAung on 9/2/2016.
 */
public class CourseVO {

    @SerializedName("course_title")
    private String courseTitle;

    @SerializedName("category_name")
    private String categoryName;

    @SerializedName("duration")
    private Integer durationInMinute;

    @SerializedName("author_name")
    private String authorName;

    @SerializedName("color_code")
    private String colorCode;

    @SerializedName("progress_color_code")
    private String progressColorCode;

    @SerializedName("cover_photo_url")
    private String coverPhotoUrl;

    @SerializedName("course_category")
    private CourseCategoryVO courseCategory;

    @SerializedName("chapters")
    private List<ChapterVO> chapters;

    @SerializedName("discussions")
    private List<DiscussionVO> discussions;

    public String getTitle() {
        return courseTitle;
    }

    public void setTitle(String title) {
        this.courseTitle = title;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getDurationInMinute() {
        return durationInMinute;
    }

    public void setDurationInMinute(Integer durationInMinute) {
        this.durationInMinute = durationInMinute;
    }

    public String getProgressColorCode() {
        return progressColorCode;
    }

    public void setProgressColorCode(String progressColorCode) {
        this.progressColorCode = progressColorCode;
    }

    public String getCoverPhotoUrl() {
        return coverPhotoUrl;
    }

    public void setCoverPhotoUrl(String coverPhotoUrl) {
        this.coverPhotoUrl = coverPhotoUrl;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public CourseCategoryVO getCourseCategory() {
        return courseCategory;
    }

    public void setCourseCategory(CourseCategoryVO courseCategory) {
        this.courseCategory = courseCategory;
    }

    public List<ChapterVO> getChapters() {
        return chapters;
    }

    public void setChapters(List<ChapterVO> chapters) {
        this.chapters = chapters;
    }

    public List<DiscussionVO> getDiscussions() {
        return discussions;
    }

    public void setDiscussions(List<DiscussionVO> discussions) {
        this.discussions = discussions;
    }
}
