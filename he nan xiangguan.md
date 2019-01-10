#文件相关接口
##
## 1.文件上传
### 请求方式：post
### 请求地址：/court/external/files/singleUpload
### 请求类型：
### 请求说明：
### 使用场景：
### 参数说明: 
	|参数|值|是否必须|说明|
	|:--|:--|:--|:--|
	|caseCode|String|是|案件唯一标示|
	|fileName|String|否|文件名|
	|index|String|是|文件顺序|
    |directoryName|String|是|目录名称|
	|downloadUrl|String|是|文件下载地址|
### 请求示例：

	http://localhost:8088/court/external/files/singleUpload

### 请求参数：
	{
	    "caseCode": "10000000103442",
	    "fileName": "测试文件.jpg",
        "directoryName":"起诉书",
		"index":"1",
		"downloadUrl": "http://192.168.0.11:123........"
	}

### 返回结果
	{
	    "code": "0",
	    "message": "Success"
        "data":{
             "fileId":"1000372634376788",
		}
	}


### 结果说明
	|参数|值|说明|
	|:--|:--|:--|
	|code|String|返回码|
	|message|String|返回信息|
	|data|Object|返回内容|
	|fileId|String|文件唯一标示ID|

### 返回码说明
	|值|说明|
	|:--|:--|
	|0|成功|
	|1|失败|
	|2722|唯一标示为空|
	|2701|案件不存在|
	|2709|上传文件为空|


## 2.文件目录修改
### 请求方式：post
### 请求地址：/court/external/files/update
### 请求类型：
### 请求说明：
### 使用场景：
### 参数说明: 
	|参数|值|是否必须|说明|
	|:--|:--|:--|:--|
	|caseCode|String|是|案件唯一标示|
	|updateList|List|是|文件列表|
	|fileId|String|是|文件ID|
	|directoryName|String|是|目录名称|

### 请求示例：

	http://localhost:8088/court/external/files/update

### 请求参数：
	{
		"caseCode":"10000000103442",
        "updateList":
		[
		{
			"fileId":"1000372634376788",
			"directoryName":"起诉书"
		},
		{
			"fileId":"1003088832958756",
			"directoryName":"立案审批表"
		},
		...
	]}

### 结果说明
	|参数|值|说明|
	|:--|:--|:--|
	|code|String|返回码|
	|message|String|返回信息|

### 返回码说明
	|值|说明|
	|:--|:--|
	|0|成功|
	|1|失败|
	|2722|唯一标示为空|
	|2701|案件不存在|
	|3007|fileId为空|
	|1001|文件不存在|
	|2601|目录名称为空|
	|2609|目录不存在|
	



## 3.文件删除
### 请求方式：post
### 请求地址：/court/external/files/deleteFile
### 请求类型：
### 请求说明：
### 使用场景：
### 参数说明: 
	|参数|值|是否必须|说明|
	|:--|:--|:--|:--|
	|caseCode|String|是|案件唯一标示|
	|fileIdList|String[]|是|文件ID|

### 请求示例：

	http://localhost:8088/court/external/files/deleteFile

### 请求参数：
	{
        "caseCode":"10000000103442",
         "fileIdList":
        ["1000372634376788","1003088832958756"
		
		...
	]
    }

### 结果说明
	|参数|值|说明|
	|:--|:--|:--|
	|code|String|返回码|
	|message|String|返回信息|

### 返回码说明
	|值|说明|
	|:--|:--|
	|0|成功|
	|1|失败|
	|2722|唯一标示为空|
	|2701|案件不存在|
	|3007|fileId为空|
	|1001|文件不存在|









## 4.卷宗预览界面
### 请求方式：get
### 请求地址：/viewer/model/Preview/page.html
### 请求类型：
### 请求说明：
### 使用场景：
### 参数说明: 
	|参数|值|是否必须|说明|
	|:--|:--|:--|:--|
	|caseCode|String|是|案件唯一标示|

### 请求示例：

	http://localhost:8088/viewer/model/Preview/page.html?caseCode=3973806032384628
