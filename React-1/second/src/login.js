
import React from 'react';
import {useHistory} from 'react-router-dom';
const Login = () =>{
    const history = useHistory();
    const navigate = () =>{
        history.push("/home");
    }
    return(
        <div>
            <h1>Login Page</h1>
            <button onClick={()=>navigate()}>Go to home</button>

        </div>
    );
}
export default Login;