package com.apps.fullcourseandroidclassb.breakingbadapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.apps.fullcourseandroidclassb.R
import com.apps.fullcourseandroidclassb.breakingbadapp.ui.utils.CharacterListAdapter

@Suppress("DEPRECATION")
class CharacterListFragment : Fragment(){

    private val characterListViewModel:CharacterListViewModel by viewModels {
        CharacterListViewModelFactory((requireActivity().application as BreakingBadApplication).characterRepository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_character_list,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val rvCharacterList = requireActivity().findViewById<RecyclerView>(R.id.rvCharacterList)
        val adapter = CharacterListAdapter{bbCharacter ->
            //TODO
            if (bbCharacter.img !=null){
                findNavController().navigate(CharacterListFragmentDirections.showCharacterImageFragment(bbCharacter.img))
            }
        }
        rvCharacterList.adapter = adapter
        characterListViewModel.characters.observe(viewLifecycleOwner,{
            bbCharacter ->
            adapter.submitList(bbCharacter)
        })
        val refeshLayout = requireActivity().findViewById<SwipeRefreshLayout>(R.id.refreshLayout)
        refeshLayout.setOnRefreshListener {
            characterListViewModel.refreshDataFromRepository()
            Toast.makeText(requireContext(),"Data Refreshed",Toast.LENGTH_LONG).show()
            refeshLayout.isRefreshing = false
        }

    }
}