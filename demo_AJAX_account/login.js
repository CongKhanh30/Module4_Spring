// function login() {
//     let username = document.getElementById("userNameLogin").value;
//     let password = document.getElementById("passwordLogin").value;
//     var settings = {
//         "url": "http://localhost:8080/accounts/login?username=" + username + "&password=" + password,
//         "method": "Get",
//         "timeout": 0,
//         "headers": {
//             "Authorization": "a",
//             "Content-Type": "application/json"
//         }
//     };
//     $.ajax(settings).done(function (response) {
//         if (response !== "") {
//             if (response.role.name === "admin") {
//                 window.location = "http://localhost:63342/demo_AJAX_account/demo_AJAX_account/account.html";
//             } else {
//                 window.location = "http://localhost:63342/demo_AJAX_account/demo_AJAX_account/login.html";
//             }
//         }else {
//             window.location = "http://localhost:63342/demo_AJAX_account/demo_AJAX_account/login.html";
//         }
//     });
// }

function login() {
    let username = document.getElementById("userNameLogin").value;
    let password = document.getElementById("passwordLogin").value;
    let account = {username, password};

    var settings = {
        "url": "http://localhost:8080/login",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data": JSON.stringify(account),
    };

    $.ajax(settings).done(function (response) {
        localStorage.setItem("token",response);
        window.location.href="../account.html";
    }).fail(function (xhr, status, error) {
        console.log("Error:", error);
    });
}

