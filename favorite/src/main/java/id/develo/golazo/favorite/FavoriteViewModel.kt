package id.develo.golazo.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import id.develo.golazo.core.domain.usecase.TeamUseCase

class FavoriteViewModel(teamUseCase: TeamUseCase): ViewModel() {
    val favoriteTeams = teamUseCase.getFavoriteTeams().asLiveData()
}