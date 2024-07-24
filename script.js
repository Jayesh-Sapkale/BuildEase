$(document).ready(function () {

    var count = 0;
    change = function () {


        if (count == 0) {

            $("#signInContainer").fadeOut(500)
            setTimeout(() => {
                $("#signUpContainer").slideToggle(1000)
            }, 1000);
            $("#rightContainerText p").text("Already registered?")
            $("#rightContainer button").text("SIGN IN")
            count++;
        }
        else {
            $("#signUpContainer").fadeOut(500)
            setTimeout(() => {
                $("#signInContainer").slideToggle(1000)
            }, 1000);
            $("#rightContainerText p").text("Register with your personal details to use all of site features")
            $("#rightContainer button").text("SIGN UP")
            count = 0;
        }


    }


})