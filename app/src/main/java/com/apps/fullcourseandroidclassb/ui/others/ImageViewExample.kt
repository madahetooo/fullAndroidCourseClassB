package com.apps.fullcourseandroidclassb.ui.others

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.apps.fullcourseandroidclassb.R
import com.apps.fullcourseandroidclassb.data.local.db.ProfileInformation
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_image_view_example.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class ImageViewExample : Fragment() {
    private val profileInformationCollectionRef =
        Firebase.firestore.collection("profileInformation")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_image_view_example, container, false)
        val buttonRetrieveData = view.findViewById<Button>(R.id.btnRetrieveData)
        buttonRetrieveData.setOnClickListener {
            retrieveProfileInformation()
        }
        return view
    }

    private fun retrieveProfileInformation() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val querySnapshot = profileInformationCollectionRef.get().await()
                val stringBuilder = StringBuilder()
                for (document in querySnapshot.documents) {
                    val profileInformation = document.toObject<ProfileInformation>()
                    stringBuilder.append("$profileInformation\n")
                }
                withContext(Dispatchers.Main) {
                    tvRetrieveProfileInformation.text = stringBuilder.toString()
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(requireContext(), e.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}