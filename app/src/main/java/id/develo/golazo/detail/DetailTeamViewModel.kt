package id.develo.golazo.detail

import androidx.lifecycle.ViewModel
import id.develo.golazo.core.domain.model.TeamModel
import id.develo.golazo.core.domain.usecase.TeamUseCase

class DetailTeamViewModel(private val teamUseCase: TeamUseCase) : ViewModel() {
    fun setFavoriteTeam(team: TeamModel, newStatus: Boolean) =
        teamUseCase.setFavoriteTeam(team, newStatus)
}