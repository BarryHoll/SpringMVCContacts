<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Contact</title>
</head>
<body>

<form:form commandName="insertUser" method="POST" action="insertJdbcContact.do" id="userdetailsid" >		
 
			<fieldset>
				<legend>Contact details</legend>
				<ol>
					<li>
						<label for=name>Name</label>
						<form:input path="name"  type="text" placeholder="First and last name" />
					</li>
					<li>
						<label for=dateOfBirth>Date of Birth</label>
					<form:input path="dateOfBirth" type="date" required="true" />
					</li>
					<li>
						<label for=emailAddress>Email</label>
						<form:input path="emailAddress" type="text" required="true" />
					</li>
					<li>
						<label for=phoneNumber>Phone</label>
						<form:input path="phoneNumber" type="text" required="true" />
					</li>
				</ol>
			</fieldset>
			<fieldset>
				<legend>User address</legend>
				<ol>
					<li>
 
						<label for=address>Address</label>
						<form:input path="address" type="text" required="true" />
					</li>
					<li>
						<label for=postCode>Post code</label>
						<form:input path="pinCode" type="text" required="true" />
					</li>
					<li>
						<label for=country>Country</label>
						<form:input path="country" type="text" required="true" />
					</li>
				</ol>
			</fieldset>
			<fieldset>
				<button type=submit>Save Contact Details!</button>
			</fieldset>
		</form:form>

</body>
</html>