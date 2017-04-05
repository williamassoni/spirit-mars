package br.com.assoni.mars.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.assoni.mars.objects.Instruction;
import br.com.assoni.mars.objects.Robot;
import br.com.assoni.mars.objects.location.Location;
import br.com.assoni.mars.objects.location.World;

@Service
public class NavigationService {

	public String navegate(String command){
		Location location = new Location(new World(), 0L, 0L);
		Robot robot = new Robot(location);
		
		Optional<Robot> newRobot = new Instruction(command).execute(robot);
		
		return newRobot.get().getPosition();
	}
}