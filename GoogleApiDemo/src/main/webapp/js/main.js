var token=null;
var contactList=null;
$(document).ready(function(){
    $("#lgoogle").click(function(){
        var oauth_uri=" https://accounts.google.com/o/oauth2/auth?";
        var scopes="https://www.googleapis.com/auth/contacts https://www.googleapis.com/auth/contacts.readonly https://www.google.com/m8/feeds https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo.email https://www.googleapis.com/auth/plus.me https://www.googleapis.com/auth/plus.circles.read";
        var client_id="518184818239-dgd4og7jf2fuc4tsubul0to3bqqd74oq.apps.googleusercontent.com";
        var redirect_uri="http://localhost:8080/";
        var type="token";
        var url=oauth_uri + "scope=" + scopes + "&client_id=" + client_id + "&redirect_uri=" + redirect_uri +  "&response_type=" + type;
        var win=window.open(url,"window for Oauth Google","width=500,higth=500");

        var spam=window.setInterval(function()
        {
            var token_url=win.document.URL;
            if(token_url.indexOf(redirect_uri)!=-1)
            {
                window.clearInterval(spam);
                win.close();
                var start=token_url.indexOf("access_token=");
                var end=token_url.indexOf("&token_type");
                token=token_url.substring(start + 13,end);
                validateToken(token);
            }
        },500);

    });

    function validateToken(token)
    {
        $.ajax({
            url:'https://www.googleapis.com/oauth2/v1/tokeninfo?access_token='+token,
            data:null,
            success:function(result){
                getContactsInformation(token);
            },
            dataType:'jsonp'
        });
    }


    function getContactsInformation(token)
    {
        $.ajax({
            url:'https://www.google.com/m8/feeds/contacts/default/full?alt=json&max-results=1000&access_token='+token,
            data:null,
            success:function(result){
                var data=result.feed.entry;
                contactList=data;
                $("#searchandshowbutton").show();
                $( "#usercontainer" ).empty();
                for(var i in data)
                {
                    mapContactData(data[i]);
                }
            },
            dataType:'jsonp'
        });

        $('#usercontainer').show();
    }




    $("#searchfriend").click(function(){
        var searchkeyName = document.getElementById('usr').value;
        $( "#usercontainer" ).empty();
        for(var i in contactList )
        {
            var str=contactList[i].title.$t;
            if(str.includes(searchkeyName))
            {
                mapContactData(contactList[i]);
            }
        }
        $('#usercontainer').show();
    });

    $("#showallfriends").click(function(){
        if(contactList!=null) {
            $("#usercontainer").empty();
            for (var i in contactList) {
                mapContactData(contactList[i]);
            }
            $('#usercontainer').show();
        }
    });

    function mapContactData(contact)
    {
        var currentdiv= document.createElement("div");
        var br = document.createElement("br");
        currentdiv.setAttribute("class","col-sm-5");
        currentdiv.setAttribute("style","margin: 20px; height: 200px;padding: 10px 43px;background: #3999cb; width: 300px;border-radius:2px");

        var name = document.createElement("span");
        name.setAttribute("style","font-weight: bold;");
        name.innerHTML = contact.title.$t+"<br>";

        currentdiv.appendChild(name);

        if(contact.gd$phoneNumber!=null)
        {
            var phonenumber = document.createElement("span");
            phonenumber.setAttribute("style","color: blue;");
            phonenumber.innerHTML = contact.gd$phoneNumber[0].$t+"<br>";
            currentdiv.appendChild(phonenumber);
        }
        if(contact.gd$email!=null)
        {
            var email = document.createElement("span");
            email.setAttribute("style","color: blue;word-wrap: break-word;");
            email.innerHTML = contact.gd$email[0].address+"<br>";
            currentdiv.appendChild(email);
        }

        $('#usercontainer').append(currentdiv);
    }


    /*
     function getConnectionInformation(token)
     {
     $.ajax({
     url:'https://people.googleapis.com/v1/people/me/connections?access_token='+token,
     data:null,
     success:function(result){
     var data=result.connections;
     console.log("Testing aftrer");
     console.log(data);
     for(var i in data)
     {
     console.log(data[i].photos.url);
     console.log(data[i].names.displayName);
     }

     },
     dataType:'jsonp'
     });


     }
     */



    /*
     function getInformation(token)
     {
     $.ajax({
     url:'https://www.googleapis.com/oauth2/v1/userinfo?access_token='+token,
     data:null,
     success:function(result){
     $('#userName').append(result.name);
     $('#email_id').append(result.email);
     $('#gender').append(result.gender);
     $('#link').append(result.link);
     $("#pic").attr("src",result.picture);
     $('#lgoogle').hide();
     $('#logoutbutton').show();

     },
     dataType:'jsonp'
     });
     }*/

  $("#searchglobalfriend").click(function(){
     var searchname = document.getElementById('gsearchvalue').value;
     var restUri='https://www.googleapis.com/plus/v1/people?access_token='+token
     $.ajax({
     url:restUri,
     data:{query:searchname,key:100},
     success:function(response){
     mapGolobleSearchdataOnGUI(response);
     },
     dataType:'jsonp'
     });
     });

  function mapGolobleSearchdataOnGUI(response)
     {
         var data=response.items;
         $( "#usercontainer" ).empty();

         for(var i in data)
         {
             var currentdiv= document.createElement("div");
             currentdiv.setAttribute("class","col-sm-4");
             currentdiv.setAttribute("style","margin: 20px; height: 200px;padding: 10px 43px;background: #3999cb; width: 300px;border-radius:2px");

             var imgdiv= document.createElement("div");

             var imagechild = document.createElement("img");

             imagechild.setAttribute("style","margin-left: 45px;margin-bottom: 14px;HEIGHT: 113px;border-radius: 50%;");
             imagechild.setAttribute("src",data[i].image.url);

             imgdiv.appendChild(imagechild);

             var lb = document.createElement("span");
             lb.setAttribute("style","margin-left: 48px;font-size: 18px;color: white;");
             lb.innerHTML = data[i].displayName;

             currentdiv.appendChild(imgdiv);
             currentdiv.appendChild(lb);
             $('#usercontainer').append(currentdiv);

         }
         $('#usercontainer').show();
     }

});