import com.uk.leftleague.utils.AppConstants;
import com.uk.leftyleague.domain.LastRankUpdate;

class BootStrap {

    def init = { servletContext ->
		
		LastRankUpdate lastUpdate = LastRankUpdate.get(AppConstants.LAST_RANK_UPDATE_ID)
		
		if(!lastUpdate){
			
			Calendar lastWeek = Calendar.getInstance()
			lastWeek.add(Calendar.DAY_OF_WEEK, -7)
			
			lastUpdate = new LastRankUpdate(AppConstants.LAST_RANK_UPDATE_ID, lastWeek.getTime())
			lastUpdate.save(flush:true)
		}
    }
    def destroy = {
    }
}
