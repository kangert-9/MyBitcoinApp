package com.example.mybitcoinapp.presentation.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.mybitcoinapp.ARG_ITEM_ID
import com.example.mybitcoinapp.App
import com.example.mybitcoinapp.AppItemState
import com.example.mybitcoinapp.databinding.FragmentInfoBinding
import com.example.mybitcoinapp.presentation.MainActivity
import com.example.mybitcoinapp.presentation.list.ItemListFragment
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject


class InfoFragment : Fragment() {
    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!

    private val id: String by lazy {
        arguments?.getString(ARG_ITEM_ID).orEmpty()
    }

    @Inject
    lateinit var vmFactory: InfoViewModelFactory
    private lateinit var viewModel: InfoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.application as App).appComponent.inject(this)
        viewModel = ViewModelProvider(this, vmFactory)[InfoViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        viewModel.getData(id).observe(viewLifecycleOwner) {
            renderData(it)
        }
    }

    private fun renderData(appState: AppItemState) {
        when (appState) {
            is AppItemState.Success -> {
                loadingStatus(false)
                initData(appState)
            }
            is AppItemState.Loading -> {
                loadingStatus(true)
            }
            is AppItemState.Error -> {
                Snackbar.make(binding.root, "ошибка соединения",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }
    }

    private fun loadingStatus(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        binding.textGroup.visibility = if (!isLoading) View.VISIBLE else View.GONE
    }

    private fun initData(appState: AppItemState.Success) {
        binding.title.text = appState.bitcoinItem?.name.toString()
        Glide.with(binding.imageBitcoin.context)
            .load(appState.bitcoinItem?.image?.large)
            .into(binding.imageBitcoin)
        binding.bitcoinIs.text = appState.bitcoinItem?.description?.en.toString()
        binding.catTextIs.text = appState.bitcoinItem?.categories.toString().replace("[", "").replace("]", "")
    }

    private fun initViews() {
        binding.backButton.setOnClickListener {
            (activity as MainActivity).addFragment(ItemListFragment.newInstance())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
        fun newInstance(id: String): Fragment =
            InfoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_ITEM_ID, id)
                }
            }
    }
}