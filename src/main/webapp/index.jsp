<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome to my Website</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        body {
            background-color: #87CEFA;
        }

        .container {
            padding: 100px 0;
            text-align: center;
        }

        h1, p {
            color: #FFFFFF;
        }

        a.btn-primary {
            background-color: #FFFFFF;
            color: #87CEFA;
            border: none;
            font-size: 24px;
            font-weight: bold;
            border-radius: 8px;
            cursor: pointer;
            box-shadow: 0px 2px 6px rgba(0, 0, 0, 0.3);
            font-family: 'Montserrat', sans-serif;
            transition: background-color 0.3s ease-in-out;
        }

        a.btn-primary:hover {
            background-color: #008B8B;
            color: white;
            box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.3);
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Welcome to Library Management System</h1>
    <p>Please click the buttons:</p>
    <div>
        <a href="/user" class="btn btn-primary">View People</a>
    </div>
    <br/>
    <div>
        <a href="/book" class="btn btn-primary">View Books</a>
    </div>
</div>
<!-- Bootstrap JS and jQuery -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIH7UfgDw"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>