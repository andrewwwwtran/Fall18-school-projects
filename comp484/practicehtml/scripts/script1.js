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
	var average = 0;
	var i = 1;
	while(i <= 10){
		grade = parseInt(window.prompt("student " + i + "\'s quiz grade:"));
		// if didnt enter a number or pressed the cancel button
		if(isNaN(grade)){
			window.alert("start over, didn't enter a number.");
			break;
		}
		// entered a number bigger than 100
		if(grade > 100){
			window.alert("grade is over 100, try again.");
			break;
		}
		average += grade;
		i++;
	}
	i--;
	sprint("class quiz average is " + (average/i));
}
