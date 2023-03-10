/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.wordsapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordsapp.databinding.ActivityMainBinding

/**
 * Main Activity and entry point for the app. Displays a RecyclerView of letters.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        setupActionBarWithNavController(navController)
    }

    /**
     * onSupportNavigateUp()을 구현합니다.
     * XML에서 defaultNavHost를 true로 설정하는 것과 함께 이 메서드를 사용하면 위로 버튼을 처리할 수 있습니다.
     * 그러나 활동이 구현을 제공해야 합니다.
     */
    override fun onSupportNavigateUp(): Boolean {
        /**
         * 참고: navigateUp() 함수가 실패할 수 있으므로 성공 여부에 관해 Boolean을 반환합니다.
         * 그러나 navigateUp()이 false를 반환하는 경우에만 super.onSupportNavigateUp()을 호출해야 합니다.
         * 이것이 효과적인 이유는 || 연산자는 조건 중 하나만 true이면 되기 때문입니다.
         * 따라서 navigateUp()이 true를 반환하면 || 표현식의 오른쪽이 실행되지 않습니다.
         * 그러나 navigateUp()이 false이면 상위 클래스의 구현이 호출됩니다.
         * 이를 단락 평가라고 하며 알고 있으면 좋은 작은 프로그래밍 기술입니다.
         */
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
