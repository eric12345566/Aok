<!doctype html>
<html>
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <!-- Fonts -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" type="text/css" href="/assets/css/navbar.css" />
  <title>作業一覽</title>
</head>
<body>
  <nav class="main-navigation">
    <div class="navbar-header animated fadeInUp">
        <a class="navbar-brand" href="#">Logo Area</a>
    </div>
    <ul class="nav-list">
        <li class="nav-list-item">
            <a href="#" class="nav-link">Home</a>
        </li>
        <li class="nav-list-item">
            <a href="#" class="nav-link">About Us</a>
        </li>
        <li class="nav-list-item">
            <a href="#" class="nav-link">Blog</a>
        </li>
        <li class="nav-list-item">
            <a href="#" class="nav-link">Works</a>
        </li>
        <li class="nav-list-item">
            <a href="#" class="nav-link">Contact</a>
        </li>
    </ul>
</nav>
    <div class="container my-4">
      <h2>功課列表</h2>
        <p class="font-weight-bold">當週作業及代辦事項清單</p>
        <form name="form1" method="post" action="/homework">
        <ul class="list-group list-group-flush">
          <br>
          <#list dataList as ele> 
            <li class="list-group-item">
              <!-- Default checked -->
              <div class="custom-control custom-checkbox">
                <input type="checkbox" class="custom-control-input" id="${ele_index}" name="${ele_index}" value="${ele.homeWorkName}">
                <label class="custom-control-label" for="${ele_index}">${ele.homeWorkName}</label>
              </div>
              <br>
            </li>
          </#list>
        </ul>
        <br><br>
        <div>
          <button type="submit" class="btn btn-secondary">更新清單</button>
        </div>
        </form>
      </div>
    </body>
</html>
