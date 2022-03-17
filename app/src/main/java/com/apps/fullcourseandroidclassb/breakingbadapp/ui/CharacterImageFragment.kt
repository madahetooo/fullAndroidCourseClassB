package com.apps.fullcourseandroidclassb.breakingbadapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.apps.fullcourseandroidclassb.R
import com.bumptech.glide.Glide

@Suppress("DEPRECATION")
class CharacterImageFragment :Fragment() {

    private val args:CharacterImageFragmentArgs by navArgs()
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val ivCharacterImageSingle = requireActivity().findViewById<ImageView>(R.id.ivCharacterImageSingle)
        Glide.with(requireContext()).load(args.imageUrl).centerCrop().into(ivCharacterImageSingle)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_character_image,container,false)
    }
}