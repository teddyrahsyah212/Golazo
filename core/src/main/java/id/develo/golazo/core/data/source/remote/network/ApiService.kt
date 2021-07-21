package id.develo.golazo.core.data.source.remote.network

import id.develo.golazo.core.data.source.remote.response.ListTeamResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search_all_teams.php")
    suspend fun getListTeams(@Query("l") league: String): ListTeamResponse
}