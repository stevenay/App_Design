package net.naylinaung.appdesign.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.naylinaung.appdesign.AppDesignApp;
import net.naylinaung.appdesign.R;
import net.naylinaung.appdesign.data.vos.CourseVO;
import net.naylinaung.appdesign.views.holders.FeaturedCourseViewHolder;
import net.naylinaung.appdesign.views.holders.MyCourseViewHolder;

import java.util.List;

/**
 * Created by NayLinAung on 9/23/2016.
 */
public class FeaturedCourseAdapter extends RecyclerView.Adapter<FeaturedCourseViewHolder> {

    public static final String ACTION_LIKE_BUTTON_CLICKED = "action_like_button_button";
    public static final String ACTION_LIKE_IMAGE_CLICKED = "action_like_image_button";

    public static final int VIEW_TYPE_DEFAULT = 1;
    public static final int VIEW_TYPE_LOADER = 2;

    private List<CourseVO> mCourseList;

    private Context context;
    private FeaturedCourseViewHolder.ControllerFeaturedCourseItem controllerCourseItem;

    private boolean showLoadingView = false;

    public FeaturedCourseAdapter(List<CourseVO> courseList, FeaturedCourseViewHolder.ControllerFeaturedCourseItem controllerCourseItem) {
        this.context = AppDesignApp.getContext();
        this.mCourseList = courseList;
        this.controllerCourseItem = controllerCourseItem;
    }

    @Override
    public FeaturedCourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_item_featured_course, parent, false);
        FeaturedCourseViewHolder cellCourseViewHolder = new FeaturedCourseViewHolder(view, controllerCourseItem);
        return cellCourseViewHolder;
    }

    @Override
    public void onBindViewHolder(FeaturedCourseViewHolder viewHolder, int position) {
        viewHolder.bindData(this.mCourseList.get(position));
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

    public void setNewData(List<CourseVO> newCourseList) {
        mCourseList = newCourseList;
        notifyDataSetChanged();
    }

}
