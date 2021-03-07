package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import db.BateauJsonMongoDB;

class BateauJsonMongoDBTest {

	BateauJsonMongoDB test = new BateauJsonMongoDB();
	
	@Test
	void testCreerListeBateaux1() {
		test.CreerListeBateaux1();
	}

	@Test
	void testCreerListeBateaux2() {
		test.CreerListeBateaux2();	}

	@Test
	void testCreerListeBateaux3() {
		test.CreerListeBateaux3();	}

}
