package net.naylinaung.appdesign.activities;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

import net.naylinaung.appdesign.AppDesignApp;
import net.naylinaung.appdesign.R;
import net.naylinaung.appdesign.adapters.ChapterAdapter;
import net.naylinaung.appdesign.adapters.CoursePagerAdapter;
import net.naylinaung.appdesign.adapters.MyCourseAdapter;
import net.naylinaung.appdesign.animators.RecyclerItemAnimator;
import net.naylinaung.appdesign.data.vos.ChapterVO;
import net.naylinaung.appdesign.data.vos.CourseVO;
import net.naylinaung.appdesign.fragments.CourseListFragment;
import net.naylinaung.appdesign.utils.MMFontUtils;
import net.naylinaung.appdesign.utils.TransitionHelper;
import net.naylinaung.appdesign.views.holders.ChapterViewHolder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisteredCourseDetailActivity extends AppCompatActivity
    implements ChapterViewHolder.ControllerChapterItem {

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;

    @BindView(R.id.tl_navigations)
    SmartTabLayout tlNavigations;

    @BindView(R.id.pager_navigations)
    ViewPager pagerNavigations;

    @BindView(R.id.fab_play_course)
    FloatingActionButton fabPlayCourse;

    private static final String IE_COURSE_NAME = "IE_COURSE_NAME";

    private CoursePagerAdapter mCoursePagerAdapter;

    public static Intent newIntent(String courseName) {
        Intent intent = new Intent(AppDesignApp.getContext(), RegisteredCourseDetailActivity.class);
        intent.putExtra(IE_COURSE_NAME, courseName);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered_course_detail);
        setupWindowAnimations();

        ButterKnife.bind(this, this);
        bindData(prepareSampleCourseVO());

        mCoursePagerAdapter = new CoursePagerAdapter(getSupportFragmentManager());

        mCoursePagerAdapter.addTab(CourseListFragment.newInstance(), "CHAPTERS");
        mCoursePagerAdapter.addTab(CourseListFragment.newInstance(), "LEADER-BOARD");
        mCoursePagerAdapter.addTab(CourseListFragment.newInstance(), "DISCUSSION");

        pagerNavigations.setAdapter(mCoursePagerAdapter);
        pagerNavigations.setOffscreenPageLimit(mCoursePagerAdapter.getCount());

        tlNavigations.setViewPager(pagerNavigations);

        fabPlayCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToCourseFlow();
            }
        });
    }

    private void setupWindowAnimations() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Explode explode = new Explode();
            explode.setDuration(800);
            getWindow().setEnterTransition(explode);

            Fade slide = new Fade();
            slide.setDuration(500);
            getWindow().setReturnTransition(slide);
        }
    }

    private void bindData(CourseVO courseVO) {
        MMFontUtils.applyMMFontToCollapsingToolbar(collapsingToolbar);
        collapsingToolbar.setTitle(courseVO.getTitle());
    }

    private CourseVO prepareSampleCourseVO()
    {
        CourseVO courseVO = new CourseVO();
        courseVO.setTitle("UV ေရာင္ျခည္ကို ဘယ္လိုကာကြယ္မလဲ");
        return courseVO;
    }

    private void navigateToCourseFlow()
    {
        Intent intent = CourseFlowActivity.newIntent("SampleCourseID");

        final Pair<View, String>[] pairs = TransitionHelper.createSafeTransitionParticipants(this, true);
        ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, pairs);
        startActivity(intent);
    }

    @Override
    public void onTapChapter(ChapterVO chapter) {

    }
}
