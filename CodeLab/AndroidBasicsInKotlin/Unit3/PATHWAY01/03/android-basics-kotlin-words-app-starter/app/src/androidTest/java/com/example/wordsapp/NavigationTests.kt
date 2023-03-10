package com.example.wordsapp

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import junit.framework.Assert.assertEquals

class NavigationTests {
}

fun navigate_to_words_nav_component() {
    val navController = TestNavHostController(
        ApplicationProvider.getApplicationContext()
    )

    /**
     * 탐색 구성요소는 프래그먼트를 사용하여 UI를 구동합니다.
     * 테스트용으로 프래그먼트를 분리하는 데 사용되는 ActivityScenarioRule과 동등한 프래그먼트가 있으며, 이는 프래그먼트별 종속 항목이 필요한 이유입니다.
     * 이는 대상까지의 탐색을 처리하는 데 추가 코드 없이 실행할 수 있으므로 대상에 도달하기 위해 많은 탐색이 필요한 프래그먼트를 테스트하는 데 매우 유용합니다.
     */
    val letterListScenario = launchFragmentInContainer<LetterListFragment>(themeResId = R.style.Theme_Words)

    letterListScenario.onFragment { fragment ->
        navController.setGraph(R.navigation.nav_graph)
        Navigation.setViewNavController(fragment.requireView(), navController)
    }

    onView(withId(R.id.recycler_view))
        .perform(RecyclerViewActions
            .actionOnItemAtPosition<RecyclerView.ViewHolder>(2, click()))

    assertEquals(navController.currentDestination?.id, R.id.wordListFragment)
}