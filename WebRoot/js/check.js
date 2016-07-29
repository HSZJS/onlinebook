
var isOk = false;

function checkEmpty(txt) {
	var id = txt.id + "-check";
	var check = document.getElementById(id);
	id = txt.id + "-check-ok";
	var ok = document.getElementById(id);
	if (txt.value.length == 0) {
		check.style.display = "inline-block";
		ok.style.display = "none";
		isOk = false;
	} else {
		check.style.display = "none";
		ok.style.display = "inline-block";
		isOk = true;
	}
	return isOk;
}

function checkLength(txt, lenMin, lenMax) {
	var id = txt.id + "-check";
	var check = document.getElementById(id);
	id = txt.id + "-check-ok";
	var ok = document.getElementById(id);
	if (txt.value.length >= lenMax || txt.value.length <= lenMin) {
		check.style.display = "inline-block";
		ok.style.display = "none";
		isOk = false;
	} else {
		check.style.display = "none";
		ok.style.display = "inline-block";
		isOk = true;
	}
	return isOk;
}

function checkEquals(txtSrc, txtDst) {
	var id = txtDst.id + "-check";
	var check = document.getElementById(id);
	id = txtDst.id + "-check-ok";
	var ok = document.getElementById(id);
	if (txtSrc.value != txtDst.value) {
		check.style.display = "inline-block";
		ok.style.display = "none";
		isOk = false;
	} else {
		check.style.display = "none";
		ok.style.display = "inline-block";
		isOk = true;
	}
	return isOk;
}