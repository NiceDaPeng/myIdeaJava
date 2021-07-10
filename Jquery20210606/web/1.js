//jquery工厂方法，可以用来创建jquery对象
function jquery(tagName) {
    var elements = document.getElementsByTagName(tagName);
    return new jqueryObject(elements);
}

//jQuery对象的构造函数

function jqueryObject(elements) {
    //elements是一个数组，用来存储当前jquery对象包裹的标签对象。
    this.elements = elements;
    this.setAttribute = function (key, value) {
        //比如我们向把input标签的name、checked属性设为true
        //input.checked = true;
        //jq.setAttribute('checked',true);
        for (var i = 0; i < this.elements.length; i++) {
            var element = this.elements[i];
            element[key] = value;
        }
    }
}