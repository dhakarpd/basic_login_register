package com.example.demo_basic

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Lifecycle

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FinancialDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FinancialDetailsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_financial_details, container, false)
    }

    /*
    override fun getLifecycle(): Lifecycle {
        Toast.makeText(Activity,super.getLifecycle(),Toast.LENGTH_SHORT).show()
        return super.getLifecycle()
    }*/

    /*override fun onAttach(context: Context) {
        super.onAttach(context)
        Toast.makeText(view!!.context,"On Attach Financial",Toast.LENGTH_SHORT).show()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Toast.makeText(view!!.context,"On Activity Created Financial",Toast.LENGTH_SHORT).show()
    }*/

    override fun onStart() {
        super.onStart()
        Toast.makeText(context,"On Start Financial", Toast.LENGTH_SHORT).show()
    }

    /*override fun onStop() {
        super.onStop()
        Toast.makeText(view!!.context,"On Stop Financial",Toast.LENGTH_SHORT).show()
    }

    override fun onDetach() {
        super.onDetach()
        Toast.makeText(view!!.context,"On Detach Financial",Toast.LENGTH_SHORT).show()
    }*/

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FinancialDetailsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FinancialDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}