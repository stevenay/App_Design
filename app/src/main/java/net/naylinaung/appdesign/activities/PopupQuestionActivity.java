package net.naylinaung.appdesign.activities;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import net.naylinaung.appdesign.AppDesignApp;
import net.naylinaung.appdesign.R;
import net.naylinaung.appdesign.fragments.PopupQuestionFragment;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PopupQuestionActivity extends AppCompatActivity {

    @BindView(R.id.rl_result_popup)
    RelativeLayout rlResultPopup;

    private static final String IE_LESSON_CARD_ID = "IE_COURSE_ID";
    private boolean resultCheck = true;

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

        if (savedInstanceState == null) {
            navigateToPopupQuestion();
        }
    }

    @OnClick(R.id.btn_back)
    public void onbtnBackPressed(ImageButton view) { this.onBackPressed(); }

    @OnClick(R.id.btn_check)
    public void onbtnCheckPressed(Button view) {
//        if (resultCheck) {
//            rlResultPopup.animate().translationX(0);
//            resultCheck = false;
//        } else {
//            rlResultPopup.animate().translationX(-1 * (rlResultPopup.getWidth() + 50));
//            resultCheck = true;
//        }if (resultCheck) {
//            rlResultPopup.animate().translationX(0);
//            resultCheck = false;
//        } else {
//            rlResultPopup.animate().translationX(-1 * (rlResultPopup.getWidth() + 50));
//            resultCheck = true;
//        }

        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slide_in_fragment, R.anim.slide_out_fragment)
                .replace(R.id.fl_container, PopupQuestionFragment.newInstance())
                .commit();
    }

    private void navigateToPopupQuestion() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, PopupQuestionFragment.newInstance())
                .commit();
    }
}
