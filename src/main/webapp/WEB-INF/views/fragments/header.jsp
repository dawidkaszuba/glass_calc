<nav class="navbar navbar-dark bg-secondary navbar-expand-md">
    <style>
        .nav-item:hover, .navbar-toggler-icon, .dropdown-item:hover {
            background-color: lightgrey;
        }

    </style>

    <button class="navbar navbar-toggler" type="button" data-toggle="collapse" data-target="#mainMenu"><span class="navbar-toggler-icon"></span></button>
    <div class="collapse navbar-collapse" id="mainMenu">

        <ul class="navbar-nav">
            <li class="nav-item"><a class="nav-link text-dark active" href="/cms">Dash</a></li>
            <li class="nav-item dropdown">

                <a class="nav-link text-dark dropdown-toggle" href="#" data-toggle="dropdown" role="button">tile</a>

                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/tile/add">add tile</a>
                    <a class="dropdown-item" href="/tile/list">all tiles</a>
                </div>
            </li>
            <li class="nav-item dropdown">

                <a class="nav-link text-dark dropdown-toggle" href="#" data-toggle="dropdown" role="button">frames</a>

                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/frame/add">add frame</a>
                    <a class="dropdown-item" href="/frame/list">all frames</a>
                </div>
            </li>
            <li class="nav-item dropdown">

                <a class="nav-link text-dark dropdown-toggle" href="#" data-toggle="dropdown" role="button">gas</a>

                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/gas/add">add gas</a>
                    <a class="dropdown-item" href="/gas/list">all gasses</a>
                </div>
            </li>
            <li class="nav-item dropdown">

                <a class="nav-link text-dark dropdown-toggle" href="#" data-toggle="dropdown" role="button">coating</a>

                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/coating/add">add coating</a>
                    <a class="dropdown-item" href="/coating/list">all coatings</a>
                </div>
            </li>
            <li class="nav-item dropdown">

                <a class="nav-link text-dark dropdown-toggle" href="#" data-toggle="dropdown" role="button">foil</a>

                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/foil/add">add foil</a>
                    <a class="dropdown-item" href="/foil/list">all foils</a>
                </div>
            </li>
            <li class="nav-item dropdown">

                <a class="nav-link text-dark dropdown-toggle" href="#" data-toggle="dropdown" role="button">tile group</a>

                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/tileGroup/add">add tile group</a>
                    <a class="dropdown-item" href="/tileGroup/list">all tile groups</a>
                </div>
            </li>
            <li class="nav-item dropdown">

                <a class="nav-link text-dark dropdown-toggle" href="#" data-toggle="dropdown" role="button">base prices</a>

                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/basePrice2Tile/show">base price for 2-tile</a>
                    <a class="dropdown-item" href="/basePrice3Tile/show">base price for 3-tile</a>
                </div>
            </li>
            <li class="nav-item dropdown">

                <a class="nav-link text-dark dropdown-toggle" href="#" data-toggle="dropdown" role="button">standard glass prices</a>

                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/standardPrice2/show">std price for 2-tile</a>
                    <a class="dropdown-item" href="/standardPrice3/show">std price for 3-tile</a>
                </div>
            </li>
        </ul>

    </div>

</nav>