window.onload = function(){
	document.getElementById("logout").style.visibility = "hidden"; 
	document.getElementById("nrequest").style.visibility = "hidden"; 
	document.getElementById("loginBtn").addEventListener("click", loginRequest, false);	
	document.getElementById("logout").addEventListener("click", logout, false);	
	function loginRequest(){
		
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if (xhr.readyState == 4 && xhr.status == 200){
				var person = JSON.parse(xhr.responseText);
				populate(person);
				document.getElementById("login").style.visibility = "hidden"; 
				document.getElementById("logout").style.visibility = "visible"; 
				document.getElementById("nrequest").style.visibility = "visible"; 
			}
		}
		
		xhr.open("POST", "login", true);
		xhr.send({test : JSON.stringify({username:document.getElementById("uname").value, password:document.getElementById("pwd").value})});

	}
	
	function logout(){
		document.getElementById("login").style.visibility = "visible"; 
		document.getElementById("logout").style.visibility = "hidden"; 
		document.getElementById("nrequest").style.visibility = "hidden"; 
	}

	function populate(person){
		
		
	}
}