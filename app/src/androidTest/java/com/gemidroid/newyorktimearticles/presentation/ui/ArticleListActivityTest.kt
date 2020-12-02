package com.gemidroid.newyorktimearticles.presentation.ui

import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
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
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class ArticleListActivityTest {
    @Rule
    var mActivityTestRule = ActivityTestRule(
        ArticleListActivity::class.java
    )

    @Test
    fun articleListActivityTest() {
        val textView = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.snackbar_text),
                ViewMatchers.withText("No Internet Connection"),
                childAtPosition(
                    childAtPosition(
                        IsInstanceOf.instanceOf(FrameLayout::class.java),
                        0
                    ),
                    0
                ),
                ViewMatchers.isDisplayed()
            )
        )
        textView.check(ViewAssertions.matches(ViewMatchers.withText("No Internet Connection")))
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

                override fun matchesSafely(view: View): Boolean {
                    val parent = view.parent
                    return (parent is ViewGroup && parentMatcher.matches(parent)
                            && view == parent.getChildAt(position))
                }
            }
        }
    }
}