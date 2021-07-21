package id.develo.golazo.core.utils

import id.develo.golazo.core.data.source.remote.response.TeamItemResponse
import id.develo.golazo.core.domain.model.TeamModel

object DataMapper {
    fun mapResponsesToEntities(input: List<TeamItemResponse>): List<id.develo.golazo.core.data.source.local.entity.TeamEntity> {
        val teamsList = ArrayList<id.develo.golazo.core.data.source.local.entity.TeamEntity>()
        input.map {
            val team = id.develo.golazo.core.data.source.local.entity.TeamEntity(
                idTeam = it.idTeam,
                strLeague = it.strLeague,
                strTeam = it.strTeam,
                strTeamShort = it.strTeamShort,
                strDescription = it.strDescription,
                strTeamBadge = it.strTeamBadge,
                strTeamJersey = it.strTeamJersey,
                strKeywords = it.strKeywords,
                strInstagram = it.strInstagram,
                strTwitter = it.strTwitter,
                strWebsite = it.strWebsite,
                strYoutube = it.strYoutube,
                strFacebook = it.strFacebook,
                isFavorite = false
            )
            teamsList.add(team)
        }
        return teamsList
    }

    fun mapEntitiesToDomain(input: List<id.develo.golazo.core.data.source.local.entity.TeamEntity>): List<TeamModel> =
        input.map {
            TeamModel(
                idTeam = it.idTeam,
                strLeague = it.strLeague,
                strTeam = it.strTeam,
                strTeamShort = it.strTeamShort,
                strDescription = it.strDescription,
                strTeamBadge = it.strTeamBadge,
                strTeamJersey = it.strTeamJersey,
                strKeywords = it.strKeywords,
                strInstagram = it.strInstagram,
                strTwitter = it.strTwitter,
                strWebsite = it.strWebsite,
                strYoutube = it.strYoutube,
                strFacebook = it.strFacebook,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: TeamModel) =
        id.develo.golazo.core.data.source.local.entity.TeamEntity(
            idTeam = input.idTeam,
            strLeague = input.strLeague,
            strTeam = input.strTeam,
            strTeamShort = input.strTeamShort,
            strDescription = input.strDescription,
            strTeamBadge = input.strTeamBadge,
            strTeamJersey = input.strTeamJersey,
            strKeywords = input.strKeywords,
            strInstagram = input.strInstagram,
            strTwitter = input.strTwitter,
            strWebsite = input.strWebsite,
            strYoutube = input.strYoutube,
            strFacebook = input.strFacebook,
            isFavorite = input.isFavorite
        )
}