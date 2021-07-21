package id.develo.golazo.core.domain.usecase

import id.develo.golazo.core.data.source.Resource
import id.develo.golazo.core.domain.model.TeamModel
import id.develo.golazo.core.domain.repository.ITeamRepository
import kotlinx.coroutines.flow.Flow

class TeamInteractor(private val teamRepository: ITeamRepository) : TeamUseCase {

    override fun getAllTeams(): Flow<Resource<List<TeamModel>>> = teamRepository.getAllTeams()

    override fun getFavoriteTeams(): Flow<List<TeamModel>> = teamRepository.getFavoriteTeams()

    override fun setFavoriteTeam(team: TeamModel, state: Boolean) =
        teamRepository.setFavoriteTeam(team, state)
}