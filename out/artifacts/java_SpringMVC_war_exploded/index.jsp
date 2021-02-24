<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>


<form action="springmvc/testPOJO" method="post">
    用户名称: <input type="text" name="username"/>
    <br/>
    用户密码: <input type="password" name="password"/>
    <br/>
    用户邮箱: <input type="text" name="email"/>
    <br/>
    用户性别: 男 <input type="radio" name="gender" value="1"/>
    女<input type="radio" name="gender" value="0"/>
    <br/>
    <!-- 支持级联的方式 -->
    用户省份: <input type="text" name="address.province"/>
    <br/>
    用户城市: <input type="text" name="address.city"/>
    <br/>
    <input type="submit" value="注册"/>
</form>
<br/>
<a href="springmvc/testCookieValue">Test testCookieValue</a>
<br/>
<a href="springmvc/testRequestParam?username=zhanggang&age=11">Test RequestParam</a>
<br/>
<a href="springmvc/testPathVariable/1001">Test PathVaribale</a>
<form action="testRequestMappingMethod" method="post">
    <input type="submit" value="POST"/>
</form>
<a href="testRequestMapping">Test RequestMapping</a>
<br/>
<a href="helloworld">helloworld</a>

<br/>



<br/>

<a href="testCookieValue"> Test CookieValue</a>
<br/>
<a href="testRequestHeader">Test RequestHeader</a>
<br/>

<a href="testRequestParam?username=Tom&age=22">Test RequestParam</a>
<br/>
<!-- 修改一个订单 -->
<form action="order" method="post">
    <input type="hidden" name="_method" value="PUT"/>
    <input type="submit" value="REST PUT"/>
</form>
<br/>

<!-- 添加一个新的订单 -->
<form action="order" method="post">
    <input type="submit" value="REST POST"/>
</form>
<br/>
<!-- 删除id为1001的订单 -->
<form action="order/1001" method="post">
    <!-- 隐藏域· -->
    <input type="hidden" name="_method" value="DELETE"/>
    <input type="submit" value="REST DELETE"/>
</form>
<br/>
<!-- 查询id为1001的订单 -->
<a href="order/1001">REST GET</a>
<br/>

<br/>
<a href="testRequestMappingParamsAndHeaders?username=tom&age=22">Test RequestMapping Params Headers</a>
<br/>

<br/>
<a href="testRequestMappingMethod">Test RequestMapping Method</a>
<br/>
<br/>
<!--
    相对路径: 不以/开头的路径 . 相对于当前路径来发送请求.
    绝对路径: 以/开头的路径 . 直接在 http://localhost:8888 后面拼接请求.
 -->
<a href="hello">Hello SpringMVC</a>
<br/>
<a href="springmvc/helloworld">springmvc SpringMVC</a>

</body>
</html>