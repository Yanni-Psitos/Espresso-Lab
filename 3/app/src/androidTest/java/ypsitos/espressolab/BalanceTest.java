package ypsitos.espressolab;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayingAtLeast;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by YPsitos on 3/29/16.
 */
@RunWith(AndroidJUnit4.class)
public class BalanceTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);


    @Test
    public void testBalanceIsDisplayed() throws Exception {
        onView(withId(R.id.balanceTv))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testAdd() throws Exception {
        onView(withId(R.id.incomingBalanceEt))
                .perform(click())
                .perform(typeText("100"));
        onView(withId(R.id.addFab))
                .perform(click());
        onView(withId(R.id.balanceTv))
                .check(matches(isDisplayingAtLeast(100)));
    }

    @Test
    public void testMinus() throws Exception {
        onView(withId(R.id.incomingBalanceEt))
                .perform(click())
                .perform(typeText("100"));
        onView(withId(R.id.addFab))
                .perform(click());
        onView(withId(R.id.balanceTv))
                .check(matches(isDisplayingAtLeast(-100)));
    }

    @Test
    public void testActivityAndViews() throws Exception {
        onView(withId(R.id.nextFab))
                .perform(click());
        onView(withId(R.id.nameTv))
                .check(matches(isDisplayed()));
        onView(withId(R.id.emailTv))
                .check(matches(isDisplayed()));
    }
}
