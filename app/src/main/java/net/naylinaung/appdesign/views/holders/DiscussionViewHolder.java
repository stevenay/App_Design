package net.naylinaung.appdesign.views.holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import net.naylinaung.appdesign.AppDesignApp;
import net.naylinaung.appdesign.R;
import net.naylinaung.appdesign.data.vos.DiscussionVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by NayLinAung on 9/16/2016.
 */
public class DiscussionViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.layout_like_button)
    LinearLayout layoutLikeButton;

    private Context mContext;
    private DiscussionVO mDiscussionVO;
    private ControllerDiscussionItem mController;
    private View mSelfView;

    public DiscussionViewHolder(View itemView, ControllerDiscussionItem controller) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        this.mContext = AppDesignApp.getContext();
        this.mController = controller;
        this.mSelfView = itemView;

        setupClickableViews(mSelfView, mController);
    }

    private void setupClickableViews(View selfView, final ControllerDiscussionItem controller) {
        selfView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.onTapDiscussion(mDiscussionVO);
            }
        });

        layoutLikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.onTapLikeButton(1);
            }
        });
    }

    public void bindData(DiscussionVO discussion) {
        this.mDiscussionVO = discussion;

    }

    public interface ControllerDiscussionItem {
        void onTapDiscussion(DiscussionVO discussion);
        void onTapLikeButton(Integer discussionID);
    }
}