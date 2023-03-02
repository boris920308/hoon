package codelab.hoon.tiptime

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CalculatorTests {

    /**
     * ActivityScenarioRule은 AndroidX 테스트 라이브러리에서 가져옵니다.
     * 기기에 개발자가 지정한 활동을 실행하라고 지시합니다.
     * @get:Rule로 주석을 달아야 합니다.
     * 이는 후속 규칙(이 경우 활동 실행)이 클래스의 모든 테스트 전에 실행되어야 한다고 지정합니다.
     * 테스트 규칙은 테스트에 필수적인 도구이므로 결국 직접 작성하는 방법을 배우게 됩니다.
     */
    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun calculate_20_percent_tip() {
        /**
         * 첫 번째 단계는 onView() 함수를 사용하여 상호작용할 UI 구성요소(이 경우에는 TextInputEditText)를 찾는 것입니다.
         * onView() 함수는 ViewMatcher 객체 매개변수를 사용합니다.
         * ViewMatcher는 기본적으로 특정 기준과 일치하는 UI 구성요소입니다.
         * 이 경우에는 ID가 R.id.cost_of_service_edit_text인 구성요소입니다.
         */
        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText("50.00"))
            .perform(ViewActions.closeSoftKeyboard())


        /**
         * 이제 텍스트가 입력되므로 테스트에서 Calculate 버튼을 클릭해야 합니다.
         * 이를 위한 코드는 텍스트를 입력하는 데 사용한 것과 유사한 형식을 따릅니다.
         * UI 구성요소가 다르므로 withId() 함수에 전달되는 ID 이름도 다릅니다.
         * 그러나 이 접근 방식의 유일한 차이점은 ViewAction이 다르다는 점입니다.
         * typeText() 대신 click() 함수가 사용됩니다.
         */
        onView(withId(R.id.calculate_button))
            .perform(click())

        /**
         * 마지막으로 올바른 팁이 표시되었다고 어설션을 만들어야 합니다.
         * 팁 금액은 $10.00일 것으로 예상됩니다.
         * 이 테스트에서는 ID가 tip_result인 TextView에 예상 팁 값이 문자열 형식으로 포함되어 있는지 확인합니다.
         */
        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("₩10"))))
    }
}