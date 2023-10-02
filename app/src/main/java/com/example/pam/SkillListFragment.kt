package com.example.pam


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pam.databinding.FragmentSkillListBinding

import com.example.pam.model.SkillModel
import java.util.Locale


class SkillListFragment : Fragment() {

    private var _binding : FragmentSkillListBinding? = null
    lateinit var rvSkill : RecyclerView


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSkillListBinding.inflate(inflater,container, false)

        val root: View = binding.root
        val recyclerView = binding.rvSkill
        val searchView = binding.searchskill
        val lm = LinearLayoutManager(activity)
        lm.orientation = LinearLayoutManager.VERTICAL

        val adapterSkill = SkillAdapter(ArraySkill,activity){
            navigateToDetail(it)
        }
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = lm
        recyclerView.adapter = adapterSkill

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
               return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if(newText != null){
                    val filteredList = ArrayList<SkillModel>()
                    for (i in ArraySkill){
                        if(i.namaSkill!!.lowercase(Locale.ROOT).contains(newText)){
                            filteredList.add(i)
                        }
                    }
                    if(filteredList.isEmpty()){
                        Toast.makeText(requireContext(), "No Data Found", Toast.LENGTH_SHORT).show()
                    }else{
                        adapterSkill.setfilteredList(filteredList)
                    }
                }

                return true
            }

        })


        return root
    }



    val ArraySkill : ArrayList<SkillModel>get(){

        val arrayskill = ArrayList<SkillModel>()

        val skill1 = SkillModel()
        skill1.namaSkill = "Kotlin"

        val skill2 = SkillModel()
        skill2.namaSkill = "React"

        val skill3 = SkillModel()
        skill3.namaSkill = "React Native"

        val skill4 = SkillModel()
        skill4.namaSkill = "Python"

        val skill5 = SkillModel()
        skill5.namaSkill = "HTML"

        val skill6 = SkillModel()
        skill6.namaSkill = "CSS"

        val skill7 = SkillModel()
        skill7.namaSkill = "JavaScript"

        val skill8 = SkillModel()
        skill8.namaSkill = "Kotlin"

        val skill9 = SkillModel()
        skill9.namaSkill = "Java"

        val skill10 = SkillModel()
        skill10.namaSkill = "PHP"

        arrayskill.add(skill1)
        arrayskill.add(skill2)
        arrayskill.add(skill3)
        arrayskill.add(skill4)
        arrayskill.add(skill5)
        arrayskill.add(skill6)
        arrayskill.add(skill7)
        arrayskill.add(skill8)
        arrayskill.add(skill9)
        arrayskill.add(skill10)

        return arrayskill
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun navigateToDetail(extraName : String){
        val bundle = Bundle()

        bundle.putString("extra_name", extraName)
        findNavController().navigate(R.id.action_nak_skill_to_skill_detail, bundle)
    }



}