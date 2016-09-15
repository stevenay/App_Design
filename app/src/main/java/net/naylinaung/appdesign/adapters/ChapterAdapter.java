package net.naylinaung.appdesign.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.naylinaung.appdesign.AppDesignApp;
import net.naylinaung.appdesign.R;
import net.naylinaung.appdesign.data.vos.ChapterVO;
import net.naylinaung.appdesign.views.holders.ChapterViewHolder;

import java.util.List;

/**
 * Created by NayLinAung on 9/6/2016.
 */
public class ChapterAdapter extends RecyclerView.Adapter<ChapterViewHolder> {

    private LayoutInflater mInflater;
    private List<ChapterVO> mChapterList;
    private ChapterViewHolder.ControllerChapterItem mControllerChapterItem;

    public ChapterAdapter(List<ChapterVO> chapterList, ChapterViewHolder.ControllerChapterItem controllerChapterItem) {
        mInflater = LayoutInflater.from(AppDesignApp.getContext());
        mChapterList = chapterList;
        mControllerChapterItem = controllerChapterItem;
    }

    @Override
    public ChapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.view_item_chapter, parent, false);
        return new ChapterViewHolder(itemView, mControllerChapterItem);
    }

    @Override
    public void onBindViewHolder(ChapterViewHolder holder, int position) {
        holder.bindData(mChapterList.get(position));
    }

    @Override
    public int getItemCount() {
        return mChapterList.size();
    }

    public void setNewData(List<ChapterVO> newChapterList) {
        mChapterList = newChapterList;
        notifyDataSetChanged();
    }

}
