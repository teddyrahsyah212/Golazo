package id.develo.golazo.core.domain.repository

import id.develo.golazo.core.data.source.Resource
import id.develo.golazo.core.domain.model.TeamModel
import kotlinx.coroutines.flow.Flow

interface ITeamRepository {

    fun getAllTeams(): Flow<Resource<List<TeamModel>>>

    fun getFavoriteTeams(): Flow<List<TeamModel>>

    fun setFavoriteTeam(team: TeamModel, state: Boolean)
}