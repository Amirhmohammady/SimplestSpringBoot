<!DOCTYPE html>
<html>
<body>

<div id="demo">
    <h2>The XMLHttpRequest Object</h2>
    <button type="button" onclick="loadDoc()">Change Content</button>
</div>

<script>
    function loadDoc() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                let obj01 = JSON.parse(this.responseText);
                if (obj01[0].isPassCorrect == true)
                document.getElementById("demo").innerHTML = obj01[0].message;
            }
        };
        xhttp.open("GET", "${pageContext.request.contextPath}/ajaxrequest", true);
		<%-- ${request.contextPath}
		${req.requestURL}
		${object.linkUrl}
		${pageContext.request.contextPath} --%>
        xhttp.send();
    }
</script>

</body>
</html>