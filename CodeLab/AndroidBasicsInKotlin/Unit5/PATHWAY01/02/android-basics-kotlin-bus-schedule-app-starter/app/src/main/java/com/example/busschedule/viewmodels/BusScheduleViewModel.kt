package com.example.busschedule.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.busschedule.database.schedule.Schedule
import com.example.busschedule.database.schedule.ScheduleDao
import kotlinx.coroutines.flow.Flow

class BusScheduleViewModel(private val scheduleDao: ScheduleDao): ViewModel() {

    fun fullSchedule(): Flow<List<Schedule>> = scheduleDao.getAll()

    fun scheduleForStopName(name: String): Flow<List<Schedule>> = scheduleDao.getByStopName(name)

    /**
     * 뷰 모델 정의를 완료했지만 BusScheduleViewModel을 직접 인스턴스화하고 모든 것이 작동할 것으로 기대할 수는 없습니다.
     * ViewModel 클래스 BusScheduleViewModel은 수명 주기를 인식해야 하므로 수명 주기 이벤트에 응답할 수 있는 객체로 인스턴스화해야 합니다.
     * 프래그먼트 중 하나에서 직접 인스턴스화하면 프래그먼트 객체가 앱 코드의 기능 범위를 벗어나는 모든 메모리 관리 등 모든 것을 처리해야 합니다.
     * 대신 뷰 모델 객체를 인스턴스화하는 팩토리라는 클래스를 만들 수 있습니다.
     */
    class BusScheduleViewModelFactory(
        private val scheduleDao: ScheduleDao
    ) : ViewModelProvider.Factory {

        // 인스턴스화를 위한 오버라이딩
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(BusScheduleViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return BusScheduleViewModel(scheduleDao) as T
            }
            throw IllegalArgumentException("Unknown ViewModel clasS")
        }
    }
}
