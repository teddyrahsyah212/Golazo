package id.develo.golazo.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import id.develo.golazo.R
import id.develo.golazo.core.domain.model.TeamModel
import id.develo.golazo.databinding.ActivityDetailTeamBinding
import org.koin.android.ext.android.inject

class DetailTeamActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val detailTeamViewModel: DetailTeamViewModel by inject()
    private lateinit var binding: ActivityDetailTeamBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val detailTeam = intent.getParcelableExtra<TeamModel>(EXTRA_DATA)
        showTeamDetail(detailTeam)
    }

    private fun showTeamDetail(detailTeam: TeamModel?) {
        detailTeam?.let {
            with(binding) {
                supportActionBar?.title = detailTeam.strTeam

                // Team Detail UI
                Glide.with(this@DetailTeamActivity)
                    .load(detailTeam.strTeamBadge)
                    .into(ivBadge)
                Glide.with(this@DetailTeamActivity)
                    .load(detailTeam.strTeamJersey)
                    .into(ivJersey)

                tvTeam.text = detailTeam.strTeam
                tvTeamShort.text = detailTeam.strTeamShort
                tvKeywords.text = detailTeam.strKeywords
                tvTeamLeague.text = detailTeam.strLeague
                tvTeamDescription.text = detailTeam.strDescription
                if (detailTeam.strTwitter.isNotEmpty()) tvTwitter.text =
                    detailTeam.strTwitter else tvTwitter.visibility = View.GONE

                if (detailTeam.strInstagram.isNotEmpty()) tvInstagram.text =
                    detailTeam.strInstagram else tvInstagram.visibility = View.GONE

                if (detailTeam.strFacebook.isNotEmpty()) tvFacebook.text =
                    detailTeam.strFacebook else tvFacebook.visibility = View.GONE

                if (detailTeam.strWebsite.isNotEmpty()) tvWebsite.text =
                    detailTeam.strWebsite else tvWebsite.visibility = View.GONE

                if (detailTeam.strYoutube.isNotEmpty()) tvYoutube.text =
                    detailTeam.strYoutube else tvYoutube.visibility = View.GONE

                var favoriteState = detailTeam.isFavorite
                setFavoriteStatus(favoriteState)
                btnFavorite.setOnClickListener {
                    favoriteState = !favoriteState
                    detailTeamViewModel.setFavoriteTeam(detailTeam, favoriteState)
                    setFavoriteStatus(favoriteState)
                }
            }
        }
    }

    private fun setFavoriteStatus(favoriteState: Boolean) {
        if (favoriteState) {
            binding.btnFavorite.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_love, 0, 0, 0)
        } else {
            binding.btnFavorite.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_love_outline, 0, 0, 0)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}