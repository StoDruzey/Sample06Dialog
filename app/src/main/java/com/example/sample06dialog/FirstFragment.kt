package com.example.sample06dialog

import android.app.DatePickerDialog
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.text.buildSpannedString
import androidx.core.text.color
import androidx.fragment.app.Fragment
import com.example.sample06dialog.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding: FragmentFirstBinding
        get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentFirstBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {

            val colorValue = ContextCompat.getColor(
                requireContext(),
                androidx.constraintlayout.widget.R.color.abc_btn_colored_text_material
            )
            val neutralButtonText = buildSpannedString {
                color(colorValue) {
                    append("neutral")
                }
            }
//            val cancelText = android.R.string.cancel.toString()
            val cancelButtonText = buildSpannedString {
                color(Color.GREEN) {
                    append("cancel")
                }
            }

            button.setOnClickListener {

                AlertDialog.Builder(requireContext())
                    .setTitle("title")
                    .setMessage("message")
                    .setCancelable(false)
                    .setPositiveButton(android.R.string.ok) {_, _ ->

                    }
                    .setNegativeButton(cancelButtonText) {_, _ ->

                    }
                    .setNeutralButton(neutralButtonText) {_, _ ->

                    }
                    .show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}