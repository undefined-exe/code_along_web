/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

/* global bootstrap */

function validForm() {
    var result = validate_empty('username', 'UserName') && validate_empty('password', 'PassWord');
    username = document.getElementById('username').value;
    password = document.getElementById('password').value;
    if (result) {
        ajax_call('POST', 'home.fin', 'user=' + username + "&pass=" + password, 'ajax');
        var status = document.getElementById('ajax').value;
        if (status > 0) {
            window.location.href = "dashboard";
        } else {
            alert('UserName or Password is Invalid!');
        }
    }
    return false;
}
function validateSignup() {
    var result = validate_empty('username', 'UserName') && validate_empty('email', 'Email') && validate_empty('password', 'Password') && validate_empty('cnfPassword', 'confirm password');
    username = document.getElementById('username').value;
    email = document.getElementById('email').value;
    password = document.getElementById('password').value;
    cnfpassword = document.getElementById('cnfPassword').value;
    if (password !== cnfpassword) {
        alert('pasword and confirm password should be same.');
        return false;
    }
    if (result) {
        ajax_call('POST', 'SignupServlet', 'user=' + username + "&pass=" + password + "&email=" + email, 'ajax2');
        var status = document.getElementById('ajax2').value;
        if (status > 0) {
            window.location.href = "dashboard";
        } else {
            alert('something went wrong!');
        }
    }
    return false;
}
function logoutUser() {
    var res = confirm('Are you sure, you want to logout?');

    if (res) {
        ajax_call('POST', 'Logoutservlet', '', 'ajax', 'value');

        window.location.href = "index.jsp";
    }
}
function validate_empty(elementId, elementName) {
    var value = document.getElementById(elementId).value;
    if (value === '') {
        alert(elementName + " is required and cannot be Empty!");
        return false;
    }
    return true;
}
function ajax_call(method, url, data, destination, isHTML) {
    var xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        if (isHTML) {
            document.getElementById(destination).innerHTML = this.responseText;
        } else {
            document.getElementById(destination).value = this.responseText;
        }
    };
    xhttp.open(method, url, false);
    xhttp.setRequestHeader('content-type', 'application/x-www-form-urlencoded');
    xhttp.send(data);
}
function StudentsLoader(process) {
    ajax_call('POST', 'StudentServlet', 'process=' + process, 'ajax', 'html');
}
function masterloader(process) {
    ajax_call('POST', 'StudentServlet', 'process=' + process, 'studentload', 'html');

}
function ValidateStudentForm() {
    var result = validate_empty('name', 'Name') && validate_empty('address', 'Address') && validate_empty('email', 'Email address') && validate_empty('state', 'State') && validate_empty('city', 'City');

    name = document.getElementById("name").value;
    address = document.getElementById("address").value;
    email = document.getElementById("email").value;
    state = document.getElementById("state").value;
    city = document.getElementById("city").value;
    data = "&name=" + name + "&address=" + address + "&email=" + email + "&state=" + state + "&city=" + city + "&process=insert";
    if (result) {
        ajax_call('POST', 'StudentServlet', data, 'processAjax', 'html');
        if (document.getElementById("status").value > 0) {
            alert("student inserted successfully!");
            document.getElementById("studForm").reset();
        }
    }
    return false;
}
function populateModal(element, process) {
    var rowId = element.getAttribute("data-row-id");
//    alert(rowId);
    ajax_call('POST', 'StudentServlet', "id=" + rowId + "&process=" + process, 'modal', 'html');
    var modal = new bootstrap.Modal(document.getElementById("staticBackdrop"));
    modal.show();
}

function makeEdit() {
    var id = document.getElementById("id").value;
    var name = document.getElementById("name").value;
    var address = document.getElementById("address").value;
    var email = document.getElementById("email").value;
    var state = document.getElementById("state").value;
    var city = document.getElementById("city").value;
    var data = "id=" + id + "&name=" + name + "&address=" + address + "&email=" + email + "&state=" + state + "&city=" + city;
    ajax_call('POST', 'StudentServlet', data + "&process=makeEdit", 'mAjax');

    var status = document.getElementById("mAjax").value;
    if (status > 0) {
        alert("successfully updated!");
        var modal = document.getElementById("staticBackdrop");
        document.getElementById('closeModal').click();
        masterloader('edit');

    } else {
        alert("something went wrong...");
    }
}

function makeDelete(element) {
    var res = confirm('are you sure you want to delete..');
    if (res) {
        var rowId = element.getAttribute("data-row-id");
        ajax_call('POST', 'StudentServlet', "id=" + rowId + "&process=makeDelete", 'modal', 'html');
        if (document.getElementById('modal').innerHTML === '1') {
            alert('data deleted successfully');
        } else {
            alert('something went wrong');
        }
        masterloader('delete');
    }
}
