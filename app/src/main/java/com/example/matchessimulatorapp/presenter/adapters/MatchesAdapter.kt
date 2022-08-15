package com.example.matchessimulatorapp.presenter.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.matchessimulatorapp.DetailsActivity
import com.example.matchessimulatorapp.data.entities.MatchEntity
import com.example.matchessimulatorapp.databinding.MatchItemBinding

class MatchesAdapter(
    private val matches: List<MatchEntity>?
) : RecyclerView.Adapter<MatchesAdapter.MatchesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchesViewHolder {
        val binding = MatchItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MatchesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MatchesViewHolder, position: Int) {
        val context = holder.itemView.context
        val match = matches?.get(position)
        holder.bind(match)
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java).also {
                it.putExtra("EXTRA_MATCH", match)
                context.startActivity(it)
            }
        }
    }

    override fun getItemCount(): Int {
        return matches?.size ?: 0
    }

    class MatchesViewHolder(
        private val binding: MatchItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MatchEntity?) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(item?.principalTeam?.image)
                    .into(ivPrincipalTeamFlag)
                tvPrincipalTeamName.text = item?.principalTeam?.name
                Glide.with(itemView.context)
                    .load(item?.visitorTeam?.image)
                    .into(ivVisitorTeamFlag)
                tvVisitorTeamName.text = item?.visitorTeam?.name
            }
        }
    }
}