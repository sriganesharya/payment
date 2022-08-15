import { Receiver } from "./Receiver";
import { Sender } from "./Sender";
import './HomePage.css';
import { NavBar } from "./NavBar";

export function HomePage() {
    return(
        <div>
            <NavBar />
            <Sender />
            <Receiver />
            <div className="row mt-5 text-center">
                <div className="col-lg-4"></div>
                <div className="col-lg-4">
                    <button className="btn btn-success" type="button" >Submit</button>
                </div>
            </div>
        </div>
    );
}