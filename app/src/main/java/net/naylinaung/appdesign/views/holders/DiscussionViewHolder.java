package net.naylinaung.appdesign.views.holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import net.naylinaung.appdesign.AppDesignApp;
import net.naylinaung.appdesign.R;
import net.naylinaung.appdesign.data.vos.DiscussionVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by NayLinAung on 9/16/2016.
 */
public class DiscussionViewHolder extends RecyclerView.ViewHolder {

    private Context mContext;
    private DiscussionVO mDiscussionVO;

    public DiscussionViewHolder(View itemView, ControllerDiscussionItem controller) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        this.mContext = AppDesignApp.getContext();
    }

    public void bindData(DiscussionVO discussion) {
        this.mDiscussionVO = discussion;

//        tvChapterNumber.setText("Chapter-" + String.valueOf(chapter.getChapterNumber()));
//        tvChapterTitle.setText(chapter.getTitle());
//        tvChapterBrief.setText(chapter.getChapterBrief());
//
//        String durtionInMinute = tvDuration.getResources().getQuantityString(
//                R.plurals.minutes_count, chapter.getDurationInMins(), chapter.getDurationInMins()
//        );
//        tvDuration.setText(durtionInMinute);
//
//        String cardsCount = tvDuration.getResources().getQuantityString(
//                R.plurals.cards_count, chapter.getLessonCount(), chapter.getLessonCount()
//        );
//        tvCardCount.setText(cardsCount);
//
//        if (chapter.isLocked()) {
//            // Define Colors for Disabled State
//            tvChapterNumber.setTextColor(mContext.getResources().getColor(R.color.chapter_disabled_text_color));
//            tvChapterTitle.setTextColor(mContext.getResources().getColor(R.color.chapter_disabled_text_color));
//            tvChapterBrief.setTextColor(mContext.getResources().getColor(R.color.chapter_disabled_text_color));
//
//            // Hide Duration and Cards Count
//            tvDuration.setVisibility(View.INVISIBLE);
//            tvCardCount.setVisibility(View.INVISIBLE);
//            tvFinishedPercentage.setVisibility(View.INVISIBLE);
//
//            // Define Lock Disabled Color
//            vFinished.setBackgroundColor(mContext.getResources().getColor(R.color.chapter_disabled_background));
//            vFinished.setLayoutParams(new LinearLayout.LayoutParams(0,
//                    ViewGroup.LayoutParams.MATCH_PARENT, 100));
//
//            vRemaining.setLayoutParams(new LinearLayout.LayoutParams(0,
//                    ViewGroup.LayoutParams.MATCH_PARENT, 0));
//
//        } else {
//            ivLock.setVisibility(View.GONE);
//            tvLock.setVisibility(View.GONE);
//
//            // Define Finished Percentage if it's not Lock
//            vFinished.setLayoutParams(new LinearLayout.LayoutParams(0,
//                    ViewGroup.LayoutParams.MATCH_PARENT, chapter.getFinishedPercentage()));
//
//            vRemaining.setLayoutParams(new LinearLayout.LayoutParams(0,
//                    ViewGroup.LayoutParams.MATCH_PARENT, 100 - chapter.getFinishedPercentage()));
//
//            if (chapter.getFinishedPercentage() > 0)
//                tvFinishedPercentage.setText(String.valueOf(chapter.getFinishedPercentage()) + "% ဖတ္ၿပီး");
//            else
//                tvFinishedPercentage.setText("လံုးဝ မဖတ္ရေသး");
//        }
    }

    public interface ControllerDiscussionItem {
        void onTapDiscussion(DiscussionVO discussion);
    }
}