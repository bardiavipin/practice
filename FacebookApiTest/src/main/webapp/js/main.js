var foundFriendList=[];

    window.fbAsyncInit = function() {
        FB.init({
            appId      : '245733249241876',
            cookie     : true,
            xfbml      : true,
            version    : 'v2.8'
        });


        FB.getLoginStatus(function(response) {
            statusChangeCallback(response);
        });


    };

    (function(d, s, id){
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) {return;}
        js = d.createElement(s); js.id = id;
        js.src = "//connect.facebook.net/en_US/sdk.js";
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));

    function statusChangeCallback(response){
        if(response.status === 'connected') {
            console.log('Logged in And Authenticated');
            setElemets(true);
            testApi();
        } else
        {
            console.log('Not Authenticated ');
            setElemets(false);
        }
    }


    function testApi() {
        FB.api( '/me/taggable_friends', 'GET', {"limit":"21"}, function(response) {
            // Insert your code here
            if(response && !response.error) {
                //console.log(response);
                handleAlbumsResponse(response)

            }
        });
    }

    function findFriend() {

        var name = document.getElementById("frientText").value;
        console.log(name);
        foundFriendList=[];
        FB.api( '/me/taggable_friends', 'GET', {}, function(response) {
            if(response && !response.error) {
                //console.log(response);
                $.ajaxSetup({
                    async: false
                });
                handleFindFriend(response)

                showFoundFriends();
                console.log(foundFriendList);
                $.ajaxSetup({
                    async: true
                });
            }
        });
    }

    function showFoundFriends()
    {
        $( "#friend_list" ).empty();
        for( var i in foundFriendList) {
            var currentdiv= document.createElement("div");
            currentdiv.setAttribute("class","col-sm-4");
            currentdiv.setAttribute("style","height:151px;width:151px;border-radius: 32px;");

            var imagechild = document.createElement("img");
            imagechild.setAttribute("style","height:100px;width:100px;");
            imagechild.setAttribute("src",foundFriendList[i].imageUrl);

            var lb = document.createElement("span");
            lb.innerHTML = foundFriendList[i].name;



            currentdiv.appendChild(imagechild);
            currentdiv.appendChild(lb);
            $('#friend_list').append(currentdiv);
        }

        document.getElementById('nav-btn').style.display = 'none';
    }
    function handleFindFriend(response) {
        var nametofind = document.getElementById("frientText").value;

        for( var i in response.data) {

            if( response.data[i].name.toLowerCase().search(nametofind.toLowerCase()) >= 0)
            {
                foundFriendList.push({"name":response.data[i].name, "imageUrl":response.data[i].picture.data.url});
            }
        }

        if(response.paging.next)
        {
            $.getJSON(response.paging.next, function(response){
                handleFindFriend(response);
            });
        }

    }
    function handleAlbumsResponse(response){

        //console.log(response);

        var friendtab = "<tr>";
        var start = true;
        $( "#friend_list" ).empty();
        for( var i in response.data) {



            var currentdiv= document.createElement("div");
            currentdiv.setAttribute("class","col-sm-4");
            currentdiv.setAttribute("style","height:151px;width:151px;border-radius: 32px;");

            var imagechild = document.createElement("img");
            imagechild.setAttribute("style","height:100px;width:100px;");
            imagechild.setAttribute("src",response.data[i].picture.data.url);

            var lb = document.createElement("span");
            lb.innerHTML = response.data[i].name;



            currentdiv.appendChild(imagechild);
            currentdiv.appendChild(lb);
            $('#friend_list').append(currentdiv);


        }
        $('#friend_list').show();
        document.getElementById('nav-btn').style.display = 'block';
        //friendtab += ` </tr>`;
        //console.log(friendtab);
        //document.getElementById('friend_table').innerHTML = friendtab;
        // add logic for displaying details


        document.getElementById("next_reference").value = response.paging.next;
        document.getElementById("prev_reference").value = response.paging.previous;

        document.getElementById("prev-btn").disabled = (response.paging.previous === undefined);
        document.getElementById("next-btn").disabled = (response.paging.next === undefined);
    }


    function handleRequest(btn) {

        url = document.getElementById(btn + "_reference").value;
        $.getJSON(url, function(response){
            handleAlbumsResponse(response);
        });

    }



    function checkLoginState() {
        FB.getLoginStatus(function(response) {
            statusChangeCallback(response);
        });
    }

    function setElemets(isLoggedIn){
        if(isLoggedIn){
            document.getElementById('logout').style.display = 'block';
            document.getElementById('friend_list_Container').style.display = 'block';
            document.getElementById('fb-btn').style.display = 'none';
            document.getElementById('heading').style.display = 'none';
        } else {
            document.getElementById('logout').style.display = 'none';
            document.getElementById('friend_list_Container').style.display = 'none';
            document.getElementById('fb-btn').style.display = 'block';
            document.getElementById('heading').style.display = 'block';

        }
    }

    function logout(){
        FB.logout(function(response){
            setElemets(false);
        });
    }