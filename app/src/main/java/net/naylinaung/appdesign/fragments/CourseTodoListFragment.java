package net.naylinaung.appdesign.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.swipe.util.Attributes;

import net.naylinaung.appdesign.R;
import net.naylinaung.appdesign.adapters.TodoAdapter;
import net.naylinaung.appdesign.utils.DividerItemDecoration;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.recyclerview.animators.FadeInLeftAnimator;

// This fragment is for todolists shown in the Course Detail Activity
public class CourseTodoListFragment extends Fragment {

    @BindView(R.id.rv_todo_list)
    RecyclerView rvTodoList;

    private RecyclerView.Adapter mAdapter;
    private ArrayList<String> mDataSet;

    public static CourseTodoListFragment newInstance() {
        CourseTodoListFragment fragment = new CourseTodoListFragment();
        return fragment;
    }

    public CourseTodoListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_course_todo_list, container, false);
        ButterKnife.bind(this, view);

        // Layout Managers:
        rvTodoList.setLayoutManager(new LinearLayoutManager(getContext()));

        // Item Decorator:
        // rvTodoList.addItemDecoration(new DividerItemDecoration(getResources().getDrawable(R.drawable.divider)));
        rvTodoList.setItemAnimator(new FadeInLeftAnimator());

        // Adapter:
        String[] adapterData = new String[]{
                "Write down my skills/expertise in this field.",
                "Write down how I'm different from other experts in the field.",
                "Write down how others will benefit from my opinions and advice.",
                "Define my personal branding target audience.",
                "Write down my target audience's interests that are related to my field.",
                "Create a personal branding website.",
                "Write a short website bio and a shorter social media bio.",
                "Choose a universal profile photo."};
        mDataSet = new ArrayList<String>(Arrays.asList(adapterData));
        mAdapter = new TodoAdapter(mDataSet);
        ((TodoAdapter) mAdapter).setMode(Attributes.Mode.Single);

        rvTodoList.setAdapter(mAdapter);

        return view;
    }

}
