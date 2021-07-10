<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DPJ
  Date: 2021/6/2
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        window.onload = function () {
            // document.getElementById("country").onchange=function () {
            //     var xmlHttp = new XMLHttpRequest();
            //     xmlHttp.open("post", "queryAllArea?cid="+this.value, true);
            //     xmlHttp.send();
            //     xmlHttp.onreadystatechange = function () {
            //         if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            //            var countryEle = document.getElementById("country");
            //             spanArea.innerHTML = xmlHttp.responseText;
            //             var countries =JSON.parse(responseText);
            //             for (var i = 0; i < countries.length; i++) {
            //                 var newOptionEle = document.createElement("option");
            //                 newOptionEle.setAttribute("value",countries[i].cid);
            //                 newOptionEle.innerHtml=countries[i].cname;
            //                 countryEle.appendChild(newOptionEle);
            //             }
            //         }
            //     }
            // }

            //AJAX和JSON 实现联动
            //获取国家标签对象，当对象里面的内容发生改变的时候，执行函数
            document.getElementById("country").onchange=function () {

                //创建XMLHttpRequest对象
                var xmlHttp = new XMLHttpRequest();
                //开启一条请求的通道
                xmlHttp.open("post","queryAllArea?cid="+this.value,true);
                //发送请求
                xmlHttp.send();
                //监听请求的状态，请求的状态发生改变的时候，执行函数
                xmlHttp.onreadystatechange = function () {
                    //当请求的状态码为4的时候，表示请求已完成，响应已就绪，此时再执行函数，
                    //不能每次改变都执行函数。
                    if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {

                        //当响应信息就绪的时候，获取到地区标签对象
                        var areaEle = document.getElementById("area");
                        //将地区标签对象里面的option都清空
                        areaEle.options.length = 0;
                        //创建一个新的option标签
                        areaOptionEle = document.createElement("option");
                        //将标签里面的内容更改为==区域==
                        areaOptionEle.innerHTML = "==地区==";
                        //将新的option添加到select标签中
                        areaEle.appendChild(areaOptionEle);
                        //为什么要将原来的option删除呢？因为如果不删除，那么前面的就会和后面的area取得的值一起出现
                        //第一将其长度设为0，第二创建新的option添加到里面。
                        //==========================================

                        //获取响应的字符串内容
                        var resText = xmlHttp.responseText;
                        //通过JSON的parse对字符串进行解析，得到的是一个键值对。
                        var jsonObject = JSON.parse(resText);
                        //根据健获取到值，得到的是一个集合。因为我们在Controller层存的是一个集合。
                        var areaList = jsonObject.areas;
                        //遍历集合
                        for (var i = 0; i < areaList.length; i++) {
                            //集合中的每一个元素都是一个对象，通过对象来获取其属性的值。
                            var aid = areaList[i].aid;
                            var aname = areaList[i].aname;
                            //创建一个新的option
                            var newOption = document.createElement("option");
                            //设置新的option的value属性值，因为我们后面还要用到这个去获得对应的城市
                            newOption.setAttribute("value",aid);
                            //设置option里面的内容为aname属性值
                            newOption.innerHTML = aname;
                            //将新的Option添加到select标签对象中
                            areaEle.appendChild(newOption);
                        }
                    }
                }
            }

            document.getElementById("area").onchange=function () {
                var xmlhttp;
                if (window.XMLHttpRequest)
                {// code for IE7+, Firefox, Chrome, Opera, Safari
                    xmlhttp=new XMLHttpRequest();
                }
                else
                {// code for IE6, IE5
                    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
                }
                xmlhttp.open("post","queryCity?aid="+this.value,true);
                xmlhttp.send();
                xmlhttp.onreadystatechange=function () {
                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                        var cityEle = document.getElementById("city");
                        cityEle.options.length = 0;
                        var cityNewOption = document.createElement("option");
                        cityNewOption.innerHTML = "==城市==";
                        cityEle.appendChild(cityNewOption);
                        var resText = xmlhttp.responseText;
                        var jsonObject = JSON.parse(resText);
                        var jsonobj = jsonObject.cities;
                        for (var i = 0; i < jsonobj.length; i++) {
                            var newOption = document.createElement("option");
                            newOption.innerHTML = jsonobj[i].cityname;
                            cityEle.appendChild(newOption);
                        }
                    }
                }
            }
        }
    </script>
</head>
<body>

<form action="">

    账户：<input type="text" name="uname" value=""> <br>
    密码：<input type="text" name="upassword" value=""> <br>
    确认：<input type="text" name="checkupassword" value=""> <br>
    性别：<input type="radio" name="sex" value="男">男
    <input type="radio" name="sex" value="女">女 <br>
    住址：
    <select name="country" id="country">
        <option value="">==国家==</option>
        <c:forEach var="country" items="${requestScope.countries}">
            <option value="${country.cid}">${country.cname}</option>
        </c:forEach>
    </select>


        <select name="area" id="area">
            <option value="">==地区==</option>
        </select>



        <select name="city" id="city">
            <option value="">==城市==</option>

        </select>
   <br>

    电话：<input type="text" name="uname" value=""> <br>
    邮箱：<input type="text" name="uname" value=""> <br>
    <input type="submit" value="注册">
    <input type="reset" value="重置">
</form>
</body>
</html>
