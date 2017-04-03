package br.com.assoni.mars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.junit.Test;
import org.mockito.Mockito;

import br.com.assoni.mars.enums.MarsExceptionType;
import br.com.assoni.mars.enums.Orientation;
import br.com.assoni.mars.objects.Instruction;
import br.com.assoni.mars.objects.Robot;
import br.com.assoni.mars.objects.World;

public class InstructionUnitTest {

	@Test
	public void should_throw_exception_when_empty_comand(){
		assertThatThrownBy(()-> {new Instruction("");}).extracting("type").contains(MarsExceptionType.EMPTY_COMMAND);
	}
	
	@Test
	public void should_split_command_in_order(){
		List<String> commands = new Instruction("MMRMMRMM").getComands();
		
		assertThat(commands).containsExactly("M","M","R","M","M","R","M","M");
	}
	
	@Test
	public void should_throw_exception_when_unknow_command(){
		assertThatThrownBy(() -> {new Instruction("T").execute(Mockito.mock(Robot.class));}).extracting("type").contains(MarsExceptionType.INVALID_COMMAND);
	}
	
	@Test
	public void should_change_direction_for_right(){
		Consumer<Optional<Robot>> robotRequirements = robot -> {
			assertThat(robot.isPresent()).isTrue();
			assertThat(robot.get().getPosition()).contains(Orientation.EAST.getKey());
		};
			
		Optional<Robot> robot = new Instruction("R").execute(new Robot(new World()));
		
		
		assertThat(robot).satisfies(robotRequirements);
	}

	@Test
	public void should_change_direction_for_left(){
		Consumer<Optional<Robot>> robotRequirements = robot -> {
			assertThat(robot.isPresent()).isTrue();
			assertThat(robot.get().getPosition()).contains(Orientation.WEST.getKey());
		};
			
		Optional<Robot> robot = new Instruction("L").execute(new Robot(new World()));
		
		assertThat(robot).satisfies(robotRequirements);
	}
	
	
}
