

<head>
    <title>Social Auth</title>
    <link  rel="stylesheet" href="https://bootswatch.com/cerulean/bootstrap.min.css">
    <style>
        #fb-btn{margin-top:20px;}
        #profile,#logout {display:none}
        #nav-btn{display: inline-block;
            float: right;
            margin-right: 114px;}
        .nav-button {
            width: 100px;
        }
        #search_box {margin-bottom: 20px;}

    </style>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
</head>
<body>




<nav class="navbar navbar-inverse ">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Soacial Auth</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="view.jsp">Home</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a id="logout" href="#" onclick="logout()">Logout</a></li>
                <fb:login-button id="fb-btn"
                                 scope="public_profile,email,user_friends"
                                 onlogin="checkLoginState();">
                </fb:login-button>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<div class="container" role="main">
    <h3 id="heading">Login to view Friend list</h3>
    <div id="search_box" class="input-group">
        <input type="text" id="frientText" class="form-control" placeholder="Search Friend">
        <div class="input-group-btn">
            <button class="btn btn-default" onclick="findFriend()" type="submit">
                <i class="glyphicon glyphicon-search"></i>
            </button>
        </div>
    </div>
    <div id="friend_list_Container">
        <div id="friend_list">
            <!-- <table id="friend_table" align="center" border="0" width="10" cellspacing="20">

            </table>
            -->
        </div>
        <div id="nav-btn">
            <button id="prev-btn" class="btn btn-primary nav-button" onclick="handleRequest('prev')">Previous</button>
            <button id="next-btn" class="btn btn-primary nav-button" onclick="handleRequest('next')">Next</button>
        </div>

    </div>

    <div >
        <input type="hidden" id="next_reference" />
        <input type="hidden" id="prev_reference" />

    </div>

</div>



</body>


