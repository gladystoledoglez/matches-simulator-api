package com.example.matchessimulatorapp.presenter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.matchessimulatorapp.MainActivity
import com.example.matchessimulatorapp.data.MatchesAPI
import com.example.matchessimulatorapp.data.entities.MatchEntity
import com.example.matchessimulatorapp.databinding.FragmentMatchesBinding
import com.example.matchessimulatorapp.presenter.adapters.MatchesAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MatchesFragment : Fragment() {

    private lateinit var binding: FragmentMatchesBinding
    private lateinit var matchesAPI: MatchesAPI
    private lateinit var matchesAdapter: MatchesAdapter
    private lateinit var mainActivity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentMatchesBinding.inflate(layoutInflater)
        mainActivity = (activity as MainActivity)

        setupHttpClient()
        setupMatchesList()
        setupFloatingActionButton()
        return binding.root
    }

    private fun setupHttpClient() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://gladystoledoglez.github.io/matches-simulator-api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        matchesAPI = retrofit.create(MatchesAPI::class.java)
    }

    private fun setupMatchesList() {
        binding.pbMatches.visibility = View.VISIBLE
        binding.rvMatches.layoutManager = LinearLayoutManager(context)
        matchesAPI.getMatches().enqueue(object : Callback<List<MatchEntity>> {

            override fun onResponse(
                call: Call<List<MatchEntity>>, response: Response<List<MatchEntity>>
            ) {
                if (response.isSuccessful) {
                    val matches: List<MatchEntity> = response.body() ?: emptyList()
                    matchesAdapter = MatchesAdapter(matches)
                    binding.rvMatches.adapter = matchesAdapter
                } else {
                    showErrorMessage()
                }
                binding.pbMatches.visibility = View.GONE
            }

            override fun onFailure(call: Call<List<MatchEntity>>, t: Throwable) {
                showErrorMessage()
                binding.pbMatches.visibility = View.GONE
            }
        })
    }

    private fun setupFloatingActionButton() {
        mainActivity.binding.fabSimulator.setOnClickListener {
        }
    }

    private fun showErrorMessage() {
        Toast.makeText(context?.applicationContext, "API error", Toast.LENGTH_SHORT).show()
        //TODO error message
    }

    companion object {
        fun newInstance() = MatchesFragment()
    }
}