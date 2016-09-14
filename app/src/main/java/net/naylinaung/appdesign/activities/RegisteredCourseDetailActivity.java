package net.naylinaung.appdesign.activities;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.view.View;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

import net.naylinaung.appdesign.AppDesignApp;
import net.naylinaung.appdesign.R;
import net.naylinaung.appdesign.adapters.CourseHeaderPagerAdapter;
import net.naylinaung.appdesign.adapters.CoursePagerAdapter;
import net.naylinaung.appdesign.components.PageIndicatorView;
import net.naylinaung.appdesign.data.vos.ChapterVO;
import net.naylinaung.appdesign.data.vos.CourseVO;
import net.naylinaung.appdesign.fragments.ChapterListFragment;
import net.naylinaung.appdesign.fragments.CourseInfoHeaderFragment;
import net.naylinaung.appdesign.fragments.CourseProgressHeaderFragment;
import net.naylinaung.appdesign.fragments.CourseTodoListFragment;
import net.naylinaung.appdesign.utils.MMFontUtils;
import net.naylinaung.appdesign.utils.TransitionHelper;
import net.naylinaung.appdesign.views.holders.ChapterViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisteredCourseDetailActivity extends AppCompatActivity
    implements ChapterViewHolder.ControllerChapterItem {

    @BindView(R.id.appbar)
    AppBarLayout appBar;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;

    @BindView(R.id.tl_navigations)
    SmartTabLayout tlNavigations;

    @BindView(R.id.pager_navigations)
    ViewPager pagerNavigations;

    @BindView(R.id.pager_course_header)
    ViewPager pageCourseHeader;

    @BindView(R.id.fab_play_course)
    FloatingActionButton fabPlayCourse;

    @BindView(R.id.pi_course_header_pager)
    PageIndicatorView piCourseHeaderPager;

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

        mCoursePagerAdapter.addTab(ChapterListFragment.newInstance(), "CHAPTERS");
        mCoursePagerAdapter.addTab(ChapterListFragment.newInstance(), "DISCUSSION");
        mCoursePagerAdapter.addTab(CourseTodoListFragment.newInstance(), "TODO-List (3)");

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

    private void bindData(final CourseVO courseVO) {
        MMFontUtils.applyMMFontToCollapsingToolbar(collapsingToolbar);

        // hide CollapsingToolbar Title on Expanded Condition
        // show only when Collapsed State
        appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(courseVO.getTitle());
                    isShow = true;
                } else if(isShow) {
                    collapsingToolbar.setTitle(" ");//carefull there should a space between double quote otherwise it wont work
                    isShow = false;
                }
            }
        });

        piCourseHeaderPager.setNumPage(2);

        CourseHeaderPagerAdapter pagerAdapter = new CourseHeaderPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addTab(CourseInfoHeaderFragment.newInstance(), "CourseInfo");
        pagerAdapter.addTab(CourseProgressHeaderFragment.newInstance(), "CourseProgress");

        pageCourseHeader.setAdapter(pagerAdapter);
        pageCourseHeader.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                piCourseHeaderPager.setCurrentPage(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

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
