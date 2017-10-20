/**
 * 
 */
function checkFunction(vard){
	console.log("entered checkFunction");
	

	try {
		if (document.getElementById("pId").value == "") {
			throw "enter a company Name";
		} else if (vard == "notAllowed") {
			throw "product already exist"
		} else {
			document.getElementById("nError").innerHTML = '';
		}

	} catch (e) {
		document.getElementById("nError").innerHTML = e.toString();
		document.getElementById("pId").value = '';
	}
	
}