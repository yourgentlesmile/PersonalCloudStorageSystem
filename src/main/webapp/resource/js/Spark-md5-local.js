function getFileMD5(fileobj,callback){
    file = fileobj;
    var fileReader = new FileReader(),
    blobSlice = File.prototype.mozSlice || File.prototype.webkitSlice || File.prototype.slice,
    //文件每块分割2M，计算分割详情
    chunkSize = 20971520,
    chunks = Math.ceil(file.size / chunkSize),
    currentChunk = 0,
    spark = new SparkMD5();
    fileReader.onload = function(e) {
        spark.appendBinary(e.target.result);
        currentChunk++;
        if(currentChunk < chunks) {
            loadNext();
        } else {
            callback(spark.end());
        }
    };
    function loadNext() {
        var start = currentChunk * chunkSize;
        end = start + chunkSize >= file.size ? file.size : start + chunkSize;
        fileReader.readAsBinaryString(blobSlice.call(file, start, end));
    }
    loadNext();
}
//function calculate(file,callBack){    
//      var fileReader = new FileReader();    
//      blobSlice = File.prototype.mozSlice || File.prototype.webkitSlice || File.prototype.slice;    
//      chunkSize = 20971520;
//      // read in chunks of 20MB    
//      chunks = Math.ceil(file.size / chunkSize);    
//      currentChunk = 0;    
//      spark = new SparkMD5();    
//      fileReader.onload = function(e) {    
//          spark.appendBinary(e.target.result); // append binary string    
//          currentChunk++;    
//          if (currentChunk < chunks) {    
//              loadNext();    
//          }    
//          else {    
//              callBack(spark.end());  
//          }    
//      };    
//      function loadNext() {    
//          var start = currentChunk * chunkSize;    
//          end = start + chunkSize >= file.size ? file.size : start + chunkSize;    
//          fileReader.readAsBinaryString(blobSlice.call(file, start, end));    
//      };    
//      loadNext();
//}