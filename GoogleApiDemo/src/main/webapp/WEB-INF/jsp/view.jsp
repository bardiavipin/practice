
<head>
    <title>Google Api Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><input type="text" class="form-control" id="gsearchvalue" placeholder="Search Global Users"></li>
                <li class="active"><button type="button" class="btn btn-primary" id="searchglobalfriend">Search</button></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a  id="accountname"/>
                    <button id="lgoogle" class="btn btn-block btn-social btn-google" style="background: darkred;">Login with Google+</button>
                    <button style="display: none;" id="logoutbutton"><span class="glyphicon  glyphicon-off"></span>  LOGOUT </button></li>

            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid text-left">
    <div class="row content">
        <div class="col-sm-2 nav">
        </div>

        <div class="col-sm-7 text-left">
            <div class="page-header">
                <div id="searchandshowbutton" style="display: none;">
                <input type="text" class="form-control" id="usr" placeholder="Search Friend"><br>
                <button type="button" class="btn btn-primary" id="searchfriend" >Search</button>&nbsp;&nbsp;&nbsp;
                <button type="button" class="btn btn-primary" id="showallfriends" >Show ALl Friends </button>
                </div>

            </div>

            <div id="usercontainer">
            </div>
        </div>
    </div>
</div>
</div>

</body>