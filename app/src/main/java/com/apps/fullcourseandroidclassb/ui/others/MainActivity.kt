package com.apps.fullcourseandroidclassb.ui.others

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.apps.fullcourseandroidclassb.R
import com.apps.fullcourseandroidclassb.data.local.db.ProfileDetails
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_registration.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

@Suppress("DEPRECATION")
class MainActivity : Fragment() {
    private val profileDetailsCollectionRef = Firebase.firestore.collection("profileDetails")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_main, container, false)
//        subscribeToRealTimeUpdates()
        val btnSaveProfileDetails = view.findViewById<Button>(R.id.btnSaveProfileDetails)
        val btnRetrieveProfileDetails = view.findViewById<Button>(R.id.btnRetrieveProfileDetails)
        val btnDeleteProfileDetails = view.findViewById<Button>(R.id.btnDeleteProfileDetails)
        val btnUpdateProfileDetails = view.findViewById<Button>(R.id.btnUpdateProfileDetails)
        btnSaveProfileDetails.setOnClickListener {
            val oldProfileDetails = getOldProfileDetails()
            saveProfileDetailsData(oldProfileDetails)
        }
        btnRetrieveProfileDetails.setOnClickListener {
            retrieveProfileDetailsData()
        }
        btnDeleteProfileDetails.setOnClickListener {
            val oldProfileDetails = getOldProfileDetails()
            deleteProfileDetails(oldProfileDetails)
        }
        btnUpdateProfileDetails.setOnClickListener {
            val oldProfileDetails = getOldProfileDetails()
            val newProfileDetails = getNewProfileDetails()
            updateProfileDetails(oldProfileDetails,newProfileDetails)
        }
        return view
    }

    private fun getOldProfileDetails(): ProfileDetails {
        val oldFirstName = etOldFirstName.text.toString()
        val oldLastName = etOldLastName.text.toString()
        val oldAge = etOldAge.text.toString().toInt()
        return ProfileDetails(oldFirstName, oldLastName, oldAge)
    }

    private fun getNewProfileDetails(): Map<String, Any> {
        val newFirstName = etNewFirstName.text.toString()
        val newLastName = etNewLastName.text.toString()
        val newAge = etNewAge.text.toString()
        val map = mutableMapOf<String, Any>()
        if (newFirstName.isNotEmpty()) {
            map["firstName"] = newFirstName
        }
        if (newLastName.isNotEmpty()) {
            map["lastName"] = newLastName
        }
        if (newAge.isNotEmpty()) {
            map["age"] = newAge.toInt()
        }
        return map
    }


    private fun saveProfileDetailsData(profileDetails: ProfileDetails) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                profileDetailsCollectionRef.add(profileDetails)
                withContext(Dispatchers.Main) {
                    Toast.makeText(requireContext(), "Data Saved Successfully", Toast.LENGTH_LONG)
                        .show()
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(requireContext(), e.message, Toast.LENGTH_LONG).show()
                }
            }
        }

    }

    private fun retrieveProfileDetailsData() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val querySnapshot = profileDetailsCollectionRef.get().await()
                val stringBuilder = StringBuilder()
                for (document in querySnapshot.documents) {
                    val profileInformation = document.toObject<ProfileDetails>()
                    stringBuilder.append("$profileInformation\n")
                }
                withContext(Dispatchers.Main) {
                    tvShowProfileDetails.text = stringBuilder.toString()
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(requireContext(), e.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun subscribeToRealTimeUpdates() {
        profileDetailsCollectionRef.addSnapshotListener { querySnapShot, firebaseFirestoreException ->
            firebaseFirestoreException?.let {
                Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                return@addSnapshotListener
            }
            querySnapShot?.let {
                val stringBuilder = StringBuilder()
                for (document in it) {
                    val profileDetails = document.toObject<ProfileDetails>()
                    stringBuilder.append("$profileDetails\n")
                }
                tvShowProfileDetails.text = stringBuilder.toString()

            }
        }
    }

    private fun deleteProfileDetails(profileDetails: ProfileDetails) {
        CoroutineScope(Dispatchers.IO).launch {
            val profileDetailsQuery = profileDetailsCollectionRef
                .whereEqualTo("firstName", profileDetails.firstName)
                .whereEqualTo("lastName", profileDetails.lastName)
                .whereEqualTo("age", profileDetails.age)
                .get()
                .await()

            if (profileDetailsQuery.documents.isNotEmpty()) {
                for (document in profileDetailsQuery)
                    try {
                        profileDetailsCollectionRef.document(document.id).delete().await()
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                requireContext(),
                                "Data Deleted Successfully",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } catch (e: Exception) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(requireContext(), e.message, Toast.LENGTH_LONG).show()
                        }
                    }
            } else {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        requireContext(),
                        "No Profile Details Matched in Query",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

    }

    private fun updateProfileDetails(oldProfileDetails: ProfileDetails,newProfileDetails:Map<String,Any>){

        CoroutineScope(Dispatchers.IO).launch {
            val profileDetailsQuery = profileDetailsCollectionRef
                .whereEqualTo("firstName", oldProfileDetails.firstName)
                .whereEqualTo("lastName", oldProfileDetails.lastName)
                .whereEqualTo("age", oldProfileDetails.age)
                .get()
                .await()
            if (profileDetailsQuery.documents.isNotEmpty()) {
                for (document in profileDetailsQuery)
                    try {
                        profileDetailsCollectionRef.document(document.id).set(newProfileDetails,
                            SetOptions.merge()).await()
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                requireContext(),
                                "Data Updated Successfully",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } catch (e: Exception) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(requireContext(), e.message, Toast.LENGTH_LONG).show()
                        }
                    }
            } else {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        requireContext(),
                        "No Profile Details Matched in Query",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}