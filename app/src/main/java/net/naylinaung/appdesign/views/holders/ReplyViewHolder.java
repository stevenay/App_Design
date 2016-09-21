package net.naylinaung.appdesign.views.holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import net.naylinaung.appdesign.AppDesignApp;
import net.naylinaung.appdesign.data.vos.ReplyVO;

import butterknife.ButterKnife;

/**
 * Created by NayLinAung on 9/16/2016.
 */
public class ReplyViewHolder extends RecyclerView.ViewHolder {

    private Context mContext;
    private ReplyVO mReplyVO;

    public ReplyViewHolder(View itemView, ControllerReplyItem controller) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        this.mContext = AppDesignApp.getContext();
    }

    public void bindData(ReplyVO reply) {
        this.mReplyVO = reply;

    }

    public interface ControllerReplyItem {
        void onTapReply(ReplyVO reply);
    }

}
