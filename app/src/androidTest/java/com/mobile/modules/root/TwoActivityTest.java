package com.mobile.modules.root;


import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.TextView;

import com.mobile.modules.R;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;

/**
 * Created by Alex Michenko
 */
@RunWith(AndroidJUnit4.class)
public class TwoActivityTest {

    @Rule
    public ActivityTestRule<TwoActivity> mActivityRule =
            new ActivityTestRule<>(TwoActivity.class);

    @Test
    public void ensureBtnLogoDisplayed() {
        onView(withId(R.id.btn_logo))
                .check(matches(isDisplayed()));
    }

    @Test
    public void ensureToolbarVisibleChange() {
        onView(withId(R.id.toolbar))
                .perform(setTextViewVisibility(true));
        onView(withId(R.id.toolbar))
                .check(matches(isDisplayed()));

        onView(withId(R.id.btn_hide))
                .perform(click());

        onView(withId(R.id.toolbar))
                .check(matches(not(isDisplayed())));

    }
    private static ViewAction setTextViewVisibility(final boolean value) {
        return new ViewAction() {

            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(View.class);
            }

            @Override
            public void perform(UiController uiController, View view) {
                view.setVisibility(value ? View.VISIBLE : View.GONE);
            }

            @Override
            public String getDescription() {
                return "Show / Hide View";
            }
        };
    }
}