package net.naylinaung.appdesign.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.naylinaung.appdesign.AppDesignApp;
import net.naylinaung.appdesign.R;
import net.naylinaung.appdesign.data.vos.ChapterVO;
import net.naylinaung.appdesign.data.vos.DiscussionVO;
import net.naylinaung.appdesign.views.holders.ChapterViewHolder;
import net.naylinaung.appdesign.views.holders.DiscussionViewHolder;

import java.util.List;

/**
 * Created by NayLinAung on 9/16/2016.
 */
public class DiscussionAdapter extends RecyclerView.Adapter<DiscussionViewHolder> {

    private LayoutInflater mInflater;
    private List<DiscussionVO> mDiscussionList;
    private DiscussionViewHolder.ControllerDiscussionItem mControllerDiscussionItem;

    public DiscussionAdapter(List<DiscussionVO> discussionList, DiscussionViewHolder.ControllerDiscussionItem controllerDiscussionItem) {
        mInflater = LayoutInflater.from(AppDesignApp.getContext());
        mDiscussionList = discussionList;
        mControllerDiscussionItem = controllerDiscussionItem;
    }

    @Override
    public DiscussionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.view_item_discussion, parent, false);
        return new DiscussionViewHolder(itemView, mControllerDiscussionItem);
    }

    @Override
    public void onBindViewHolder(DiscussionViewHolder holder, int position) {
        // holder.bindData(mDiscussionList.get(position));
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public void setNewData(List<DiscussionVO> newDisucssionList) {
        mDiscussionList = newDisucssionList;
        notifyDataSetChanged();
    }

}