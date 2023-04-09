package com.test.hoon

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.cupcake.model.OrderViewModel
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test


class ViewModelTests {
    /**
     * 간단한 테스트부터 시작해 보겠습니다.
     * 기기나 에뮬레이터에서 앱과 상호작용할 때 가장 먼저 하는 작업은 컵케이크 수량을 선택하는 것입니다.
     * 따라서 먼저 OrderViewModel에서 setQuantity() 메서드를 테스트하고 quantity LiveData 객체의 값을 확인합니다.
     * 테스트할 quantity 변수는 LiveData의 인스턴스입니다.
     * LiveData 객체를 테스트하려면 추가 단계가 필요하며 여기서 추가한 종속 항목이 중요한 역할을 합니다.
     * 값이 변경되는 즉시 LiveData를 사용하여 UI를 업데이트합니다.
     * UI는 '기본 스레드'라고 하는 것에서 실행됩니다. 스레딩과 동시 실행을 잘 몰라도 괜찮습니다.
     * 다른 Codelab에서 자세히 알아볼 예정입니다. 지금은 Android 앱이라는 컨텍스트에서 기본 스레드를 UI 스레드로 생각하세요.
     * 사용자에게 UI를 표시하는 코드는 이 스레드에서 실행됩니다.
     * 달리 명시되지 않는 한 단위 테스트는 모든 항목이 기본 스레드에서 실행된다고 가정합니다.
     * 그러나 LiveData 객체는 기본 스레드에 액세스할 수 없으므로 LiveData 객체가 기본 스레드를 호출하면 안 된다고 명시적으로 지정해야 합니다.
     *
     * LiveData 객체가 기본 스레드를 호출하면 안 된다고 지정하려면 LiveData 객체를 테스트할 때마다 특정 테스트 규칙을 제공해야 합니다.
     *
     */

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Test
    fun quantity_twelve_cupcakes() {
        val viewModel = OrderViewModel()
        viewModel.quantity.observeForever{}
        viewModel.setQuantity(12)
        assertEquals(12, viewModel.quantity.value)
    }

    @Test
    fun price_twelve_cupcakes() {
        val viewModel = OrderViewModel()
        viewModel.setQuantity(12)
        viewModel.price.observeForever {}
        assertEquals("$27.00", viewModel.price.value)
    }



}