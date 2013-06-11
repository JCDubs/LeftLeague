package com.uk.leftyleague.domain

import org.springframework.dao.DataIntegrityViolationException

class DateMultiplierController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def newDateMultiplier() {
        def dateMultiplierInstance = new DateMultiplier(params.newNumOfDays.toInteger(),params.newMultiplier.toDouble())
        if (!dateMultiplierInstance.save(flush: true)) {
			request.error = "A error occurred while attempting to save the new date multiplier."
            render(template:"/admin/dateMultipliersForm", model:[dateMultipliersList:DateMultiplier.list().sort()])
            return
        }

        request.message = "Date muliplier '${dateMultiplierInstance.toString()}' saved."
        render(template:"/admin/dateMultipliersForm", model:[dateMultipliersList:DateMultiplier.list().sort()])
    }

    
    def editDateMultiplier(Long id, Long version) {
        def dateMultiplierInstance = DateMultiplier.get(id)
        if (!dateMultiplierInstance) {
            request.error = "Date Multiplier '${dateMultiplierInstance.toString()}' does not exist."
            render(template:"/admin/dateMultipliersForm", model:[dateMultipliersList:DateMultiplier.list().sort()])
            return
        }

        if (version != null) {
            if (dateMultiplierInstance.version > version) {
                request.error = "Another user is currently editing Date Multiplier '${dateMultiplierInstance.toString()}'."
                render(template:"/admin/dateMultipliersForm", model:[dateMultipliersList:DateMultiplier.list().sort()])
                return
            }
        }

        dateMultiplierInstance.properties = params

        if (!dateMultiplierInstance.save(flush: true)) {
			request.error = "A problem occurred while attempting to update Date Multiplier '${dateMultiplierInstance.toString()}'."
            render(template:"/admin/dateMultipliersForm", model:[dateMultipliersList:DateMultiplier.list().sort()])
            return
        }

        request.message = "Date Multiplier '${dateMultiplierInstance.toString()}' updated."
        render(template:"/admin/dateMultipliersForm", model:[dateMultipliersList:DateMultiplier.list().sort()])
    }

    def deleteDateMultiplier() {
        def dateMultiplierInstance = DateMultiplier.get(params.id)
        if (!dateMultiplierInstance) {
            request.error = "Date Multiplier of id '${params.id}' does not exist."
            render(template:"/admin/dateMultipliersForm", model:[dateMultipliersList:DateMultiplier.list().sort()])
            return
        }

        try {
            dateMultiplierInstance.delete(flush: true)
            request.message = "Date Multiplier '${dateMultiplierInstance.toString()}' deleted."
            render(template:"/admin/dateMultipliersForm", model:[dateMultipliersList:DateMultiplier.list().sort()])
        }
        catch (DataIntegrityViolationException e) {
            request.error = "A problem occurred while attempting to delete Date Multiplier ${dateMultiplierInstance.toString()}"
            render(template:"/admin/dateMultipliersForm", model:[dateMultipliersList:DateMultiplier.list().sort()])
        }
    }
}
