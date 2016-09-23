package net.naylinaung.appdesign.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.widget.ExploreByTouchHelper;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
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
import android.widget.TextView;
import android.widget.Toast;

import net.naylinaung.appdesign.R;
import net.naylinaung.appdesign.adapters.MyCourseAdapter;
import net.naylinaung.appdesign.animators.RecyclerItemAnimator;
import net.naylinaung.appdesign.data.vos.CourseVO;
import net.naylinaung.appdesign.fragments.FeaturedCourseListFragment;
import net.naylinaung.appdesign.fragments.MyCourseListFragment;
import net.naylinaung.appdesign.utils.ScreenUtils;
import net.naylinaung.appdesign.utils.TransitionHelper;
import net.naylinaung.appdesign.views.holders.FeaturedCourseViewHolder;
import net.naylinaung.appdesign.views.holders.FeaturedCourseViewHolder.ControllerFeaturedCourseItem;
import net.naylinaung.appdesign.views.holders.MyCourseViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity
        implements MyCourseViewHolder.ControllerCourseItem,
        ControllerFeaturedCourseItem {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.content)
    CoordinatorLayout clContent;

//    @BindView(R.id.fab_search)
//    FloatingActionButton fabSearch;

    @BindView(R.id.tv_screen_title)
    TextView tvScreenTitle;

    private MenuItem inboxMenuItem;

    public static final String ACTION_SHOW_LOADING_ITEM = "action_show_loading_item";
    public static final int ACTION_BAR_SIZE = ScreenUtils.dpToPx(56);

    private static final int ANIM_DURATION_TOOLBAR = 300;
    private static final int ANIM_DURATION_FAB = 400;

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

        if (savedInstanceState == null) {
            pendingIntroAnimation = true;
            prepareIntroAnimation();
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (ACTION_SHOW_LOADING_ITEM.equals(intent.getAction())) {
            // showFeedLoadingItemDelayed();
        }
    }

    private void prepareIntroAnimation() {
//        fabSearch.setTranslationY(2 * getResources().getDimensionPixelOffset(R.dimen.btn_fab_size));
        toolbar.setTranslationY(-ACTION_BAR_SIZE);
        tvScreenTitle.setTranslationY(-ACTION_BAR_SIZE);
    }

    private void startIntroAnimation() {

        inboxMenuItem.getActionView().setTranslationY(-ACTION_BAR_SIZE);

        toolbar.animate()
                .translationY(0)
                .setDuration(ANIM_DURATION_TOOLBAR)
                .setStartDelay(300);
        tvScreenTitle.animate()
                .translationY(0)
                .setDuration(ANIM_DURATION_TOOLBAR)
                .setStartDelay(400);
        inboxMenuItem.getActionView().animate()
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
//        fabSearch.animate()
//                .translationY(0)
//                .setInterpolator(new OvershootInterpolator(1.f))
//                .setStartDelay(300)
//                .setDuration(ANIM_DURATION_FAB)
//                .start();

        navigateToMyCourseListFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        inboxMenuItem = menu.findItem(R.id.action_profile);
        inboxMenuItem.setActionView(R.layout.menu_item_view);

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
            navigateToMyCourseListFragment();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showLikedSnackbar() {
        Snackbar.make(clContent, "Liked!", Snackbar.LENGTH_SHORT).show();
    }

    //region CourseItemListener
    @Override
    public void onTapCourse(CourseVO course) {
        Intent intent = RegisteredCourseDetailActivity.newIntent("SampleCourseName");

        final Pair<View, String>[] pairs = TransitionHelper.createSafeTransitionParticipants(this, true);
        ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, pairs);
        startActivity(intent, transitionActivityOptions.toBundle());
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

    //region Navigation
    private void navigateToMyCourseListFragment() {
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slide_up_fragment, R.anim.slide_up_out_fragment)
                .replace(R.id.fl_container, MyCourseListFragment.newInstance())
                .commit();
    }

    private void navigateToFeaturedCourseListFragment() {
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slide_up_fragment, R.anim.slide_up_out_fragment)
                .replace(R.id.fl_container, FeaturedCourseListFragment.newInstance())
                .commit();
    }

    //endregion


    private void setupWindowAnimations() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Fade explode = new Fade();
            explode.setDuration(800);
            getWindow().setExitTransition(explode);
        }
    }

    //region FeaturedCourseItemListener
    @Override
    public void onTapFeaturedCourse(CourseVO course) {
        Intent intent = RegisteredCourseDetailActivity.newIntent("SampleCourseName");

        final Pair<View, String>[] pairs = TransitionHelper.createSafeTransitionParticipants(this, true);
        ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, pairs);
        startActivity(intent, transitionActivityOptions.toBundle());
    }

    @Override
    public void onFeaturedCoverImageClick() {

    }
    //endregion
}
