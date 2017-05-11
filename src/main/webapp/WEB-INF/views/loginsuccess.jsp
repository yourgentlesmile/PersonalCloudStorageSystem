<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <link rel="stylesheet" href="resource/css/bootstrap.css" />
    <!-- <link rel="stylesheet" href="resource/css/bootstrap-theme.css" /> -->
    <style type="text/css">
        body{
        overflow:hidden;
        }
        .fonts{
            color: #A6B779;
        }
        .showposition{
            margin-top: 400px;
        }
        .col-center{
            float: none;
            display: block;
            margin-left: auto;
            margin-right: auto;
        }
        .imgdi div{
            border: 1px solid black;
            padding: 0px;
            border-radius: 50%;
            overflow: hidden;
          /*  color: #22313F;*/
        }
        .imgdi img{
            width: 100%;
        }
    </style>
    <body>
        <div style="position: absolute; overflow: hidden; width: 100%; height: 100%;" id="large-header" class="zuida"> 
            <canvas id="demo-canvas" width="1918px" height="1080px"></canvas> 
        </div>
        <div class="container-fluid fonts" style="border-bottom: 1px solid grey;">
            <div class="col-sm-2 col-sm-offset-6" style="text-align: right;" id="currentUser">当前用户:${username}</div>
            <div class="col-sm-2" style="padding-top:5px ;">
                <div class="progress" style="height: 10px;margin-bottom: 0;">
                    <div class="progress-bar progress-bar-info" style="width: ${percent};"></div>
                </div>
            </div>
                <span id="freeSpace"><strong>${usedspace}</strong> /${totalspace}</span>
            </div>
        </div>
        <div class="container showposition">
            <div class="col-center">
                <div class="row imgdi col-center">
                    <div class="col-sm-2" style="margin-left: 47.5px;">
                        <img src="resource/img/image.png"/>
                    </div>
                    <div class="col-sm-2 col-sm-offset-1">
                        <img src="resource/img/image.png"/>
                    </div>
                    <div class="col-sm-2 col-sm-offset-1">
                        <img src="resource/img/image.png"/>
                    </div>
                    <div class="col-sm-2 col-sm-offset-1">
                        <img src="resource/img/image.png"/>
                    </div>
                </div>
                <div class="row col-center" style="text-align: center;margin-top: 20px;font-size: 20px;font-family: '微软雅黑'; color: #A6B779;">
                    <div class="col-sm-2 " style="margin-left: 47.5px;">文件管理</div>
                    <div class="col-sm-2 col-sm-offset-1">权限管理</div>
                    <div class="col-sm-2 col-sm-offset-1">日志操作</div>
                    <div class="col-sm-2 col-sm-offset-1">个人交流</div>
                </div>
            </div>
        </div>
        <script type="text/javascript" src="resource/js/jquery-3.2.0.js" ></script>
        <script>
        $('body').css("height",window.innerHeight);
        </script>
        <script type="text/javascript" src="resource/js/bootstrap.js" ></script>
        <script type="text/javascript" src="resource/js/quietflow.min.js" ></script>
        <script type="text/javascript" src="resource/js/EasePack.min.js" ></script>
        <script type="text/javascript" src="resource/js/TweenLite.min.js" ></script>
        <script type="text/javascript" src="resource/js/demo-1.js" ></script>
        <script>
            var superLinkCollection=["filemanager","authoritymanager","logoperate","shortmessage"];
            $(".row.imgdi.col-center div").each(function(indexInArray,valueOfElement){
                $(valueOfElement).click(function(){
                    window.location=superLinkCollection[indexInArray]
                    });
            });
            $("body").quietflow({
                theme   : "simpleGradient",
                primary : "#22313F",
                accent  : "#000"
            });
        </script>
    </body>
</html>
