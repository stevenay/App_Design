package net.naylinaung.appdesign.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import net.naylinaung.appdesign.AppDesignApp;
import net.naylinaung.appdesign.R;
import net.naylinaung.appdesign.adapters.ChapterAdapter;
import net.naylinaung.appdesign.adapters.ReplyAdapter;
import net.naylinaung.appdesign.data.vos.ReplyVO;
import net.naylinaung.appdesign.views.holders.ChapterViewHolder;
import net.naylinaung.appdesign.views.holders.ReplyViewHolder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DiscussionDetailActivity extends AppCompatActivity {

    @BindView(R.id.rv_reply_list)
    RecyclerView rvReplyList;

    private ReplyAdapter replyAdapter;
    private ReplyViewHolder.ControllerReplyItem controllerReplyItem;

    private static final String IE_DISCUSSION_ID = "IE_DISCUSSION_ID";

    public static Intent newIntent(String discussionID) {
        Intent intent = new Intent(AppDesignApp.getContext(), DiscussionDetailActivity.class);
        intent.putExtra(IE_DISCUSSION_ID, discussionID);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discussion_detail);
        ButterKnife.bind(this, this);

        if (savedInstanceState == null) {
            bindReplyListData();
        }
    }

    private void bindReplyListData() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this) {
            @Override
            protected int getExtraLayoutSpace(RecyclerView.State state) {
                return 300;
            }
        };
        rvReplyList.setLayoutManager(linearLayoutManager);

        replyAdapter = new ReplyAdapter(new ArrayList<ReplyVO>(), controllerReplyItem);
        rvReplyList.setAdapter(replyAdapter);
    }
}
