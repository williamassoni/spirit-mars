package br.com.assoni.mars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.assoni.mars.enums.MarsExceptionType;
import br.com.assoni.mars.services.NavigationService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NavigationServiceIntegrationTest {

	@Autowired
	public NavigationService navigationService;
	
	@Test
	public void should_return_expected_positions(){
		assertThat(this.navigationService.navegate("MMRMMRMM")).isEqualTo("(2, 0, S)");
		assertThat(this.navigationService.navegate("MML")).isEqualTo("(0, 2, W)");
		assertThat(this.navigationService.navegate("MMMMRMMRMMlMlMMlMMM")).isEqualTo("(0, 4, W)");
		assertThat(this.navigationService.navegate("MMMMRMMMMRMMMMRMMMRMMMRMMRMRM")).isEqualTo("(2, 2, W)");
		assertThat(this.navigationService.navegate("RR")).isEqualTo("(0, 0, S)");
		assertThat(this.navigationService.navegate("RRR")).isEqualTo("(0, 0, W)");
	}
	
	@Test
	public void should_throw_exception_when_command_is_invalid(){
		assertThatThrownBy(() -> {this.navigationService.navegate("AAA");}).extracting("type").contains(MarsExceptionType.INVALID_COMMAND);
	}
	
	@Test
	public void should_trow_exception_when_invalid_position(){
		assertThatThrownBy(() -> {this.navigationService.navegate("MMMMMMMMMMMMMMMMMMMMMMMM");}).extracting("type").contains(MarsExceptionType.INVALID_LOCATION);
	}
}
