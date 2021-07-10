<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title></title>
    <script type="text/javascript">
        window.onload = function (){
            var button = document.getElementById("button");
            button.onclick=function (){
                var xhr = new XMLHttpRequest();
                xhr.open("post","test3",true);
                xhr.setRequestHeader("Content-type","application/json;charset=UTF-8");
                xhr.onreadystatechange = function (){
                    if (xhr.readyState == 4 && xhr.status == 200){
                        console.log(xhr.responseText);
                    }
                }
                xhr.send({"name":"good"});
            }
        }
    </script>
</head>
<body>
<h2>Hello World!</h2>
<a href="test1?name=dpj&amp;password=aaa">测试1</a>

<input type="button" value="测试" id="button"/>
</body>
</html>
