<html>
	<head>
		<meta charset="UTF-8"/>
		<title>springboot整合freemarker</title>
	</head>
	<body>
	<h1>${date?datetime}</h1>
		<table boder="1">
			<tr>
				<th>年龄</th>
				<th>姓名</th>
				<th>性别</th>
			</tr>
			<#list list as user>
				<tr>
					<th>${user.age}</th>
					<th>${user.name}</th>
					<th>${user.sex}</th>
				</tr>
			</#list>
		</table>
	</body>
</html>