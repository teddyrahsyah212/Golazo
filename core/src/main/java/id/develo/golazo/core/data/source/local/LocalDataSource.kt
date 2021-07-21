package id.develo.golazo.core.data.source.local

import id.develo.golazo.core.data.source.local.entity.TeamEntity
import id.develo.golazo.core.data.source.local.room.TeamDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val teamDao: TeamDao) {

    fun getAllTeams(): Flow<List<TeamEntity>> = teamDao.getAllTeams()

    fun getFavoriteTeams(): Flow<List<TeamEntity>> = teamDao.getFavoriteTeams()

    suspend fun insertTeams(teams: List<TeamEntity>) = teamDao.insertTeams(teams)

    fun updateTeam(team: TeamEntity, newState: Boolean) {
        team.isFavorite = newState
        teamDao.updateFavoriteTeam(team)
    }
}