package net.naylinaung.appdesign.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.naylinaung.appdesign.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CourseInfoHeaderFragment extends Fragment {

    public static CourseInfoHeaderFragment newInstance() {
        CourseInfoHeaderFragment fragment = new CourseInfoHeaderFragment();
        return fragment;
    }

    public CourseInfoHeaderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_course_info_header, container, false);
    }

}
