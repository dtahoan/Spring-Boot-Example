<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<h1>Upload File Example</h1>
<form action="/files/upload" method="post" enctype="multipart/form-data">
	<input type="file" name="file" required="required">
	<button type="submit">Upload</button>
</form>
<p>Upload File Example - W3Stacks</p>