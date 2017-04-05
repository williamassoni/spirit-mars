package br.com.assoni.mars;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.function.Consumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.assoni.mars.enums.Orientation;
import br.com.assoni.mars.objects.location.Location;
import br.com.assoni.mars.objects.location.World;

@RunWith(MockitoJUnitRunner.class)
public class LocationUnitTest {
	
	@Mock
	private World world;
	
	@Test
	public void should_return_false_when_invalid_location(){
		Mockito.when(world.isValidLatitude(Mockito.anyObject())).thenReturn(Boolean.FALSE);
		Mockito.when(world.isValidLatitude(Mockito.anyObject())).thenReturn(Boolean.TRUE);
		
		assertThat(new Location(world, 1L, 1L).isValidLocation()).isFalse();
		
		Mockito.when(world.isValidLatitude(Mockito.anyObject())).thenReturn(Boolean.TRUE);
		Mockito.when(world.isValidLatitude(Mockito.anyObject())).thenReturn(Boolean.FALSE);
		
		assertThat(new Location(world, 1L, 1L).isValidLocation()).isFalse();
	}
	
	@Test
	public void should_move_to_north(){
		Consumer<Location> locationRequirements = local -> {
		   assertThat(local.getCurrentLatitude()).isEqualTo(2L);
		   assertThat(local.getCurrentLongitude()).isEqualTo(3L);
		};
		
		assertThat(new Location(world, 2L, 2L).move(Orientation.NORTH)).satisfies(locationRequirements);
	}
	
	@Test
	public void should_move_to_south(){
		Consumer<Location> locationRequirements = local -> {
		   assertThat(local.getCurrentLatitude()).isEqualTo(2L);
		   assertThat(local.getCurrentLongitude()).isEqualTo(1L);
		};
		
		assertThat(new Location(world, 2L, 2L).move(Orientation.SOUTH)).satisfies(locationRequirements);
	}
	
	@Test
	public void should_move_to_east(){
		Consumer<Location> locationRequirements = local -> {
		   assertThat(local.getCurrentLatitude()).isEqualTo(3L);
		   assertThat(local.getCurrentLongitude()).isEqualTo(2L);
		};
		
		assertThat(new Location(world, 2L, 2L).move(Orientation.EAST)).satisfies(locationRequirements);
	}
	
	@Test
	public void should_move_to_west(){
		Consumer<Location> locationRequirements = local -> {
		   assertThat(local.getCurrentLatitude()).isEqualTo(1L);
		   assertThat(local.getCurrentLongitude()).isEqualTo(2L);
		};
		
		assertThat(new Location(world, 2L, 2L).move(Orientation.WEST)).satisfies(locationRequirements);
	}
}
