package thermostat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//Predicate Coverage
class ThermostatTest_PC {
	
	Thermostat therm = new Thermostat();
	ProgrammedSettings settings = new ProgrammedSettings();

	
	@BeforeEach
	public void objectInstance() {
		settings = new ProgrammedSettings();
		therm = new Thermostat(); 
		settings.setSetting(Period.MORNING, DayType.WEEKDAY, 60); 
		therm.setPeriod(Period.MORNING); 
		therm.setDay(DayType.WEEKDAY); 
	}
	
	/*
	Case title has row and truth assignment
	For example: PredicateCoverage_TFTF_TRUE(){}
	_TFTF means that a = true, b = false, c = true, d = false
	_TRUE means assertTrue
	*/
	
	@Test
	public void PredicateCoverage_TTTT_TRUE() {
		therm.setCurrentTemp(40); //clause a
		therm.setThresholdDiff(1); //clause a
		therm.setOverride(true); //clause b
		therm.setOverTemp(60); //clause c
		therm.setMinLag(5); //clause d
		therm.setTimeSinceLastRun(12); //clause d
		assertTrue (therm.turnHeaterOn(settings)); 
	}
	
	@Test
	public void PredicateCoverage_FFFF_FALSE() {
		therm.setCurrentTemp(100); //clause a
		therm.setThresholdDiff(1); //clause a
		therm.setOverride(false); //clause b
		therm.setOverTemp(10); //clause c
		therm.setMinLag(5); //clause d
		therm.setTimeSinceLastRun(4); //clause d
		assertFalse (therm.turnHeaterOn(settings)); 
	}
	
	

}
