class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(controller:"game", action:"leagueRankings")
		"500"(view:'/error')
	}
}
