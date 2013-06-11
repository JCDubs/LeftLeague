package com.uk.leftyleague.domain

import org.springframework.dao.DataIntegrityViolationException

class PlayerController {

    //static allowedMethods = [addPlayer: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }   

    def addPlayer() {
        def playerInstance = new Player(params.playerName, params.rank.asType(Integer.class))
        if (!playerInstance.save(flush: true)) {
			request.error = "A error occurred while attempting to save League Player '${playerInstance?.name}'"
            render(template: "/admin/playerForm", model: [leaguePlayerList: Player.list().sort()])
            return
        }

        request.message = "League Player '${playerInstance?.name}' saved."
        render(template: "/admin/playerForm", model:[leaguePlayerList: Player.list().sort()])
    }   

    def deletePlayer(Long id) {
        def playerInstance = Player.get(params.id)
        if (!playerInstance) {
            request.error = "League Player with id '${params?.id}' does not exist."
            render(template: "/admin/playerForm", model: [leaguePlayerList: Player.list().sort()])
            return
        }

        try {
            playerInstance.delete(flush: true)
            request.message = "League Player '${playerInstance?.name}' deleted."
            render(template: "/admin/playerForm", model: [leaguePlayerList: Player.list().sort()])
        }
        catch (DataIntegrityViolationException e) {
            request.error = "A problem occurred while attempting to delete League Player '${playerInstance?.name}'"
            render(template: "/admin/playerForm", model: [leaguePlayerList: Player.list().sort()])
        }
    }
}
