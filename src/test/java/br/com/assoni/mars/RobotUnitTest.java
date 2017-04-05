package br.com.assoni.mars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.function.Consumer;

import org.junit.Test;
import org.mockito.Mockito;

import br.com.assoni.mars.enums.Direction;
import br.com.assoni.mars.enums.MarsExceptionType;
import br.com.assoni.mars.enums.Orientation;
import br.com.assoni.mars.objects.Robot;
import br.com.assoni.mars.objects.location.Location;
import br.com.assoni.mars.objects.location.World;

public class RobotUnitTest {

	@Test
	public void should_begin_in_default_location(){
		Consumer<Robot> robotRequirements = robot -> {
		   assertThat(robot.getLocation().getCurrentLatitude()).isEqualTo(0L);
		   assertThat(robot.getLocation().getCurrentLongitude()).isEqualTo(0L);
		   assertThat(robot.getPosition()).contains(Orientation.NORTH.getKey());
		};
			
		Location location = new Location(new World(), 0L, 0L);
		assertThat(new Robot(location)).satisfies(robotRequirements);
	}
	
	@Test
	public void should_turn_on_direction(){
		Location location = new Location(new World(), 0L, 0L);
		assertThat(new Robot(location).turn(Direction.LEFT).getPosition()).contains(Orientation.WEST.getKey());
		assertThat(new Robot(location).turn(Direction.RIGHT).getPosition()).contains(Orientation.EAST.getKey());
	}
	
	@Test
	public void should_walk(){
		Consumer<Robot> robotRequirements = robot -> {
		   assertThat(robot.getLocation().getCurrentLatitude()).isEqualTo(0L);
		   assertThat(robot.getLocation().getCurrentLongitude()).isEqualTo(1L);
		   assertThat(robot.getPosition()).contains(Orientation.NORTH.getKey());
		};
			
		Robot robot = new Robot(new Location(new World(), 0L, 0L)).walk(); 
		assertThat(robot).satisfies(robotRequirements);
	}
	
	@Test
	public void should_throw_exception_when_try_walk_out_of_knew_location(){
		World wold = Mockito.mock(World.class);
		Mockito.when(wold.isValidLatitude(Mockito.anyObject())).thenReturn(Boolean.FALSE);
		
		Robot robot = new Robot(new Location(wold, 0L, 0L)); 
		
		assertThatThrownBy(()-> {robot.walk();}).extracting("type").contains(MarsExceptionType.INVALID_LOCATION);
	}
}
