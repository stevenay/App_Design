package net.naylinaung.appdesign.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import net.naylinaung.appdesign.AppDesignApp;
import net.naylinaung.appdesign.R;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PopupQuestionActivity extends AppCompatActivity {

    @BindView(R.id.tv_screen_title)
    TextView tvScreenTitle;

    private static final String IE_LESSON_CARD_ID = "IE_COURSE_ID";

    public static Intent newIntent(String lessonCardID) {
        Intent intent = new Intent(AppDesignApp.getContext(), PopupQuestionActivity.class);
        intent.putExtra(IE_LESSON_CARD_ID, lessonCardID);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_question);
        ButterKnife.bind(this, this);
    }

    @OnClick(R.id.btn_back)
    public void onbtnBackPressed(ImageButton view) { this.onBackPressed(); }
}
