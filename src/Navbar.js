import { Link } from "react-router-dom";


export function Navbar() {
    return (
        <div style = {{"display" : "flex" , "gap": "2rem", "justifyContent" : "center"}}>
            <Link to = "/home">Home</Link>
            <Link to = "/customers">Customer</Link>
            <Link to = "/about">About</Link>
        </div>
    )
}