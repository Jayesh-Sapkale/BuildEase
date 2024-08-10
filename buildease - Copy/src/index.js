import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter as Router, Route, Switch, Redirect } from 'react-router-dom';
import './style.css';
import NotFound1 from './views/NotFound1';
import Home from './views/home';
import User from './pages/UserOld'; // change
import Navbar from './components/navbar';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap-icons/font/bootstrap-icons.css';

const App = () => {
  return (
    <Router>
    <Navbar></Navbar>
      <Switch>
        <Route component={NotFound1} exact path="/NotFound1" />
        <Route component={Home} exact path="/" />
        <Route component={User} path="/User" /> {/* change */}
        <Route component={NotFound1} path="**" />
        <Redirect to="**" />
      </Switch>
    </Router>
  );
};

ReactDOM.render(<App />, document.getElementById('app'));
