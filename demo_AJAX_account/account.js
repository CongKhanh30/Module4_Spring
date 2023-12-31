let token = localStorage.getItem('token');

function getAll() {
    // Tạo ra 1 request.
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
            "Authorization": "Bearer " + token
        },
        url: "http://localhost:8080/accounts",
        success: function (data) {
            show(data);
        },
        error: function (err) {
            console.log(err)
            // lỗi
        }
    });

}

getAll();

function show(arr) {
    let str = "";
    for (const a of arr) {
        str += ` <tr>
              <td>${a.id}</td>
              <td>${a.username}</td>
              <td>${a.password}</td>
              <td>${a.role.name}</td>
              <td><button type="button" class="btn btn-warning" onclick="showEdit(${a.id})" data-toggle="modal" data-target="#modalEdit" >Edit</button></td>
              <td><button type="button" class="btn btn-danger" onclick="deleteA(${a.id})" >Delete</button></td>
             </tr>`

    }
    document.getElementById("show").innerHTML = str;
}

function showEdit(idA){
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
            "Authorization": "Bearer " + token
        },
        url: "http://localhost:8080/accounts/"+idA,
        success: function (data) {
            document.getElementById("idE").value = data.id;
            document.getElementById("usernameE").value = data.username;
            document.getElementById("passwordE").value = data.password;
            document.getElementById("idRoleE").value = data.role.id;
        },
        error: function (err) {
            console.log(err)
        }
    });
}

function edit() {
    let id = document.getElementById("idE").value;
    let username = document.getElementById("usernameE").value;
    let password = document.getElementById("passwordE").value;
    let idRole = document.getElementById("idRoleE").value;

    let account = {id, username, password, role: {id: idRole}};

    $.ajax({
        type: "Post",
        headers: {
            'Content-Type': 'application/json',
            "Authorization": "Bearer " + token
        },
        url: "http://localhost:8080/accounts",
        data: JSON.stringify(account),
        success: function (data) {
            getAll();
        },
        error: function (err) {
            console.log(err)
        }
    });
}
    function deleteA(idA){
        $.ajax({
            type: "GET",
            headers: {
                "Authorization": "Bearer " + token
            },
            url: "http://localhost:8080/accounts/delete/"+idA,
            success: function (data) {
                getAll();
            },
            error: function (err) {
                console.log(err)
            }
        });
    }

function create() {
    let username = document.getElementById("usernameC").value;
    let password = document.getElementById("passwordC").value;
    let idRole = document.getElementById("idRoleC").value;

    let account = {username, password, role: {id: idRole}};

    $.ajax({
        type: "POST",
        headers: {
            'Content-Type': 'application/json',
            "Authorization": "Bearer " + token
        },
        url: "http://localhost:8080/accounts",
        data: JSON.stringify(account),
        success: function (data) {
            getAll();
            // Đặt các giá trị về rỗng sau khi tạo thành công

            document.getElementById("usernameC").value = "";
            document.getElementById("passwordC").value = "";
            document.getElementById("idRoleC").value = "";
        },
        error: function (err) {
            console.log(err)
        }
    });
}

function search() {
    let name = document.getElementById("nameSearch").value;

    if (name === ""){
        getAll()
    }else {
        $.ajax({
            type : "GET",
            headers: {
                'Accept': 'application/json',
                "Authorization": "Bearer " + token
            },
            url: "http://localhost:8080/accounts/search/" + name,

            success : function (data) {
                show(data)
            },
            error: function (err) {
                console.log(err)
            }
        });
    }
}




