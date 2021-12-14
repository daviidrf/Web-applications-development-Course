// User of the actual sesion initialized with empty attributes
var userSesion = {
    'username': '',
    'password': '',
    'role': ''
};

$(document).ready(function () {
    // When submit the form execute ajax & pass the form to the back-end
    $('#loginForm').submit(function (e) {
        e.preventDefault();
        $.ajax({
            type: "POST",
            url: 'server/login.php',
            data: $(this).serialize(),
            success: function (response) {
                // Convert to Json th response from the back-end
                var jsonData = JSON.parse(response);

                // User is logged in successfully in the back-end
                if (jsonData.success == "1") {
                    userSesion = jsonData.user;
                    console.log(jsonData.user);

                    // Let's create the cookie to save the actual role
                    document.cookie = "actualUserRole=" + userSesion.role;

                    // Let's redirect to the planificator page
                    location.href = 'pages/planificator.html';
                }
                else {
                    $("#errorMessage").text("Invalid Credentials!").css("color", "red");
                    console.log('Invalid Credentials!');
                }
            }
        });
    });
});