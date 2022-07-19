package com.example.collapisbleform

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.collapisbleform.databinding.FragmentBlankBinding


class BlankFragment : Fragment() {

    private var _binding : FragmentBlankBinding?  = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_blank,container,false)

        if(savedInstanceState!=null){
            binding?.motionlayout?.transitionState = savedInstanceState.getBundle("key")
        }
        // Inflate the layout for this fragment
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val myDataset = Datasource().loadAffirmations()

        binding?.recyclerView?.adapter = ItemAdapter(requireContext(),myDataset)

        binding?.recyclerView?.setHasFixedSize(true)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBundle("key",binding?.motionlayout?.transitionState)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}