import React, { useState } from "react";
import { useHistory, Link } from "react-router-dom";
import "./signin.css";

const SignIn = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [errors, setErrors] = useState({});
  const history = useHistory();

  const validateEmail = (email) => {
    const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return re.test(String(email).toLowerCase());
  };

  const validatePassword = (password) => {
    return password.length >= 6;
  };

  const handleSignIn = (e) => {
    e.preventDefault();
    let valid = true;
    let errors = {};

    if (!validateEmail(email)) {
      errors.email = "Please enter a valid email address.";
      valid = false;
    }

    if (!validatePassword(password)) {
      errors.password = "Password must be at least 6 characters.";
      valid = false;
    }

    setErrors(errors);

    if (valid) {
      console.log("Form is valid. Redirecting to profile...");
      history.push("/profile");
    }
  };

  const handleSignUpClick = () => {
    console.log("Sign Up button clicked");
    history.push("/signup");
  };

  return (
    <div id="signInWrapper">
      <div id="signInContainer">
        <button
          type="button"
          className="back hoverEffect"
          onClick={() => history.goBack()}
        >
          Back
        </button>
        <form onSubmit={handleSignIn}>
          <h2 id="title">Login</h2>
          <div id="accountCards">
            <div className="cardElement hoverEffect">
              <a href="#">
                <i className="fa-brands fa-google-plus-g"></i>
              </a>
              <span className="hidden">Google</span>
            </div>
            <div className="cardElement hoverEffect">
              <a href="#">
                <i className="fa-brands fa-facebook-f"></i>
              </a>
              <span className="hidden">Facebook</span>
            </div>
            <div className="cardElement hoverEffect">
              <a href="#">
                <i className="fa-brands fa-github"></i>
              </a>
              <span className="hidden">GitHub</span>
            </div>
            <div className="cardElement hoverEffect">
              <a href="#">
                <i className="fa-brands fa-linkedin-in"></i>
              </a>
              <span className="hidden">LinkedIn</span>
            </div>
            <div className="cardElement hoverEffect">
              <a href="#">
                <i className="fa-solid fa-mobile"></i>
              </a>
              <span className="hidden">Otp</span>
            </div>
          </div>
          <p id="alternativeSignIn">or use your email & password</p>
          <input
            type="email"
            required
            placeholder="Email"
            name="signInEmail"
            id="signInEmail"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
          {errors.email && <p className="error">{errors.email}</p>}
          <input
            type="password"
            required
            placeholder="Password"
            name="signInPassword"
            id="signInPassword"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
          {errors.password && <p className="error">{errors.password}</p>}
          <p id="forgotPassword">
            <Link to="/forgot-password">Forgot Your Password?</Link>
          </p>
          <div id="signInContainerButtons">
            <button type="submit" className="button hoverEffect">
              SIGN IN
            </button>
            <button
              type="button"
              className="button hoverEffect shake"
              id="signUpButton"
              onClick={handleSignUpClick}
            >
              SIGN UP
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default SignIn;
