//prints object to page, shorthand for document.writeln
function sprint(object){
	document.writeln(object + "<br>");
}

//grading scale for window prompt input
function scale(grade){
	var letter;
	if(grade >100)
		sprint(grade + " you're a beast");
	else if(grade >= 90){
		letter = "A";
	}else if (grade >= 80) {
		letter = "B";
	}else if (grade >= 70) {
		letter = "C";
	}else if(grade >= 60){
		letter = "D";
	}else {
		letter = "F";
	}
	sprint("with " + grade + ", you got a " + letter);
}

//increment an int from 1 - 10
function oneToTen(){
	var x = 1;
	while(x <= 10){
		sprint("x = " + x++);
	}
}

function quizAverage(){
	var grade;
	var count = 0;
	var total = 0;
	var gradenum = 0 ;
	var average = 0;
	var pass = 0;
	var fail = 0;
	// sentinel -1
	while( gradenum != -1){
		grade = window.prompt("enter a grade 0-100, enter -1 to finish");
		gradenum = parseInt(grade);
		//error check
		//checks if user entered a number and if the number is between 0 and 100
		if( !isNaN(gradenum) && (gradenum != -1 ) && ( gradenum >= 0 && gradenum <= 100)){
			total += gradenum;
			count++;
			//check if student passes
			if(gradenum >= 70){
				pass++;
			}else{
				fail++;
			}
		}
		else
			console.log(grade + " is NaN or outside 0-100")
	}
	if ( count > 0 ){
		average = total/count ;
		document.writeln("<p> average is "+average+"</p>");
		sprint(pass + " students passed, and " + fail + " students failed.");
	}
	else
		document.writeln("<p>no grade entered </p>");
}
