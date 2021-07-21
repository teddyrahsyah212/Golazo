package id.develo.golazo.core.data.source.local.room

import androidx.room.*
import id.develo.golazo.core.data.source.local.entity.TeamEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TeamDao {

    @Query("SELECT * FROM teams")
    fun getAllTeams(): Flow<List<TeamEntity>>

    @Query("SELECT * FROM teams WHERE isFavorite = 1")
    fun getFavoriteTeams(): Flow<List<TeamEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeams(teams: List<TeamEntity>)

    @Update
    fun updateFavoriteTeam(team: TeamEntity)
}