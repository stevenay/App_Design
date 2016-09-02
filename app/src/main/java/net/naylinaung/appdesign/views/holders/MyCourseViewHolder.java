package net.naylinaung.appdesign.views.holders;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;

import net.naylinaung.appdesign.R;
import net.naylinaung.appdesign.components.SendingProgressView;
import net.naylinaung.appdesign.data.vos.CourseVO;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyCourseViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.iv_course_cover_image)
    ImageView ivCourseCoverImage;

    @BindView(R.id.tv_category_name)
    TextView tvCategoryName;

    @BindView(R.id.tv_course_title)
    TextView tvCourseTitle;

    @BindView(R.id.tv_duration)
    TextView tvDuration;

    @BindView(R.id.vImageRoot)
    public FrameLayout vImageRoot;

    @BindView(R.id.btnComments)
    ImageButton btnComments;

    @BindView(R.id.btnLike)
    public ImageButton btnLike;

    @BindView(R.id.btnMore)
    ImageButton btnMore;

    @BindView(R.id.vBgLike)
    public View vBgLike;

    @BindView(R.id.ivLike)
    public ImageView ivLike;

    @BindView(R.id.tsLikesCounter)
    public TextSwitcher tsLikesCounter;

    private CourseVO mCourseVO;

    public SendingProgressView vSendingProgress;
    public View vProgressBg;

    public MyCourseViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    public void bindData(CourseVO courseVO) {
        mCourseVO = courseVO;
        ivCourseCoverImage.setBackgroundColor(Color.parseColor(mCourseVO.getColorCode()));
        tvCourseTitle.setText(mCourseVO.getTitle());
        tvCategoryName.setText(mCourseVO.getCategoryName());
        String durationAndAuthor = mCourseVO.getDurationInMinute().toString() + " mins - Admin Team";
        tvDuration.setText(durationAndAuthor);

//        Context context = ivCourseCoverImage.getContext();
//        int id = context
//                    .getResources()
//                    .getIdentifier("drawable-nodpi/" + courseVO.getImageUrl(), null, context.getPackageName());
//        ivCourseCoverImage.setImageResource(id);

//            Glide.with(ivCourseCoverImage.getContext())
//                    .load(imageUrl)
//                    .centerCrop()
//                    .placeholder(R.drawable.stock_photo_placeholder)
//                    .error(R.drawable.stock_photo_placeholder)
//                    .into(ivAttraction);
    }

}