package net.naylinaung.appdesign.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.naylinaung.appdesign.R;
import net.naylinaung.appdesign.adapters.ChapterAdapter;
import net.naylinaung.appdesign.data.vos.ChapterVO;
import net.naylinaung.appdesign.views.holders.ChapterViewHolder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CourseListFragment extends Fragment {

    @BindView(R.id.rv_chapter_list)
    RecyclerView rvChapterList;

    private ChapterAdapter chapterAdapter;
    private ChapterViewHolder.ControllerChapterItem controllerChapterItem;

    public static CourseListFragment newInstance() {
        CourseListFragment fragment = new CourseListFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        controllerChapterItem = (ChapterViewHolder.ControllerChapterItem) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course_list, container, false);
        ButterKnife.bind(this, view);

        bindChapterListData();

        return view;
    }

    private void bindChapterListData() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext()) {
            @Override
            protected int getExtraLayoutSpace(RecyclerView.State state) {
                return 300;
            }
        };
        rvChapterList.setLayoutManager(linearLayoutManager);

        chapterAdapter = new ChapterAdapter(new ArrayList<ChapterVO>(), controllerChapterItem);
        rvChapterList.setAdapter(chapterAdapter);
    }

}
