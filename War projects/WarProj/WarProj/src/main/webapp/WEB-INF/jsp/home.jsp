<!DOCTYPE html>
<html>
<head>
    <title>Welcome Home</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #74ebd5, #9face6);
            margin: 0;
            padding: 0;
        }
        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            color: #333;
        }
        h1 {
            font-size: 48px;
            margin-bottom: 20px;
        }
        p {
            font-size: 20px;
            max-width: 600px;
            text-align: center;
        }
        .button {
            margin-top: 30px;
        }
        .btn {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 15px 30px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 18px;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }
        .btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to Our Application</h1>
        <p>This is the home page of your Java web application. You can customize this page to add links, features, or any other information you'd like to present to users.</p>
        <div class="button">
            <a href="about.jsp" class="btn">Learn More</a>
        </div>
    </div>
</body>
</html>