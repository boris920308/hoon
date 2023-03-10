package com.example.wordsapp

import android.os.Bundle
import android.view.*
import android.widget.GridLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordsapp.databinding.FragmentLetterListBinding

class LetterListFragment : Fragment() {
    /**
     * 유형은 FragmentLetterListBinding?이어야 하고 초깃값은 null이어야 합니다.
     * null을 허용해야 하는 이유는 무엇인가요? onCreateView()가 호출될 때까지 레이아웃을 확장할 수 없기 때문입니다.
     * LetterListFragment의 인스턴스가 만들어지는 시점(수명 주기가 onCreate()로 시작될 때)과 이 속성을 실제로 사용할 수 있는 시점 사이에는 기간이 있습니다.
     * 프래그먼트의 뷰는 프래그먼트의 수명 주기 동안 여러 번 만들어지고 소멸될 수 있다는 사실에도 유의해야 합니다.
     * 이러한 이유로 다른 수명 주기 메서드 onDestroyView()에서도 값을 재설정해야 합니다.
     */

    private var _binding: FragmentLetterListBinding? = null
    private val binding
        get() = _binding!! // 여기서 get()은 이 속성이 'get-only'임을 나타냅니다. 즉, 값을 가져올 수 있지만 여기서와 같이 할당되고 나면 다른 것에 할당할 수 없습니다.
    private lateinit var recyclerView: RecyclerView
    private var isLinearLayoutManager = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLetterListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView
        chooseLayout()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.layout_menu, menu)

        val layoutButton = menu.findItem(R.id.action_switch_layout)
        setIcon(layoutButton)
    }

    private fun chooseLayout() {
        when (isLinearLayoutManager) {
            true -> {
                recyclerView.layoutManager = LinearLayoutManager(context)
                recyclerView.adapter = LetterAdapter()
            }
            false -> {
                recyclerView.layoutManager = GridLayoutManager(context, 4)
                recyclerView.adapter = LetterAdapter()
            }
        }
    }

    private fun setIcon(menuItem: MenuItem?) {
        if (menuItem == null)
            return

        menuItem.icon =
            if (isLinearLayoutManager)
                ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_grid_layout)
            else
                ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_linear_layout)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_switch_layout -> {
                isLinearLayoutManager = !isLinearLayoutManager
                chooseLayout()
                setIcon(item)
                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

}