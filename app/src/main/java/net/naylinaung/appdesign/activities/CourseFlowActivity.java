package net.naylinaung.appdesign.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import net.naylinaung.appdesign.AppDesignApp;
import net.naylinaung.appdesign.R;
import net.naylinaung.appdesign.SwipeAnimation.SwipeStack;
import net.naylinaung.appdesign.adapters.LessonCardAdapter;
import net.naylinaung.appdesign.data.vos.LessonCardVO;
import net.naylinaung.appdesign.views.holders.LessonCardViewHolder;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import in.arjsna.swipecardlib.SwipePageView;

public class CourseFlowActivity extends AppCompatActivity
    implements LessonCardViewHolder.ControllerLessonCardItem {

    @BindView(R.id.pb_course_flow)
    ProgressBar pbCourseFlow;

    @BindView(R.id.page_swipe_view)
    SwipePageView pageSwipeView;

    private LessonCardAdapter arrayAdapter;

    private static final String IE_COURSE_ID = "IE_COURSE_ID";

    public static Intent newIntent(String courseID) {
        Intent intent = new Intent(AppDesignApp.getContext(), CourseFlowActivity.class);
        intent.putExtra(IE_COURSE_ID, courseID);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_flow);
        ButterKnife.bind(this, this);

        pbCourseFlow.setScaleY(1.5f);

        arrayAdapter = new LessonCardAdapter(this, getDummyData(), this);
        pageSwipeView.setAdapter(arrayAdapter);
        pageSwipeView.setFlingListener(new SwipePageView.OnPageFlingListener() {
            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {

            }

            @Override
            public void onScroll(float scrollProgressPercent) {
            }

            @Override
            public void onTopCardExit(Object dataObject) {
            }

            @Override
            public void onBottomCardExit(Object dataObject) {
            }
        });
        pageSwipeView.setOnItemClickListener(new SwipePageView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
            }
        });
    }

    private ArrayList<LessonCardVO> getDummyData() {
        ArrayList<LessonCardVO> al = new ArrayList<>();

        LessonCardVO card = new LessonCardVO();
        card.setLessonDescription("John");
        card.setCardOrderNumber(1);
        al.add(card);

        LessonCardVO card1 = new LessonCardVO();
        card1.setLessonDescription("John");
        card1.setCardOrderNumber(2);
        al.add(card1);

        LessonCardVO card2 = new LessonCardVO();
        card2.setLessonDescription("John");
        card2.setCardOrderNumber(3);
        al.add(card2);

        return al;
    }

    @OnClick(R.id.btn_back)
    public void onbtnBackPressed(ImageButton view) {
        this.onBackPressed();
    }

    @OnClick(R.id.btn_share)
    public void onbtnSharePressed(ImageButton view) {
        Intent intent = PopupQuestionActivity.newIntent("SampleLessonCardID");
        startActivity(intent);
    }

    //region ControllerLessonCardItem Implementation
    @Override
    public void onTapPinButton(LessonCardVO lessonCard) {
        if (lessonCard.isBookmarked()) {
            lessonCard.setBookmarked(false);
        } else {
            lessonCard.setBookmarked(true);
        }
    }

    @Override
    public void onTapRequestButton() {
        Intent intent = TodoListActivity.newIntent("Sample CourseID");
        startActivity(intent);
    }
    //endregion
}
