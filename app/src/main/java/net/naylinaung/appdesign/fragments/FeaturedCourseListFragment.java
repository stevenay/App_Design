package net.naylinaung.appdesign.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.naylinaung.appdesign.R;
import net.naylinaung.appdesign.adapters.ChapterAdapter;
import net.naylinaung.appdesign.adapters.MyCourseAdapter;
import net.naylinaung.appdesign.animators.RecyclerItemAnimator;
import net.naylinaung.appdesign.data.vos.CourseVO;
import net.naylinaung.appdesign.views.holders.ChapterViewHolder;
import net.naylinaung.appdesign.views.holders.MyCourseViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeaturedCourseListFragment extends Fragment {

    @BindView(R.id.rv_lifestyle_list)
    RecyclerView rvLifestyleList;

    @BindView(R.id.rv_technology_list)
    RecyclerView rvTechnologyList;

    private MyCourseAdapter myCourseAdapter;
    private MyCourseViewHolder.ControllerCourseItem controllerCourseItem;

    public static FeaturedCourseListFragment newInstance()
    {
        FeaturedCourseListFragment fragment = new FeaturedCourseListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_featured_course_list, container, false);
        ButterKnife.bind(this, view);

        setupFeaturedCourse();

        return view;
    }

    private void setupFeaturedCourse() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false);
        rvLifestyleList.setLayoutManager(linearLayoutManager);

        myCourseAdapter = new MyCourseAdapter(prepareSampleCourseList(), controllerCourseItem);
        rvLifestyleList.setAdapter(myCourseAdapter);
        rvLifestyleList.setItemAnimator(new RecyclerItemAnimator());

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false);
        rvTechnologyList.setLayoutManager(linearLayoutManager1);
        rvTechnologyList.setAdapter(myCourseAdapter);
    }

    public List<CourseVO> prepareSampleCourseList() {
        List<CourseVO> courseList = new ArrayList<>();

        CourseVO courseOne = new CourseVO();
        courseOne.setTitle("UV ေရာင္ျခည္ကို ဘယ္လိုကာကြယ္မလဲ");
        courseOne.setCategoryName("LifeStyle");
        courseOne.setDurationInMinute(15);
        courseOne.setAuthorName("Admin Team");
        courseOne.setColorCode("#aed582");
        courseOne.setImageUrl("co_terrace.png");
        courseList.add(courseOne);

        CourseVO courseTwo = new CourseVO();
        courseTwo.setTitle("အားကစားကို နည္းမွန္လမ္းမွန္ ျပဳလုပ္နည္းမ်ား");
        courseTwo.setCategoryName("Sports and Fitness");
        courseTwo.setDurationInMinute(15);
        courseTwo.setAuthorName("Admin Team");
        courseTwo.setColorCode("#81c683");
        courseOne.setImageUrl("co_runner.png");
        courseList.add(courseTwo);

        CourseVO courseThree = new CourseVO();
        courseThree.setTitle("C# အသံုးျပဳ Console Application တစ္ခု ဘယ္လိုတည္ေဆာက္မလဲ");
        courseThree.setCategoryName("Programming");
        courseThree.setDurationInMinute(10);
        courseThree.setAuthorName("Admin Team");
        courseThree.setColorCode("#25c6da");
        courseOne.setImageUrl("co_terrace.png");
        courseList.add(courseThree);

        return courseList;
    }
}
