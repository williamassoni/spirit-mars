package br.com.assoni.mars.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.assoni.mars.objects.Instruction;
import br.com.assoni.mars.objects.Robot;
import br.com.assoni.mars.objects.World;

@Service
public class NavigationService {

	public String navegate(String command){
		Robot robot = new Robot(new World());
		
		Optional<Robot> newRobot = new Instruction(command).execute(robot);
		
		return newRobot.get().getPosition();
	}
}