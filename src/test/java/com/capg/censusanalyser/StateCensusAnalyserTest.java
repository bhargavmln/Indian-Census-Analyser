package com.capg.censusanalyser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StateCensusAnalyserTest {

	private static final String STATE_CENSUS_CSV_FILE_PATH = "./src/test/resources/StateCensusData.csv";
	private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/StateCensusData.csv";
	
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

	@Test
	public void givenWrongFile_ShouldThrow_CustomException() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			stateCensusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
		} catch (CensusAnalyserException e) {
			assertEquals(CensusAnalyserException.ExceptionType.FILE_NOT_FOUND, e.type);
		}
	}
}