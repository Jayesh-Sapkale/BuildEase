import React from "react";
import ReactDOM from "react-dom";
import {
  BrowserRouter as Router,
  Route,
  Switch,
  Redirect,
} from "react-router-dom";
import "./style.css";
import NotFound1 from "./views/NotFound1";
import Home from "./views/home";
import SignIn from "./pages/SignIn_SignUp/signin";
import SignUp from "./pages/SignIn_SignUp/signup";
import Navbar from "./components/navbar";
import About from "./pages/Other/about";
import Contact from "./pages/Other/contactus";
import Services from "./pages/Other/services";
import Projects from "./pages/Other/projects";
import Footer from "./components/footer";
import Profile1 from "./pages/Other/profile";
import BuilderPortfolio from "./pages/BuilderPortfolio/BuilderPortfolio";
import AdminPortfolio from "./pages/AdminPortfolio/AdminPortfolio";
import UserPortfolio from "./pages/UserPortfolio/UserPortfolio";
import Payment from "./pages/payment/payment"


const App = () => {



  return (
    <Router>
      <div>
        <Navbar />
        <Switch>
          <Route exact path="/" component={Home} />
          <Route path="/about" component={About}></Route>
          <Route path="/contactus" component={Contact}></Route>
          <Route path="/services" component={Services}></Route>
          <Route path="/projects" component={Projects}></Route>
          <Route path="/signin" component={SignIn} />
          <Route path="/signup" component={SignUp} />
          <Route path="/profile" component={Profile1} />
          <Route path="/builder-portfolio" component={BuilderPortfolio} />
          <Route path="/admin-portfolio" component={AdminPortfolio} />
          <Route path="/user-portfolio" component={UserPortfolio} />
          <Route path="/payment" component={Payment} />
          <Route path="/NotFound1" component={NotFound1} />
          <Route path="*" component={NotFound1} />

          <Redirect to="*" />
        </Switch>
        <Footer />
      </div>
    </Router>
  );
};

ReactDOM.render(<App />, document.getElementById("app"));
