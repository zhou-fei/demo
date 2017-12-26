<!DOCTYPE html>

<html lang="en">

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

	<form id="updateForm" method="post" action="/update">
        <label>
            ID<input type="text" name="id" value="1"/>
        </label>
        <br/>
        <label>
            birthday<input type="text" name="birthday" value="2017-01-01"/>
        </label>
        <br/>
        <label>
            createdDate<input type="text" name="createdDate" value="${user.createdDate?string('yyyy-MM-dd HH:mm:ss')}"/>
        </label>
        <br/>
		<input type="submit" value="提交"/>
	</form>
</body>

</html>
