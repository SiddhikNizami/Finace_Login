<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <!DOCTYPE html>
<html>
<head>
    <title>Finance Tracker - Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f3f3f3;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 380px;
            margin: 80px auto;
            background: #fff;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 0 10px #aaa;
        }
        h2 { text-align: center; }
        input[type=text], input[type=password], input[type=email] {
            width: 100%;
            padding: 12px;
            margin-top: 8px;
            margin-bottom: 16px;
            border-radius: 5px;
            border: 1px solid #888;
        }
        button {
            width: 100%;
            padding: 12px;
            background: #2e86de;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover { background: #1e6ac0; }
        .error { color: red; text-align: center; }
        .success { color: green; text-align: center; }
        .toggle {
            text-align: center;
            margin-top: 15px;
            cursor: pointer;
            color: #2e86de;
        }
    </style>
</head>
<body>

<div class="container">

    <h2>Login</h2>

    <form action="login" method="post">
        <label>Username</label>
        <input type="text" name="username" required>

        <label>Password</label>
        <input type="password" name="password" required>

        <button type="submit">Login</button>
    </form>

    <div class="error">${error}</div>
    <div class="success">${success}</div>

    <div class="toggle" onclick="showRegister()">Create New Account</div>

</div>



<!-- Registration POPUP -->
<div id="registerBox" style="
     position: fixed; top: 0; left: 0; width: 100%; height: 100%;
     background: rgba(0,0,0,0.6); display: none;">

    <div style="
        width: 420px; margin: 80px auto; background: #fff; padding: 25px;
        border-radius: 10px; box-shadow: 0 0 10px #000;">
        <h2>Register</h2>

        <form action="register" method="post">
            <label>Full Name</label>
            <input type="text" name="fullName" required>

            <label>Email</label>
            <input type="email" name="email" required>

            <label>Username</label>
            <input type="text" name="username" required>

            <label>Password</label>
            <input type="password" name="password" required>

            <button type="submit">Register</button>
        </form>

        <div class="toggle" onclick="hideRegister()">Close</div>
    </div>

</div>


<script>
    function showRegister() {
        document.getElementById("registerBox").style.display = "block";
    }
    function hideRegister() {
        document.getElementById("registerBox").style.display = "none";
    }
</script>

</body>
</html>