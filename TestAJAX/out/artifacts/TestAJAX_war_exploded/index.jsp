<%--
  Created by IntelliJ IDEA.
  User: DPJ
  Date: 2021/6/1
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>TestAJAX</title>

    <script type="text/javascript">
      // window.onload = function () {
      //    document.getElementById("uname").onblur=function () {
      //       var span = document.getElementById("showSpan");
      //       var unameElementValue = this.value;
      //       if (unameElementValue.length >= 6 && unameElementValue.length <= 10) {
      //           span.innerHTML = "合法";
      //       } else {
      //           span.innerHTML = "长度不合法"
      //       }
      //    }
      // };

      window.onload= function () {
          //找到文本框，绑定一个失去焦点事件
          document.getElementById("uname").onblur=function () {
              //获取当前文本框的value属性，
              var unameEleValue = this.value;
              //发送AJAX异步请求， 需要一个XMLHttpRequest对象
              var xmlHttp = new XMLHttpRequest();
              //创建完对象以后需要打开一个管道。目的是为了与服务器进行通信的,
              //open里面有三个参数：
              // 1，String类型的，请求的方式：get/post；
              // 2，String 类型的，请求的url可以拼接？作为参数；
              // 3，boolean类型的 ，表示的是是否为异步请求，默认是true
              xmlHttp.open("get","checkName?uname="+unameEleValue,true);
              //发送请求,请求发送以后，时刻监听着服务器执行状态
              xmlHttp.send();
              //xmlHttp对象有一个属性，readyState，是一个int类型的数字，这个数字从0-4 这么几个状态
              //发出去以后xmlHttp时刻监听着这个状态
              //监测的是服务器的处理状态。
              // 0: 请求未初始化
              // 1: 服务器连接已建立
              // 2: 请求已接收
              // 3: 请求处理中
              // 4: 请求已完成，且响应已就绪
              //xmlHttp对象会随时监听这个属性的值的变化，有个函数，就是当值发生改变的时候，如果有变化就调用某个函数
              xmlHttp.onreadystatechange = function () {
                if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                    //将响应信息接回来
                    var result = xmlHttp.responseText;
                    //将信息展示在span标签内
                    var spanEle = document.getElementById("showSpan");
                    spanEle.innerHTML = result;
                }
              }
              //等待回来的响应信息，并处理，展示在span标签内。
          }

          document.getElementById("country").onchange=function () {
              var xmlHttp = new XMLHttpRequest();
              xmlHttp.open("post","showCountry?selected="+this.value,true);
              xmlHttp.send();
          }
      }
    </script>
  </head>
  <body>

  <form action="" method="post">

    账号：<input id="uname" type="text" name="uname" value="">
    <span id="showSpan"></span>
    <br>
    密码：<input id="password" type="password" name="upassword" value=""><br>
    确认：<input id="checkpassword" type="password" name="ucheckpassword",value=""><br>
    电话：<input id="telphone" type="text" name="utel" value=""><br>
    地址：
    <select name="country" id="country">
      <option>==请选择==</option>
      <option value="中国">中国</option>
      <option value="德国">德国</option>
      <option value="巴西">巴西</option>
      <option value="巴基斯坦">巴基斯坦</option>
    </select>

    <select name="city" id="city">
      <option value="">==请选择==</option>
      <option value="上海">上海</option>
      <option value="北京">北京</option>
      <option value="广州">广州</option>
    </select>

    <select name="area" id="area">
      <option value="">==请选择==</option>
      <option value="huangpu">黄浦区</option>
      <option value="changning">长宁区</option>
      <option value="jingan">静安区</option>
    </select>
    <br>

    爱好：
    <input type="checkbox" name="hoppy" value="足球">足球
    <input type="checkbox" name="hoppy" value="篮球">篮球
    <input type="checkbox" name="hoppy" value="排球">排球 <br>

    <input type="submit" value="注册">

  </form>
  </body>
</html>
