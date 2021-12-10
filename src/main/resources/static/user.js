$user = $('#userInfo');
$info = $('#navBar')
$(document).ready(function () {
    $.ajax({
        method: 'GET',
        url: '/user/about',
        success: function (user) {

            let infoNavBar = "<b>" + user.username + "</b> with role: ";
            let a = "";
            for (let b of user.roles) {
                a += b.name.substr(5) + " ";
            }

            $user.append('<td>' + user.id + '</td>')
            $user.append('<td>' + user.username + '</td>')
            $user.append('<td>' + user.lastName + '</td>')
            $user.append('<td>' + user.email + '</td>')
            $user.append('<td>' + a + '</td>')

            $info.append('<th>' + infoNavBar + a + '</th>')
        }
    });
})