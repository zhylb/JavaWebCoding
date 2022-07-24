function addCartItem(bookId) {
    window.location.href = "cart.do?operate=addItem&bookId="+bookId;
}

function updateCart(id,num,bookId) {
    window.location.href = "cart.do?operate=updateCart&id="+ id + "&num="+num+"&bookId="+bookId;

}


function $(id){
    return document.getElementById(id);
}

function ckRegist(){


    //用户名应为6~16位数字和字母组成
    let regUname = /^[0-9a-zA-Z_]{6,16}$/;
    let uname = $("uname").value;
    let unameErr = $("unameErr");

    if(regUname.test(uname)){
        unameErr.style.visibility = "hidden";
    }else {
        unameErr.innerText = "用户名应为6~16位数组和字母组成"
        unameErr.style.visibility = "visible";
        return false;
    }


    //密码
    let regPwd = /^[0-9a-zA-Z_]{6,16}$/;
    let pwd = $("pwd").value;
    let pwdErr = $("pwdErr");

    if(regPwd.test(pwd)){
        pwdErr.style.visibility = "hidden";
    }else {
        pwdErr.style.visibility = "visible";
        return false;
    }

    //确认密码
    let repPwd = $("repPwd").value;
    let regPwdErr = $("regPwdErr");
    if(repPwd === pwd){
        regPwdErr.style.visibility = "hidden";
    }else {
        regPwdErr.style.visibility = "visible";
        return false;
    }

    //邮箱
    let regEmail = /^[a-zA-Z0-9_\.-]+@([a-zA-Z0-9-]+[\.]{1})+[a-zA-Z]+$/;
    let email = $("email").value;
    let emailErr = $("emailErr");
    if(regEmail.test(email)){
        emailErr.style.visibility = "hidden";
    }else {
        emailErr.style.visibility = "visible";
        return false;
    }
    return true;
}

//1 创建对象
let xmlHttpRequest

//2 实例化
function createXMLHttpRequest() {
    if(window.XMLHttpRequest){
        //谷歌 火狐 正常的浏览器
        xmlHttpRequest = new XMLHttpRequest();
    }else {
        //阴间的浏览器器 IE
        try{
            xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
        }catch (e) {
            xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP")
        }
    }
}

//3编写主要的函数
function ckUname(uname){
    createXMLHttpRequest();
    let url = "user.do?operate=checkName&uname="+uname;
    xmlHttpRequest.open("GET",url,true);

    //设置回调函数
    xmlHttpRequest.onreadystatechange = ckUnameOnReady;

    //发送请求
    xmlHttpRequest.send();

}


//4 编写回调函数
function ckUnameOnReady(){
    if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200){

        let text = xmlHttpRequest.responseText;
         if(text == "{'uname':'1'}"){
            let unameErr = $("unameErr");


            unameErr.innerText = "用户名已经存在"
            unameErr.style.visibility = "visible";
        }else {
             let unameErr = $("unameErr");


             unameErr.innerText = "用户名可用"
             unameErr.style.visibility = "visible";
         }
    }
}