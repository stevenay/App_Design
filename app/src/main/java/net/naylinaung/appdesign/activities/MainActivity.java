package net.naylinaung.appdesign.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.widget.ExploreByTouchHelper;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Toast;

import net.naylinaung.appdesign.R;
import net.naylinaung.appdesign.adapters.MyCourseAdapter;
import net.naylinaung.appdesign.animators.RecyclerItemAnimator;
import net.naylinaung.appdesign.data.vos.CourseVO;
import net.naylinaung.appdesign.utils.ScreenUtils;
import net.naylinaung.appdesign.utils.TransitionHelper;
import net.naylinaung.appdesign.views.holders.MyCourseViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity
        implements MyCourseViewHolder.ControllerCourseItem {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.content)
    CoordinatorLayout clContent;

    @BindView(R.id.rvMyCourse)
    RecyclerView rvMyCourse;

    @BindView(R.id.fab_search)
    FloatingActionButton fabSearch;

    public static final String ACTION_SHOW_LOADING_ITEM = "action_show_loading_item";
    public static final int ACTION_BAR_SIZE = ScreenUtils.dpToPx(56);

    private static final int ANIM_DURATION_TOOLBAR = 300;
    private static final int ANIM_DURATION_FAB = 400;

    private MyCourseAdapter myCourseAdapter;

    private boolean pendingIntroAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);
        setupWindowAnimations();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        setupMyCourse();

        if (savedInstanceState == null) {
            pendingIntroAnimation = true;
            prepareIntroAnimation();
        } else {
            myCourseAdapter.updateItems(false, new ArrayList<CourseVO>());
        }

    }

    private void setupMyCourse() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this) {
            @Override
            protected int getExtraLayoutSpace(RecyclerView.State state) {
                return 300;
            }
        };
        rvMyCourse.setLayoutManager(linearLayoutManager);

        myCourseAdapter = new MyCourseAdapter(new ArrayList<CourseVO>(), this);
        rvMyCourse.setAdapter(myCourseAdapter);


        rvMyCourse.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                // TODO
//                FeedContextMenuManager.getInstance().onScrolled(recyclerView, dx, dy);
            }
        });

        rvMyCourse.setItemAnimator(new RecyclerItemAnimator());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (ACTION_SHOW_LOADING_ITEM.equals(intent.getAction())) {
            showFeedLoadingItemDelayed();
        }
    }

    private void prepareIntroAnimation() {
        fabSearch.setTranslationY(2 * getResources().getDimensionPixelOffset(R.dimen.btn_fab_size));
        getToolbar().setTranslationY(-ACTION_BAR_SIZE);
        getScreenTitle().setTranslationY(-ACTION_BAR_SIZE);
    }

    private void showFeedLoadingItemDelayed() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                rvMyCourse.smoothScrollToPosition(0);
                myCourseAdapter.showLoadingView();
            }
        }, 500);
    }

    private void startIntroAnimation() {

        getInboxMenuItem().getActionView().setTranslationY(-ACTION_BAR_SIZE);

        getToolbar().animate()
                .translationY(0)
                .setDuration(ANIM_DURATION_TOOLBAR)
                .setStartDelay(300);
        getScreenTitle().animate()
                .translationY(0)
                .setDuration(ANIM_DURATION_TOOLBAR)
                .setStartDelay(400);
        getInboxMenuItem().getActionView().animate()
                .translationY(0)
                .setDuration(ANIM_DURATION_TOOLBAR)
                .setStartDelay(500)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        startContentAnimation();
                    }
                })
                .start();
    }

    private void startContentAnimation() {
        fabSearch.animate()
                .translationY(0)
                .setInterpolator(new OvershootInterpolator(1.f))
                .setStartDelay(300)
                .setDuration(ANIM_DURATION_FAB)
                .start();

        myCourseAdapter.updateItems(true, prepareSampleCourseList());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        if (pendingIntroAnimation) {
            pendingIntroAnimation = false;
            startIntroAnimation();
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_profile) {
            Toast.makeText(getApplicationContext(), "Tap on Profile", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showLikedSnackbar() {
        Snackbar.make(clContent, "Liked!", Snackbar.LENGTH_SHORT).show();
    }

    public List<CourseVO> prepareSampleCourseList() {
        List<CourseVO> courseList = new ArrayList<>();

        CourseVO courseOne = new CourseVO();
        courseOne.setTitle("UV ေရာင္ျခည္ကို ဘယ္လိုကာကြယ္မလဲ");
        courseOne.setCategoryName("LifeStyle");
        courseOne.setDurationInMinute(15);
        courseOne.setAuthorName("Admin Team");
        courseOne.setColorCode("#aed582");
        courseOne.setImageUrl("co_terrace.png");
        courseList.add(courseOne);

        CourseVO courseTwo = new CourseVO();
        courseTwo.setTitle("အားကစားကို နည္းမွန္လမ္းမွန္ ျပဳလုပ္နည္းမ်ား");
        courseTwo.setCategoryName("Sports and Fitness");
        courseTwo.setDurationInMinute(15);
        courseTwo.setAuthorName("Admin Team");
        courseTwo.setColorCode("#81c683");
        courseOne.setImageUrl("co_runner.png");
        courseList.add(courseTwo);

        CourseVO courseThree = new CourseVO();
        courseThree.setTitle("C# အသံုးျပဳ Console Application တစ္ခု ဘယ္လိုတည္ေဆာက္မလဲ");
        courseThree.setCategoryName("Programming");
        courseThree.setDurationInMinute(10);
        courseThree.setAuthorName("Admin Team");
        courseThree.setColorCode("#25c6da");
        courseOne.setImageUrl("co_terrace.png");
        courseList.add(courseThree);

        return courseList;
    }

    //region CourseItemListener
    @Override
    public void onTapCourse(CourseVO course) {
        Intent intent = CourseFlowActivity.newIntent("SampleCourseID");
        startActivity(intent);
    }

    @Override
    public void onCommentsClick(View v, int position) {

    }

    @Override
    public void onMoreClick(View v, int position) {

    }

    @Override
    public void onProfileClick(View v) {

    }

    @Override
    public void onCoverImageClick() {
        Intent intent = RegisteredCourseDetailActivity.newIntent("SampleCourseName");

        final Pair<View, String>[] pairs = TransitionHelper.createSafeTransitionParticipants(this, true);
        ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, pairs);
        startActivity(intent, transitionActivityOptions.toBundle());
    }
    //endregion

    private void setupWindowAnimations() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Fade explode = new Fade();
            explode.setDuration(800);
            getWindow().setExitTransition(explode);
        }
    }
}
