package junit;

import org.junit.jupiter.api.Test;

import controller.BateauController;

class BateauControllerTest {
	
	BateauController controller = new BateauController();

	@Test
	void testAfficherCentresNautiques() {
		controller.afficherCentresNautiques();
	}

	@Test
	void testCreerCentresNautiques() {
		controller.creerCentresNautiques();
	}

}
