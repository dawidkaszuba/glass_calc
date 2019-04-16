<nav class="navbar navbar-light bg-third navbar-expand-md">
    <style>
        .nav-item:hover, .navbar-toggler-icon, .dropdown-item:hover {
            background-color: dodgerblue;
        }

    </style>

    <button class="navbar navbar-toggler" type="button" data-toggle="collapse" data-target="#mainMenu"><span class="navbar-toggler-icon"></span></button>
    <div class="collapse navbar-collapse" id="mainMenu">

        <ul class="navbar-nav">
            <li class="nav-item"><a class="nav-link text-dark active" href="/">Home</a></li>
            <li class="nav-item dropdown">

                <a class="nav-link text-dark dropdown-toggle" href="#" data-toggle="dropdown" role="button">Two tiles glass</a>

                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/configurator2Tiles/add">new two tiles glass</a>
                    <a class="dropdown-item" href="/configurator2Tiles/list">my two tiles glass</a>
                </div>
            </li>
            <li class="nav-item dropdown">

                <a class="nav-link text-dark dropdown-toggle" href="#" data-toggle="dropdown" role="button">frames</a>

                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/configurator3Tiles/add">new three tiles glass</a>
                    <a class="dropdown-item" href="/configurator3Tiles/list">my three tiles glass</a>
                </div>
            </li>
        </ul>

    </div>

</nav>