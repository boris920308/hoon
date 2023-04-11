/*
 * Copyright (C) 2021 The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.marsphotos.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.android.marsphotos.databinding.FragmentOverviewBinding

/**
 * This fragment shows the the status of the Mars photos web services transaction.
 *
 * MainActivity 내에 표시되는 프래그먼트입니다.
 * 이전 단계에서 확인한 자리표시자 텍스트가 이 프래그먼트에 표시됩니다.
 * 다음 Codelab에서 이 프래그먼트는 화성 사진 백엔드 서버에서 받은 데이터를 표시합니다.
 * 이 클래스는 OverviewViewModel 객체 참조를 보유합니다.
 * OverviewFragment에는 데이터 결합을 사용하여 fragment_overview 레이아웃을 확장하고
 * 결합 수명 주기 소유자를 자체로 설정하고 결합 객체의 viewModel 변수를 자체로 설정하는 onCreateView() 함수가 있습니다.
 * 수명 주기 소유자가 할당되므로 데이터 결합에 사용된 모든 LiveData의 변경이 자동으로 관찰되며, 변경사항에 따라 UI가 업데이트됩니다.
 */
class OverviewFragment : Fragment() {

    private val viewModel: OverviewViewModel by viewModels()

    /**
     * Inflates the layout with Data Binding, sets its lifecycle owner to the OverviewFragment
     * to enable Data Binding to observe LiveData, and sets up the RecyclerView with an adapter.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOverviewBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel

        return binding.root
    }
}
