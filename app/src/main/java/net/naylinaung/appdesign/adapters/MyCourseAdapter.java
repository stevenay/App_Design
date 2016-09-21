package net.naylinaung.appdesign.adapters;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;

import net.naylinaung.appdesign.AppDesignApp;
import net.naylinaung.appdesign.R;
import net.naylinaung.appdesign.activities.MainActivity;
import net.naylinaung.appdesign.components.SendingProgressView;
import net.naylinaung.appdesign.data.vos.CourseVO;
import net.naylinaung.appdesign.utils.ScreenUtils;
import net.naylinaung.appdesign.views.holders.MyCourseViewHolder;
import net.naylinaung.appdesign.views.items.LoadingCourseItemView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by Dell on 9/1/2016.
 */
public class MyCourseAdapter extends RecyclerView.Adapter<MyCourseViewHolder> {
    public static final String ACTION_LIKE_BUTTON_CLICKED = "action_like_button_button";
    public static final String ACTION_LIKE_IMAGE_CLICKED = "action_like_image_button";

    public static final int VIEW_TYPE_DEFAULT = 1;
    public static final int VIEW_TYPE_LOADER = 2;

    private List<CourseVO> mCourseList;

    private Context context;
    private MyCourseViewHolder.ControllerCourseItem controllerCourseItem;

    private boolean showLoadingView = false;

    public MyCourseAdapter(List<CourseVO> courseList, MyCourseViewHolder.ControllerCourseItem controllerCourseItem) {
        this.context = AppDesignApp.getContext();
        this.mCourseList = courseList;
        this.controllerCourseItem = controllerCourseItem;
    }

    @Override
    public MyCourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == VIEW_TYPE_DEFAULT) {

            View view = LayoutInflater.from(context).inflate(R.layout.view_item_my_course, parent, false);
            MyCourseViewHolder cellCourseViewHolder = new MyCourseViewHolder(view, controllerCourseItem);
            // setupClickableViews(view, cellCourseViewHolder);
            return cellCourseViewHolder;

        } else if (viewType == VIEW_TYPE_LOADER) {

            LoadingCourseItemView view = new LoadingCourseItemView(context);
            view.setLayoutParams(new LinearLayoutCompat.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)
            );

            return new MyCourseViewHolder.LoadingCourseItemViewHolder(view, this.controllerCourseItem);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(MyCourseViewHolder viewHolder, int position) {
        viewHolder.bindData(this.mCourseList.get(position));

        // This is the same as bindData method
        // ((CellFeedViewHolder) viewHolder).bindView(feedItems.get(position));

        if (getItemViewType(position) == VIEW_TYPE_LOADER) {
            bindLoadingMyCourse((MyCourseViewHolder.LoadingCourseItemViewHolder) viewHolder);
        }
    }

    private void bindLoadingMyCourse(final MyCourseViewHolder.LoadingCourseItemViewHolder holder) {
        holder.loadingCourseItemView.setOnLoadingFinishedListener(new LoadingCourseItemView.OnLoadingFinishedListener() {
            @Override
            public void onLoadingFinished() {
                showLoadingView = false;
                notifyItemChanged(0);
            }
        });
        holder.loadingCourseItemView.startLoading();
    }

    @Override
    public int getItemViewType(int position) {
        if (showLoadingView && position == 0) {
            return VIEW_TYPE_LOADER;
        } else {
            return VIEW_TYPE_DEFAULT;
        }
    }

    @Override
    public int getItemCount() {
        return mCourseList.size();
    }


    public void updateItems(boolean animated, List<CourseVO> courseList) {
        this.mCourseList.clear();
        this.mCourseList = courseList;

        if (animated) {
            notifyItemRangeInserted(0, this.mCourseList.size());
        } else {
            notifyDataSetChanged();
        }
    }

    public void setControllerCourseItem(MyCourseViewHolder.ControllerCourseItem onCourseItemClickListener) {
        this.controllerCourseItem = onCourseItemClickListener;
    }

    public void showLoadingView() {
        showLoadingView = true;
        notifyItemChanged(0);
    }
}
