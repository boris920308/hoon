package com.example.inventory.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


/**
 * @Database 주석에는 Room이 데이터베이스를 빌드할 수 있도록 인수가 여러 개 필요합니다.
 * Item을 entities 목록이 있는 유일한 클래스로 지정합니다.
 * version을 1로 설정합니다. 데이터베이스 테이블의 스키마를 변경할 때마다 버전 번호를 높여야 합니다.
 * 스키마 버전 기록 백업을 유지하지 않도록 exportSchema를 false로 설정합니다.
 */
@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class ItemRoomDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemDao

    companion object {
        /**
         * @Volatile에 INSTANCE 주석을 답니다.
         * 휘발성 변수의 값은 캐시되지 않고 모든 쓰기와 읽기는 기본 메모리에서 실행됩니다.
         * 이렇게 하면 INSTANCE 값이 항상 최신 상태로 유지되고 모든 실행 스레드에서 같은지 확인할 수 있습니다.
         * 즉, 한 스레드에서 INSTANCE를 변경하면 다른 모든 스레드에 즉시 표시됩니다.
         */
        @Volatile
        private var INSTANCE: ItemRoomDatabase? = null

        fun getDatabase(context: Context): ItemRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemRoomDatabase::class.java,
                    "item_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }

    }
}