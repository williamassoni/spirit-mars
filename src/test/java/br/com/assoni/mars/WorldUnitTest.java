package br.com.assoni.mars;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import br.com.assoni.mars.objects.World;

public class WorldUnitTest {

	@Test
	public void should_verify_valid_latitude(){
		assertThat(new World().isValidLatitude(1L)).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void should_verify_invalid_latitude(){
		assertThat(new World().isValidLatitude(10L)).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void should_verify_valid_longitude(){
		assertThat(new World().isValidLongitude(1L)).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void should_verify_invalid_longitude(){
		assertThat(new World().isValidLongitude(10L)).isEqualTo(Boolean.FALSE);
	}
}
