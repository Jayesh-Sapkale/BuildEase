import React from "react";
import ReactDOM from "react-dom";

import {
  BrowserRouter as Router,
  Route,
  Switch,
  Redirect,
} from "react-router-dom";

import "./style.css";
import NotFound1, { NotFound } from "./views/NotFound1";
import Home from "./views/home";
import AdminPortfolio from "./pages/AdminPortfolio";
import BuilderPortfolio from "./pages/BuilderPortfolio";
import Navbar from "./components/navbar"
const App = () => {
  return (
    <Router>
      
        <Navbar/>
      <Switch>
        <Route component={NotFound1} exact path="/NotFound1" />
        <Route component={Home} exact path="/" />
        <Route component={AdminPortfolio} exact path="/admin-portfolio" />
        <Route component={BuilderPortfolio} exact path="/builder" />
        <Route component={NotFound1} path="**" />
        <Redirect to="**" />
      </Switch>
    </Router>
  );
};

ReactDOM.render(<App />, document.getElementById("app"));   

