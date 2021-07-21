package id.develo.golazo.di

import id.develo.golazo.core.domain.usecase.TeamInteractor
import id.develo.golazo.core.domain.usecase.TeamUseCase
import id.develo.golazo.detail.DetailTeamViewModel
import id.develo.golazo.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<TeamUseCase> { TeamInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailTeamViewModel(get()) }
}
