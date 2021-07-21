package id.develo.golazo.core.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "teams")
data class TeamEntity (

    // Team Detail
    @PrimaryKey(autoGenerate = false)
    @NonNull
    @ColumnInfo(name = "idTeam")
    var idTeam: String,

    @ColumnInfo(name = "strLeague")
    var strLeague: String,

    @ColumnInfo(name = "strTeam")
    var strTeam: String,

    @ColumnInfo(name = "strTeamShort")
    var strTeamShort: String?,

    @ColumnInfo(name = "strDescription")
    var strDescription: String,

    @ColumnInfo(name = "strTeamBadge")
    var strTeamBadge: String,

    @ColumnInfo(name = "strTeamJersey")
    var strTeamJersey: String,

    @ColumnInfo(name = "strKeywords")
    var strKeywords: String,

    // Social Media
    @ColumnInfo(name = "strInstagram")
    var strInstagram: String,

    @ColumnInfo(name = "strTwitter")
    var strTwitter: String,

    @ColumnInfo(name = "strWebsite")
    var strWebsite: String,

    @ColumnInfo(name = "strYoutube")
    var strYoutube: String,

    @ColumnInfo(name = "strFacebook")
    var strFacebook: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
) : Parcelable