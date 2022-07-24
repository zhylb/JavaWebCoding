<?php
require_once('lzuapp_fns.php');
session_start();
$valid_user = stripslashes($_SESSION['valid_user']);
?>
<html>
<head>
	<title>课程表</title>
	<meta charset="UTF-8">	
</head>
<body>
<table border="1" align="2" align="center" cellspacing="10" cellpadding="10">
    <caption><?php echo $valid_user; ?>的课程表</caption>
    <thead>
        <tr>
            <td></td>
            <td>星期一</td>
            <td>星期二</td>
            <td>星期三</td>
            <td>星期四</td>
            <td>星期五</td>
            <td>星期六</td>
            <td>星期日</td>
        </tr>
        <tr>
            <td rowspan="4">上午</td>
            <td>语文</td>
            <td>数学</td>
            <td>英语</td>
            <td>英语</td>
            <td>物理</td>
            <td>计算机</td>
            <td rowspan="4">休息</td>
        </tr>
        <tr>
            <td>数学</td>
            <td>数学</td>
            <td>地理</td>
            <td>历史</td>
            <td>化学</td>
            <td>计算机</td>
        </tr>
        <tr>
            <td>化学</td>
            <td>语文</td>
            <td>体育</td>
            <td>计算机</td>
            <td>英语</td>
            <td>计算机</td>
        </tr>
        <tr>
            <td>政治</td>
            <td>英语</td>
            <td>体育</td>
            <td>历史</td>
            <td>地理</td>
            <td>计算机</td>
        </tr>
        <tr>
            <td rowspan="4">下午</td>
            <td>语文</td>
            <td>数学</td>
            <td>英语</td>
            <td>物理</td>
            <td>计算机</td>
            <td>英语</td>
            <td rowspan="2">休息</td>
        </tr>
        <tr>
            <td>数学</td>
            <td>数学</td>
            <td>地理</td>
            <td>历史</td>
            <td>化学</td>
            <td>计算机</td>
        </tr>
    </thead>
</table>
</body>
</html>