package com.example.matchessimulatorapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.matchessimulatorapp.data.entities.MatchEntity
import com.example.matchessimulatorapp.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadMatchFromExtra()
    }

    private fun loadMatchFromExtra() {
        intent.getParcelableExtra<MatchEntity>("EXTRA_MATCH")?.let {
            with(binding) {
                Glide.with(this@DetailsActivity).load(it.place.image).into(ivPlace)
                tvTitle.text = it.description
                tvPlaceName.text = it.place.name

                Glide.with(this@DetailsActivity)
                    .load(it.principalTeam.image)
                    .into(ivPrincipalTeamFlag)
                tvPrincipalTeamName.text = it.principalTeam.name

                Glide.with(this@DetailsActivity)
                    .load(it.visitorTeam.image)
                    .into(ivVisitorTeamFlag)
                tvVisitorTeamName.text = it.visitorTeam.name
            }
        }
    }
}