package com.example.gd11_b_0717


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class AddEditActivityTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(AddEditActivity::class.java)

    @Test
    fun addEditActivityTest() {
        val materialButton = Espresso.onView(
            Matchers.allOf(
                withId(R.id.btn_save), withText("Simpan"),
                childAtPosition(
                    Matchers.allOf(
                        withId(R.id.ll_button),
                        childAtPosition(
                            withClassName(Matchers.`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            1
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        materialButton.perform(click())
        Espresso.onView(isRoot()).perform(waitFor(3000))

        val textInputEditText = Espresso.onView(
            Matchers.allOf(
                withId(R.id.et_nama),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.layout_nama),
                        0
                    ),
                    0
                )
            )
        )
        textInputEditText.perform(scrollTo(), replaceText("A"), closeSoftKeyboard())

        val materialButton2 = Espresso.onView(
            Matchers.allOf(
                withId(R.id.btn_save), withText("Simpan"),
                childAtPosition(
                    Matchers.allOf(
                        withId(R.id.ll_button),
                        childAtPosition(
                            withClassName(Matchers.`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            1
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        materialButton2.perform(click())
        Espresso.onView(isRoot()).perform(waitFor(3000))

        val textInputEditText2 = Espresso.onView(
            Matchers.allOf(
                withId(R.id.et_npm),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.layout_npm),
                        0
                    ),
                    0
                )
            )
        )
        textInputEditText2.perform(scrollTo(), replaceText("1"), closeSoftKeyboard())

        val materialButton3 = Espresso.onView(
            Matchers.allOf(
                withId(R.id.btn_save), withText("Simpan"),
                childAtPosition(
                    Matchers.allOf(
                        withId(R.id.ll_button),
                        childAtPosition(
                            withClassName(Matchers.`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            1
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        materialButton3.perform(click())
        Espresso.onView(isRoot()).perform(waitFor(3000))

        val textInputEditText3 = Espresso.onView(
            Matchers.allOf(
                withId(R.id.ed_fakultas),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.layout_fakultas),
                        0
                    ),
                    0
                )
            )
        )
        textInputEditText3.perform(scrollTo(), replaceText("FTI"), closeSoftKeyboard())

        val materialButton4 = Espresso.onView(
            Matchers.allOf(
                withId(R.id.btn_save), withText("Simpan"),
                childAtPosition(
                    Matchers.allOf(
                        withId(R.id.ll_button),
                        childAtPosition(
                            withClassName(Matchers.`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            1
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        materialButton4.perform(click())
        Espresso.onView(isRoot()).perform(waitFor(3000))

        val textInputEditText4 = Espresso.onView(
            Matchers.allOf(
                withId(R.id.ed_prodi),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.layout_prodi),
                        0
                    ),
                    0
                )
            )
        )
        textInputEditText4.perform(scrollTo(), replaceText("Informatika"), closeSoftKeyboard())

        val materialButton5 = Espresso.onView(
            Matchers.allOf(
                withId(R.id.btn_save), withText("Simpan"),
                childAtPosition(
                    Matchers.allOf(
                        withId(R.id.ll_button),
                        childAtPosition(
                            withClassName(Matchers.`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            1
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        materialButton5.perform(click())
        Espresso.onView(isRoot()).perform(waitFor(3000))
    }



}

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
            return parent is ViewGroup && parentMatcher.matches(parent)
                    && view == parent.getChildAt(position)
        }
    }
}

fun waitFor(delay: Long) : ViewAction? {
    return object: ViewAction {
        override fun getConstraints(): Matcher<View> {
            return isRoot()
        }
        override fun perform(uiController: UiController, view: View?) {
            uiController.loopMainThreadForAtLeast(delay)
        }
        override fun getDescription(): String {
            return "wait for "+delay + " miliseconds"
        }
    }
}