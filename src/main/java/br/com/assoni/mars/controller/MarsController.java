package br.com.assoni.mars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.assoni.mars.services.NavigationService;

@RestController
@RequestMapping("/rest/mars")
public class MarsController {

	@Autowired
	private NavigationService navigationService;
	
	@RequestMapping(value="/{command}",produces=MediaType.TEXT_PLAIN_VALUE,method = RequestMethod.POST)
	public String navegate(@PathVariable String command){
		return navigationService.navegate(command);
	}
}
