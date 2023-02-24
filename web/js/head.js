function getParam(e){
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == e){
            console.log(e);
            return decodeURI(pair[1]);
        }
    }
    return(false);
}
// 判断用户是否已登录的函数
function isLoggedIn() {
    let userId = getParam("username");
    if (userId == false){
        return false;
    }
    // 在这里编写你的代码来检查用户是否已登录
    // 如果已登录，返回 true；否则返回 false。
    return true; // 假设用户已登录
}

// 在页面加载完成后执行代码
window.onload = function() {
    // 获取登录按钮元素
    var loginButton = document.getElementById("login-button");
    // 获取导航栏元素
    var navBar = document.getElementsByTagName("nav")[0];

    // 检查用户是否已登录
    if (isLoggedIn()) {
        // 如果已登录，创建一个元素来显示用户名
        var usernameElement = document.createElement("span");
        usernameElement.textContent = "Username";
        usernameElement.style.marginLeft = "auto";
        usernameElement.style.marginRight = "20px";

        // 将该元素添加到导航栏中
        navBar.insertBefore(usernameElement, loginButton);

        // 隐藏登录按钮
        loginButton.style.display = "none";
    }
};