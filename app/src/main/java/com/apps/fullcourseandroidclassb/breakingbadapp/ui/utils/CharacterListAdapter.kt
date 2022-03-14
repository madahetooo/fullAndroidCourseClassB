package com.apps.fullcourseandroidclassb.breakingbadapp.ui.utils

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.apps.fullcourseandroidclassb.R
import com.apps.fullcourseandroidclassb.breakingbadapp.model.BBCharacter
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.character_item.view.*
import kotlinx.android.synthetic.main.clothes_item.view.*

class CharacterListAdapter() {

    inner class CharacterViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        private val tvCharacterName:TextView = itemView.findViewById(R.id.tvCharacterName)
        private val tvCharacterNickName:TextView = itemView.findViewById(R.id.tvCharacterNickName)
        private val tvCharacterBirthday:TextView = itemView.findViewById(R.id.tvCharacterBirthday)
        private val tvCharacterOccupation:TextView = itemView.findViewById(R.id.tvCharacterOccupation)
        private val tvCharacterStatus:TextView = itemView.findViewById(R.id.tvCharacterStatus)
        private val ivCharacterImage:ImageView = itemView.findViewById(R.id.ivCharacterImage)

        fun bind(charcter:BBCharacter){
            tvCharacterName.text = charcter.name
            tvCharacterNickName.text = charcter.nickname
            tvCharacterBirthday.text = charcter.birthday
            tvCharacterOccupation.text = charcter.occupation.joinToString { "," }
            tvCharacterStatus.text = charcter.status

            if (charcter.img !=null){
                Glide.with(itemView).load(charcter.img).centerCrop().into(ivCharacterImage)
            }
        }

    }

}