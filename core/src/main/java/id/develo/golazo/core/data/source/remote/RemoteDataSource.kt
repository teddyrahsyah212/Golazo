package id.develo.golazo.core.data.source.remote

import android.util.Log
import id.develo.golazo.core.data.source.remote.network.ApiResponse
import id.develo.golazo.core.data.source.remote.network.ApiService
import id.develo.golazo.core.data.source.remote.response.TeamItemResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {


    suspend fun getAllTeams(): Flow<ApiResponse<List<TeamItemResponse>>> =
        flow {
            try {
                val response = apiService.getListTeams("English Premier League")
                val dataArray = response.teams
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(dataArray))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
}