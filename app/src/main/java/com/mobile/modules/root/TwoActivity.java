package com.mobile.modules.root;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.mobile.modules.R;

/**
 * Created by Alex Michenko
 */
public class TwoActivity extends AppCompatActivity {

    ActionBar actionBar;
    NestedScrollView scroll;
    MenuItem more;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        scroll = findViewById(R.id.scroll);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();


        actionBar.setTitle("Very long title for text truncating");
        actionBar.setSubtitle("Subtitle");
        actionBar.setLogo(R.drawable.ic_whatshot);
        actionBar.setIcon(R.drawable.ic_beach);
        actionBar.setBackgroundDrawable(getDrawable(R.drawable.bg_action));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.more, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        more = menu.findItem(R.id.more);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        findViewById(R.id.btn_hide).setOnClickListener(v -> {
            if (actionBar.isShowing()) {
                actionBar.hide();
            } else {
                actionBar.show();
            }
        });
        findViewById(R.id.btn_logo).setOnClickListener(v -> {
            boolean useLogo = (actionBar.getDisplayOptions() & ActionBar.DISPLAY_USE_LOGO) != 0;
            actionBar.setDisplayUseLogoEnabled(!useLogo);
        });
        findViewById(R.id.btn_title).setOnClickListener(v -> {
            boolean useTitle = (actionBar.getDisplayOptions() & ActionBar.DISPLAY_SHOW_TITLE) != 0;
            actionBar.setDisplayShowTitleEnabled(!useTitle);
        });
        findViewById(R.id.btn_home).setOnClickListener(v -> {
            boolean showHome = (actionBar.getDisplayOptions() & ActionBar.DISPLAY_SHOW_HOME) != 0;
            actionBar.setDisplayShowHomeEnabled(!showHome);
        });
        findViewById(R.id.btn_up).setOnClickListener(v -> {
            boolean showHomeAsUp = (actionBar.getDisplayOptions() & ActionBar.DISPLAY_HOME_AS_UP) != 0;
            actionBar.setDisplayHomeAsUpEnabled(!showHomeAsUp);
        });

        findViewById(R.id.btn_overlay).setOnClickListener(v -> {
            boolean overlay = scroll.getPaddingTop() == 0;
            scroll.setPadding(0, overlay ? actionBar.getHeight() : 0,0,0);
        });

        findViewById(R.id.btn_menu).setOnClickListener(v -> {
            more.setVisible(!more.isVisible());
        });

        findViewById(R.id.btn_custom).setOnClickListener(v -> {

//            View custom = getLayoutInflater().inflate(R.layout.item_list, null);
//            ActionBar.LayoutParams params = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER);
//            actionBar.setCustomView(custom, params);
            actionBar.setCustomView(R.layout.item_list);
            boolean useCustom = (actionBar.getDisplayOptions() & ActionBar.DISPLAY_SHOW_CUSTOM) != 0;
            actionBar.setDisplayShowCustomEnabled(!useCustom);
        });

        findViewById(R.id.btn_option).setOnClickListener(v -> {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_TITLE, ActionBar.DISPLAY_SHOW_HOME);
        });

        findViewById(R.id.btn_option).setOnLongClickListener(v -> {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME |ActionBar.DISPLAY_SHOW_TITLE);
            return true;
        });

    }
}
