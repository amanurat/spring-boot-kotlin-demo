package com.truthbean.demo.core.model

/**
 * Created by TruthBean on 2016/3/16 0016.
 */

object ErrorPage {

    fun setError(name: String, content: String): String {

        /*"<!DOCTYPE html>\n" +
                "<html>\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\"/>\n" +
                    "    <title>错误页面</title>\n" +
                    "    <meta name=\"msapplication-TileColor\" content=\"#5bc0de\"/>\n" +
                    "    <link rel=\"stylesheet\" href=\"/webjars/bootstrap/3.3.6/css/bootstrap.min.css\"/>\n" +
                    "    <link rel=\"stylesheet\" href=\"/webjars/font-awesome/4.5.0/css/font-awesome.min.css\"/>\n" +
                    "</head>\n" +
                    "<body class=\"error\">\n" +
                        "<div class=\"container\">\n" +
                        "    <div class=\"col-lg-8 col-lg-offset-2 text-center\">\n" +
                        "        <div class=\"logo\">\n" +
                        "            <h1>error</h1>\n" +
                        "        </div>\n" +
                        "        <p >$name</p>\n" + "<!--<p>$content</p>-->"+
                        "        <div class=\"clearfix\"></div>\n" +
                        "        <div class=\"col-lg-6 col-lg-offset-3\">\n" +
                        "            <form action=\"index.html\">\n" +
                        "                <div class=\"input-group\">\n" +
                        "                    <input type=\"text\" placeholder=\"查询 ...\" class=\"form-control\" />\n" +
                        "                      <span class=\"input-group-btn\">\n" +
                        "                        <button class=\"btn btn-default\" type=\"button\"><i class=\"fa fa-search\"></i></button>\n" +
                        "                      </span>\n" +
                        "                </div>\n" +
                        "            </form>\n" +
                        "        </div>\n" +
                        "        <div class=\"clearfix\"></div>\n" +
                        "        <br />\n" +
                        "        <div class=\"col-lg-6 col-lg-offset-3\">\n" +
                        "               <div class=\"btn-group btn-group-justified\">\n" +
                        "                <a href=\"dashboard.html\" class=\"btn btn-info\">通知管理员</a>\n" +
                        "                <a href=\"index.html\" class=\"btn btn-warning\">返回主页</a>\n" +
                        "            </div>\n" +
                        "        </div>\n" +
                        "    </div>\n" +
                        "</div>\n" +
                    "</body>\n" +
                "</html>";*/

        return "<!DOCTYPE html>\n<html>\n<head>\n    <meta charset=\"UTF-8\"/>\n    <title>错误页面</title>\n    <meta name=\"msapplication-TileColor\" content=\"#5bc0de\"/>\n    <link rel=\"stylesheet\" href=\"/webjars/bootstrap/3.3.6/css/bootstrap.min.css\"/>\n    <link rel=\"stylesheet\" href=\"/webjars/font-awesome/4.5.0/css/font-awesome.min.css\"/>\n</head>\n<body class=\"error\">\n<div class=\"container\">\n    <div class=\"col-lg-8 col-lg-offset-2 text-center\">\n        <div class=\"logo\">\n            <h1>error</h1>\n        </div>\n        <p >$name</p>\n<!--<p>$content</p>-->        <div class=\"clearfix\"></div>\n        <div class=\"col-lg-6 col-lg-offset-3\">\n            <form action=\"index.html\">\n                <div class=\"input-group\">\n                    <input type=\"text\" placeholder=\"查询 ...\" class=\"form-control\" />\n                      <span class=\"input-group-btn\">\n                        <button class=\"btn btn-default\" type=\"button\"><i class=\"fa fa-search\"></i></button>\n                      </span>\n                </div>\n            </form>\n        </div>\n        <div class=\"clearfix\"></div>\n        <br />\n        <div class=\"col-lg-6 col-lg-offset-3\">\n               <div class=\"btn-group btn-group-justified\">\n                <a href=\"dashboard.html\" class=\"btn btn-info\">通知管理员</a>\n                <a href=\"index.html\" class=\"btn btn-warning\">返回主页</a>\n            </div>\n        </div>\n    </div>\n</div>\n</body>\n</html>";
    }
}