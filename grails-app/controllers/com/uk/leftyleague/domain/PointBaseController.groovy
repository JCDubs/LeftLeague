package com.uk.leftyleague.domain

import org.springframework.dao.DataIntegrityViolationException

import com.uk.leftleague.utils.AppConstants;

class PointBaseController {

    def editPointBase(Long version) {
        def pointBaseInstance = PointBase.get(AppConstants.POINT_BASE_ID)
        if (!pointBaseInstance) {
			pointBaseInstance = new PointBase(AppConstants.POINT_BASE_ID, 1)			
        }
		else{
			
			if (pointBaseInstance.version > version) {
				request.error = "Another user is updating Base Point with id '${AppConstants.POINT_BASE_ID}'."
				render(template:"/admin/pointsBaseForm", model:[pointsBase:PointBase.get(AppConstants.POINT_BASE_ID)])
				return
			}
		}        

		def results = params
		
        pointBaseInstance.properties = params

        if (!pointBaseInstance.save(flush: true)) {
            request.error = "A error occurred while attempting to update Base Point with id '${AppConstants.POINT_BASE_ID}'."
            render(template:"/admin/pointsBaseForm", model:[pointsBase:PointBase.get(AppConstants.POINT_BASE_ID)])
            return
        }

        request.message = "Base Point '${pointBaseInstance.toString()}' updated."
        render(template:"/admin/pointsBaseForm", model:[pointsBase:pointBaseInstance])
    }    
}
