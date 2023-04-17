package com.example.busschedule.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.busschedule.database.schedule.ScheduleDao


/**
 * 이제 DAO에 액세스하기 위한 프래그먼트의 모델과 DAO, 뷰 모델을 정의했지만 여전히 이러한 모든 클래스로 할 작업을 Room에 알려야 합니다.
 * 여기서 AppDatabase 클래스가 필요합니다.
 * Room을 사용하는 Android 앱은 RoomDatabase 클래스를 서브클래스로 분류하고 몇 가지 주요 책임이 있습니다.
 * 앱에서 AppDatabase는 다음 작업을 실행해야 합니다.
 *
 * 1. 데이터베이스에서 정의되는 항목을 지정합니다.
 * 2. 각 DAO 클래스의 단일 인스턴스 액세스 권한을 제공합니다.
 * 3. 데이터베이스 미리 채우기와 같은 추가 설정을 실행합니다.
 *
 */

@Database(entities = [ScheduleDao::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun scheduleDao(): ScheduleDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database")
                    .createFromAsset("database/bus_schedule.db")
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}