<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Register</title>
  <link rel="stylesheet" href="styles/style.css">
</head>
<body class="center" style="background-color: #4b545d; color: white">
<form action="register" method="POST" >
  <h1>Register</h1>
  <div>
    <div>
      <span>Name</span>
      <span style="color: red">*</span>
    </div>
    <div style="display: flex; gap: 10px">
      <div style="display: flex; flex-direction: column">
        <input type="text" name="firstName" style="height: 25px; width: 200px">
        <span>First</span>
      </div>
      <div style="display: flex; flex-direction: column">
        <input type="text" name="lastName" style="height: 25px; width: 200px">
        <span>Last</span>
      </div>
    </div>
  </div>

  <div style="margin-top: 20px">
    <div>
      <span>Username</span>
      <span style="color: red">*</span>
    </div>
    <input type="text" name="username" style="height: 25px; width: 420px">

  </div>

  <div style="margin-top: 20px">
    <div>
      <span>E-mail</span>
      <span style="color: red">*</span>
    </div>
    <input type="email" name="email" style="height: 25px; width: 420px">

  </div>

  <div style="margin-top: 20px">
    <div>
      <span>Password</span>
      <span style="color: red">*</span>
    </div>
    <input type="text" name="password" style="height: 25px; width: 420px">

  </div>

  <div style="margin-top: 20px">
    <div>
      <span>Facebook</span>
    </div>
    <input type="url" name="facebook" style="height: 25px; width: 420px; display: block">
    <span>Enter your Facebook profile URL.</span>
  </div>


  <div style="margin-top: 20px">
    <div>
      <span>Short Bio</span>
    </div>
    <textarea name="shortBio" style="width: 420px; height: 100px; display: block"></textarea>

    <span>Share a little information about yourself.</span>
  </div>

  <button type="submit" style="padding: 8px 20px; color: black; cursor: pointer; margin-top: 20px">Submit</button>


</form>
</body>
</html>