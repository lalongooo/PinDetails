package com.example.pindetails;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.pindetails.ui.ActivityMain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.action.ViewActions.longClick;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class PinDetailsInstrumentedTest {

    @Rule
    public ActivityTestRule<ActivityMain> mActivityRule = new ActivityTestRule<>(ActivityMain.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.pindetails", appContext.getPackageName());
    }

    @Test
    public void validateIfMapViewIsDisplayed() {
        onView(withId(R.id.mapView)).check(matches(isDisplayed()));
    }

    @Test
    public void theMapViewIsLongClickable() {
        onView(withId(R.id.mapView)).perform(longClick());
    }


}
