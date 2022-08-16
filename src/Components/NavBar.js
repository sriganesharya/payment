import './HomePage.css';

export function NavBar() {
    return(
        <div>
            <nav className="navbar navbar-dark bg-dark">
                <div className="container">
                    <h2>PAYMENT SYSTEM</h2>
                    <a className="navbar-brand" id="item1" >Home</a>
                     <div className="dropdown">
                        <button className="btn  dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          <img src='/assets/images/profileimg.png' alt='profile image' />
                        </button>
                      </div>
                </div>
            </nav>
        </div>
    )
}