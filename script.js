$(document).ready(function () {

    var count = 0;
    change = function () {

        
        if (count == 0) {
<<<<<<< HEAD
            $("#signInContainer").hide()
            $("#signUpContainer").slideDown(1000)
=======

            $("#signInContainer").hide(1000)
            $("#signUpContainer").show()
>>>>>>> 4edc3b07f73f5a4fc235cde2d7891365b20b9cdb
            $("#rightContainerText p").text("Already registered?")
            $("#rightContainer button").text("SIGN IN")
            count++;
        }
        else {
<<<<<<< HEAD
            $("#signUpContainer").hide()
            $("#signInContainer").slideDown(1000)
=======
            $("#signUpContainer").hide(1000)
            $("#signInContainer").show()
>>>>>>> 4edc3b07f73f5a4fc235cde2d7891365b20b9cdb
            $("#rightContainerText p").text("Register with your personal details to use all of site features")
            $("#rightContainer button").text("SIGN UP")
            count = 0;
        }


    }


})