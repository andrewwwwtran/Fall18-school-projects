//prints object to page, shorthand for document.writeln
function sprint(object){
	document.writeln(object + "<br>");
}

//increase and decrease font size (inline styling)
function fontIncreaseDecrease(){
	let size = 10;
	while(size <= 20){
		sprint("<p style = 'font-size: " + size + "px'> some text </p>");
		size+=2;
	}
	for(size = 20; size >= 10; size-=2){
		sprint("<p style = 'font-size: " + size + "px'> some text </p>");
	}
}

function two2hundred(){
	let sum = 0;
	for(let i = 2; i <= 100; i+=2){
		sum+=i;
		// sprint(sum+=i);
	}
	sprint("sum : " + sum);
}

//a = p ( 1 + r ) ^ n , use Math.pow(x,y) and amount.toFixed(2)
//put it in a table
function annualDeposit(){
	let principle = 1000;
	let rate = 0.05;
	let years = 1;
	let amount = 0;
	sprint("<table><thead><tr><th>year</th><th>amount</th></tr></thead><tbody>");
	for(years = 1; years <= 10; years++){
		amount = principle*Math.pow((1+rate),years);
		if(years%2==0){
			sprint("<tr class=\"even\"><td>" + years+ "</td><td>" + amount.toFixed(2)+ "</td></tr>");
		}else{
			sprint("<tr><td>" + years+ "</td><td>" + amount.toFixed(2)+ "</td></tr>");
		}
		// sprint("year " + years + " | " + amount.toFixed(2));
	}
	sprint("</tbody></table>")
}
