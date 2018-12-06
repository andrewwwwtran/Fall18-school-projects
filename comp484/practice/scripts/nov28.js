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

	var saveButton = document.getElementById("saveButton");
	var clearButton = document.getElementById("clearButton");

	saveButton.addEventListener("click", saveSearch, false);
	clearButton.addEventListener("click", clearAllSearches, false);

	loadSearches();
}

function loadSearches(){
	testStr = "";
	markup = "";

	if(!sessionStorage.getItem("herePreviously")){
		document.getElementById("welcomeMessage").innerHTML = "Welcome to favorite twitter"
		sessionStorage.setItem("herePreviously", "true");
	}

	// // check for items
	// testStr += "<p>session storage content</p>";
	// for(let i = 0; i < sessionStorage.length; i++){
	// 	// sessionStorage.getItem(sessionStorage.key(i));
	// 	// for cleaner code do
	// 	key = sessionStorage.key(i);
	// 	value = sessionStorage.getItem(key);
	// 	testStr += "<p> key : " + key + ", value : " + value + ".</p>";
	// }
	//
	// testStr += "<p>local storage content</p>";
	// for(let i = 0; i < localStorage.length; i++){
	// 	// localStorage.getItem(localStorage.key(i));
	// 	// for cleaner code do
	// 	key = localStorage.key(i);
	// 	value = localStorage.getItem(key);
	// 	testStr += "<p> key : " + key + ", value : " + value + ".</p>";
	// }

	tags = [];
	for(let i = 0; i < localStorage.length; i++){
		tags[i] = localStorage.key(i);
	}
	tags.sort();
	// testStr += "<p>tag array is: "+tags.join()+"</p>";

	document.getElementById("tests").innerHTML = testStr;

	document.getElementById("searches").innerHTML = markup;

	var tb = "";
	var url = "https://twitter.com/search?q=";
	var listmarkup = "<ul>";
	for(tag in tags){
		var query = localStorage.getItem(tags[tag]);
		//replace spaces with '+'
		query = query.replace(" ", "%2B");
		query += url + query;
		listmarkup += "<li> <a href='" + query + "'>" + tags[tag] + "</a>" +
		"<input id = '" + tags[tag] + "' type = 'button' value = 'Edit' onclick = 'editTag(id)'>" +
		"<input id = '" + tags[tag] + "' type = 'button' value = 'Delete' onclick = 'deleteTag(id)'</li>";
	}

	listmarkup += "</ul>";

	document.getElementById("searches").innerHTML += listmarkup;
}

function clearAllSearches(){

	//clear the local storage
	localStorage.clear();

	loadSearches();
}

function saveSearch(){
	//get user entries
	var query1 = document.getElementById("query").value;
	var tag1 = document.getElementById("tag").value;
	localStorage.setItem(tag1, query1);

	loadSearches();
}

function deleteTag(tag){
	//id is set to tags[tag]
	//want to delete where key name is tag
	localStorage.removeItem(tag);
	loadSearches();
}

function editTag(tag){
	//find the element to edit, show it where the user saves
	document.getElementById("tag").value = tag;
	document.getElementById("query").value = localStorage.getItem(tag);
	//doing this will overwrite "edit" the user queries

	loadSearches();
}
