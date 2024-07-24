$(document).ready(function () {

    var count = 0;
    change = function () {


        if (count == 0) {

            // $("#signUpButton").click(() => {
            $("#signInContainer").hide(1000)
            $("#signUpContainer").show()
            $("#rightContainerText p").text("Already registered?")
            $("#rightContainer button").text("SIGN IN")
            // })
            count++;
        }
        else {
            // $("#signUpButton").click(() => {
            $("#signUpContainer").hide(1000)
            $("#signInContainer").show()
            $("#rightContainerText p").text("Register with your personal details to use all of site features")
            $("#rightContainer button").text("SIGN UP")
            // })
            count = 0;
        }


    }


})