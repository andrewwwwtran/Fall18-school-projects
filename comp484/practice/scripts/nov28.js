var tags;
var markup = "";
var saveButton;
var clearButton;
var output;
var testStr = "";
var key;
var value;

window.addEventListener("load", start, false);

function start(){
	if(!sessionStorage.getItem("herePreviously")){
		document.getElementById("welcomeMessage").innerHTML = "Welcome to favorite twitter"
		sessionStorage.setItem("herePreviously", "true");
	}

	// check for items
	testStr += "<p>session storage content</p>";
	for(let i = 0; i < sessionStorage.length; i++){
		// sessionStorage.getItem(sessionStorage.key(i));
		// for cleaner code do
		key = sessionStorage.key(i);
		value = sessionStorage.getItem(key);
		testStr += "<p> key : " + key + ", value : " + value + ".</p>";
	}

	testStr += "<p>local storage content</p>";
	for(let i = 0; i < localStorage.length; i++){
		// localStorage.getItem(localStorage.key(i));
		// for cleaner code do
		key = localStorage.key(i);
		value = localStorage.getItem(key);
		testStr += "<p> key : " + key + ", value : " + value + ".</p>";
	}

	tags = [];
	for(let i = 0; i < localStorage.length; i++){
		tags[i] = localStorage.key(i);
	}
	tags.sort();
	testStr += "<p>"+tags.join()+"</p>";

	test = document.getElementById("tests"),innerHTML = testStr;

	output = document.getElementById("searches").innerHTML = markup;
	output.innerHTML = markup;
}

function loadSearches(){

}

function clearAllSearches(){

}

function saveSearch(){

}

function deleteTag(tag){

}

function editTag(tag){

}
