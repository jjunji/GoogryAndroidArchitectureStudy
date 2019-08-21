package com.architecture.study.view.coin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.architecture.study.R
import com.architecture.study.data.repository.CoinRepositoryImp
import com.architecture.study.network.model.MarketResponse
import com.architecture.study.view.coin.adapter.CoinTabPagerAdapter
import com.architecture.study.view.coin.presenter.CoinListActivityContract
import com.architecture.study.view.coin.presenter.CoinListActivityPresenter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class CoinListActivity : AppCompatActivity(), CoinListActivityContract.View {

    override lateinit var presenter: CoinListActivityContract.Presenter

    private lateinit var coinTapPagerAdapter: CoinTabPagerAdapter

    private val tabList = listOf(
        R.string.monetary_unit_1,
        R.string.monetary_unit_2,
        R.string.monetary_unit_3,
        R.string.monetary_unit_4
    )

    override fun onResume() {
        super.onResume()
        presenter.start()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = CoinListActivityPresenter(
            CoinRepositoryImp.getInstance(),
            this@CoinListActivity,
            false
        )
    }

    override fun showMessage(message: String) {
        Toast.makeText(this@CoinListActivity, message, Toast.LENGTH_SHORT).show()
    }

    /* tab layout && view pager init*/
    override fun setTabPager(marketList: List<MarketResponse>) {
        monetary_unit_tablayout.run {
            tabList.map {
                addTab(newTab().setText(getString(it)))
            }
            tabGravity = TabLayout.GRAVITY_FILL

            addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    coin_list_viewpager.currentItem = tab.position
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }
            })
        }

        coinTapPagerAdapter = CoinTabPagerAdapter(supportFragmentManager, tabList, this@CoinListActivity, marketList)
        coin_list_viewpager.run {
            adapter = coinTapPagerAdapter
            addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(monetary_unit_tablayout))
        }

    }

}