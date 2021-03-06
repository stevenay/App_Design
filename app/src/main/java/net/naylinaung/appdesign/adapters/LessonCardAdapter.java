package net.naylinaung.appdesign.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import net.naylinaung.appdesign.R;
import net.naylinaung.appdesign.data.vos.LessonCardVO;
import net.naylinaung.appdesign.views.holders.LessonCardViewHolder;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by NayLinAung on 9/8/2016.
 */
public class LessonCardAdapter extends ArrayAdapter<LessonCardVO> {

    private final ArrayList<LessonCardVO> cards;
    private final LayoutInflater layoutInflater;
    private LessonCardViewHolder.ControllerLessonCardItem controllerLessonCardItem;

    public LessonCardAdapter(Context context, ArrayList<LessonCardVO> cards,
                             LessonCardViewHolder.ControllerLessonCardItem controllerLessonCardItem) {
        super(context, -1);
        this.cards = cards;
        this.layoutInflater = LayoutInflater.from(context);

        this.controllerLessonCardItem = controllerLessonCardItem;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LessonCardViewHolder viewHolder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.view_item_lesson_card, parent, false);
            viewHolder = new LessonCardViewHolder(convertView, controllerLessonCardItem);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (LessonCardViewHolder) convertView.getTag();
        }

        viewHolder.bindData(getItem(position));
        return convertView;
    }

    @Override
    public LessonCardVO getItem(int position) {
        return cards.get(position);
    }

    @Override
    public int getCount() {
        return cards.size();
    }
}
