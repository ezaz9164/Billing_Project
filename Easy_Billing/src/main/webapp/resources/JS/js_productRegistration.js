/**
 * 
 */
function checkFunction(strd) {

	console.log("entered checkFunction");

	try {
		if (document.getElementById("pId").value == "") {
			throw "enter a company Name";
		} else if (strd == "notAllowed") {
			throw "product already exist"
		} else {
			document.getElementById("nError").innerHTML = '';
		}

	} catch (e) {
		document.getElementById("nError").innerHTML = e.toString();
		document.getElementById("pId").value = '';
	}

}

/*function dropGsts(gstList) {

	var j = JSON.parse(gstList);

	var gstSelectTag = document.getElementById("gTag");
	var populateTag = "";
	gstSelectTag.innerHTML = populateTag;

	var dummyTag = document.createElement("option");
	dummyTag.innerHTML = "";
	gstSelectTag.appendChild(dummyTag);

	for (var i = 0; i < j.length; i++) {
		var optionTag = document.createElement("option");
		optionTag.innerHTML = j[i];
		gstSelectTag.appendChild(optionTag);
	}

}
*/

function dropGsts(gstList) {

	var j = JSON.parse(gstList);

	var gstSelectTag = document.getElementById("gTag");
	var populateTag = "";
	gstSelectTag.innerHTML = populateTag;

	var dummyTag = document.createElement("option");
	
	dummyTag.setAttribute("value", "");
	dummyTag.innerHTML = "select";
	gstSelectTag.appendChild(dummyTag);

	for (var i = 0; i < j.length; i++) {
		var optionTag = document.createElement("option");
		optionTag.innerHTML = j[i];
		gstSelectTag.appendChild(optionTag);
	}

}