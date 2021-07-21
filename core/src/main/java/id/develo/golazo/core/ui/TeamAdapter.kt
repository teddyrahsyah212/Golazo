package id.develo.golazo.core.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.develo.golazo.core.R
import id.develo.golazo.core.databinding.ItemListTeamBinding
import id.develo.golazo.core.domain.model.TeamModel

class TeamAdapter : RecyclerView.Adapter<TeamAdapter.ListViewHolder>() {

    private var listData = ArrayList<TeamModel>()
    var onItemClick: ((TeamModel) -> Unit)? = null

    fun setData(newListData: List<TeamModel>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListTeamBinding.bind(itemView)

        @SuppressLint("SetTextI18n")
        fun bind(data: TeamModel) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.strTeamBadge)
                    .into(ivItemBadge)
                Glide.with(itemView.context)
                    .load(data.strTeamJersey)
                    .into(ivItemJersey)
                tvItemTeam.text = data.strTeam
                tvItemTeamShort.text = data.strTeamShort
                tvItemKeywords.text = data.strKeywords
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder =
        ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_team, parent, false)
        )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listData.size
}