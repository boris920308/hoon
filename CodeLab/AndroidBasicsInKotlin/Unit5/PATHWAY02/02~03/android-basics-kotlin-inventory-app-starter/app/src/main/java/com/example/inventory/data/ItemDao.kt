package com.example.inventory.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow


/**
 * 데이터 액세스 객체(DAO)는 추상 인터페이스를 제공하여 지속성 레이어를 애플리케이션의 나머지 부분과 분리하는 데 사용되는 패턴입니다.
 * 이러한 격리는 이전 Codelab에서 확인한 단일 책임 원칙을 따릅니다.
 * DAO의 기능은 애플리케이션 나머지 부분의 기본 지속성 레이어에서 데이터베이스 작업 실행과 관련된 모든 복잡성을 숨기는 것입니다.
 * 이를 통해 데이터를 사용하는 코드와 상관없이 데이터 액세스 레이어를 변경할 수 있습니다.
 */

@Dao
interface ItemDao {
    // OnConflict 인수는 충돌이 발생하는 경우 Room에 실행할 작업을 알려줍니다. OnConflictStrategy.IGNORE 전략은 기본 키가 이미 데이터베이스에 있으면 새 항목을 무시합니다
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query("SELECT * from item WHERE id = :id")
    fun getItem(id: Int): Flow<List<Item>>
}