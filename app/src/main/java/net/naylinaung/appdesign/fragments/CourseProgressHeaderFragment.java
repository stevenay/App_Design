package net.naylinaung.appdesign.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.naylinaung.appdesign.R;

public class CourseProgressHeaderFragment extends Fragment {

    public static CourseProgressHeaderFragment newInstance() {
        CourseProgressHeaderFragment fragment = new CourseProgressHeaderFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_course_progress_header, container, false);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
