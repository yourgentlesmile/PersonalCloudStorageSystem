(function(factory){
    var glob;
    glob = window;
    glob.singleFileUpload = factory();
}(function(){
    //preliminary ideas
    //step 1 构造一个函数 参数为多文件数组集合，无返回值，函数名为MultiFileUpLoader
    //step 2 构造供MultiFileUpLoader调用的文件MD5值生成函数，参数为单文件对象(object),返回值为该文件对象的MD5值
    //wait wait wait, let us build a flow chart
    //A multiFileArray in -> set a grobal variable(current upload file index) -> send the current index object to the fileUpload function -> 
    // -> calculate a MD5 (use create MD5 function)
    // -> post MD5 to server -> if MD5 found in server -> change progress to 100% goto next file upload progress
    //                        | -> if MD5 not found -> send current file object to singleFileUpload function
    // -> when the progress finished goto the send the current index object to the fileUpload function step
    // end condition : when index == multiFileArray.lenth(), the loop will be exit, we achieve it~
    function progressEvent(evt){
        var percentage = document.getElementById("uploadValue");
        if(evt.lengthComputable){
            percentage.innerHTML = Math.round(evt.loaded / evt.total * 100) + "%";
        }
        
    };
    function uploadFail(evt){
        console.log("UploadFailed");
    };
    var xhr;
    var ot;
    var oloaded;
    function singleFileUpload(){
        
    }
    singleFileUpload.prototype.single = function (fileobj,url,filemd5,callback){
    	console.log("[DEBUG] In fileupload file name = " + fileobj.name);
        var form = new FormData();
        form.append("xc", fileobj);
        form.append("filemd5",filemd5);
        xhr = new XMLHttpRequest();
        xhr.open("POST", url, true);
        xhr.onload = callback;
        xhr.onerror = uploadFail;
        xhr.upload.onprogress = progressEvent;
        xhr.upload.onloadstart = function(){
            console.log("upload execute~");
        };
        xhr.send(form);
    };
    return singleFileUpload;
}));