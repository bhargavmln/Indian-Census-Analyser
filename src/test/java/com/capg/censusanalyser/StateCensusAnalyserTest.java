package com.capg.censusanalyser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StateCensusAnalyserTest {

	private static final String STATE_CENSUS_CSV_FILE_PATH = "./src/test/resources/StateCensusData.csv";

	@Test
	public void givenCsvPath_ShouldReturn_NumberOfRecords() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			int numOfRecords = stateCensusAnalyser.loadIndiaCensusData(STATE_CENSUS_CSV_FILE_PATH);
			assertEquals(28, numOfRecords);
			System.out.println(numOfRecords);
		} catch (CensusAnalyserException e) {
			e.getMessage();
		}
	}
}