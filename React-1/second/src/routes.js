import React from 'react';
import {BrowserRouter as Router,Route, Switch} from 'react-router-dom';
import Login from './login';
import Home from './Home';
const Routes = () =>{
    return (
        <Router>
        <Switch>
            <Route exact path='/' component={Login}/>
            <Route path="/home" component={Home}/>
            
        </Switch>
    </Router>
    );
}
    
export default Routes;