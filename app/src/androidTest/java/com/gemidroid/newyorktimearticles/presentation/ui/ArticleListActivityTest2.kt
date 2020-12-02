package com.gemidroid.newyorktimearticles.presentation.ui

import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.gemidroid.newyorktimearticles.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class ArticleListActivityTest2 {
    @Rule
    var mActivityTestRule = ActivityTestRule(
        ArticleListActivity::class.java
    )

    @Test
    fun articleListActivityTest2() {
        val imageView = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.iv_article),
                childAtPosition(
                    childAtPosition(
                        ViewMatchers.withId(R.id.rec_articles),
                        3
                    ),
                    0
                ),
                ViewMatchers.isDisplayed()
            )
        )
        imageView.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        val recyclerView = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.rec_articles),
                childAtPosition(
                    childAtPosition(
                        ViewMatchers.withId(R.id.drawer),
                        0
                    ),
                    1
                ),
                ViewMatchers.isDisplayed()
            )
        )
        recyclerView.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        val imageView2 = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.iv_article),
                childAtPosition(
                    childAtPosition(
                        ViewMatchers.withId(R.id.rec_articles),
                        1
                    ),
                    0
                ),
                ViewMatchers.isDisplayed()
            )
        )
        imageView2.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        val textView = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.tv_date), ViewMatchers.withText("2020-06-09"),
                childAtPosition(
                    childAtPosition(
                        ViewMatchers.withId(R.id.rec_articles),
                        3
                    ),
                    4
                ),
                ViewMatchers.isDisplayed()
            )
        )
        textView.check(ViewAssertions.matches(ViewMatchers.withText("2020-06-09")))
        val textView2 = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.tv_article_title),
                ViewMatchers.withText("Free Food, Free Speech and Free of Police: Inside Seattle’s ‘Autonomous Zone’"),
                childAtPosition(
                    childAtPosition(
                        ViewMatchers.withId(R.id.rec_articles),
                        5
                    ),
                    1
                ),
                ViewMatchers.isDisplayed()
            )
        )
        textView2.check(ViewAssertions.matches(ViewMatchers.withText("Free Food, Free Speech and Free of Police: Inside Seattle’s ‘Autonomous Zone’")))
    }

    companion object {
        private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int
        ): Matcher<View> {
            return object : TypeSafeMatcher<View>() {
                override fun describeTo(description: Description) {
                    description.appendText("Child at position $position in parent ")
                    parentMatcher.describeTo(description)
                }

                public override fun matchesSafely(view: View): Boolean {
                    val parent = view.parent
                    return (parent is ViewGroup && parentMatcher.matches(parent)
                            && view == parent.getChildAt(position))
                }
            }
        }
    }
}