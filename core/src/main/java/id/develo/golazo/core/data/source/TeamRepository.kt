package id.develo.golazo.core.data.source

import id.develo.golazo.core.data.source.local.LocalDataSource
import id.develo.golazo.core.data.source.remote.RemoteDataSource
import id.develo.golazo.core.data.source.remote.network.ApiResponse
import id.develo.golazo.core.data.source.remote.response.TeamItemResponse
import id.develo.golazo.core.domain.model.TeamModel
import id.develo.golazo.core.domain.repository.ITeamRepository
import id.develo.golazo.core.utils.AppExecutors
import id.develo.golazo.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TeamRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ITeamRepository {
    override fun getAllTeams(): Flow<Resource<List<TeamModel>>> =
        object :
            id.develo.golazo.core.data.source.NetworkBoundResource<List<TeamModel>, List<TeamItemResponse>>() {
            override fun loadFromDB(): Flow<List<TeamModel>> =
                localDataSource.getAllTeams().map { DataMapper.mapEntitiesToDomain(it) }

            override fun shouldFetch(data: List<TeamModel>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<TeamItemResponse>>> =
                remoteDataSource.getAllTeams()

            override suspend fun saveCallResult(data: List<TeamItemResponse>) {
                val teamList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertTeams(teamList)
            }
        }.asFlow()

    override fun getFavoriteTeams(): Flow<List<TeamModel>> =
        localDataSource.getFavoriteTeams().map { DataMapper.mapEntitiesToDomain(it) }

    override fun setFavoriteTeam(team: TeamModel, state: Boolean) {
        val teamEntity = DataMapper.mapDomainToEntity(team)
        appExecutors.diskIO().execute { localDataSource.updateTeam(teamEntity, state) }
    }
}