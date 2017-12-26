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
    birthday: ${user.birthday?date}
    <br>
    created_date: ${user.created_date?date}
    <br>
    updated_date: ${user.updated_date?datetime}

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
            created_date<input type="text" name="created_date" value="${user.created_date?datetime}"/>
        </label>
        <br/>
		<input type="submit" value="提交"/>
	</form>





</body>

</html>
