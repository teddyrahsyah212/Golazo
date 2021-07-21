package id.develo.golazo.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import id.develo.golazo.core.domain.usecase.TeamUseCase

class HomeViewModel(teamUseCase: TeamUseCase) : ViewModel() {
    val teams = teamUseCase.getAllTeams().asLiveData()
}