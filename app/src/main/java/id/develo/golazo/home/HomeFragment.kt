package id.develo.golazo.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import id.develo.golazo.core.ui.TeamAdapter
import id.develo.golazo.databinding.FragmentHomeBinding
import id.develo.golazo.detail.DetailTeamActivity
import org.koin.android.ext.android.inject

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by inject()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val teamAdapter = TeamAdapter()
            teamAdapter.onItemClick = { selectedData ->
                Intent(activity, DetailTeamActivity::class.java).also {
                    it.putExtra(DetailTeamActivity.EXTRA_DATA, selectedData)
                    startActivity(it)
                }
            }
            homeViewModel.teams.observe(viewLifecycleOwner, { team ->
                if (team != null) {
                    when (team) {
                        is id.develo.golazo.core.data.source.Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is id.develo.golazo.core.data.source.Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            teamAdapter.setData(team.data)
                        }
                        is id.develo.golazo.core.data.source.Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            Log.e("GAGAL", "ERROR API")
                        }
                    }
                }
            })

            with(binding.rvTeams) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = teamAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}