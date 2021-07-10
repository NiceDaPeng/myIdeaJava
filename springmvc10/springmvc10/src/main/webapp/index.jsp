<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>


<html>

<head>
    <script type="text/javascript">
        window.onload = function (){
            document.getElementById("button").onclick = function (){
                var xhr = new XMLHttpRequest();
                xhr.open("post","testResponse",true);
                xhr.setRequestHeader("Content-type","application/json;charset=UTF-8");
                xhr.onreadystatechange = function (){
                    if (xhr.readyState == 4 && xhr.status == 200){
                        console.log(xhr.responseText);
                    }
                }
                xhr.send();
            }
        }
    </script>
</head>
<body>


<input type="button" id="button" value="测试JSON">
</body>
</html>
