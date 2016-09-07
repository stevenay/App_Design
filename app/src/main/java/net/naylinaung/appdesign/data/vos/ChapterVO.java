package net.naylinaung.appdesign.data.vos;

/**
 * Created by Dell on 9/6/2016.
 */
public class ChapterVO {

    private String title;
    private String chapterBrief;

    public String getChapterBrief() {
        return chapterBrief;
    }

    public void setChapterBrief(String chapterBrief) {
        this.chapterBrief = chapterBrief;
    }

    private Integer lessonCount;
    private Integer questionCount;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLessonCount() {
        return lessonCount;
    }

    public void setLessonCount(Integer lessonCount) {
        this.lessonCount = lessonCount;
    }

    public Integer getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(Integer questionCount) {
        this.questionCount = questionCount;
    }
}
