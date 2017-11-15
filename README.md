
Sample GPA database project
===========================

This project has a single top-level java file, `TranscriptReader.java`, and
three Java packages that it depends upon:

* `GPAcalculator`
* `GPAdb`
* `TextTokenizer`

Compilation can be acheived by simply compiling the top-level file:

	javac TranscriptReader.java

Sample data files are provided:

* `brokendata.txt`
* `brokenheader.txt`
* `fullmarks.txt`
* `sampledata.txt`

Those with "broken" in their names contain parse errors which are discovered
by the system.  The `fullmarks.txt` and `samplemarks.txt` are correctly formatted
files.

The format for the database is as follows (described in Backus-Naur form):

		;;; a file must have a header and data
	<database> ::= <header> <data> ;

		;;; header consists of two fields
	<header> ::= <student-name-string> <student-id-integer> ;

	<student-name-string> ::= <string> ;
	<student-id-integer> ::= <integer> ;


		;;; note the empty declaration before the '|' character;
		;;; that is, the data portion can be empty
	<data> ::= 	 | <data> <term-description> ;

		;;; the string "term" in quotes indicates that it is a
		;;; literal value
	<term-description> ::=  "term" <term-name-string> <course-list> ;

	<term-name-string> ::= <string> ;


		;;; the lack of an empty decalration here indicates that
		;;; at least one <course-information> data element must
		;;; exist in a valid <course-list>
	<course-list> ::=  <course-information> | <course-list> <course-information> ;


	<course-information> ::=  "course" <course-name-string> <course-grade> ;

	<course-grade> ::=  <course-lettergrade> | <course-percentagegrade> ;


	<course-name-string> ::=  <string> ;
	<course-lettergrade> ::= "A+" | "A" | "A-" | "B+" | "B" | "B-" |
				"C+" | "C" | "C-" | "D+" | "D" | "D-" | "F" ;
	<course-percentagegrade> ::=  <integer> ;

	<string> ::= <letter-sequence> | '"' <letter-sequence> '"';
	<letter-sequence> ::= <letter> | <letter-sequence> <letter>;
	<letter> ::=
			'a' | 'b' | 'c' | 'd' | 'e' | 'f' | 'g' | 'h' | 'i' | 'j' |
			'k' | 'l' | 'm' | 'n' | 'o' | 'p' | 'q' | 'r' | 's' | 't' |
			'u' | 'v' | 'w' | 'x' | 'y' | 'z' |
			'A' | 'B' | 'C' | 'D' | 'E' | 'F' | 'G' | 'H' | 'I' | 'J' |
			'K' | 'L' | 'M' | 'N' | 'O' | 'P' | 'Q' | 'R' | 'S' | 'T' |
			'U' | 'V' | 'W' | 'X' | 'Y' | 'Z' |
			'0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9' |
			'_' | '-' | "'" ;

	<integer> ::= <digit> | <integer> <digit>;
	<digit> ::= '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9'

