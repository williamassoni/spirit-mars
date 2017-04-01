package br.com.assoni.mars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.assoni.mars.services.NavigationService;

@Controller
@EnableAutoConfiguration
public class MarsController {

	@Autowired
	private NavigationService navigationService;
	
	@RequestMapping(value="/mars/{command}",produces=MediaType.TEXT_PLAIN_VALUE,method = RequestMethod.POST)
	public String navegate(String command){
		return navigationService.navegate(command);
	}
}
