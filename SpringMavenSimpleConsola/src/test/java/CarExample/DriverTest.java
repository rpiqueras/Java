package CarExample;

import static org.mockito.Mockito.*;
import org.junit.Test;

public class DriverTest {

	@Test
	public void driveCallsMove(){
		Vehicle falseVehicle = mock(Vehicle.class);
		Driver driver = new Driver(falseVehicle);
		driver.drive();
		verify(falseVehicle,times(1)).move();
	}
}
