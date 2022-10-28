package com.example.mybitcoinapp.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.domain.domain.models.ExchangeRates
import com.example.mybitcoinapp.App
import com.example.mybitcoinapp.AppListState
import com.example.mybitcoinapp.databinding.FragmentItemListBinding
import com.example.mybitcoinapp.presentation.info.InfoFragment
import com.example.mybitcoinapp.presentation.MainActivity
import com.example.mybitcoinapp.presentation.recycler.BitcoinAdapter
import com.google.android.material.chip.Chip
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject


class ItemListFragment : Fragment(), BitcoinAdapter.OnItemClickListener {
    private var _binding: FragmentItemListBinding? = null
    private val binding get() = _binding!!

    @Inject lateinit var vmFactory: ListViewModelFactory
    lateinit var viewModel: ListViewModel

    private val adapter = BitcoinAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.application as App).appComponent.inject(this)
        viewModel = ViewModelProvider(this, vmFactory)[ListViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.list.adapter = adapter
        initViews()
        observe()
    }

    private fun observe(currency: ExchangeRates = ExchangeRates()) {
        viewModel.getData(currency).observe(viewLifecycleOwner) {
            renderData(it)
        }
    }

    private fun renderData(appState: AppListState) {
        when (appState) {
            is AppListState.Success -> {
                adapter.submitList(appState.bitcoinList)
                loadingStatus(false)
            }
            is AppListState.Loading -> {
                loadingStatus(true)
            }
            is AppListState.Error -> {
                Snackbar.make(binding.root, "ошибка соединения",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }
    }

    private fun loadingStatus(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        binding.list.visibility = if (!isLoading) View.VISIBLE else View.GONE
    }

    private fun initViews() {
        binding.chipUSD.setOnClickListener {
            observe(ExchangeRates((it as Chip).text.toString()))
        }
        binding.chipEUR.setOnClickListener {
            observe(ExchangeRates((it as Chip).text.toString()))
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onItemPicked(item: com.example.domain.domain.models.Bitcoin) {
        (activity as MainActivity).addFragment(InfoFragment.newInstance(item.id.toString()))
    }


    companion object{
        fun newInstance(): ItemListFragment {
            return ItemListFragment()
        }
    }
}