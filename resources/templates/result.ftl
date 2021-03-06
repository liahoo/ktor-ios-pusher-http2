<#-- @ftlvariable name="data" type="com.fascode.IndexData" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta httpEquiv = "X-UA-Compatible" >
    <meta name="viewport" content="width=device-width, initial-scale=1">
<!--    <link rel="shortcut icon" href = "/static/images/favicon.ico" type = "image/x-icon">-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/all.css" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.3.0/css/flag-icon.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/5.0.1/css/fileinput.min.css" media="all" type="text/css" />
    <link rel="stylesheet" href="/static/css/style.css">
    <link rel="stylesheet" href="/static/css/bootstrap-select.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.3.1/jquery.min.js" type="text/javascript"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <title>
    Index
    </title>
    <script>
    </script>
</head>
<body>
    <ol class="breadcrumb">
        <li class="breadcrumb-item active">Pusher</li>
    </ol>
    <div class="container">
        <h3>Sent push notification to iOS device : </h3>
        <h2> {{token}}</h2>
        <h2>Result: {{result}}</h2>
    </div>
    <div class="container">
        <h2>Push Messages</h2>
        <form action="/push/message" method="post">
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">Device Token</span>
                </div>
                <input type="text" class="form-control" id="token" name="token" placeholder="Device Token" required="required">
            </div>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">Message</span>
                </div>
                <input type="text" class="form-control" id="message" name="message" placeholder="Message" required="required">
            </div>
            <button class="btn btn-primary btn-rounded waves-effect" type="submit">Send Message</button>
        </form>

        <h2>Uninstall checking</h2>
        <form action="/push/uninstall" method="post">
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">Device Token</span>
                </div>
                <input type="text" class="form-control" id="token" name="token" placeholder="Device Token" required="required">
            </div>
            <button class="btn btn-primary btn-rounded waves-effect" type="submit">Push for uninstall checking</button>
        </form>
    </div>
</body>
</html>
