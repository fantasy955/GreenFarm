// var top_html = '<header class="header">\n' +
//     '\t\t\t<!--学子商城logo-->\n' +
//     '\t\t\t<div class="row">\n' +
//     '\t\t\t\t<div class="col-md-3">\n' +
//     '\t\t\t\t\t<a href="index.html">\n' +
//     '\t\t\t\t\t\t<img src="../../images/index/stumalllogo.png" />\n' +
//     '\t\t\t\t\t</a>\n' +
//     '\t\t\t\t</div>\n' +
//     '\t\t\t\t<!--快捷选项-->\n' +
//     '\t\t\t\t<div class="col-md-9 top-item">\n' +
//     '\t\t\t\t\t<ul class="list-inline pull-right">\n' +
//     '\t\t\t\t\t\t<li><a href="favorites.html"><span class="fa fa-heart"></span>&nbsp;收藏</a></li>\n' +
//     '\t\t\t\t\t\t<li class="li-split">|</li>\n' +
//     '\t\t\t\t\t\t<li><a href="orders.html"><span class="fa fa-file-text"></span>&nbsp;订单</a></li>\n' +
//     '\t\t\t\t\t\t<li class="li-split">|</li>\n' +
//     '\t\t\t\t\t\t<li><a href="cart.html"><span class="fa fa-cart-plus"></span>&nbsp;购物车</a></li>\n' +
//     '\t\t\t\t\t\t<li class="li-split">|</li>\n' +
//     '\t\t\t\t\t\t<li>\n' +
//     '\t\t\t\t\t\t\t<style>\n' +
//     '\t\t\t\t\t\t\t\t.img_menu ul li#img_menu_li{width:80px;position:relative;}\n' +
//     '\t\t\t\t\t\t\t\t#img_show_menu{\n' +
//     '\t\t\t\t\t\t\t\t\twidth:100px;\n' +
//     '\t\t\t\t\t\t\t\t\theight:auto;\n' +
//     '\t\t\t\t\t\t\t\t\tbackground:#fff;\n' +
//     '\t\t\t\t\t\t\t\t\tborder:1px #d0d0d0 solid;\n' +
//     '\t\t\t\t\t\t\t\t\tborder-radius:10px;\n' +
//     '\t\t\t\t\t\t\t\t\tposition:absolute;\n' +
//     '\t\t\t\t\t\t\t\t\ttop:18px;\n' +
//     '\t\t\t\t\t\t\t\t\tleft:0px;\n' +
//     '\t\t\t\t\t\t\t\t\tz-index:9999;\n' +
//     '\t\t\t\t\t\t\t\t}\n' +
//     '\t\t\t\t\t\t\t\t#img_show_menu ul{\n' +
//     '\t\t\t\t\t\t\t\t\tfloat:none;\n' +
//     '\t\t\t\t\t\t\t\t\tmargin:5px 0px;\n' +
//     '\t\t\t\t\t\t\t\t}\n' +
//     '\t\t\t\t\t\t\t\t#img_show_menu ul li{\n' +
//     '\t\t\t\t\t\t\t\t\twidth:100px;\n' +
//     '\t\t\t\t\t\t\t\t\theight:24px;\n' +
//     '\t\t\t\t\t\t\t\t\tmargin-left:0px;\n' +
//     '\t\t\t\t\t\t\t\t\tfloat:none;\n' +
//     '\t\t\t\t\t\t\t\t}\n' +
//     '\t\t\t\t\t\t\t\t#img_show_menu ul li a{\n' +
//     '\t\t\t\t\t\t\t\t\tfont:12px/24px "Microsoft Yahei";\n' +
//     '\t\t\t\t\t\t\t\t\tcolor:#666666;\n' +
//     '\t\t\t\t\t\t\t\t\ttext-align:center;\n' +
//     '\t\t\t\t\t\t\t\t\tborder:none;\n' +
//     '\t\t\t\t\t\t\t\t\tborder-radius:0px;\n' +
//     '\t\t\t\t\t\t\t\t}\n' +
//     '\t\t\t\t\t\t\t\t#img_show_menu ul li a:hover{\n' +
//     '\t\t\t\t\t\t\t\t\tbackground:#ccc;\n' +
//     '\t\t\t\t\t\t\t\t}\n' +
//     '\t\t\t\t\t\t\t</style>\n' +
//     '\t\t\t\t\t\t\t<script>\n' +
//     '\t\t\t\t\t\t\t\t//个人信息维护下拉菜单样式\n' +
//     '\t\t\t\t\t\t\t\t$(function () {\n' +
//     '\t\t\t\t\t\t\t\t\t//个人信息维护下拉菜单\n' +
//     '\t\t\t\t\t\t\t\t\t$("#img_show_menu").hide();\n' +
//     '\t\t\t\t\t\t\t\t\t$("#img_menu_li").hover(function () {\n' +
//     '\t\t\t\t\t\t\t\t\t\t$("#img_show_menu").show();\n' +
//     '\t\t\t\t\t\t\t\t\t}, function () {\n' +
//     '\t\t\t\t\t\t\t\t\t\t$("#img_show_menu").hide();\n' +
//     '\t\t\t\t\t\t\t\t\t})\n' +
//     '\t\t\t\t\t\t\t\t\t// 鼠标移动到img_show_menu 的div上的时候img_show_menu div不会被隐藏\n' +
//     '\t\t\t\t\t\t\t\t\t$("#img_show_menu").hover(function () {\n' +
//     '\t\t\t\t\t\t\t\t\t\t$("#img_show_menu").show();\n' +
//     '\t\t\t\t\t\t\t\t\t}, function () {\n' +
//     '\t\t\t\t\t\t\t\t\t\t$("#img_show_menu").hide();\n' +
//     '\t\t\t\t\t\t\t\t\t})\n' +
//     '\n' +
//     '\t\t\t\t\t\t\t\t});\n' +
//     '\t\t\t\t\t\t\t\tfunction clearLoginCookie() {\n' +
//     '\t\t\t\t\t\t\t\t\tdocument.cookie = "avatar"+"=;expires="+(new Date(0)).toGMTString();\n' +
//     '\t\t\t\t\t\t\t\t\tdocument.cookie = "id"+"=;expires="+(new Date(0)).toGMTString();\n' +
//     '\t\t\t\t\t\t\t\t\tdocument.cookie = "username"+"=;expires="+(new Date(0)).toGMTString();\n' +
//     '\t\t\t\t\t\t\t\t}\n' +
//     '\t\t\t\t\t\t\t</script>\n' +
//     '\t\t\t\t\t\t\t<div class="img_menu">\n' +
//     '\t\t\t\t\t\t\t\t<ul class="img_menu_ul">\n' +
//     '\t\t\t\t\t\t\t\t\t<li id="img_menu_li">\n' +
//     '\t\t\t\t\t\t\t\t\t\t<a href="userdata.html"><img id="img-avatar1" src="../../images/index/user.jpg" class="top_img" /></a>\n' +
//     '\t\t\t\t\t\t\t\t\t\t<div id="img_show_menu" style="display: none">\n' +
//     '\t\t\t\t\t\t\t\t\t\t\t<ul>\n' +
//     '\t\t\t\t\t\t\t\t\t\t\t\t<li><a href="password.html">修改密码</a></li>\n' +
//     '\t\t\t\t\t\t\t\t\t\t\t\t<li><a href="userdata.html">个人资料</a></li>\n' +
//     '\t\t\t\t\t\t\t\t\t\t\t\t<li><a href="upload.html">上传头像</a></li>\n' +
//     '\t\t\t\t\t\t\t\t\t\t\t\t<li><a href="address.html">收货管理</a></li>\n' +
//     '\t\t\t\t\t\t\t\t\t\t\t\t<li><a href="login.html" onclick="clearLoginCookie()">退出登录</a></li>\n' +
//     '\t\t\t\t\t\t\t\t\t\t\t</ul>\n' +
//     '\t\t\t\t\t\t\t\t\t\t</div>\n' +
//     '\t\t\t\t\t\t\t\t\t</li>\n' +
//     '\t\t\t\t\t\t\t\t</ul>\n' +
//     '\t\t\t\t\t\t\t</div>\n' +
//     '\t\t\t\t\t\t</li>\n' +
//     '\t\t\t\t\t</ul>\n' +
//     '\t\t\t\t</div>\n' +
//     '\t\t\t</div>\n' +
//     '\t\t</header>\n' +
//     '\t\t<!--导航 -->\n' +
//     '\t\t<!--分割导航和顶部-->\n' +
//     '\t\t<div class="row top-nav">\n' +
//     '\t\t\t<div class="col-md-6">\n' +
//     '\t\t\t\t<ul class="nav nav-pills">\n' +
//     '\t\t\t\t\t<li>\n' +
//     '\t\t\t\t\t\t<a href="#"></a>\n' +
//     '\t\t\t\t\t</li>\n' +
//     '\t\t\t\t\t<li class="active"><a href="index.html"><span class="fa fa-home"></span></a></li>\n' +
//     '\t\t\t\t</ul>\n' +
//     '\t\t\t</div>\n' +
//     '\t\t\t<div class="col-md-6">\n' +
//     '\t\t\t\t<form action="search.html" class="form-inline pull-right" role="form">\n' +
//     '\t\t\t\t\t<div class="form-group">\n' +
//     '\t\t\t\t\t\t<input type="text" class="form-control" id="search" name="search" placeholder="请输入商品名称进行搜索">\n' +
//     '\t\t\t\t\t</div>\n' +
//     '\t\t\t\t\t<button type="submit" class="btn btn-default btn-sm"><span class="fa fa-search"></span></button>\n' +
//     '\t\t\t\t</form>\n' +
//     '\t\t\t</div>\n' +
//     '\t\t</div>\n' +
//     '\t\t<!--头部结束-->';

