<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<style>
			body {
 				 font-family: Georgia, serif;
 				 background-color: grey;
				}

			  * {
  				box-sizing: border-box;
  				width: 80%;
  				}


			.container {
			   margin-left: 350px;
			   margin-top: 100px;
 				padding: 16px;
  				background-color: white;
  				height: 600px;
  				width: 800px;

						}


input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid blue;
  margin-bottom: 25px;
  margin-left:2px;

}

/* Set a style for the submit button */
.registerbtn {
  background-color: blue;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
  font-size:15px;
}

.registerbtn:hover {
  opacity: 0.8;
}


a {
  color: dodgerblue;
}


.signin {
margin-left: 270px;
}
</style>
</head>
<body>


<form action="register" method="post">
  <div class="container">
    <h1>Registration Page</h1>
    <p>Welcome to this app</p>
    <hr>

    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" id="email" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" id="psw" required>

    <button type="submit" class="registerbtn">Register</button>
  </div>
</form>

</body>
</html>