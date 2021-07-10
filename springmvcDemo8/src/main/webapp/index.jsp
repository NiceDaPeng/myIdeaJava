<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>

<html>

<head>
    <script type="text/javascript">
        window.onload = function(){
           document.getElementById("button").onclick = function(){
               var xhr = new XMLHttpRequest();
               xhr.open("post","testTwo",true);
               xhr.setRequestHeader("Content-type","application/json;charset=utf-8");
               xhr.onreadystatechange = function(){
                   if (xhr.readyState == 4 && xhr.status == 200){
                       console.log(xhr.responseText)
                   }
               }
               xhr.send('{"name":"linghuchong","password":"aaaa"}');
           }
        }
    </script>
</head>
<body>

<input type="button" name="testButton" id="button" value="测试json">
</body>
</html>
