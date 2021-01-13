<!doctype html>
<html lang="en">
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
    <title>課表查詢</title>
    <script>
        $(document).ready(function() {
            $('[id^=detail-]').hide();
            $('.toggle').click(function() {
            $input = $( this );
            $target = $('#'+$input.attr('data-toggle'));
            $target.slideToggle();
        });
});
    </script>
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
    <div class="container">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">課表</h3>
            </div>
            <hr>
            <br>
            <ul class="list-group" style="margin-left: 50px;">
                <li class="list-group-item">
                    <div class="row toggle" id="dropdown-detail-1" data-toggle="detail-1">
                        <div class="col-md-10"> 星期一 </div>
                        <div class="col-md-2"><i class="fa fa-chevron-down fa-pull-right fa-border"></i></div>
                    </div>
                    <div id="detail-1">
                        <hr>
                        <div class="container">
                            <div class="fluid-row">
                                <#list data.week1 as w1> 
                                    <div class="col-xs-1">
                                        ${w1_index+1}
                                    </div>
                                    <div class="col-xs-5">
                                        ${w1.subjectName}
                                    </div>
                                </#list>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="list-group-item">
                    <dxiv class="row toggle" id="dropdown-detail-2" data-toggle="detail-2">
                        <div class="col-md-10">
                            星期二
                        </div>
                        <div class="col-md-2"><i class="fa fa-chevron-down fa-pull-right fa-border"></i></div>
                    </dxiv>
                    <div id="detail-2">
                        <hr>
                        <div class="container">
                            <div class="fluid-row">
                                <#list data.week2 as w2> 
                                    <div class="col-xs-1">
                                        ${w2_index+1}
                                    </div>
                                    <div class="col-xs-5">
                                        ${w2.subjectName}
                                    </div>
                                </#list>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="list-group-item">
                    <div class="row toggle" id="dropdown-detail-3" data-toggle="detail-3">
                        <div class="col-md-10">
                            星期三
                        </div>
                        <div class="col-md-2"><i class="fa fa-chevron-down fa-pull-right fa-border"></i></div>
                    </div>
                    <div id="detail-3">
                        <hr>
                        <div class="container">
                            <div class="fluid-row">
                                <#list data.week3 as w3> 
                                    <div class="col-xs-1">
                                        ${w3_index+1}
                                    </div>
                                    <div class="col-xs-5">
                                        ${w3.subjectName}
                                    </div>
                                </#list>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="list-group-item">
                    <div class="row toggle" id="dropdown-detail-4" data-toggle="detail-4">
                        <div class="col-md-10">
                            星期四
                        </div>
                        <div class="col-md-2"><i class="fa fa-chevron-down fa-pull-right fa-border"></i></div>
                    </div>
                    <div id="detail-4">
                        <hr>
                        <div class="container">
                            <div class="fluid-row">
                                <#list data.week4 as w4> 
                                    <div class="col-xs-1">
                                        ${w4_index+1}
                                    </div>
                                    <div class="col-xs-5">
                                        ${w4.subjectName}
                                    </div>
                                </#list>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="list-group-item">
                    <div class="row toggle" id="dropdown-detail-5" data-toggle="detail-5">
                        <div class="col-md-10">
                            星期五
                        </div>
                        <div class="col-md-2"><i class="fa fa-chevron-down fa-pull-right fa-border"></i></div>
                    </div>
                    <div id="detail-5">
                        <hr>
                        <div class="container">
                            <div class="fluid-row">
                                <#list data.week5 as w5> 
                                    <div class="col-xs-1">
                                        ${w5_index+1}
                                    </div>
                                    <div class="col-xs-5">
                                        ${w5.subjectName}
                                    </div>
                                </#list>
                            </div>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
    </body>
</html>
