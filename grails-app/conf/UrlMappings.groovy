class UrlMappings {

	static mappings = {
        "/grades"(controller: "grades", action: "index")
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/"(controller: 'grades', action: 'index')
        "500"(view:'/error')
        "404"(view:'/error')
	}
}
