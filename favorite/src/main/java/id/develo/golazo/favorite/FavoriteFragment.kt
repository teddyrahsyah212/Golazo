package id.develo.golazo.favorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import id.develo.golazo.core.ui.TeamAdapter
import id.develo.golazo.detail.DetailTeamActivity
import id.develo.golazo.favorite.databinding.FragmentFavoriteBinding
import org.koin.android.ext.android.inject
import org.koin.core.context.loadKoinModules

class FavoriteFragment : Fragment() {

    private val favoriteViewModel: FavoriteViewModel by inject()

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadKoinModules(favoriteModule)

        getTeamData()
    }

    private fun getTeamData() {
        if (activity != null) {
            val teamAdapter = TeamAdapter()
            teamAdapter.onItemClick = { selectedData ->
                Intent(activity, DetailTeamActivity::class.java).also {
                    it.putExtra(DetailTeamActivity.EXTRA_DATA, selectedData)
                    startActivity(it)
                }
            }
            favoriteViewModel.favoriteTeams.observe(viewLifecycleOwner, { dataTeam ->
                teamAdapter.setData(dataTeam)
                binding.viewEmpty.root.visibility =
                    if (dataTeam.isNotEmpty()) View.GONE else View.VISIBLE
            })

            with(binding.rvTeams) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = teamAdapter
            }
        }
    }
}