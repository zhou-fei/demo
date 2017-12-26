<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 101 Template</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
Date: ${time?date}
<br>
Time: ${time?time}
<br>
Message: ${message}
<br>
name: ${user.name}
<br>
birthday: ${user.birthday?string('yyyy-MM-dd')}
<br>
createdDate: ${user.createdDate?string('yyyy-MM-dd HH:mm:ss')}
<br>
updatedDate: ${user.updatedDate?string('yyyy-MM-dd HH:mm:ss')}


<form method="post" action="/update">
    <div class="form-group">
        <label for="id">ID</label>
        <input type="text" class="form-control" id="id" placeholder="ID" name="id" value="1">
    </div>
    <div class="form-group">
        <label for="birthday">birthday</label>
        <input type="text" class="form-control" id="birthday" placeholder="birthday" name="birthday">
    </div>
    <div class="form-group">
        <label for="createdDate">createdDate</label>
        <input type="text" class="form-control" id="createdDate" placeholder="createdDate" name="createdDate"
               value="${user.createdDate?string('yyyy-MM-dd HH:mm:ss')}">
    </div>

    <button type="submit" class="btn btn-default">提交</button>
</form>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-3.2.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
