<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Zaplanuj Jedzonko - Kontakt</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"
          rel="stylesheet">
    <link href='<c:url value="/css/style.css"/>' rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>
<body>

<jsp:include page="header.jsp"/>

<div class="mt-4 ml-4 mr-4">
    <div class="row border-bottom border-3">
        <div class="col"><h3 class="color-header text-uppercase">Kontakt</h3></div>
    </div>

<section class="padding-large bg-light">
    <div id="carouselExampleControls" class="carousel slide main-slider" data-ride="carousel">
        <div class="carousel-inner container">
            <div class="carousel-item active">
                <div class="container w-75 d-flex">
                    <div class="carousel-caption d-block">
                        <div class="col-10 text-left"><h4> Lorem ipsum dolor sit amet,
                            consectetur adipiscing elit. Donec libero lorem, consectetur sed arcu non,
                            pretium imperdiet diam. Sed ultricies sagittis mi, at ultricies mi iaculis sed.
                            Morbi luctus elit et commodo ornare. Curabitur eu urna a sem lobortis porta.
                            Maecenas gravida augue vitae bibendum interdum. </h4></div>
                        <div class="col-4 text-left"><h4><a href="mailto:loremipsum@loremipsum.com">loremipsum@loremipsum.com</a></h4></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="footer.jsp"/>

</body>
</html>
