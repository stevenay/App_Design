package net.naylinaung.appdesign.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.naylinaung.appdesign.AppDesignApp;
import net.naylinaung.appdesign.R;
import net.naylinaung.appdesign.data.vos.ReplyVO;
import net.naylinaung.appdesign.views.holders.ReplyViewHolder;

import java.util.List;

/**
 * Created by NayLinAung on 9/16/2016.
 */
public class ReplyAdapter extends RecyclerView.Adapter<ReplyViewHolder> {

    private LayoutInflater mInflater;
    private List<ReplyVO> mReplyList;
    private ReplyViewHolder.ControllerReplyItem mControllerReplyItem;

    public ReplyAdapter(List<ReplyVO> replyList, ReplyViewHolder.ControllerReplyItem controllerReplyItem) {
        mInflater = LayoutInflater.from(AppDesignApp.getContext());
        mReplyList = replyList;
        mControllerReplyItem = controllerReplyItem;
    }

    @Override
    public ReplyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.view_item_reply, parent, false);
        return new ReplyViewHolder(itemView, mControllerReplyItem);
    }

    @Override
    public void onBindViewHolder(ReplyViewHolder holder, int position) {
        // holder.bindData(mDiscussionList.get(position));
    }

    @Override
    public int getItemCount() {
        return 15;
    }

    public void setNewData(List<ReplyVO> newReplyList) {
        mReplyList = newReplyList;
        notifyDataSetChanged();
    }

}