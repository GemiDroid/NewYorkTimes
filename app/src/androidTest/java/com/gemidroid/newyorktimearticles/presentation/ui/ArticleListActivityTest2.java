package com.gemidroid.newyorktimearticles.presentation.ui;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.gemidroid.newyorktimearticles.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ArticleListActivityTest2 {

    @Rule
    public ActivityTestRule<ArticleListActivity> mActivityTestRule = new ActivityTestRule<>(ArticleListActivity.class);

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

    @Test
    public void articleListActivityTest2() {
        ViewInteraction imageView = onView(
                allOf(withId(R.id.iv_article),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.rec_articles),
                                        3),
                                0),
                        isDisplayed()));
        imageView.check(matches(isDisplayed()));

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.rec_articles),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.drawer),
                                        0),
                                1),
                        isDisplayed()));
        recyclerView.check(matches(isDisplayed()));

        ViewInteraction imageView2 = onView(
                allOf(withId(R.id.iv_article),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.rec_articles),
                                        1),
                                0),
                        isDisplayed()));
        imageView2.check(matches(isDisplayed()));

        ViewInteraction textView = onView(
                allOf(withId(R.id.tv_date), withText("2020-06-09"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.rec_articles),
                                        3),
                                4),
                        isDisplayed()));
        textView.check(matches(withText("2020-06-09")));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.tv_article_title), withText("Free Food, Free Speech and Free of Police: Inside Seattle’s ‘Autonomous Zone’"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.rec_articles),
                                        5),
                                1),
                        isDisplayed()));
        textView2.check(matches(withText("Free Food, Free Speech and Free of Police: Inside Seattle’s ‘Autonomous Zone’")));
    }
}
