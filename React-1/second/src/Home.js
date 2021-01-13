
import React from 'react';
import {useHistory} from 'react-router-dom';
const Home = () =>{
    const history = useHistory();
    const navigate = () =>{
        history.push("/");
    }
    return(
        <div>
            <h1>home Page</h1>
            <button onClick={()=>navigate()}>Go to login</button>

        </div>
    );
}
export default Home;