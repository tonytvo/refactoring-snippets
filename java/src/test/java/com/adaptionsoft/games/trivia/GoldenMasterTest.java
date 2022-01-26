package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.trivia.runner.GameRunner;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

public class GoldenMasterTest {

	private ByteArrayOutputStream getConsoleOutput() {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(byteArrayOutputStream);
		System.setOut(printStream);
		return byteArrayOutputStream;
	}

	@Test
	public void testGoldenMasterFrom1To500() {
		ByteArrayOutputStream console = getConsoleOutput();
		for(int seed=1; seed < 500; seed++)
			GameRunner.playGameWith(new Random(seed));
		Approvals.verify(console.toString());
	}}
