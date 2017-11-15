import GPAcalculator.*;
import GPAdb.*;


import org.junit.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.*;
import java.io.*;
import java.text.*;

import java.io.IOException;
import java.lang.Exception;

public class TestCases {
	private static Database db = null;
	private static Parser parser = null;


	@BeforeClass
	public static void setUpClass() {
		String filename = "sampledata.txt";
		try {
			parser = new Parser(filename);
		} catch (Exception e) {
			System.err.format("Failed opening file '%s'\n", filename);
			return;
		}

		try {
			db = parser.readTranscriptFile();
		}catch (ParseException pe) {
			System.err.format("Failed at line %d on exception: %s\n",
					pe.getErrorOffset(), pe.toString());
			return;
		}
	}

	@AfterClass
	public static void tearDownClass() throws IOException {
		System.out.println("@AfterClass tearDownClass");
	}

	private void println(String string) {
		System.out.println(string);
	}

	@Before
	public void setUp() {
		this.println("@Before setUp");
	}

	@After
	public void tearDown() throws IOException {
		this.println("@After tearDown");
	}

	@Test
	public void test1() {
		this.println("@Test in test1");

		float calcSum = db.getTermGPA(0);
		float expected = 3.0f;

		Assert.assertEquals(expected, calcSum, 0.01f);
	}

	@Test
	public void test2() {
		this.println("@Test in test2");

		float calcSum = db.getTermGPA(-100);
		float expected = java.lang.Float.POSITIVE_INFINITY;

		Assert.assertEquals(expected, calcSum, 0.01f);
	}

}