var top_html = '<header class="header">\n' +
    '\t\t\t<!--学子商城logo-->\n' +
    '\t\t\t<div class="row">\n' +
    '\t\t\t\t<div class="col-md-3">\n' +
    '\t\t\t\t\t<a href="index.html">\n' +
    '\t\t\t\t\t\t<img src="../../images/index/stumalllogo.png" />\n' +
    '\t\t\t\t\t</a>\n' +
    '\t\t\t\t</div>\n' +
    '\t\t\t\t<!--快捷选项-->\n' +
    '\t\t\t\t<div class="col-md-9 top-item">\n' +
    '\t\t\t\t\t<ul class="list-inline pull-right">\n' +
    '\t\t\t\t\t\t<li><a href="favorites.html"><span class="fa fa-heart"></span>&nbsp;收藏</a></li>\n' +
    '\t\t\t\t\t\t<li class="li-split">|</li>\n' +
    '\t\t\t\t\t\t<li><a href="orders.html"><span class="fa fa-file-text"></span>&nbsp;订单</a></li>\n' +
    '\t\t\t\t\t\t<li class="li-split">|</li>\n' +
    '\t\t\t\t\t\t<li><a href="cart.html"><span class="fa fa-cart-plus"></span>&nbsp;购物车</a></li>\n' +
    '\t\t\t\t\t\t<li class="li-split">|</li>\n' +
    '\t\t\t\t\t\t<li>\n' +
    '\t\t\t\t\t\t\t<style>\n' +
    '\t\t\t\t\t\t\t\t.img_menu ul li#img_menu_li{width:80px;position:relative;}\n' +
    '\t\t\t\t\t\t\t\t#img_show_menu{\n' +
    '\t\t\t\t\t\t\t\t\twidth:100px;\n' +
    '\t\t\t\t\t\t\t\t\theight:auto;\n' +
    '\t\t\t\t\t\t\t\t\tbackground:#fff;\n' +
    '\t\t\t\t\t\t\t\t\tborder:1px #d0d0d0 solid;\n' +
    '\t\t\t\t\t\t\t\t\tborder-radius:10px;\n' +
    '\t\t\t\t\t\t\t\t\tposition:absolute;\n' +
    '\t\t\t\t\t\t\t\t\ttop:18px;\n' +
    '\t\t\t\t\t\t\t\t\tleft:0px;\n' +
    '\t\t\t\t\t\t\t\t\tz-index:9999;\n' +
    '\t\t\t\t\t\t\t\t}\n' +
    '\t\t\t\t\t\t\t\t#img_show_menu ul{\n' +
    '\t\t\t\t\t\t\t\t\tfloat:none;\n' +
    '\t\t\t\t\t\t\t\t\tmargin:5px 0px;\n' +
    '\t\t\t\t\t\t\t\t}\n' +
    '\t\t\t\t\t\t\t\t#img_show_menu ul li{\n' +
    '\t\t\t\t\t\t\t\t\twidth:100px;\n' +
    '\t\t\t\t\t\t\t\t\theight:24px;\n' +
    '\t\t\t\t\t\t\t\t\tmargin-left:0px;\n' +
    '\t\t\t\t\t\t\t\t\tfloat:none;\n' +
    '\t\t\t\t\t\t\t\t}\n' +
    '\t\t\t\t\t\t\t\t#img_show_menu ul li a{\n' +
    '\t\t\t\t\t\t\t\t\tfont:12px/24px "Microsoft Yahei";\n' +
    '\t\t\t\t\t\t\t\t\tcolor:#666666;\n' +
    '\t\t\t\t\t\t\t\t\ttext-align:center;\n' +
    '\t\t\t\t\t\t\t\t\tborder:none;\n' +
    '\t\t\t\t\t\t\t\t\tborder-radius:0px;\n' +
    '\t\t\t\t\t\t\t\t}\n' +
    '\t\t\t\t\t\t\t\t#img_show_menu ul li a:hover{\n' +
    '\t\t\t\t\t\t\t\t\tbackground:#ccc;\n' +
    '\t\t\t\t\t\t\t\t}\n' +
    '\t\t\t\t\t\t\t</style>\n' +
    '\t\t\t\t\t\t\t<script>\n' +
    '\t\t\t\t\t\t\t\t//个人信息维护下拉菜单样式\n' +
    '\t\t\t\t\t\t\t\t$(function () {\n' +
    '\t\t\t\t\t\t\t\t\t//个人信息维护下拉菜单\n' +
    '\t\t\t\t\t\t\t\t\t$("#img_show_menu").hide();\n' +
    '\t\t\t\t\t\t\t\t\t$("#img_menu_li").hover(function () {\n' +
    '\t\t\t\t\t\t\t\t\t\t$("#img_show_menu").show();\n' +
    '\t\t\t\t\t\t\t\t\t}, function () {\n' +
    '\t\t\t\t\t\t\t\t\t\t$("#img_show_menu").hide();\n' +
    '\t\t\t\t\t\t\t\t\t})\n' +
    '\t\t\t\t\t\t\t\t\t// 鼠标移动到img_show_menu 的div上的时候img_show_menu div不会被隐藏\n' +
    '\t\t\t\t\t\t\t\t\t$("#img_show_menu").hover(function () {\n' +
    '\t\t\t\t\t\t\t\t\t\t$("#img_show_menu").show();\n' +
    '\t\t\t\t\t\t\t\t\t}, function () {\n' +
    '\t\t\t\t\t\t\t\t\t\t$("#img_show_menu").hide();\n' +
    '\t\t\t\t\t\t\t\t\t})\n' +
    '\n' +
    '\t\t\t\t\t\t\t\t});\n' +
    '\t\t\t\t\t\t\t\tfunction clearLoginCookie() {\n' +
    '\t\t\t\t\t\t\t\t\tdocument.cookie = "avatar"+"=;expires="+(new Date(0)).toGMTString();\n' +
    '\t\t\t\t\t\t\t\t\tdocument.cookie = "id"+"=;expires="+(new Date(0)).toGMTString();\n' +
    '\t\t\t\t\t\t\t\t\tdocument.cookie = "username"+"=;expires="+(new Date(0)).toGMTString();\n' +
    '\t\t\t\t\t\t\t\t}\n' +
    '\t\t\t\t\t\t\t</script>\n' +
    '\t\t\t\t\t\t\t<div class="img_menu">\n' +
    '\t\t\t\t\t\t\t\t<ul class="img_menu_ul">\n' +
    '\t\t\t\t\t\t\t\t\t<li id="img_menu_li">\n' +
    '\t\t\t\t\t\t\t\t\t\t<a href="userdata.html"><img id="img-avatar1" src="../../images/index/user.jpg" class="top_img" /></a>\n' +
    '\t\t\t\t\t\t\t\t\t\t<div id="img_show_menu" style="display: none">\n' +
    '\t\t\t\t\t\t\t\t\t\t\t<ul>\n' +
    '\t\t\t\t\t\t\t\t\t\t\t\t<li><a href="password.html">修改密码</a></li>\n' +
    '\t\t\t\t\t\t\t\t\t\t\t\t<li><a href="userdata.html">个人资料</a></li>\n' +
    '\t\t\t\t\t\t\t\t\t\t\t\t<li><a href="upload.html">上传头像</a></li>\n' +
    '\t\t\t\t\t\t\t\t\t\t\t\t<li><a href="address.html">收货管理</a></li>\n' +
    '\t\t\t\t\t\t\t\t\t\t\t\t<li><a href="login.html" onclick="clearLoginCookie()">退出登录</a></li>\n' +
    '\t\t\t\t\t\t\t\t\t\t\t</ul>\n' +
    '\t\t\t\t\t\t\t\t\t\t</div>\n' +
    '\t\t\t\t\t\t\t\t\t</li>\n' +
    '\t\t\t\t\t\t\t\t</ul>\n' +
    '\t\t\t\t\t\t\t</div>\n' +
    '\t\t\t\t\t\t</li>\n' +
    '\t\t\t\t\t</ul>\n' +
    '\t\t\t\t</div>\n' +
    '\t\t\t</div>\n' +
    '\t\t</header>\n' +
    '\t\t<!--导航 -->\n' +
    '\t\t<!--分割导航和顶部-->\n' +
    '\t\t<div class="row top-nav">\n' +
    '\t\t\t<div class="col-md-6">\n' +
    '\t\t\t\t<ul class="nav nav-pills">\n' +
    '\t\t\t\t\t<li>\n' +
    '\t\t\t\t\t\t<a href="#"></a>\n' +
    '\t\t\t\t\t</li>\n' +
    '\t\t\t\t\t<li class="active"><a href="index.html"><span class="fa fa-home"></span></a></li>\n' +
    '\t\t\t\t\t<li><a href="productList.html"><span>农场租赁</span></a></li>\n' +
    '\t\t\t\t\t<li><a href="productList.html"><span>农产品</span></a></li>\n' +
    '\t\t\t\t</ul>\n' +
    '\t\t\t</div>\n' +
    '\t\t\t<div class="col-md-6">\n' +
    '\t\t\t\t<form action="search.html" class="form-inline pull-right" role="form">\n' +
    '\t\t\t\t\t<div class="form-group">\n' +
    '\t\t\t\t\t\t<input type="text" class="form-control" id="search" name="search" placeholder="请输入商品名称进行搜索">\n' +
    '\t\t\t\t\t</div>\n' +
    '\t\t\t\t\t<button type="submit" class="btn btn-default btn-sm"><span class="fa fa-search"></span></button>\n' +
    '\t\t\t\t</form>\n' +
    '\t\t\t</div>\n' +
    '\t\t</div>\n' +
    '\t\t<!--头部结束-->';


