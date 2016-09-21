package net.naylinaung.appdesign.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;

import net.naylinaung.appdesign.AppDesignApp;
import net.naylinaung.appdesign.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewDiscussionActivity extends AppCompatActivity {

    @BindView(R.id.spinner_topic)
    Spinner spinnerTopic;

    private String[] arraySpinner;

    private static final String IE_DISCUSSION_ID = "IE_DISCUSSION_ID";

    public static Intent newIntent(Integer discussionID) {
        Intent intent = new Intent(AppDesignApp.getContext(), NewDiscussionActivity.class);
        intent.putExtra(IE_DISCUSSION_ID, discussionID);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_discussion);
        ButterKnife.bind(this, this);

        this.arraySpinner = new String[] {
            "General Topic",
            "1. Wear broad-spectrum sunscreen",
            "2. Put on protective clothing",
            "3. Use UV-blocking sunglasses",
            "4. Limiting Your Overall Exposure to UV Rays.",
            "5. Stay out of the sun during peak UV rediation times"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                                        R.layout.view_item_discussion_topic, arraySpinner);
        spinnerTopic.setAdapter(adapter);
    }
}
