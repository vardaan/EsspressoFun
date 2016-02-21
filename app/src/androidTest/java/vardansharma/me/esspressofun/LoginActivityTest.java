package vardansharma.me.esspressofun;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Vardan sharma on 21/2/16.
 */
@RunWith(AndroidJUnit4.class) public class LoginActivityTest {
  @Rule public ActivityTestRule<LoginActivity> mActivityRule =
      new ActivityTestRule<>(LoginActivity.class);

  @Test public void allFieldsDisplayed() {
    onView(withId(R.id.et_email)).check(matches(isDisplayed()));
    onView(withId(R.id.et_password)).check(matches(isDisplayed()));
    onView(withId(R.id.btn_login)).check(matches(isDisplayed()));
  }

  @Test public void emptyEmailSubmissionShowsError() {
    onView(withId(R.id.btn_login)).perform(click());
    onView(withId(R.id.et_email)).check(matches(hasErrorText("please enter your email")));
  }

  @Test public void invalidEmailSubmissionShowsError() {
    onView(withId(R.id.et_email)).perform(typeText("sdfsdfd"));
    onView(withId(R.id.btn_login)).perform(click());
    onView(withId(R.id.et_email)).check(matches(hasErrorText("please enter valid email")));
  }

  @Test public void emptyPasswordSubmissionShowsError() {
    onView(withId(R.id.et_email)).perform(typeText("vardansharma@zapbuild.com"));
    onView(withId(R.id.btn_login)).perform(click());
    onView(withId(R.id.et_password)).check(matches(hasErrorText("please enter password")));
  }

  @Test public void shortPasswordSubmissionShowsError() {
    onView(withId(R.id.et_email)).perform(typeText("vardansharma@zapbuild.com"));
    onView(withId(R.id.et_password)).perform(typeText("124"));//short password
    onView(withId(R.id.btn_login)).perform(click());
    onView(withId(R.id.et_password)).check(
        matches(hasErrorText("password should be ateast 6 characters long")));
  }
}
