


							//**								Date-->Time	Java Database							**//



	//**		Command Name	   **//     //**					Formatting						**//   //**				Result			**//
	
	system.out.printf("%tC",new Date())		//complete date&time format									   // Mon Feb 09 18:05:19 PST 2004
	system.out.printf("%tF",new Date())		//Iso 8601 format											   //2004-02-09
	system.out.printf("%tD",new Date())		//US formatted date											   //02/09/2004
	system.out.printf("%tT",new Date())		//24-hour time												   //28:05:19
	system.out.printf("%tr",new Date())		//12-hour time												   //06:05:19 pm
	system.out.printf("%tR",new Date())		//24-hour time-seconds										   //18.05
	system.out.printf("%tY",new Date())		//Four-digit-year(with leading zeros)						   //2014
	system.out.printf("%ty",new Date())		//Last two digits of year(with leading zeros)			       //14
	system.out.printf("%tC",new Date())		//First two digits of year(with leading zeros)				   //20
	system.out.printf("%tB",new Date())		//Full month name											   //January
	system.out.printf("%tb",new Date())		//Abbreviated month name									   //Jan
	system.out.printf("%th",new Date())		//Abbreviate month name										   //Jan
	system.out.printf("%tm",new Date())		//Two digit month(with leading zeros)						   //01
	system.out.printf("%td",new Date())		//Two digit day(with leading zeros)							   //07
	system.out.printf("%te",new Date())		//Two digit day												   //7
	system.out.printf("%tA",new Date())		//Full weekday name											   //Tuesday
	system.out.printf("%ta",new Date())		//Abbreviated weekday name									   //Mon
	system.out.printf("%tj",new Date())		//Three-digit day of year(1-366)							   //069
	system.out.printf("%tH",new Date())		//Two-digit-hour(with leading zero),(00-23)				       //18
	system.out.printf("%tk",new Date())		//Two-digit hour (without leading zeroes), between 0 and 23	   //18
	system.out.printf("%tI",new Date())		//Two-digit hour (with leading zeroes), between 01 and 12	   //06
	system.out.printf("%tl",new Date())		//Two-digit hour (without leading zeroes), between 1 and 12	   //6
	system.out.printf("%tM",new Date())		//Two-digit minutes (with leading zeroes)					   //05
	system.out.printf("%tS",new Date())		//Two-digit seconds (with leading zeroes)					   //19
	system.out.printf("%tL",new Date())		//Three-digit milliseconds(with leading zeroes)				   //047
	system.out.printf("%tN",new Date())		//Nine-digit nanoseconds(with leading zeroes)				   //047000000
	system.out.printf("%tP",new Date())		//Uppercase morning or afternoon marker						   //PM
	system.out.printf("%tp",new Date())		//Lowercase morning or afternoon marker						   //pm
	system.out.printf("%tz",new Date())		//RFC 822 numeric offset from GMT							   //-0800
	system.out.printf("%tZ",new Date())		//Time zone													   //PST
	system.out.printf("%ts",new Date())		//Seconds since 1970-01-01 00:00:00GMT						   //107884319
	system.out.printf("%tQ",new Date())		//Milliseconds since 1970-01-01 00:00:00 GMT				   //1078884319047
	
	
	//**		Author--->DM		**//	//**			Java Open Source Licenced			   	**//   //** Compiled Tuesday 7th January 2014**//