var top_html_business = '<header class="header">\n' +
    '\t\t\t<!--学子商城logo-->\n' +
    '\t\t\t<div class="row">\n' +
    '\t\t\t\t<div class="col-md-3">\n' +
    '\t\t\t\t\t<a href="index.html">\n' +
    '\t\t\t\t\t\t<img src="../../images/index/stumalllogo.png" />\n' +
    '\t\t\t\t\t</a>\n' +
    '\t\t\t\t</div>\n' +
    '\t\t\t\t<!--快捷选项-->\n' +
    '\t\t\t\t<div class="col-md-9 top-item">\n' +
    '\t\t\t\t\t<ul class="list-inline pull-right">\n' +
    '\t\t\t\t\t\t<li>\n' +
    '\t\t\t\t\t\t\t<style>\n' +
    '\t\t\t\t\t\t\t\t.img_menu ul li#img_menu_li{width:80px;position:relative;}\n' +
    '\t\t\t\t\t\t\t\t#img_show_menu{\n' +
    '\t\t\t\t\t\t\t\t\twidth:100px;\n' +
    '\t\t\t\t\t\t\t\t\theight:auto;\n' +
    '\t\t\t\t\t\t\t\t\tbackground:#fff;\n' +
    '\t\t\t\t\t\t\t\t\tborder:1px #d0d0d0 solid;\n' +
    '\t\t\t\t\t\t\t\t\tborder-radius:10px;\n' +
    '\t\t\t\t\t\t\t\t\tposition:absolute;\n' +
    '\t\t\t\t\t\t\t\t\ttop:18px;\n' +
    '\t\t\t\t\t\t\t\t\tleft:0px;\n' +
    '\t\t\t\t\t\t\t\t\tz-index:9999;\n' +
    '\t\t\t\t\t\t\t\t}\n' +
    '\t\t\t\t\t\t\t\t#img_show_menu ul{\n' +
    '\t\t\t\t\t\t\t\t\tfloat:none;\n' +
    '\t\t\t\t\t\t\t\t\tmargin:5px 0px;\n' +
    '\t\t\t\t\t\t\t\t}\n' +
    '\t\t\t\t\t\t\t\t#img_show_menu ul li{\n' +
    '\t\t\t\t\t\t\t\t\twidth:100px;\n' +
    '\t\t\t\t\t\t\t\t\theight:24px;\n' +
    '\t\t\t\t\t\t\t\t\tmargin-left:0px;\n' +
    '\t\t\t\t\t\t\t\t\tfloat:none;\n' +
    '\t\t\t\t\t\t\t\t}\n' +
    '\t\t\t\t\t\t\t\t#img_show_menu ul li a{\n' +
    '\t\t\t\t\t\t\t\t\tfont:12px/24px "Microsoft Yahei";\n' +
    '\t\t\t\t\t\t\t\t\tcolor:#666666;\n' +
    '\t\t\t\t\t\t\t\t\ttext-align:center;\n' +
    '\t\t\t\t\t\t\t\t\tborder:none;\n' +
    '\t\t\t\t\t\t\t\t\tborder-radius:0px;\n' +
    '\t\t\t\t\t\t\t\t}\n' +
    '\t\t\t\t\t\t\t\t#img_show_menu ul li a:hover{\n' +
    '\t\t\t\t\t\t\t\t\tbackground:#ccc;\n' +
    '\t\t\t\t\t\t\t\t}\n' +
    '\t\t\t\t\t\t\t</style>\n' +
    '\t\t\t\t\t\t\t<script>\n' +
    '\t\t\t\t\t\t\t\t//个人信息维护下拉菜单样式\n' +
    '\t\t\t\t\t\t\t\t$(function () {\n' +
    '\t\t\t\t\t\t\t\t\t//个人信息维护下拉菜单\n' +
    '\t\t\t\t\t\t\t\t\t$("#img_show_menu").hide();\n' +
    '\t\t\t\t\t\t\t\t\t$("#img_menu_li").hover(function () {\n' +
    '\t\t\t\t\t\t\t\t\t\t$("#img_show_menu").show();\n' +
    '\t\t\t\t\t\t\t\t\t}, function () {\n' +
    '\t\t\t\t\t\t\t\t\t\t$("#img_show_menu").hide();\n' +
    '\t\t\t\t\t\t\t\t\t})\n' +
    '\t\t\t\t\t\t\t\t\t// 鼠标移动到img_show_menu 的div上的时候img_show_menu div不会被隐藏\n' +
    '\t\t\t\t\t\t\t\t\t$("#img_show_menu").hover(function () {\n' +
    '\t\t\t\t\t\t\t\t\t\t$("#img_show_menu").show();\n' +
    '\t\t\t\t\t\t\t\t\t}, function () {\n' +
    '\t\t\t\t\t\t\t\t\t\t$("#img_show_menu").hide();\n' +
    '\t\t\t\t\t\t\t\t\t})\n' +
    '\n' +
    '\t\t\t\t\t\t\t\t});\n' +
    '\t\t\t\t\t\t\t\tfunction clearLoginCookie() {\n' +
    '\t\t\t\t\t\t\t\t\tdocument.cookie = "avatar"+"=;expires="+(new Date(0)).toGMTString();\n' +
    '\t\t\t\t\t\t\t\t\tdocument.cookie = "id"+"=;expires="+(new Date(0)).toGMTString();\n' +
    '\t\t\t\t\t\t\t\t\tdocument.cookie = "username"+"=;expires="+(new Date(0)).toGMTString();\n' +
    '\t\t\t\t\t\t\t\t}\n' +
    '\t\t\t\t\t\t\t</script>\n' +
    '\t\t\t\t\t\t\t<div class="img_menu">\n' +
    '\t\t\t\t\t\t\t\t<ul class="img_menu_ul">\n' +
    '\t\t\t\t\t\t\t\t\t<li id="img_menu_li">\n' +
    '\t\t\t\t\t\t\t\t\t\t<a href="businessdata.html"><img id="img-avatar1" src="../../images/index/user.jpg" class="top_img" /></a>\n' +
    '\t\t\t\t\t\t\t\t\t\t<div id="img_show_menu" style="display: none">\n' +
    '\t\t\t\t\t\t\t\t\t\t\t<ul>\n' +
    '\t\t\t\t\t\t\t\t\t\t\t\t<li><a href="password.html">修改密码</a></li>\n' +
    '\t\t\t\t\t\t\t\t\t\t\t\t<li><a href="businessdata.html">个人资料</a></li>\n' +
    '\t\t\t\t\t\t\t\t\t\t\t\t<li><a href="upload.html">上传头像</a></li>\n' +
    '\t\t\t\t\t\t\t\t\t\t\t\t<li><a href="myproducts.html">订单管理</a></li>\n' +
    '\t\t\t\t\t\t\t\t\t\t\t\t<li><a href="myproducts.html">租赁管理</a></li>\n' +
    '\t\t\t\t\t\t\t\t\t\t\t\t<li><a href="myproducts.html">产品管理</a></li>\n' +
    '\t\t\t\t\t\t\t\t\t\t\t\t<li><a href="login.html" onclick="clearLoginCookie()">退出登录</a></li>\n' +
    '\t\t\t\t\t\t\t\t\t\t\t</ul>\n' +
    '\t\t\t\t\t\t\t\t\t\t</div>\n' +
    '\t\t\t\t\t\t\t\t\t</li>\n' +
    '\t\t\t\t\t\t\t\t</ul>\n' +
    '\t\t\t\t\t\t\t</div>\n' +
    '\t\t\t\t\t\t</li>\n' +
    '\t\t\t\t\t</ul>\n' +
    '\t\t\t\t</div>\n' +
    '\t\t\t</div>\n' +
    '\t\t</header>\n' +
    '\t\t<!--导航 -->\n' +
    '\t\t<!--分割导航和顶部-->\n' +
    '\t\t<div class="row top-nav">\n' +
    '\t\t\t<div class="col-md-6">\n' +
    '\t\t\t\t<ul class="nav nav-pills">\n' +
    '\t\t\t\t\t<li>\n' +
    '\t\t\t\t\t\t<a href="#"></a>\n' +
    '\t\t\t\t\t</li>\n' +
    '\t\t\t\t\t<li class="active"><a href="index.html"><span class="fa fa-home"></span></a></li>\n' +
    '\t\t\t\t\t<li><a href="productList.html"><span>农场租赁</span></a></li>\n' +
    '\t\t\t\t\t<li><a href="productList.html"><span>农产品</span></a></li>\n' +
    '\t\t\t\t</ul>\n' +
    '\t\t\t</div>\n' +
    '\t\t\t<div class="col-md-6">\n' +
    '\t\t\t\t<form action="search.html" class="form-inline pull-right" role="form">\n' +
    '\t\t\t\t\t<div class="form-group">\n' +
    '\t\t\t\t\t\t<input type="text" class="form-control" id="search" name="search" placeholder="请输入商品名称进行搜索">\n' +
    '\t\t\t\t\t</div>\n' +
    '\t\t\t\t\t<button type="submit" class="btn btn-default btn-sm"><span class="fa fa-search"></span></button>\n' +
    '\t\t\t\t</form>\n' +
    '\t\t\t</div>\n' +
    '\t\t</div>\n' +
    '\t\t<!--头部结束-->';