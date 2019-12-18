<script language="JavaScript" type="text/javascript">
    function CloseAndRefreshOK()
    {
        opener.location.reload(true);
        opener.location.assign("/delplan?del=true");
        self.close();
    }
    function CloseAndRefreshAbort()
    {
        opener.location.reload(true);
        opener.location.assign("/app/plan/list/");
        self.close();
    }
</script>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Zaplanuj Jedzonko</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"
          rel="stylesheet">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>
<body>
<div class="col-10 text-left"><h4>Czy na pewno chcesz usunąć plan?</h4></div>
<a href="/delplan?del=true" onclick="CloseAndRefreshOK(); return true" class="btn btn-info rounded-0 text-light m-1">OK</a>
<a onclick="CloseAndRefreshAbort(); return true" class="btn btn-warning rounded-0 text-light m-1">Anuluj</a>
</body>
</html>