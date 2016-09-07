package net.naylinaung.appdesign.views.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import net.naylinaung.appdesign.data.vos.ChapterVO;

/**
 * Created by Dell on 9/6/2016.
 */
public class ChapterViewHolder extends RecyclerView.ViewHolder {

    public ChapterViewHolder(View itemView, ControllerChapterItem controller) {
        super(itemView);
    }

    public void bindData(ChapterVO chapter) {

    }

    public interface ControllerChapterItem {
        void onTapChapter(ChapterVO chapter);
    }
}
