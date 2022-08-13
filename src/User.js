import React from "react";

const User = (props) => {
    return(
        <div>
           <h2>Name : {props.firstName}</h2>
           <h2>Clan : {props.lastName} </h2>
           <h2>Contact me only if you are an uchiha : {props.email} </h2>
        </div>
    );
}

export default User;