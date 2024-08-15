import React, { useState } from "react";
import { useHistory, Link } from "react-router-dom";
import axios from "axios";
import "./SignInUpdated.css";
import "@fortawesome/fontawesome-free/css/all.min.css";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const SignIn = () => {
  const [userName, setuserName] = useState("");
  const [password, setPassword] = useState("");
  const [showPassword, setShowPassword] = useState(false);
  const [errors, setErrors] = useState({});
  const [role, setRole] = useState("Admin"); // Default role is Admin
  const history = useHistory();

  const validatePassword = (password) => {
    return password.length >= 6;
  };

  const handleSignIn = async (e) => {
    e.preventDefault();
    let valid = true;
    let errors = {};

    if (!validatePassword(password)) {
      errors.password = "Password must be at least 6 characters.";
      valid = false;
    }

    setErrors(errors);

    if (valid) {
      // Create the DTO object
      const signInDto = {
        userName: userName,
        password: password
      };

      try {
        await toast.promise(
          axios.post(`http://localhost:8081/signIn/${role}`, signInDto, {
            headers: {
              'Content-Type': 'application/json'
            }
          }),
          {
            pending: 'Signing in...',
            success: 'Sign-in successful! Redirecting...',
            error: 'Sign-in failed. Please check your credentials.'
          }
        );
        history.push("/profile");
      } catch (error) {
        console.error('There was an error!', error);
      }
    }
  };



  const handleSignUpClick = () => {
    console.log("Sign Up button clicked");
    history.push("/signup");
  };

  const togglePasswordVisibility = () => {
    setShowPassword(!showPassword);
  };

  return (
    <div id="signInWrapper">
      <div id="signInContainer">
        <button
          type="button"
          className="back hoverEffect"
          onClick={() => history.goBack()}
        >
          ⬅
        </button>
        <form onSubmit={handleSignIn}>
          <h2 id="title">Login</h2>
          <div id="accountCards">
            {/* Social login options */}
          </div>
          <p id="alternativeSignIn">or use your user name & password</p>
          <input
            type="text"
            required
            placeholder="User Name"
            name="signInuserName"
            id="signInuserName"
            value={userName}
            onChange={(e) => setuserName(e.target.value)}
          />
          {errors.userName && <p className="error">{errors.userName}</p>}
          <div className="password-container">
            <input
              type={showPassword ? "text" : "password"}
              required
              placeholder="Password"
              name="signInPassword"
              id="signInPassword"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
            <i
              className={`fa ${showPassword ? "fa-eye-slash" : "fa-eye"} password-icon`}
              onClick={togglePasswordVisibility}
            ></i>
          </div>
          {errors.password && <p className="error">{errors.password}</p>}
          <p id="forgotPassword">
            <Link to="/forgot-password">Forgot Your Password?</Link>
          </p>
          <div id="roleSelection">
            <label htmlFor="role">Select Role:</label>
            <select
              id="role"
              value={role}
              onChange={(e) => setRole(e.target.value)}
            >
              <option value="Admin">Admin</option>
              <option value="Customer">Customer</option>
              <option value="Builder">Builder</option>
            </select>
          </div>
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
        <ToastContainer />
      </div>
    </div>
  );
};

export default SignIn;
