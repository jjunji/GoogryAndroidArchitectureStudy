package study.architecture.myarchitecture.ui.tickerlist

import android.os.Bundle
import org.jetbrains.anko.support.v4.toast
import study.architecture.myarchitecture.R
import study.architecture.myarchitecture.base.BaseFragment
import study.architecture.myarchitecture.data.Injection
import study.architecture.myarchitecture.databinding.FragmentTickerListBinding
import study.architecture.myarchitecture.util.Filter

class TickerListFragment : BaseFragment<FragmentTickerListBinding>(R.layout.fragment_ticker_list) {

    private lateinit var tickerViewModel: TickerListViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        arguments?.let { bundle ->

            tickerViewModel = TickerListViewModel(
                Injection.provideFolderRepository(requireContext()),
                bundle.getString(KEY_MARKETS, "")
            )
            binding.tickerModel = tickerViewModel

            tickerViewModel.loadData()

        } ?: error("arguments is null")

        initRecyclerView()

    }

    override fun onDestroyView() {
        tickerViewModel.detachView()
        super.onDestroyView()
    }

    fun showTickerListOrderByField(field: Filter.SelectArrow, order: Int) {
        tickerViewModel.sortByField(field, order)
    }

    private fun initRecyclerView() {
        binding.rvTickerList.adapter = TickerAdapter { toast(it.toString()) }
    }

    companion object {

        const val KEY_MARKETS = "markets"

        fun newInstance(tickers: String) = TickerListFragment().apply {
            arguments = Bundle().apply {
                putString(KEY_MARKETS, tickers)
            }
        }
    }
}