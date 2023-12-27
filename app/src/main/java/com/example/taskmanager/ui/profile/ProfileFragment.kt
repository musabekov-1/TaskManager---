package com.example.taskmanager.ui.profile

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import com.example.taskmanager.data.local.Pref
import com.example.taskmanager.databinding.FragmentProfileBinding
import com.example.taskmanager.ui.utils.loadImage

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private val pref by lazy {
        Pref(requireContext())
    }
    private val openGallery =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val img = it.data?.data
                pref.saveImg(img.toString())
                binding.profileImage.loadImage(img.toString())
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.etName.setText(pref.getName())
        binding.profileImage.loadImage(pref.getImg())


        binding.btnSave.setOnClickListener {
            pref.saveName(binding.etName.text.toString())
        }
        binding.profileImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.setType("image/*")
openGallery.launch(intent)
        }
    }
}