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
        
        <title>成績查詢</title>
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
    <div class="container"  style="margin-top: 30px;">
        <div class="row">
            <h2>成績查詢</h2>
            <div class="col-12" style="margin-top: 30px;">
                <div class="card">
                    <div class="card-body p-0">
                        <div class="row p-5">
                            <div class="col-md-6">
                                <h4 class="font-weight-bold mb-4">Student Information</h4>
                                <p class="mb-1">姓名：${scores.student.name}</p>
                                <p class="mb-1">學號：${scores.student.id}</p>
                                <p class="mb-1">班級：${scores.student.classNo}</p>
                            </div>
                            <div class="col-md-6 text-right">
                                <p class="font-weight-bold mb-4">Payment Details</p>
                            </div>
                        </div>
                        <div class="row p-5">
                            <div class="col-md-12">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th class="border-0 text-uppercase small font-weight-bold">編號</th>
                                            <th class="border-0 text-uppercase small font-weight-bold">科目名稱</th>
                                            <th class="border-0 text-uppercase small font-weight-bold">期中考成績</th>
                                            <th class="border-0 text-uppercase small font-weight-bold">期末考成績</th>
                                            <th class="border-0 text-uppercase small font-weight-bold">學期總成績</th>
                                            <th class="border-0 text-uppercase small font-weight-bold">排名</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <#list scores.list as score>
                                            <tr>
                                                <td>${score_index}</td>
                                                <td>${score.subject}</td>
                                                <td>${score.mid}</td>
                                                <td>${score.fin}</td>
                                                <td>${score.total}</td>
                                                <td>${score.rank}</td>
                                            </tr>
                                        </#list>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="d-flex flex-row-reverse bg-dark text-white p-4">
                            <div class="py-3 px-5 text-right">
                                <div class="mb-2">Grand Total</div>
                                <div class="h2 font-weight-light">$234,234</div>
                            </div>
    
                            <div class="py-3 px-5 text-right">
                                <div class="mb-2">Discount</div>
                                <div class="h2 font-weight-light">10%</div>
                            </div>
    
                            <div class="py-3 px-5 text-right">
                                <div class="mb-2">Sub - Total amount</div>
                                <div class="h2 font-weight-light">$32,432</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    </body>
</html>
